package Controller.Cor;

import Daos.CorMascoteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//
//@WebServlet(name = "deletarCor" , value = "/deletarCor")
//public class DeletarCor extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
//        int pkCorMascote = Integer.parseInt(pkCorMascoteStr);
//
//        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
//        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);
//
//
//        if (verifica) {
//            request.setAttribute("verifica",true);
//            request.setAttribute("mensagem","Cor deletada com sucesso!");
//            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//        }
//        else {
//            request.setAttribute("verifica",false);
//            request.setAttribute("mensagem","Não foi possível deletar!");
//            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//
//        }
//
//    }
//}
//De acordo com a requisição do usuário excluir cor




@WebServlet(name = "deletarCor", value = "/deletarCor")
public class DeletarCor extends HttpServlet {
    // Método que trata requisições POST para deletar uma cor de mascote
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro que representa a chave primária da cor do mascote
        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote;

        // Tenta converter o parâmetro para um inteiro
        try {
            pkCorMascote = Integer.parseInt(pkCorMascoteStr);
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
        boolean verifica = corMascoteDAO.softDeleteCorMascote(pkCorMascote);

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

