package Controller;

import Daos.BarracaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "AtualizarBarraca" , value = "/tabAtualizarBarraca")
public class AtualizarBarraca extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{


           String nomeCampo = request.getParameter("nomeCampo");
           String valorNovo = request.getParameter("valorNovo");
           int pkBarraca = Integer.parseInt(request.getParameter("pkBarraca"));
           BarracaDAO barracaDAO = new BarracaDAO();
           boolean verifica = barracaDAO.atualizarBarraca(nomeCampo,valorNovo,pkBarraca);
           String mensagem = verifica ? "Barraca atualizada com sucesso!" : "Erro em atualizar barraca.";

           request.setAttribute("verifica",verifica);
           request.setAttribute("mensagem",mensagem);

           request.getRequestDispatcher("mensagem.jsp").forward(request,response);


       }catch (NumberFormatException nfe){
           request.setAttribute("verifica",false);
           request.setAttribute("mensagem",nfe.getMessage());
           request.getRequestDispatcher("mensagem.jsp").forward(request,response);


       }
    }
}






