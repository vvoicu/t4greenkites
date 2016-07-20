package tools;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.NoSuchProviderException;
import java.util.Properties;
import javax.mail.BodyPart;

public class ReadLastEmail {

	//   private static final Message Message = null;

	public void check(String host, String storeType, String user,String password) 
	   {
	      try {

	      //create properties field
	      Properties properties = new Properties();

	      properties.put("mail.imaps.host", "mail.Evozon.com");
	      properties.put("mail.imaps.port", "993");
	      properties.put("mail.store.protocol", "imaps");
	      Session emailSession = Session.getDefaultInstance(properties);
	  
	      //create the POP3 store object and connect with the pop server
	      Store store = emailSession.getStore("imaps");

	      store.connect(host, user, password);

	      //create the folder object and open it
	      Folder emailFolder = store.getFolder("INBOX");
	      emailFolder.open(Folder.READ_ONLY);

	      int messageNumbers=0;
	      messageNumbers=emailFolder.getMessageCount();
	      
	      System.out.println("YOU HAVE:"+ messageNumbers);
	      Message lastMessage = emailFolder.getMessage(messageNumbers);
	      
	      
	      // retrieve the messages from the folder in an array and print it
	      Message[] messages = emailFolder.getMessages();
	     
	      
	      //Message msg = inbox.getMessage(inbox.getMessageCount());
          //Address[] in = msg.getFrom();
 		  //for (int i = messages.length-1; i >= 0; i--) {
	      //for (Address address : in) {
	      //Message message = messages[i];
	      		System.out.println("messages.length---" + messages.length);
	      		System.out.println(lastMessage.getFrom()[0]);
	      		System.out.println("messages.length--- " + messages.length);
	          	System.out.println("---------------------------------");
	  	        System.out.println("Subject: " + lastMessage.getSubject());
	  	        System.out.println("From: " + lastMessage.getFrom()[0]);
	  	        System.out.println("Text: " + getTextFromMessage(lastMessage));
	  	  //      }
	      
	      //close the store and folder objects
	      emailFolder.close(false);
	      store.close();

	      } catch (NoSuchProviderException e) {
	         e.printStackTrace();
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

	private String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart) throws Exception{
	    String result = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/*")) {
	            result = result + "\n" + bodyPart.getContent();
	            break; // without break same text appears twice in my tests
	        } else if (bodyPart.isMimeType("text/html")) {
	            String html = (String) bodyPart.getContent();
	            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
	        } else if (bodyPart.getContent() instanceof MimeMultipart){
	            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return result;
	}	
	
	   public static void main(String[] args) {

	      String host = "mail.Evozon.com";// change accordingly
	      String mailStoreType = "993";
	      String username = "anca.coroama@evozon.com";// change accordingly
	      String password = "AncaDelia%12";// change accordingly
	      
	      ReadLastEmail readLastEmail = new ReadLastEmail();
	      readLastEmail.check(host, mailStoreType, username, password);
	     
	   }

	}
