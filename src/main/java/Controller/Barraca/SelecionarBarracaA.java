//package Controller.Barraca;
//import Daos.BarracaDAO;
//import Model.Barraca;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//import java.util.List;
//
//
//@WebServlet(name = "Cadastro Tropicalias", value = "/tabSelecionarBarracaA")
//public class SelecionarBarracaA extends HttpServlet {
//
//    private BarracaDAO barracaDAO = new BarracaDAO();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            List<Barraca> barracaA = barracaDAO.selecionarBarracaA();
//
//            request.setAttribute("barracaA", barracaA);
//
//            // Encaminha para a página selecionada
//            request.getRequestDispatcher("SelecinarBarracaA.jsp").forward(request, response);
//
//        } catch (NumberFormatException nfe) {
//            // Se houver uma exceção, encaminha para uma página de mensagem
//            request.getRequestDispatcher("/Pages/Mensagem.jsp").forward(request, response);
//        }
//    }
//}
