package Controller;
import java.io.*;
import java.time.LocalDate;
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

        if (preco.matches("[0-9]+([,.][0-9]+)?")) {
            double precoDouble = Double.parseDouble(preco);
        } else {
            req.setAttribute("resultado","Você digitou o preço de maneira errada!");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        LocalDate datainiDate = null;
        if (dataini.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
            datainiDate = LocalDate.parse(dataini);
        } else {
            req.setAttribute("resultado","Você digitou a data de maneira errada!");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        LocalDate datafimDate = null;
        if (datafim.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
            datafimDate = LocalDate.parse(dataini);
        } else {
            req.setAttribute("resultado","Você digitou a data de maneira errada!");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        if (!datainiDate.isBefore(datafimDate)) {
            req.setAttribute("resultado","A data de início deve ser menor que a data de término");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }
            
    }

    public void destroy() {
    }
}