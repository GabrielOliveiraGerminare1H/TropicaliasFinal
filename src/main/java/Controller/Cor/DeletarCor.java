package Controller.Cor;

import Daos.CorMascoteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//
//@WebServlet(name = "deletarCor" , value = "/deletarCor")
//public class DeletarCor extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
//        int pkCorMascote = Integer.parseInt(pkCorMascoteStr);
//
//        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
//        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);
//
//
//        if (verifica) {
//            request.setAttribute("verifica",true);
//            request.setAttribute("mensagem","Cor deletada com sucesso!");
//            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//        }
//        else {
//            request.setAttribute("verifica",false);
//            request.setAttribute("mensagem","Não foi possível deletar!");
//            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//
//        }
//
//    }
//}
//De acordo com a requisição do usuário excluir cor




@WebServlet(name = "deletarCor", value = "/deletarCor")
public class DeletarCor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote;

        try {
            pkCorMascote = Integer.parseInt(pkCorMascoteStr);
        } catch (NumberFormatException e) {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return;
        }

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);

        if (verifica) {
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Cor deletada com sucesso!");
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Não foi possível deletar!");
        }

        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}
