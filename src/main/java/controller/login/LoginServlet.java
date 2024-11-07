package controller.login;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "acessarConta", value = "/acessarConta")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os parâmetros de email e senha da solicitação
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Define a URL da API para autenticação
        String url = "https://tropicalias-api-dev.onrender.com/user/authorization/" + email + "/" + senha;
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        String mensagemErro;

        // Verifica o código de resposta da API para determinar o resultado do login
        if (conn.getResponseCode() == 200) {
            // Login bem-sucedido
            request.getRequestDispatcher("/pages/ADM.jsp").forward(request, response);
        } else {
            // Verifica cada código de erro e define a mensagem apropriada
            if (conn.getResponseCode() == 401) {
                mensagemErro = "E-mail ou senha inválidos!";
            } else if (conn.getResponseCode() == 403) {
                mensagemErro = "Usuário não autorizado!";
            } else if (conn.getResponseCode() == 404) {
                mensagemErro = "Usuário não encontrado!";
            } else if (conn.getResponseCode() == 500) {
                mensagemErro = "Ocorreu um erro interno no servidor! Tente novamente mais tarde.";
            } else {
                mensagemErro = "Erro desconhecido. Por favor, tente novamente.";
            }

            // Define a mensagem de erro para exibição na página de login
            request.setAttribute("mensagemErro", mensagemErro);
            request.getRequestDispatcher("pages/Login.jsp").forward(request, response);
        }

        conn.disconnect();
    }
}