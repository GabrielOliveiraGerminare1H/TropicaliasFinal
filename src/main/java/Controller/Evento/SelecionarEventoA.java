package Controller.Evento;

import Daos.EventoDAO;
import Model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cadastro Tropicalias" , value = "")
public class SelecionarEventoA extends HttpServlet {

    EventoDAO eventoDAO = new EventoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Evento> eventoA = eventoDAO.selecionarEventoA() ;

        request.setAttribute("eventoA", eventoDAO.toString() );

        request.getRequestDispatcher("SelecionarEventosA").forward(request,response);

    }
}
