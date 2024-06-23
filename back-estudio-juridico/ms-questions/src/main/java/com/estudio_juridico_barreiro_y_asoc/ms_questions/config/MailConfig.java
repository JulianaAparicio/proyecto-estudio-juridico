package com.estudio_juridico_barreiro_y_asoc.ms_questions.config;


import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;

public class MailConfig {
    public static void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            //set message headers
            mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
            mimeMessage.addHeader("format", "flowed");
            mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");

            mimeMessage.setFrom(new InternetAddress("consultas.estudiobarreiroyasoc@gmail.com", "Consulta - Estudio Barreiro & Asociados"));

            mimeMessage.setReplyTo(InternetAddress.parse("consultas.estudiobarreiroyasoc@gmail.com", false));

            mimeMessage.setSubject(subject, "UTF-8");

            mimeMessage.setContent(body, "text/html");

            mimeMessage.setSentDate(new Date());

            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready.");
            Transport.send(mimeMessage);

            System.out.println("Email sent successfully.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
