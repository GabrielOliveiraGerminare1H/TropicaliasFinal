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

@WebServlet(name = "cadastrarCor" , value = "/CadastrarCor")
public class CadastrarCor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String textFundo =request.getParameter("text_fundo");
        String textPrimaria = request.getParameter("text_primaria");
        String textSecundaria = request.getParameter("text_secundaria");

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();


        if (textFundo.matches("^#([A-Fa-f0-9]{6})$")) {
            CorMascote corMascote = new CorMascote(textFundo,textPrimaria,textSecundaria);
            boolean verifica = corMascoteDAO.cadastrarCorMascote(corMascote);
            if (verifica) {
                request.setAttribute("verifica",true);
                request.setAttribute("mensagem","Cadastrado no Banco");
                request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);

            }
            else {
                request.setAttribute("mensagem","Não foi possível cadastrar!");
                request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);

            }
        } else {
            request.setAttribute("verifica",false);
            request.setAttribute("mensagem","Você digitou o código de cor RGB de maneira errada!");
            request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);
        }
    }
}


