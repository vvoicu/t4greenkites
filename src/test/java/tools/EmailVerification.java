package tools;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.PageObject;

public class EmailVerification extends PageObject {

	public String subject;
	public Address from;
	public String textToVerify;

	public void check(String emailSubject) {

		try {
			Properties properties = new Properties();

			properties.put("mail.imaps.host", "mail.Evozon.com");
			properties.put("mail.imaps.port", "993");
			properties.put("mail.store.protocol", "imaps");
			Session emailSession = Session.getDefaultInstance(properties);

			Store store = emailSession.getStore("imaps");
			store.connect("mail.Evozon.com", 993, "cornelia.bodea@evozon.com", "Parolamea1994*.");

			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			for (int i = 0; i < 10; i++) {
				if (emailFolder.getUnreadMessageCount() == 0) {
					waitABit(1000);
				}
			}
			int messageNumbers = 0;

			messageNumbers = emailFolder.getMessageCount();

			System.out.println("YOU HAVE " + messageNumbers);
			Message[] messages = emailFolder.getMessages();

			Message lastMessage = emailFolder.getMessage(messageNumbers);

			System.out.println("messages.length--- " + messages.length);

			System.out.println("---------------------------------");
			System.out.println(lastMessage.getFrom()[0]);
			System.out.println("Subject: " + lastMessage.getSubject());
			System.out.println("From: " + lastMessage.getFrom()[0]);
			System.out.println("Text: " + getTextFromMessage(lastMessage));
			subject = lastMessage.getSubject();
			from = lastMessage.getFrom()[0];
			
			
			boolean verifyText = false;
			if (subject.equals(emailSubject)) {
				verifyText = true;
			}
			Assert.assertTrue("Email not found", verifyText);
			
			emailFolder.close(false);
			store.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getTextFromMessage(Message message) throws Exception {
		String result = "";
		if (message.isMimeType("text/*")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}

}
