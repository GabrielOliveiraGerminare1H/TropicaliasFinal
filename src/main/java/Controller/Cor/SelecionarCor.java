package Controller.Cor;

import Daos.CorMascoteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "selecionarCor" , value = "/selecionarCor")

public class SelecionarCor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        corMascoteDAO.buscarCorMascoteAtivo();
        try {
            req.setAttribute("verifica",true);
            req.setAttribute("corMascote", corMascoteDAO.buscarCorMascoteAtivo());
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Pages/Mensagem.jsp").forward(req, resp);
        }

    }
}
//De acordo com a requisição do usuário  mostrar cor ativas (igual usuários ativos)
