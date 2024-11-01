package Controller.Cor;

import Daos.CorMascoteDAO;
import Model.CorMascote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "atualizarCor" , value = "/AtualizarCor")

public class AtualizarCor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeCampo =request.getParameter("nomeCampo");
        String atualizacaoCampo = request.getParameter("atualizacaoCampo");
        String pkCorMascoteStr = request.getParameter("pk_int_id_cor_mascote");
        int pkCorMascote = Integer.parseInt(pkCorMascoteStr);

        CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
        boolean verifica = corMascoteDAO.atualizarCorMascote(nomeCampo,atualizacaoCampo,pkCorMascote);

        if (atualizacaoCampo.matches("^#([A-Fa-f0-9]{6})$")){
            if (verifica){
                request.setAttribute("verifica",true);
                request.setAttribute("mensagem","Cadastro realizado com sucesso!");
                request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);

            }else {
                request.setAttribute("mensagem","Não foi possível atualizar!");
                request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);

            }
        }
        else {
            request.setAttribute("mensagem","Você digitou o código de cor RGB de maneira errada!");
            request.setAttribute("verifica",false);
            request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);
        }

    }
}//De acordo com a requisição do usuário atualizar cor
