package Controller.Cor;

import Daos.JDBC.CorMascoteDAO;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "atualizarCor" , value = "/atualizarCor")

public class AtualizarCor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nomeCampo =req.getParameter("nomeCampo");
        String atualizacaoCampo = req.getParameter("atualizacaoCampo");
        String pkCorMascoteStr = req.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote = Integer.parseInt(pkCorMascoteStr);

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();

        if (atualizacaoCampo.matches("^#([A-Fa-f0-9]{6})$")){
            if (corMascoteDAO.atualizarCorMascote(nomeCampo,atualizacaoCampo,pkCorMascote)==0){
                req.getRequestDispatcher("telasadmin.jsp").forward(req, resp);
            }else {
                req.setAttribute("resultado","Não foi possível atualizar!");
                req.getRequestDispatcher("atualizarCorMascote.jsp").forward(req, resp);
            }
        }
        else {
            req.setAttribute("resultado","Você digitou o código de cor RGB de maneira errada!");
            req.getRequestDispatcher("atualizarCorMascote.jsp").forward(req, resp);
        }

    }
}//De acordo com a requisição do usuário atualizar cor
