package poly.service;

public interface Mailer {
	void sendEmail(String from, String to,String subject, String body);
}
