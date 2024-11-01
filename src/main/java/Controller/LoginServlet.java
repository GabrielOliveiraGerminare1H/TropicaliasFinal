package Controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//        if(email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org\\.br)$"){
@WebServlet(name = "conta", value = "/conta")
public class LoginServlet extends HttpServlet {
//d
    @Override

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email =req.getParameter("email");
        String senha = req.getParameter("senha");

        String url = "https://tropicalias-api-dev.onrender.com/user/authorization/" + email + "/" + senha;
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() == 200) {
            req.getRequestDispatcher("/telasadmin (1).html").forward(req,resp);
        }
        else if (conn.getResponseCode() == 401) {
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Email ou senha inválidos!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp");


        } else if (conn.getResponseCode() == 403) {
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem","Usuário não autorizado!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp");

        } else if (conn.getResponseCode() == 404) {
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Usuário não encontrado!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp");


        } else if (conn.getResponseCode() == 418) {
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Você é muito especial!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp");
        } else if (conn.getResponseCode()== 500) {
            req.setAttribute("verifica", false);
            req.setAttribute("mensagem", "Ocorreu um erro interno do servidor! Tente novamente mais tarde!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));


        conn.disconnect();
    }

    public void destroy() {
    }
}