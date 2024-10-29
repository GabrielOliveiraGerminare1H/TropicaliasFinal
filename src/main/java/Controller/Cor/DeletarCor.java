package Controller.Cor;

import Daos.CorMascoteDAO;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletarCor" , value = "/deletarCor")
public class DeletarCor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pkCorMascoteStr = req.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote = Integer.parseInt(pkCorMascoteStr);

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        CorMascote corMascote = new CorMascote();
        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);


        if (verifica) {
            req.getRequestDispatcher("mensagem.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("mensagem","Não foi possível deletar!");
            req.getRequestDispatcher("mensagem.jsp").forward(req, resp);
            req.setAttribute("verifica",false);
        }

    }
}
//De acordo com a requisição do usuário excluir cor


