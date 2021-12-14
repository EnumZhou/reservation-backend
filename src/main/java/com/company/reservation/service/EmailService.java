package com.company.reservation.service;

import com.company.reservation.annotation.AccessLog;
import com.company.reservation.entity.Customer;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration configuration;

    @Value("${spring.mail.username}")
    private String from;

    @AccessLog(operation = "Send Simple text email message")
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AccessLog(operation = "Send Simple HTML email message.")
    public void sendHTMLMessage(String to, String subject,Customer customer)
            throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setTo(to);
        String emailContent = getEmailContent(customer);
        helper.setText(emailContent,true);
        javaMailSender.send(mimeMessage);
    }

    @AccessLog(operation = "Get HTML String email content")
    public String getEmailContent(Customer customer) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String,String> modal = new HashMap<>();
        modal.put("firstname",customer.getFirstname());
        configuration.getTemplate("email.ftlh").process(modal,stringWriter);
        return stringWriter.getBuffer().toString();
    }

}
