package functions;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {

    private static String USER_NAME = "martaprotsak13@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "uM1rOdXG"; // GMail password
    private static String RECIPIENT = "martaprotsak007@gmail.com";

    public static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "8080");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            System.setProperty("https.protocols", "TLSv1.1");

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public static boolean sendError(String errorsMessage) {

        // final String login = "plwkcm@gmail.com";
        // final String password = "jjqtlfstfdycwoby";
        Properties properties = new Properties();
        String login = null;
        String password = null;
        try {
            InputStream is = new FileInputStream(new File("C:\\Users\\Marta\\sample.properties"));
            properties.load(is);
            login = properties.getProperty("login");
            password = properties.getProperty("password");
            System.out.println("login: " + properties.getProperty("login"));
            System.out.println("password: " + properties.getProperty("password"));
            System.out.println("mail.smtp.host: " + properties.getProperty("mail.smtp.host"));
            System.out.println("mail.smtp.auth: " + properties.getProperty("mail.smtp.auth"));
            System.out.println("mail.smtp.starttls.enable: " + properties.getProperty("mail.smtp.starttls.enable"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        System.setProperty("https.protocols", "TLSv1.1");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.port", "587");
        String finalLogin = login;
        String finalPassword = password;
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalLogin, finalPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(login));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(login));
            message.setSubject("Exception");
            message.setText(errorsMessage);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        sendFromGMail(from, pass, to, subject, body);
    }
}
