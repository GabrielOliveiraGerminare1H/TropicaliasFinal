package Controller.Evento;

import Daos.EventoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "atualizarCor" , value = "/atualizarEvento")

public class AtualizarEvento {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String nomeCampo = request.getParameter("nomeCampo");
            String atualizacaoCampo = request.getParameter("atualizacaoCampo");
            String pk_int_id_evento = request.getParameter("pk_int_id_evento");
            int pkEvento = Integer.parseInt(pk_int_id_evento);

            EventoDAO eventoDAO = new EventoDAO();
            boolean verifica = eventoDAO.atualizarEvento(nomeCampo, atualizacaoCampo, pkEvento);
            String mensagem = verifica ? "Evento atualizado com sucesso!" : "Erro em atualizar evento.";

            request.setAttribute("verifica",verifica);
            request.setAttribute("mensagem",mensagem);

            request.getRequestDispatcher("mensagem.jsp").forward(request,response);

        } catch (NumberFormatException nfe) {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", nfe.getMessage());
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }

    }

}
