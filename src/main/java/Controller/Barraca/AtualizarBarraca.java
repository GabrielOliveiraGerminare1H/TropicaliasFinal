package Controller.Barraca;

import Daos.BarracaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "atualizarBarraca" , value = "/atualizarBarraca")
public class AtualizarBarraca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém parâmetros da requisição
        String nomeCampo = request.getParameter("campoBarraca"); // Nome do campo a ser atualizado
        String valorNovo = request.getParameter("atualizacaoBarraca"); // Novo valor para o campo
        String pkBarraca = request.getParameter("pk_int_id_barraca"); // ID da barraca
        int pkBarracaInt;

        // Converte o ID da barraca de String para int
        try {
            pkBarracaInt = Integer.parseInt(pkBarraca);
        } catch (NumberFormatException e) {
            // Caso o ID seja inválido, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return; // Sai do método
        }

        // Cria uma instância do DAO e tenta atualizar a barraca no banco de dados
        BarracaDAO barracaDAO = new BarracaDAO();
        boolean verifica = barracaDAO.atualizarBarraca(nomeCampo, valorNovo, pkBarracaInt);

        // Define mensagem de acordo com o resultado da atualização
        if (verifica) {
            // Se a atualização foi bem-sucedida, define mensagem de sucesso
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Barraca atualizada com sucesso!");
        } else {
            // Se não foi possível atualizar, define mensagem de erro
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro ao atualizar a barraca. ATENÇÃO verifique os campos e se a barraca existe");
        }
        //Adicionar condição para mensagme se a barrca bão existe se o campo não existit

        // Redireciona para a página de mensagens
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }


}






