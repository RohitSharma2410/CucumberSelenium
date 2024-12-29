package utilsClasses;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class MailerClass {

	public static void prepareEmail() {
		MultiPartEmail email = new MultiPartEmail();
		try {
			EmailAttachment attachment = new EmailAttachment();
			email.setHostName("Automation Suite");
			email.setMsg("This email report is generated from Test automation suite created by Rohit Sharma ");
			attachment.setPath("/Users/rohitsharma/eclipse-workspace/Cucumber/target/htmlreport.html");
			email.addTo("testerrohitsharma@gmail.com");
			email.setSmtpPort(587);
			email.attach(attachment);
			email.setAuthentication("testerrohitsharma@gmail.com", "goio fgww vvct yakt");
			email.setDebug(false);
			email.setHostName("smtp.gmail.com");
			email.setFrom("testerrohitsharma@gmail.com");
			email.setSubject("Cucumber test result");
			email.setMsg("Mail from automation suite");
			email.setStartTLSEnabled(true);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}