package Controller.Evento;

import Daos.EventoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "deletarEvento", value = "/deletarEvento")
public class DeletarEvento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica para deletar o evento
        String eventoId = request.getParameter("pk_int_id_evento");

        if (eventoId != null && !eventoId.isEmpty()) {
            try {
                int id = Integer.parseInt(eventoId);
                // Lógica para deletar o evento usando o EventoDAO, por exemplo:
                EventoDAO eventoDAO = new EventoDAO();
                eventoDAO.softDeleteEvento(id);

                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Evento deletado com sucesso!");
            } catch (NumberFormatException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "ID de evento inválido!");
            }
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID do evento é obrigatório!");
        }

        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}
