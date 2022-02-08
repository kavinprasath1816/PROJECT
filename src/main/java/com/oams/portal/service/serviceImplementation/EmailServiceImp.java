package com.oams.portal.service.serviceImplementation;

import com.oams.portal.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class EmailServiceImp implements EmailService{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String toEmail,
                         String subject,
                         String body) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(new InternetAddress("skavin1804@gmail.com", "University.com"));
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(body);

            mailSender.send(mimeMessageHelper.getMimeMessage());

            log.info("Mail send Successfully");

        } catch (Exception e) {
            log.error("Error in Sending mail");
        }
    }
}
