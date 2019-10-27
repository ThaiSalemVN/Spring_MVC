package poly.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import poly.service.Mailer;

@Service()
public class MailerImpl implements Mailer {
@Autowired
JavaMailSender mailer;

	@Override
	public void sendEmail(String from, String to, String subject, String body) {
		try {
			MimeMessage  mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true,"utf-8");
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from,from);
			helper.setSubject(subject);
			helper.setText(body,true);		
			mailer.send(mail);
		
		} catch (Exception e) {
			throw new RuntimeException();		
		}
		
	}

}
