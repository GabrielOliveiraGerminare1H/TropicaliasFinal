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

@WebServlet(name = "deletarCor", value = "/deletarCor")
public class DeletarCor extends HttpServlet {
    // Método que trata requisições POST para deletar uma cor de mascote
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instancia a conexão e declara variáveis de controle
        Conexao conexao = new Conexao();
        boolean verifica = false;

        try {
            // Obtém o parâmetro que representa a chave primária da cor do mascote
            int pkCorMascote = Integer.parseInt(request.getParameter("pk_int_id_cor_mascote"));

            // Cria uma instância do DAO para interagir com o banco de dados e tenta realizar a exclusão
            CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
            verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);

            // Define mensagens de sucesso ou erro com base no resultado da operação
            if (verifica) {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Cor deletada com sucesso!");
            } else {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Não foi possível deletar a cor! Erro na pk");
            }
            // Redireciona para a página de mensagens com o feedback da operação
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Formato de ID inválido.");

        }
    }
}
