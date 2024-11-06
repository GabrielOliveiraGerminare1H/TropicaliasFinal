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
        int pkBarraca = Integer.parseInt(request.getParameter("pk_int_id_barraca"));

        // Cria uma instância do DAO para interagir com o banco de dados
        BarracaDAO barracaDAO = new BarracaDAO();

        // Tenta realizar a "exclusão" (SOFTDELETE) da barraca
        boolean verifica = barracaDAO.softDeleteBarraca(pkBarraca);

        // Define mensagens de sucesso ou erro com base no resultado da operação
           if (verifica) {
               request.setAttribute("verifica", true);
               request.setAttribute("mensagem", "Barraca deletada com sucesso!");
           } else {
               request.setAttribute("verifica", false);
               request.setAttribute("mensagem", "Não foi possível deletar a barraca! Erro na pk");
           }

           // Redireciona para a página de mensagens com o feedback da operação
           request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}



