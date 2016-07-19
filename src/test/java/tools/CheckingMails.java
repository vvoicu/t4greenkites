package tools;


import java.security.NoSuchProviderException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class CheckingMails {

	 public static void check(String host, String storeType, String user,
	 String password) {
	 try {
	 Properties properties = new Properties();
	
	 properties.put("mail.imaps.host", host);
	 properties.put("mail.imaps.port", "993");
	 properties.put("mail.store.protocol", "imaps");
	 Session emailSession = Session.getDefaultInstance(properties);
	
	 Store store = emailSession.getStore("imaps");
	 store.connect(host, user, password);
	
	 Folder emailFolder = store.getFolder("INBOX");
	 emailFolder.open(Folder.READ_ONLY);
	
	 Message[] messages = emailFolder.getMessages();
	 System.out.println("messages.length---" + messages.length);
	
	 for (int i = 0, n = messages.length; i < n; i++) {
	 Message message = messages[i];
	 Multipart mp = (Multipart) message.getContent();
     BodyPart bp = mp.getBodyPart(0);
	 System.out.println("---------------------------------");
	 System.out.println("Email Number " + (i + 1));
	 System.out.println("Subject: " + message.getSubject());
	 System.out.println("From: " + message.getFrom()[0]);
	 System.out.println("Text: " + bp.getContent());
	
	 }
	 emailFolder.close(false);
	 store.close();
//	 } catch (NoSuchProviderException e) {
//	 e.printStackTrace();
	 } catch (MessagingException e) {
	 e.printStackTrace();
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }
	
	 public static void main(String[] args) {
	
	 String host = "imap.gmail.com";// change accordingly
	 String mailStoreType = "imaps";
	 String username = "nellyblondina@gmail.com";// change accordingly
	 String password = "nellyblondina1994*.";// change accordingly
	
	 check(host, mailStoreType, username, password);
	
	 }

}
