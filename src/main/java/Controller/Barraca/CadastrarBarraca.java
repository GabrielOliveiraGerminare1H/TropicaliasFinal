package Controller.Barraca;

import Daos.BarracaDAO;
import Model.Barraca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastrarBarraca", value = "/cadastrarBarraca")
public class CadastrarBarraca extends HttpServlet {

    // Método que trata requisições POST para cadastrar uma nova barraca
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtém o parâmetro "nome" da requisição para definir o nome da barraca
            String nome = request.getParameter("nome");
            // Obtém o parâmetro "fk_int_id_evento" da requisição e converte para um inteiro, que representa o evento associado à barraca
            int fkEvento = Integer.parseInt(request.getParameter("fk_int_id_evento"));

            // Cria uma nova instância da barraca com os valores fornecidos
            Barraca barraca = new Barraca(nome, fkEvento);
            // Cria uma instância do DAO para interagir com o banco de dados
            BarracaDAO barracaDAO = new BarracaDAO();
            // Tenta cadastrar a nova barraca no banco de dados
            boolean verifica = barracaDAO.cadastrarBarraca(barraca);

            // Define a mensagem de sucesso ou erro com base no resultado da operação
            String mensagem = verifica ? "Barraca cadastrada com sucesso!" : "Erro ao cadastrar barraca.";

            // Define os atributos de verificação e mensagem para exibir o resultado da operação
            request.setAttribute("verifica", verifica);
            request.setAttribute("mensagem", mensagem);
            // Encaminha a requisição para "mensagem.jsp" para exibir o feedback ao usuário
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (NumberFormatException nfe) {
            // Trata a exceção caso o parâmetro "fk_int_id_evento" não seja um número válido
            request.setAttribute("verifica", false);
            // Define a mensagem de erro com o detalhe da exceção
            request.setAttribute("mensagem", "ID do evento inválido: " + nfe.getMessage());
            // Encaminha a requisição para "mensagem.jsp" para exibir a mensagem de erro ao usuário
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }
    }
}
