package controller.emailSuporte;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Esta classe é um servlet responsável por receber as solicitações de envio de e-mail de suporte.
@WebServlet("/EnviarMensagem")
public class EmailReceiver extends HttpServlet {

    // O método doPost é chamado quando o formulário é enviado via método POST.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém os parâmetros do formulário: o e-mail do usuário e a mensagem de suporte.
        String email = request.getParameter("email"); // Captura o e-mail do formulário
        String mensagem = request.getParameter("especificar"); // Captura a descrição do problema (corrigido para "especificar")

        // Verifica se os parâmetros estão preenchidos (não são nulos e não estão vazios)
        if (email != null && !email.isEmpty() && mensagem != null && !mensagem.isEmpty()) {
            // Se os parâmetros estiverem válidos, tenta enviar o e-mail.
            try {
                // Cria uma instância da classe EmailSuporte para enviar o e-mail
                EmailSuporte emailSuporte = new EmailSuporte();
                // Envia o e-mail para o destinatário especificado (e-mail do suporte), usando o e-mail do usuário e a mensagem
                emailSuporte.enviarEmailSuporte("tropicalias2024@gmail.com", email, mensagem);

                // Redireciona o usuário para a página inicial após o envio bem-sucedido do e-mail
                mensagem = "Email enviado com sucesso!";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("/Suporte.html").forward(request, response);

            } catch (Exception e) {
                // Em caso de erro no envio do e-mail, imprime a pilha de erros e envia uma mensagem de erro ao cliente
                String mensagemErro = "Erro ao enviar a mensagem.";
                request.setAttribute("mensagemErro", mensagemErro);
                request.getRequestDispatcher("/Suporte.html").forward(request, response);
            }
        } else {
            // Se os campos não estiverem preenchidos corretamente, retorna uma mensagem de erro ao cliente
            String mensagemErro = "Por favor, preencha todos os campos!";
            request.setAttribute("mensagemErro", mensagemErro);
            request.getRequestDispatcher("/Suporte.html").forward(request, response);
        }
    }
}
