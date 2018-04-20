package elements;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




/**
 * @author Titouan Bouëte-Giraud
 * titouan.bouete@gmail.com
 * 
 * https://www.tutorialspoint.com/javamail_api/javamail_api_gmail_smtp_server.htm
 * This link contains various informations and examples on the features of this class
 *
 *
 *
 * This class contains various methods allowing interactions with the mailBox directly
 * Note that to use this class, you need to allow your gmail account to be accessed by external programs
 * If this option is not activated, the connection will fail and you should receive an email warning you about this attempt.
 */
public class EmailUsingGMailSMTP {
	private String host = "smtp.gmail.com";
	private String storeType = "imaps";
	private String email;
	private String username;
	private String pwd;
	
	@SuppressWarnings("unused")
	//Prevent the use of this constructor
	private EmailUsingGMailSMTP(){};
	
	public EmailUsingGMailSMTP(String email, String username, String pwd){
		this.email = email;
		this.username = username;
		this.pwd = pwd;
	}
	
	 /**<NEWLINE>
	  * Returns an ArrayList of the folders available in this mailbox
	  * Also displays each folder's name and it's message count
	  * @return ArrayList of the folders in the mailbox
	  */
	public ArrayList<Folder> getFolders(){
		ArrayList<Folder> ALFolders = new ArrayList<Folder>();
		try {
			
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", this.storeType);
			Session session = Session.getDefaultInstance(props, null);
			Store store  = session.getStore(this.storeType);
			store.connect(this.host, this.email, this.pwd);
			System.out.println(store);

			Folder[] folders = store.getDefaultFolder().list("*");
			for(Folder folder : folders){
				if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
		            System.out.println(folder.getFullName() + " : " + folder.getMessageCount());
		            ALFolders.add(folder);
				}
			}
		} catch (javax.mail.NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return ALFolders;
	}
	
	/**<NEWLINE>
	 * Send a mail to the specified address with the according subject and text
	 * @param to 		email address to send the mail to
	 * @param subject 	subject of the email
	 * @param text 		text of the email
	 */
	public void sendEmail(String to, String subject, String text){
		Properties props = new Properties();
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		String username = this.username;
		String pwd = this.pwd;
		
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,pwd);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			System.out.println("Email succesfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**<NEWLINE>
	 * Send an email to the specified address with the according subject and text with the linked file
	 * @param to				email address to send the mail to
	 * @param subject			subject of the email
	 * @param text				text of the email
	 * @param attachementPath	path of the attachment /!\ For windows users : each "\" must be doubled !
	 */
	public void sendEmailWithAttachment(String to, String subject, String text, String attachementPath){
		Properties props = new Properties();
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		String username = this.username;
		String pwd = this.pwd;
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,pwd);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(text);
			
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        
	        messageBodyPart = new MimeBodyPart();
	        DataSource source = new FileDataSource(attachementPath);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(attachementPath);
	        multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

			Transport.send(message);

			System.out.println("Email with attachment succesfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	/**<NEWLINE>
	 * Print
	 * 	- the number of mail the that folder
	 * 	for each mail :
	 * 	- the subject
	 *  - the address of the expediter
	 *  - the date the mail has been sent
	 * @param folderName the full name of the folder, use the getFolder method
	 */

	public void check(String folderName)  {
		try {
			Store store = this.createStore();
			store.connect(this.host, this.username, this.pwd);

		      //create the folder object and open it
			Folder emailFolder = store.getFolder(folderName);
			emailFolder.open(Folder.READ_ONLY);

		      // retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("Checking mail in "+folderName +"...");
			System.out.println("Number of mail in this folder : " + messages.length);

			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				EmailUsingGMailSMTP.writeEnvelope(message);
				//System.out.println("Text: " + message.getContent().toString());
			}

		      //close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**<NEWLINE>
	 * Print every message in the folder, with a prompt asking to continue between each message
	 * @param folderName folderName the full name of the folder, use the getFolder method
	 */
	public void fetch(String folderName){
		try {
			Store store = this.createStore();
			store.connect(this.host, this.username, this.pwd);

		      //create the folder object and open it
			Folder emailFolder = store.getFolder(folderName);
			emailFolder.open(Folder.READ_ONLY);

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			      
			Message[] messages = emailFolder.getMessages();
			System.out.println("Fetching mail in "+folderName +"...");
			System.out.println("Number of mail in this folder : " + messages.length);


			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				EmailUsingGMailSMTP.writeEnvelope(message);
				EmailUsingGMailSMTP.writePart(message);
				System.out.println("Press enter to continue, or type \"q\" to quit");
				String line = reader.readLine();
				if ("YES".equals(line)) {
					message.writeTo(System.out);
				} else if ("q".equals(line) || "Q".equals(line)) {
					break;
				}
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**<NEWLINE>
	 * This method checks for content-type 
	 * based on which, it processes and
	 * fetches the content of the message
	 * @param p The Part to be analyzed
	 * @throws Exception
	 */
	   public static void writePart(Part p) throws Exception {
	      if (p instanceof Message)
	         //Call method writeEnvelope
	         writeEnvelope((Message) p);

	      System.out.println("----------------------------");
	      System.out.println("CONTENT-TYPE: " + p.getContentType());

	      //check if the content is plain text
	      if (p.isMimeType("text/plain")) {
	         System.out.println("This is plain text");
	         System.out.println("---------------------------");
	         System.out.println((String) p.getContent());
	      } 
	      //check if the content has attachment
	      else if (p.isMimeType("multipart/*")) {
	         System.out.println("This is a Multipart");
	         System.out.println("---------------------------");
	         Multipart multiPart = (Multipart) p.getContent();
	         for (int i = 0; i < multiPart.getCount(); i++)
	            writePart(multiPart.getBodyPart(i));
	      } 
	      //check if the content is a nested message
	      else if (p.isMimeType("message/rfc822")) {
	         System.out.println("This is a Nested Message");
	         System.out.println("---------------------------");
	         writePart((Part) p.getContent());
	      } 
	      //check if the content is an inline image
	      else if (p.isMimeType("image/jpeg")) {
	         System.out.println("--------> image/jpeg");
	         Object o = p.getContent();

	         InputStream x = (InputStream) o;
	         // Construct the required byte array
	         System.out.println("x.length = " + x.available());
	         int i;
	         byte[] bArray = new byte[x.available()];
			while ((i = (int) ((InputStream) x).available()) > 0) {
	        	 int result = (int) (((InputStream) x).read(bArray));
	        	 if (result == -1){
	        		 i  = 0 ;
	        	 }
	        	 bArray = new byte[x.available()];

	        	 break;
	         }
	         //FileOutputStream f2 = new FileOutputStream("<path>");
	         //f2.write(bArray);
	      } 
	      else if (p.getContentType().contains("image/")) {
	         System.out.println("content type" + p.getContentType());
	         File f = new File("image" + new Date().getTime() + ".jpg");
	         DataOutputStream output = new DataOutputStream(
	            new BufferedOutputStream(new FileOutputStream(f)));
	            com.sun.mail.util.BASE64DecoderStream test = 
	                 (com.sun.mail.util.BASE64DecoderStream) p
	                  .getContent();
	         byte[] buffer = new byte[1024];
	         int bytesRead;
	         while ((bytesRead = test.read(buffer)) != -1) {
	            //output.write(buffer, 0, bytesRead);
	         }
	         output.close();
	      } 
	      else {
	         Object o = p.getContent();
	         if (o instanceof String) {
	            System.out.println("This is a string");
	            System.out.println("---------------------------");
	            System.out.println((String) o);
	         } 
	         else if (o instanceof InputStream) {
	            System.out.println("This is just an input stream");
	            System.out.println("---------------------------");
	            System.out.println("Not printed to prevent crashes"); 
	            /* TODO : Fix the display (can try to print .pptx file for example)
	            InputStream is = (InputStream) o;
	            is = (InputStream) o;
	            int c;
	            while ((c = is.read()) != -1)
	               System.out.write(c);
	            is.close();
	            */
	         } 
	         else {
	            System.out.println("This is an unknown type");
	            System.out.println("---------------------------");
	            //Not printed to prevent display problems
	            //System.out.println(o.toString());
	         }
	      }
	   }
	   
	   /**<NEWLINE>
	    * Print the following information of the message :
	    *  - the address of the expediter
	    *  - the addresses of the recipients
	    *  - the subject of the mail
	    *  - the date the mail was sent
	    * @param message which informations are to be printed
	    * @throws Exception
	    */
	    public static void writeEnvelope(Message message) throws Exception {
	       System.out.println("---------------------------");
	       Address[] address;
	       
	       // FROM
	       if ((address = message.getFrom()) != null) {
	          for (int i = 0; i < address.length; i++)
	          System.out.println("From:    " + address[i].toString());
	       }

	       // TO
	       if ((address = message.getRecipients(Message.RecipientType.TO)) != null) {
	          for (int i = 0; i < address.length; i++)
	          System.out.println("To:      " + address[i].toString());
	       }

	       // SUBJECT
	       if (message.getSubject() != null)
	          System.out.println("Subject: " + message.getSubject());
	       
	       // SENT
	       if (message.getSentDate() != null)
		          System.out.println("Sent:    " + message.getSentDate());

	    }
	    
	    /**<NEWLINE>
	     * 
	     * @return a Store to connect to, or null if a problem was encountered
	     */
	    private Store createStore(){
	    	Store store = null;
			try {
				Properties props = System.getProperties();
				props.setProperty("mail.store.protocol", this.storeType);
				Session session = Session.getDefaultInstance(props, null);
				store = session.getStore(this.storeType);
			} catch (javax.mail.NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return store;
	    }
	    
	    /**<NEWLINE>
	     * This method will add a {@link MessageCountListener} to the specified folder.
	     * It will then loop checking the number of mail in this folder, with the specified delay
	     * Shall this number evolve in any way, the methods actionMailRemovedFromFolder
	     * and actionMailAddedToFolder will be called accordingly
	     * @param folderName
	     * @param delay
	     */
	    public void loopWaitForEmail(String folderName, long delay){
	    	try {
				Store store = this.createStore();
				store.connect(this.host, this.username, this.pwd);

			      //create the folder object and open it
				Folder emailFolder = store.getFolder(folderName);
				emailFolder.open(Folder.READ_ONLY);
				emailFolder.addMessageCountListener(new MessageCountListener() {
					
					@Override
					public void messagesRemoved(MessageCountEvent arg0) {
						actionMailRemovedFromFolder(emailFolder);
						
					}
					
					@Override
					public void messagesAdded(MessageCountEvent arg0) {
						actionMailAddedToFolder(emailFolder);
						
					}
				});
				
				long temp = 0;
				boolean updateTemp = true;
				
				while(true){
					if(updateTemp){
						temp = System.currentTimeMillis();
						updateTemp = false;
					}
					if(System.currentTimeMillis()>temp+delay){
						
						Message[] messages = emailFolder.getMessages();
						System.out.println("Number of mail in folder " + folderName + " : " + messages.length);
						
						updateTemp = true;
					}
				}

				
	    	} catch (MessagingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	
	    }
	    
	    /**<NEWLINE>
	     * 
	     * @param folder the folder surveyed
	     * This method will print a small message to notify the user once a new mail is available on the folder.
	     * Ultimately, this method should be overridden to match the desired function.
	     */
	    public void actionMailAddedToFolder(Folder folder){
	    	System.out.println("New message available in folder");
	    }
	    
	    /**<NEWLINE>
	     * 
	     * @param folder the folder surveyed
	     * This method will print a small message to notify the user once a mail is removed on the folder.
	     * Ultimately, this method should be overridden to match the desired function.
	     */
	    public void actionMailRemovedFromFolder(Folder folder){
	    	System.out.println("Message removed from folder");
	    }
	    
	    /**<NEWLINE>
	     * 
	     * @param p the part to be analyzed
	     * @return a String corresponding to the content of the mail, or an empty String if the mail does not contain plain text
	     * @throws Exception
	     */
	    public static String getPlainTextContent(Part p) throws Exception{
	    	String ret = "";
	    	//System.out.println(p.getContentType());
	    	if (p.isMimeType("text/plain")) {
		         ret = (String) p.getContent();
		         
		      }
	    	else if (p.isMimeType("multipart/*")) {
		         Multipart multiPart = (Multipart) p.getContent();
		         ret = getPlainTextContent(multiPart.getBodyPart(0));
		      } 
	    	return ret;
	    }
	/**<NEWLINE>
	 * 
	 * @param message the message sent
	 * @return a String containing the first name, the surname and the address of the expediter
	 * @throws MessagingException
	 */
	public static String getExpediter(Message message) throws MessagingException{
		String ret = "";
		Address[] address;
		if ((address = message.getFrom()) != null) {
			for (int i = 0; i < address.length; i++)
				ret += address[i].toString();
		}
		return ret;
	}
	/**<NEWLINE>
	 * 
	 * @param message the message sent
	 * @return a String containing the first name and surname of the user as indicated by him/herself within gmail
	 * @throws MessagingException
	 */
	public static String getNameExpediter(Message message) throws MessagingException{
		String temp = EmailUsingGMailSMTP.getExpediter(message);
		String[] tabString = temp.split(" ");
		ArrayList<String> alString = new ArrayList<String>();
		for(String stringTemp : tabString){
			if(!stringTemp.contains("@"))
				alString.add(stringTemp);	
		}
		String ret = "";
		for(String stringTemp : alString)
			ret += stringTemp;
		return ret;
	}
	/**<NEWLINE>
	 * 
	 * @param message the message sent
	 * @return a String containing only the address of the Expediter
	 * @throws MessagingException
	 */
	public static String getAddressExpediter(Message message) throws MessagingException{
		String ret = "";
		Address[] address;
		if ((address = message.getFrom()) != null) {
			for (int i = 0; i < address.length; i++)
				if(address[i].toString().contains("@")){
					String[] tabStringTemp = address[i].toString().split(" ");
					for(String temp : tabStringTemp){
						if(temp.contains("@")){
							ret = temp.substring(1, temp.length()-1);
						}
					}
				}
		}
		return ret;
	}
	
	
}
