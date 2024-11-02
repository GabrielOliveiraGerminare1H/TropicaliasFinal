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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeCampo = request.getParameter("nomeCampo");
        String atualizacaoCampo = request.getParameter("atualizacaoCor");
        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote;

        try {
            pkCorMascote = Integer.parseInt(pkCorMascoteStr);
        } catch (NumberFormatException e) {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "ID inválido fornecido!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            return;
        }

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        boolean verifica = corMascoteDAO.atualizarCorMascote(nomeCampo, atualizacaoCampo, pkCorMascote);

        if (atualizacaoCampo.matches("^#([A-Fa-f0-9]{6})$")) {
            if (verifica) {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Cor atualizada com sucesso!");
            } else {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Não foi possível atualizar a cor.");
            }
        } else {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Código de cor RGB inválido!");
        }

        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}
