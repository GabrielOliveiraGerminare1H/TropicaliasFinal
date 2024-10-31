package Controller.Cor;

import Daos.CorMascoteDAO;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletarCor" , value = "/DeletarCor")
public class DeletarCor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote = Integer.parseInt(pkCorMascoteStr);

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        CorMascote corMascote = new CorMascote();
        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);


        if (verifica) {
            request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
        }
        else {
            request.setAttribute("mensagem","Não foi possível deletar!");
            request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
            request.setAttribute("verifica",false);
        }

    }
}
//De acordo com a requisição do usuário excluir cor


