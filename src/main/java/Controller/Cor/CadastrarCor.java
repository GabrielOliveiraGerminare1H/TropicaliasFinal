package Controller.Cor;

import Daos.CorMascoteDAO;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "cadastrarCor", value = "/cadastrarCor")
public class CadastrarCor extends HttpServlet {
    // Método que trata requisições POST para cadastrar uma nova cor de mascote
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém os parâmetros da requisição que representam as cores
        String textFundo = request.getParameter("text_fundo"); // Cor de fundo
        String textPrimaria = request.getParameter("text_primaria"); // Cor primária
        String textSecundaria = request.getParameter("text_secundaria"); // Cor secundária

        // Cria uma instância do DAO para interagir com o banco de dados
        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();

        // Valida se todas as cores estão em formato hexadecimal
        if ((textFundo.matches("^#([A-Fa-f0-9]{6})$")) &&
                (textPrimaria.matches("^#([A-Fa-f0-9]{6})$")) &&
                (textSecundaria.matches("^#([A-Fa-f0-9]{6})$"))) {

            // Se a validação for bem-sucedida, cria um novo objeto CorMascote
            CorMascote corMascote = new CorMascote(textFundo, textPrimaria, textSecundaria);
            boolean verifica = corMascoteDAO.cadastrarCorMascote(corMascote); // Tenta cadastrar a cor

            if (verifica) {
                // Se o cadastro for bem-sucedido, define mensagens de sucesso
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response); // Redireciona para a página de mensagens
            } else {
                // Se o cadastro falhar, define mensagem de erro
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Não foi possível realizar o cadastro!");
            }
        } else {
            // Se as cores estiverem em formato inválido, define mensagem de erro
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Você digitou o código de cor RGB de maneira errada!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response); // Redireciona para a página de mensagens
        }
    }
}



