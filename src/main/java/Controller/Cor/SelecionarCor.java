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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        corMascoteDAO.buscarCorMascoteAtivo();
        try {
            request.setAttribute("verifica",true);
            request.setAttribute("corMascote", corMascoteDAO.buscarCorMascoteAtivo());
            request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);
        }

    }
}

