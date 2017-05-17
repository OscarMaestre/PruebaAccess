package io.oscarmaestre.github.access;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class GestorEmail {

    public static void 
    	enviar_email(
    		String email_remitente,
    		String clave_remitente,
    		String servidor_smtp,
    		String destinatario,
    		String asunto,
    		String textoMensaje,
    		String puerto_tcp_servidor_smtp
    		) 
    {

    	
        Properties props = new Properties();
        /*
         * Se da por sentado que el servidor
         * usa TLS
         */
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", servidor_smtp);
        props.put("mail.smtp.port", puerto_tcp_servidor_smtp);

        Session sesion = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email_remitente, clave_remitente);
            }
          });

        try {

            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(email_remitente));
            mensaje.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(textoMensaje);

            Transport.send(mensaje);

            System.out.println(
            	"Enviado correctamente email a "+destinatario);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}