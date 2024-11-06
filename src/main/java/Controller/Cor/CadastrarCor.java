package Controller.Cor;

import Daos.CorMascoteDAO;
import Daos.JDBC.Conexao;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "cadastrarCor", value = "/cadastrarCor")
public class CadastrarCor extends HttpServlet {

    // Método que trata requisições POST para cadastrar uma nova cor de mascote
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Instanciando classe conexão
        Conexao conexao = new Conexao();

        try {
            // Obtém os parâmetros da requisição que representam as cores
            String textFundo = request.getParameter("text_fundo"); // Cor de fundo
            String textPrimaria = request.getParameter("text_primaria"); // Cor primária
            String textSecundaria = request.getParameter("text_secundaria"); // Cor secundária

            // Validação de formato RGB
            if ((textFundo.matches("^#([A-Fa-f0-9]{6})$")) &&
                    (textPrimaria.matches("^#([A-Fa-f0-9]{6})$")) &&
                    (textSecundaria.matches("^#([A-Fa-f0-9]{6})$"))) {

                // Se a validação do padrão RGB for bem-sucedida, cria um novo objeto CorMascote
                CorMascote corMascote = new CorMascote(textFundo, textPrimaria, textSecundaria);

                // Cria uma instância do DAO e tenta cadastrar a cor
                CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
                boolean verifica = corMascoteDAO.cadastrarCorMascote(corMascote);

                if (verifica) {
                    // Cadastro bem-sucedido
                    request.setAttribute("verifica", true);
                    request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
                } else {
                    // Falha no cadastro
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Não foi possível realizar o cadastro.");
                }

            } else {
                // Se as cores estiverem em formato inválido, define mensagem de erro
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Você digitou o código de cor RGB de maneira errada!");
            }
            // Redireciona para a página de mensagens
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro de entrada/saída.");


    }
    }
}
