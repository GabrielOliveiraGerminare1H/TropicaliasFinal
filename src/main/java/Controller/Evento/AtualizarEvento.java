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

        Conexao conexao = new Conexao();

        // Obtém parâmetros da requisição
        String nomeCampo = request.getParameter("nomeCampo"); // Nome do campo a ser atualizado
        String atualizacaoCampo = request.getParameter("atualizacaoCampo"); // Novo valor para o campo
        int pkEvento = Integer.parseInt(request.getParameter("pk_int_id_evento")); // PK do evento


        // Criação da instância do DAO e tenta atualizar o evento no banco de dados
        EventoDAO eventoDAO = new EventoDAO();

        //Armazenando valor booleano na variável de acordo com o retorno do método
        boolean verifica = eventoDAO.atualizarEvento(nomeCampo, atualizacaoCampo, pkEvento);

        // Define mensagem de acordo com o resultado da atualização
        if (!verifica) {
            // Se a atualização foi mal-sucedida, define mensagem de erro
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro ao atualizar evento");

            if (!validarNomeCampo(nomeCampo)) {
                // Se o nome de campo inserido não exisitir no banco de dados
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Nome do campo inválido.");
            }
            else {
                try {
                    // Se a PK de evento inserida não exisitir no banco, define mensagem de erro
                    if (!conexao.isPkValida("tb_evento","pk_int_id_evento",pkEvento)) {
                        request.setAttribute("verifica", false);
                        request.setAttribute("mensagem", "Pk não existe no banco de dados. Tente novamente");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            // Se a atualização foi bem-sucedida, define mensagem de sucesso
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Evento atualizado com sucesso! ");
        }

        // Redireciona para a página de mensagens
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }

    // Método auxiliar para validar o nome do campo
    private boolean validarNomeCampo(String nomeCampo) {
        // Verifica se o nome do campo é um dos campos da tabela no banco de dados
        return nomeCampo.equals("dt_inicio") || nomeCampo.equals("dt_final") || nomeCampo.equals("var_nome")
                || nomeCampo.equals("var_local")|| nomeCampo.equals("num_preco_ticket")
                || nomeCampo.equals("fk_int_id_usuario") || nomeCampo.equals("var_imagem")|| nomeCampo.equals("var_descricao");
    }


}
