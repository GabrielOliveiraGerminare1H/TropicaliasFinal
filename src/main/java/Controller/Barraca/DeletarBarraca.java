package Controller.Barraca;

import Daos.BarracaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletarBarraca", value = "/deletarBarraca")
public class DeletarBarraca extends HttpServlet {
    // Método que trata requisições POST para deletar uma barraca
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro que representa a chave primária da barraca
        String pkBarraca = request.getParameter("pk_int_id_barraca");
        int pkBarracaInt;

        // Tenta converter o parâmetro para um inteiro
        try {
            pkBarracaInt = Integer.parseInt(pkBarraca);
        } catch (NumberFormatException e) {
            // Se a conversão falhar, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return; // Interrompe a execução do método
        }

        // Cria uma instância do DAO para interagir com o banco de dados
        BarracaDAO barracaDAO = new BarracaDAO();

        // Tenta realizar a "exclusão" (SOFTDELETE) da barraca
        boolean verifica = barracaDAO.softDeleteBarraca(pkBarracaInt);

        // Define mensagens de sucesso ou erro com base no resultado da operação
        if (verifica) {
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Barraca deletada com sucesso!");
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Não foi possível deletar a barraca!");
        }

        // Redireciona para a página de mensagens com o feedback da operação
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}


