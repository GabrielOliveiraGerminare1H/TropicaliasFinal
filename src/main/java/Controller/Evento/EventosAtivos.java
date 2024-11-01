//package Controller.Evento;
//
//import Daos.EventoDAO;
//import Model.Evento;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "EventosAtivos" , value = "/tabEventosAtivos")
//public class EventosAtivos extends HttpServlet  {
//    private EventoDAO eventoDAO = new EventoDAO();
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            List<Evento> eventosA = eventoDAO.selecionarEventoA();
//            request.setAttribute(eventosA.toString(), "eventosA");
//
//            request.getRequestDispatcher("SelecionarEventosA.jsp");
//        }
//        catch (NumberFormatException nfe){
//
//        }
//
//
//    }
//}
