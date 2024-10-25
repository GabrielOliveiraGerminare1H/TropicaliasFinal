package Controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "evento", value = "/evento")
public class CadastrarEvento extends HttpServlet {
    @Override

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dataini = req.getParameter("dataini");
        String datafim = req.getParameter("datafim");
        String nome = req.getParameter("nome");
        String local = req.getParameter("local");
        String preco = req.getParameter("preco");

        if () {

            if () {


            } else {
                req.setAttribute();
            }

        } else {
            req.setAttribute();
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    public void destroy() {
    }
}