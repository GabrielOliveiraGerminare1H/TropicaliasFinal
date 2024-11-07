package controller.cor;

import daos.CorMascoteDAO;
import daos.JDBC.Conexao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletarCor", value = "/deletarCor")
public class DeletarCor extends HttpServlet {
    // Método que trata requisições POST para deletar uma cor de mascote
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro que representa a chave primária da cor do mascote
        int pkCorMascote = Integer.parseInt(request.getParameter("pk_int_id_cor_mascote"));

        Conexao conexao = new Conexao();

            // Cria uma instância do DAO para interagir com o banco de dados
            CorMascoteDAO corMascoteDAO = new CorMascoteDAO();

            // Tenta realizar a "exclusão" (SOFTDELETE) da cor do mascote
            boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);

        // Define mensagens de sucesso ou erro com base no resultado da operação
        if (verifica) {
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Cor deletada com sucesso!");
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Não foi possível deletar a cor.");
        }

        // Redireciona para a página de mensagens com o feedback da operação
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);

    }
}

