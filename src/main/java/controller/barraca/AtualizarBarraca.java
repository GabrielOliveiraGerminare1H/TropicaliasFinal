package controller.barraca;

import daos.BarracaDAO;
import daos.JDBC.Conexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "atualizarBarraca" , value = "/atualizarBarraca")
public class AtualizarBarraca extends HttpServlet {

    // Método que trata requisições POST para atualizar barraca
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexao conexao = new Conexao();

        // Obtém parâmetros da requisição
        String nomeCampo = request.getParameter("campoBarraca"); // Nome do campo a ser atualizado
        String valorNovo = request.getParameter("atualizacaoBarraca"); // Novo valor para o campo
        int pkBarraca = Integer.parseInt(request.getParameter("pk_int_id_barraca")); // PK da barraca

        // Cria uma instância do DAO e tenta atualizar a barraca no banco de dados
        BarracaDAO barracaDAO = new BarracaDAO();

        //Armazenando valor booleano na variável de acordo com o retorno do método
        boolean verifica = barracaDAO.atualizarBarraca(nomeCampo, valorNovo, pkBarraca);

        // Define mensagem de acordo com o resultado da atualização
        if (!verifica) {
            // Se a atualização foi mal-sucedida, define mensagem de erro
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro ao atualizar barraca");

            if (!validarNomeCampo(nomeCampo)) {
                // Se o nome de campo inserido não exisitir no banco de dados
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Nome do campo inválido.");
            }
            // Se a PK de barraca inserida não exisitir no banco de dados
            else {
                try {
                    if (!conexao.isPkValida("tb_barraca","pk_int_id_barraca",pkBarraca)) {
                        request.setAttribute("verifica", false);
                        request.setAttribute("mensagem", "Pk não existe no banco de dados.");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            // Se a atualização foi bem-sucedida, define mensagem de sucesso
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Barraca atualizada com sucesso! ");
        }

        // Redireciona para a página de mensagens
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }

    // Método auxiliar para validar o nome do campo
    private boolean validarNomeCampo(String nomeCampo) {
        // Verifica se o nome do campo é um dos campos da tabela no banco de dados
        return nomeCampo.equals("var_nome") || nomeCampo.equals("fk_int_id_evento");
    }

}






