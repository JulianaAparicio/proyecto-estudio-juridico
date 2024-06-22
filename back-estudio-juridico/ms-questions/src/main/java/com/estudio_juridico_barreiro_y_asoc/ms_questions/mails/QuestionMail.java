package com.estudio_juridico_barreiro_y_asoc.ms_questions.mails;

import com.estudio_juridico_barreiro_y_asoc.ms_questions.config.MailConfig;
import com.estudio_juridico_barreiro_y_asoc.ms_questions.model.Question;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;


public class QuestionMail {
    public static void sendQuestionEmail (Question question) {
        final String fromEmail = "consultas.estudiobarreiroyasoc@gmail.com"; //requires valid gmail id
        final String password = "Estudiobarreiroyasoc2024"; // correct password for gmail id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        String registerSubjectMail = question.getFullName() + " " + "ha enviado una consulta a su sitio web!";
        String registerBodyMail = "<div style=\"width: 90%;border: 1px solid #383b58; margin: auto;\">\n" +
                "      <div style=\"width: 100%;background-color: #1DBEB4;color:#383b58;\">\n" +
                "         <h1 style=\"padding: 0.5rem;\">Estudio Jurídico Barreiro & Asociados</h1>\n" +
                "         <h3 style=\"padding: 0.5rem;\">Se ha recibido una consulta a través de su sitio web.</h3> \n" +
                "      </div>\n" +
                "      <div style=\"padding: 1rem;\">\n" +
                "\n" +
                "         Nombre completo de la persona que la realizó: " + question.getFullName() + "<br><br><br>\n" +
                "\n" +
                "         Email de contacto que ingresó: " + question.getEmail() + "<br><br><br>\n" +
                "\n" +
                "         Teléfono de contacto que ingresó: " + question.getPhoneNumber() + "<br><br><br>\n" +
                "\n" +
                "         Su consulta fue: " + question.getMessage() + "<br><br>\n" +
                "\n" +
                "         Este email fue enviado de forma automática a través del formulario de contacto de su sitio web.\n" +
                "\n" +
                "         Ante cualquier duda o consulta póngase en contacto con el administrador del sitio.\n" +
                "      </div>\n" +
                "   </div>";

        // Acá envío a mi correo para probar:
        MailConfig.sendEmail(session, "julysch07@gmail.com",registerSubjectMail, registerBodyMail);

    }
}

