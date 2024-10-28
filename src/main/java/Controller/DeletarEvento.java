package Controller;

import Daos.JDBC.EventoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeletarEvento {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String id_evento = request.getParameter("id_evento");
            int id_eventoInt = Integer.parseInt(id_evento);

            EventoDAO eventoDAO = new EventoDAO();
            eventoDAO.softDeleteEvento(id_eventoInt);

        } catch (NumberFormatException nfe) {

            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", nfe.getMessage());
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        }

    }

}
