package Controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "conta", value = "/conta")
public class LoginServlet extends HttpServlet {

    @Override

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email =req.getParameter("email");
        String senha = req.getParameter("senha");

        if(email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org\\.br)$"){
            if(buscarEmail(email) && verificarSenha(senha)){


            }
            else{
                req.setAttribute("semEmail","E-mail incorreto");
            }
        }
        else{
            req.setAttribute("resultado","Erro de formatação no e-mail!");
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }
    }

    public void destroy() {
    }
}