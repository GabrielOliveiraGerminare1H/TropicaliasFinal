package Controller.Evento;

import Daos.EventoDAO;
import Daos.JDBC.Conexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "atualizarEvento", value = "/atualizarEvento")
public class AtualizarEvento extends HttpServlet {

    // Obtém parâmetros da requisição
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexao conexao = null;
        try {
            // Instancia a conexão e obtém os parâmetros da requisição
            conexao = new Conexao();
            String nomeCampo = request.getParameter("nomeCampo");
            String atualizacaoCampo = request.getParameter("atualizacaoCampo");
            int pkEvento = Integer.parseInt(request.getParameter("pk_int_id_evento"));

            // Cria instância do DAO e tenta realizar a atualização
            EventoDAO eventoDAO = new EventoDAO();
            boolean verifica = eventoDAO.atualizarEvento(nomeCampo, atualizacaoCampo, pkEvento);

            // Define mensagens com base no resultado da operação
            if (!verifica) {
                if (!validarNomeCampo(nomeCampo)) {
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Nome do campo inválido.");
                } else if (!conexao.isPkValida("tb_evento", "pk_int_id_evento", pkEvento)) {
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Pk não existe no banco de dados. Tente novamente.");
                }
            } else {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Evento atualizado com sucesso!");
            }
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro ao acessar o banco de dados.");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Formato de ID inválido.");


        }
    }

    // Método auxiliar para validar o nome do campo
    private boolean validarNomeCampo(String nomeCampo) {
        return nomeCampo.equals("dt_inicio") || nomeCampo.equals("dt_final") || nomeCampo.equals("var_nome")
                || nomeCampo.equals("var_local") || nomeCampo.equals("num_preco_ticket")
                || nomeCampo.equals("fk_int_id_usuario") || nomeCampo.equals("var_imagem") || nomeCampo.equals("var_descricao");
    }
}
