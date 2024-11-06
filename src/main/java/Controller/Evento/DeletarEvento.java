package Controller.Evento;

import Daos.EventoDAO;
import java.io.IOException;
import java.sql.SQLException;
import Daos.JDBC.Conexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "deletarEvento", value = "/deletarEvento")
public class DeletarEvento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexao conexao = new Conexao();

        try {
            // Obtém o parâmetro que representa a chave primária do evento
            int pkEvento = Integer.parseInt(request.getParameter("pk_int_id_evento"));

            // Cria uma instância do DAO para interagir com o banco de dados
            EventoDAO eventoDAO = new EventoDAO();

            // Tenta realizar a "exclusão" (SOFTDELETE) do evento
            boolean verifica = eventoDAO.softDeleteEvento(pkEvento);

            // Define mensagens de sucesso ou erro com base no resultado da operação
            if (verifica) {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Evento deletado com sucesso!");
            } else {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Não foi possível deletar o evento! Erro na PK.");
            }

            // Redireciona para a página de mensagens com o feedback da operação
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Captura erro relacionado a conversão de dados (ex: PK inválida)
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro: PK inválida.");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro interno no servidor.");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }
    }
}
