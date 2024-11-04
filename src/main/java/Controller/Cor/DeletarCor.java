package Controller.Cor;

import Daos.CorMascoteDAO;
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
        String pkCorMascote = request.getParameter("pk_int_id_cor_mascote");
        int pkCorMascoteInt;

        // Tenta converter o parâmetro para um inteiro
        try {
            pkCorMascoteInt = Integer.parseInt(pkCorMascote);
        } catch (NumberFormatException e) {
            // Se a conversão falhar, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return; // Interrompe a execução do método
        }

        // Cria uma instância do DAO para interagir com o banco de dados
        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();

        // Tenta realizar a "exclusão" (SOFTDELETE) da cor do mascote
        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascoteInt);

        // Define mensagens de sucesso ou erro com base no resultado da operação
        if (verifica) {
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Cor deletada com sucesso!");
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Não foi possível deletar!");
        }

        // Redireciona para a página de mensagens com o feedback da operação
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}

