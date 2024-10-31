package Controller.Barraca;

import Daos.BarracaDAO;
import Model.Barraca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CadastrarBarraca", value = "/CadastrarBarraca")
public class CadastrarBarraca extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            String nome = request.getParameter("nome");
            int fkEvento = Integer.parseInt(request.getParameter("fk_int_id_evento"));

            Barraca barraca = new Barraca(nome,fkEvento);
            BarracaDAO barracaDAO = new BarracaDAO();
            boolean verifica = barracaDAO.cadastrarBarraca(barraca);

            String mensagem = verifica ? "Barraca cadastrada com sucesso! " : "Erro ao cadastrar barraca.";

            request.setAttribute("verifica", verifica);
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagem.jsp").forward(request,response);


        }catch (NumberFormatException nfe){
            request.setAttribute("verifica",false);
            request.setAttribute("mensagem",nfe.getMessage());
            request.getRequestDispatcher(" mensagem.jsp").forward(request, response);

        }

    }
}
