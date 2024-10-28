package Controller.Evento;
//Fazer a verificação das datas, verificar se a data inicial é maior que a data final,
// e verificar se o preço está correto,,,, caso dê erro reenvia para a mesma página jsp com a mensagem do que errou!
import java.io.*;
import java.time.LocalDate;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "evento", value = "/cadastrarEvento")
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

//        LocalDate dataVerificacao = datafimDate - datainiDate;
    }

    public void destroy() {
    }
}