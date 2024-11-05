package Controller.Evento;

import Daos.EventoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "atualizarEvento", value = "/atualizarEvento")
public class AtualizarEvento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém parâmetros da requisição
        String nomeCampo = request.getParameter("nomeCampo"); // Nome do campo a ser atualizado
        String atualizacaoCampo = request.getParameter("atualizacaoCampo"); // Novo valor para o campo
        String pkEvento = request.getParameter("pk_int_id_evento"); // ID do evento
        int pkEventoInt = 0;

        // Converte o ID do evento de String para int
        try {
            pkEventoInt = Integer.parseInt(pkEvento);
        } catch (NumberFormatException e) {
            // Caso o ID seja inválido, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }

        // Cria uma instância do DAO e tenta atualizar o evento no banco de dados
        EventoDAO eventoDAO = new EventoDAO();
        boolean verifica = eventoDAO.atualizarEvento(nomeCampo, atualizacaoCampo, pkEventoInt);

        // Define mensagem de acordo com o resultado da atualização
        if (verifica) {
            // Se a atualização foi bem-sucedida, define mensagem de sucesso
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Evento atualizado com sucesso!");
        } else {
            // Se não foi possível atualizar, define mensagem de erro
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro ao atualizar o evento. ATENÇÃO verifique os campos e se o evento existe");
        }

        // Redireciona para a página de mensagens
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}
