package Controller.Cor;

import Daos.CorMascoteDAO;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "cadastrarCor" , value = "/cadastrarCor")
public class CadastrarCor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String textFundo =req.getParameter("text_fundo");
        String textPrimaria = req.getParameter("text_primaria");
        String textSecundaria = req.getParameter("text_secundaria");

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();


        if (textFundo.matches("^#([A-Fa-f0-9]{6})$")) {
            CorMascote corMascote = new CorMascote(textFundo,textPrimaria,textSecundaria);
            boolean verifica = corMascoteDAO.cadastrarCorMascote(corMascote);
            if (verifica) {
                req.setAttribute("verifica",true);
                req.setAttribute("mensagem","Cadastrado no Banco");
                req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);

            }
            else {
                req.setAttribute("mensagem","Não foi possível cadastrar!");
                req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);

            }
        } else {
            req.setAttribute("verifica",false);
            req.setAttribute("mensagem","Você digitou o código de cor RGB de maneira errada!");
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);
        }
    }
}


