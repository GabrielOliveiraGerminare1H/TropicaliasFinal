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

        Conexao conexao = new Conexao();

        // Obtém parâmetros da requisição
        String nomeCampo = request.getParameter("nomeCampo"); // Nome do campo a ser atualizado
        String atualizacaoCampo = request.getParameter("atualizacaoCor"); // Novo valor para o campo
        int pkCorMascote = Integer.parseInt(request.getParameter("pk_int_id_cor_mascote")); // PK do mascote

        // Cria uma instância do DAO e tenta atualizar a cor no banco de dados
        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();

        //Armazenando valor booleano na variável de acordo com o retorno do método
        boolean verifica = corMascoteDAO.atualizarCorMascote(nomeCampo, atualizacaoCampo, pkCorMascote);

        // Define mensagem de acordo com o resultado da atualização
        if (!verifica) {
            //Se a cor inserida não estiver no padrão RGB
            if (!atualizacaoCampo.matches("^#([A-Fa-f0-9]{6})$")) {
                System.out.println("Formato de cor inválido.");
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Código de cor RGB inválido.");

            }
            // Se o nome de campo inserido não exisitir no banco de dados
            else if (!validarNomeCampo(nomeCampo)) {
                System.out.println("Nome do campo inválido.");
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Nome do campo inválido.");
            }
            // Se a PK da cor do mascote inserida não exisitir no banco de dados
            else {
                try {
                    if (!conexao.isPkValida("tb_cor_mascote", "pk_int_id_cor_mascote", pkCorMascote)) {
                        System.out.println("PK não existe no banco.");
                        request.setAttribute("verifica", false);
                        request.setAttribute("mensagem", "Pk não existe no banco de dados. Tente novamente");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        // Se a atualização foi bem-sucedida, define mensagem de sucesso
        else {
            System.out.println("Atualização bem-sucedida!");
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Cor do mascote atualizada com sucesso!");

        }

        // Redireciona para a página de mensagens
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }

    // Método auxiliar para validar o nome do campo
    private boolean validarNomeCampo(String nomeCampo) {
        // Verifica se o nome do campo é um dos campos da tabela no banco de dados
        return nomeCampo.equals("text_fundo") || nomeCampo.equals("text_secundaria") || nomeCampo.equals("text_primaria");
    }
}
