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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro que representa a chave primária do evento
        String eventoIdStr = request.getParameter("pk_int_id_evento");
        int eventoId;

        // Tenta converter o parâmetro para um inteiro
        try {
            eventoId = Integer.parseInt(eventoIdStr);
        } catch (NumberFormatException e) {
            // Se a conversão falhar, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID de evento inválido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return; // Interrompe a execução do método
        }

        // Cria uma instância do DAO para interagir com o banco de dados
        EventoDAO eventoDAO = new EventoDAO();

        // Tenta realizar a "exclusão" (SOFTDELETE) do evento
        boolean verifica = eventoDAO.softDeleteEvento(eventoId);

        // Define mensagens de sucesso ou erro com base no resultado da operação
        if (verifica) {
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Evento deletado com sucesso!");
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Não foi possível deletar o evento!");
        }

        // Redireciona para a página de mensagens com o feedback da operação
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}

