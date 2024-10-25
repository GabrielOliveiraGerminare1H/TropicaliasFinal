package Controller;
//Fazer a verificação das datas, verificar se a data inicial é maior que a data final,
// e verificar se o preço está correto,,,, caso dê erro reenvia para a mesma página jsp com a mensagem do que errou!
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

        if (preco.matches("[0-9]+([,.][0-9]+)?")) {
            double precoDouble = Double.parseDouble(preco);
        } else {
            req.setAttribute("resultado","Você digitou o preço de maneira errada! ");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }


    }

    public void destroy() {
    }
}