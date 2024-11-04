package Controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "conta", value = "/conta")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os parâmetros de email e senha da solicitação
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Define a URL da API para autenticação
        String url = "https://tropicalias-api-dev.onrender.com/user/authorization/" + email + "/" + senha;
        // Abre uma conexão com a URL definida
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        // Define o método de requisição como GET
        conn.setRequestMethod("GET");
        // Define o cabeçalho da requisição para aceitar JSON como resposta
        conn.setRequestProperty("Accept", "application/json");

        // Verifica o código de resposta da API para determinar o resultado do login
        if (conn.getResponseCode() == 200) {
            // Redireciona para a página de administração em caso de sucesso
            request.getRequestDispatcher( "/Pages/ADM.jsp").forward(request, response);
        } else if (conn.getResponseCode() == 401) {
            // Caso as credenciais estejam incorretas
            request.setAttribute("resultado", "E-mail ou senha inválidos!");
            request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);

        } else if (conn.getResponseCode() == 403) {
            // Caso o usuário não tenha autorização para acessar o sistema
            request.setAttribute("resultado", "Usuário não autorizado!");
            request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);

        } else if (conn.getResponseCode() == 404) {
            // Caso o usuário não seja encontrado na base de dados
            request.setAttribute("resultado", "Usuário não encontrado!");
            request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);
        } else if (conn.getResponseCode() == 418) {
            // Resposta personalizada do servidor para indicar uma condição especial
            request.setAttribute("resultado", "Você é muito especial!");
            request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);

        } else if (conn.getResponseCode() == 500) {
            // Caso ocorra um erro interno no servidor
            request.setAttribute("resultado", "Ocorreu um erro interno do servidor! Tente novamente mais tarde!");
            request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);
        }

        // Lê a resposta da API
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        // Desconecta a conexão
        conn.disconnect();
    }

    public void destroy() {
    }
}
