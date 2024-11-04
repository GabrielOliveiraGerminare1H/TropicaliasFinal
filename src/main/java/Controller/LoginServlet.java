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
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Obtém os parâmetros de email e senha da solicitação
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

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
            req.getRequestDispatcher("/Pages/ADM.jsp").forward(req, resp);
        } else if (conn.getResponseCode() == 401) {
            // Caso as credenciais estejam incorretas
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Email ou senha inválidos!");
            req.getRequestDispatcher("/Pages/mensagem.jsp").forward(req, resp);

        } else if (conn.getResponseCode() == 403) {
            // Caso o usuário não tenha autorização para acessar o sistema
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Usuário não autorizado!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);

        } else if (conn.getResponseCode() == 404) {
            // Caso o usuário não seja encontrado na base de dados
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Usuário não encontrado!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);

        } else if (conn.getResponseCode() == 418) {
            // Resposta personalizada do servidor para indicar uma condição especial
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Você é muito especial!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);

        } else if (conn.getResponseCode() == 500) {
            // Caso ocorra um erro interno no servidor
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Ocorreu um erro interno do servidor! Tente novamente mais tarde!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);
        }

        // Lê a resposta da API
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        // Desconecta a conexão
        conn.disconnect();
    }

    public void destroy() {
    }
}
