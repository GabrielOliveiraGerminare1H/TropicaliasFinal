package Controller.Barraca;

import Daos.BarracaDAO;
import Daos.JDBC.Conexao;
import Model.Barraca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "cadastrarBarraca", value = "/cadastrarBarraca")
public class CadastrarBarraca extends HttpServlet {

    // Método que trata requisições POST para cadastrar uma nova barraca
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Instanciando classe conexão
        Conexao conexao = new Conexao();

        try {
            // Obtém parâmetros da requisição
            String nome = request.getParameter("nome"); // Nome do campo a ser atualizado
            int fkEvento;
            try {
                fkEvento = Integer.parseInt(request.getParameter("fk_int_id_evento")); // FK do evento relacionado à barraca
            } catch (NumberFormatException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Formato inválido para o ID do evento.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Cria uma nova instância da barraca com os valores fornecidos
            Barraca barraca = new Barraca(nome, fkEvento);

            // Cria uma instância do DAO para interagir com o banco de dados
            BarracaDAO barracaDAO = new BarracaDAO();

            // Armazenando valor booleano na variável de acordo com o retorno do método
            boolean verifica = barracaDAO.cadastrarBarraca(barraca);

            if (verifica) {
                // Se o cadastro for bem-sucedido, define mensagens de sucesso
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Cadastro realizado com sucesso!");

            } else {
                // Se a FK de barraca inserida não existir no banco de dados
                try {
                    if (!conexao.isFkValida("tb_barraca", "fk_int_id_barraca", fkEvento)) {
                        request.setAttribute("verifica", false);
                        request.setAttribute("mensagem", "FK não existe no banco de dados. Tente novamente.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Erro ao verificar FK no banco de dados.");
                }
            }

            // Redireciona para a página de mensagens
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro interno no servidor.");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        }
    }
}
