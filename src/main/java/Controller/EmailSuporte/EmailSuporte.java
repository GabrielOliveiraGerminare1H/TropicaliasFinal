package Controller.EmailSuporte;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

// Esta classe é responsável por enviar e-mails de suporte quando um usuário relata
// um problema na plataforma.
public class EmailSuporte {

    // Método que envia um e-mail de suporte.
    public void enviarEmailSuporte(String destinatario, String remetente, String mensagemUsuario) throws MessagingException {

        // Configurações do servidor SMTP para envio de e-mails via Gmail
        String host = "smtp.gmail.com"; // Host do servidor SMTP
        String port = "587"; // Porta utilizada para conexão TLS
        final String username = "tropicalias2024@gmail.com"; // E-mail do remetente
        final String password = "gtjp fznn adul jsah"; // Senha do e-mail do remetente (deve ser armazenada de forma segura)

        // Propriedades da sessão de e-mail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Habilita autenticação
        props.put("mail.smtp.starttls.enable", "true"); // Habilita TLS
        props.put("mail.smtp.host", host); // Define o host do servidor SMTP
        props.put("mail.smtp.port", port); // Define a porta do servidor SMTP

        // Criação da sessão de e-mail com autenticação
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password); // Retorna as credenciais para autenticação
                    }
                });

        // Criação do e-mail
        Message message = new MimeMessage(session); // Cria uma nova mensagem de e-mail
        message.setFrom(new InternetAddress(remetente)); // Define o remetente do e-mail
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(destinatario) // Define o destinatário do e-mail
        );
        message.setSubject("Solicitação de Suporte"); // Define o assunto do e-mail
        message.setText("Solicitação de suporte recebida:\n\n" + // Define o corpo do e-mail
                "E-mail do usuário: " + remetente + "\n" +
                "Descrição do problema: " + mensagemUsuario);

        // Envio do e-mail
        Transport.send(message); // Envia a mensagem

        // Mensagem de confirmação no console
        System.out.println("Solicitação de suporte enviada com sucesso!"); // Log de sucesso no envio
    }
}
