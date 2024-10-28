package Controller;

import Daos.JDBC.EventoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeletarEvento {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id_evento = req.getParameter("id_evento");
        int id_eventoInt = Integer.parseInt(id_evento);

    }

}
