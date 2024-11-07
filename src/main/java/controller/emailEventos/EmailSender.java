package controller.emailEventos;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Properties;

// Esta classe é um servlet que envia e-mails para os usuários que desejam cadastrar um evento.

@WebServlet(name = "EmailSender", urlPatterns = {"/emailEvento"})
public class EmailSender extends HttpServlet {

    // O método doPost é chamado quando o formulário é enviado via método POST.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Dotenv dotenv = Dotenv.load();
        // Configurações do servidor SMTP para envio de e-mails
        String host = "smtp.gmail.com"; // O servidor SMTP do Gmail
        String port = "587"; // Porta para conexão TLS
        final String username = "tropicalias2024@gmail.com"; // Endereço de e-mail que está enviando
        final String password = System.getenv("EMAIL_PASSWORD"); // Senha do e-mail (deve ser armazenada de forma segura)

        // Propriedades da sessão de e-mail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Habilita a autenticação SMTP
        props.put("mail.smtp.starttls.enable", "true"); // Habilita o STARTTLS para segurança
        props.put("mail.smtp.host", host); // Define o servidor SMTP
        props.put("mail.smtp.port", port); // Define a porta SMTP

        // Criação da sessão de e-mail com autenticação
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password); // Realiza a autenticação
                    }
                });

        try {
            // Captura o e-mail fornecido no formulário
            String email = request.getParameter("email");

            // Criação da mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tropicalias2024@gmail.com")); // Define o remetente
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email) // Define o destinatário (o e-mail do usuário)
            );
            message.setSubject("Seja bem-vindo ao Tropicálias!!"); // Define o assunto do e-mail
            message.setText("Obrigado por se inscrever!\nAbra o link a seguir e insira as informações necessárias para a criação do evento.\n" +
                    "Abra este link para cadastrar o seu evento: https://forms.office.com/r/3jqydBi9sq"); // Define o corpo do e-mail

            // Envio do e-mail
            Transport.send(message); // Realiza o envio da mensagem

            // Redireciona o usuário para a página inicial após o envio bem-sucedido
            response.sendRedirect(request.getContextPath() + "/index.html");

        } catch (MessagingException e) {
            // Em caso de erro no envio do e-mail, imprime a pilha de erros para depuração
            e.printStackTrace();
        }
    }
}
