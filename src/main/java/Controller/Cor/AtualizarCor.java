package Controller.Cor;

import Daos.CorMascoteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "atualizarCor", value = "/atualizarCor")
public class AtualizarCor extends HttpServlet {
    // Método que trata requisições POST para atualizar a cor de um mascote
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém parâmetros da requisição
        String nomeCampo = request.getParameter("nomeCampo"); // Nome do campo a ser atualizado
        String atualizacaoCampo = request.getParameter("atualizacaoCor"); // Novo valor para o campo
        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote"); // ID do mascote
        int pkCorMascote;

        // Tenta converter o ID do mascote de String para int
        try {
            pkCorMascote = Integer.parseInt(pkCorMascoteStr);
        } catch (NumberFormatException e) {
            // Caso o ID seja inválido, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return; // Sai do método
        }

        // Cria uma instância do DAO e tenta atualizar a cor no banco de dados
        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        boolean verifica = corMascoteDAO.atualizarCorMascote(nomeCampo, atualizacaoCampo, pkCorMascote);

        // Valida se o novo valor da cor está em formato hexadecimal correto
        if (atualizacaoCampo.matches("^#([A-Fa-f0-9]{6})$")) {
            if (verifica) {
                // Se a atualização foi bem-sucedida, define mensagem de sucesso
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Cor atualizada com sucesso!");
            } else {
                // Se não foi possível atualizar, define mensagem de erro
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Não foi possível atualizar a cor.");
            }
        } else {
            // Se o formato da cor for inválido, define mensagem de erro
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Código de cor RGB inválido!");
        }

        // Redireciona para a página de mensagens
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}
