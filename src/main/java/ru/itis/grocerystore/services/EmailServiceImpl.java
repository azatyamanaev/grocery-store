package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ExecutorService executorService;

    @Value("email.username")
    private String userName;

    @Override
    public void sendNotification(String subject, String text, String email) {
        Runnable runnable = () -> {
            MimeMessagePreparator messagePreparator = mimeMessage -> {
                    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                    messageHelper.setFrom(userName);
                    messageHelper.setTo(email);
                    messageHelper.setSubject(subject);
                    messageHelper.setText(text, true);
            };
            javaMailSender.send(messagePreparator);
        };
        executorService.submit(runnable);
    }
}
