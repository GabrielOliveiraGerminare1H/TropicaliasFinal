package Controller.Barraca;

import Daos.BarracaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarBarraca", value = "/tabdeletarBarraca")
public class DeletarBarraca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int idBarraca = Integer.parseInt(request.getParameter("pk_int_id_barraca"));

            BarracaDAO barracaDAO = new BarracaDAO();
            boolean verifica = barracaDAO.softDeleteBarraca(idBarraca);
            String mensagem = verifica ? "Barraca deletada com sucesso!" : "Erro ao deletar barraca.";

            request.setAttribute("verifica", verifica);
            request.setAttribute("mensagem",mensagem);
            request.getRequestDispatcher("mensagem.jsp").forward(request,response);

        }catch (NumberFormatException nfe){
            request.setAttribute("verifica",false);
            request.setAttribute("mensagem", nfe.getMessage());
            request.getRequestDispatcher("mensagem.jsp");

        }


    }
}

