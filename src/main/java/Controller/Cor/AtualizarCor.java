package Controller.Cor;

import Daos.CorMascoteDAO;
import Daos.JDBC.Conexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "atualizarCor", value = "/atualizarCor")
public class AtualizarCor extends HttpServlet {

    // Método que trata requisições POST para atualizar a cor de um mascote
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Instanciando classe conexão
        Conexao conexao = new Conexao();

        try {
            // Obtém parâmetros da requisição
            String nomeCampo = request.getParameter("nomeCampo"); // Nome do campo a ser atualizado
            String atualizacaoCampo = request.getParameter("atualizacaoCor"); // Novo valor para o campo

            int pkCorMascote;
            try {
                pkCorMascote = Integer.parseInt(request.getParameter("pk_int_id_cor_mascote")); // PK do mascote
            } catch (NumberFormatException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Formato inválido para o ID do mascote.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Cria uma instância do DAO
            CorMascoteDAO corMascoteDAO = new CorMascoteDAO();

            // Armazenando valor booleano na variável de acordo com o retorno do método
            boolean verifica = corMascoteDAO.atualizarCorMascote(nomeCampo, atualizacaoCampo, pkCorMascote);

            // Se a atualização foi mal-sucedida, define mensagem de erro
            if (!verifica) {
                // Se a cor inserida não estiver no padrão RGB
                if (!atualizacaoCampo.matches("^#([A-Fa-f0-9]{6})$")) {
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Código de cor RGB inválido.");
                }
                // Se o nome de campo inserido não existir no banco de dados
                else if (!validarNomeCampo(nomeCampo)) {
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Nome do campo inválido.");
                }
                // Se a PK da cor do mascote inserida não existir no banco de dados
                else {
                    try {
                        if (!conexao.isPkValida("tb_cor_mascote", "pk_int_id_cor_mascote", pkCorMascote)) {
                            request.setAttribute("verifica", false);
                            request.setAttribute("mensagem", "PK não existe no banco de dados. Tente novamente.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        request.setAttribute("verifica", false);
                        request.setAttribute("mensagem", "Erro ao verificar PK no banco de dados.");
                    }
                }
            }
            // Se a atualização foi bem-sucedida, define mensagem de sucesso
            else {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Cor do mascote atualizada com sucesso!");
            }
            // Redireciona para a página de mensagens
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro interno no servidor.");


    }}

    // Método auxiliar para validar o nome do campo
    private boolean validarNomeCampo(String nomeCampo) {
        // Verifica se o nome do campo é um dos campos da tabela no banco de dados
        return nomeCampo.equals("text_fundo") || nomeCampo.equals("text_secundaria") || nomeCampo.equals("text_primaria");
    }
}
