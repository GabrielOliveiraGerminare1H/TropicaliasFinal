package Controller;
import java.io.*;
import java.time.LocalDate;

import Daos.JDBC.EventoDAO;
import Model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "evento", value = "/evento")
public class CadastrarEvento extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dt_inicio = req.getParameter("dt_inicio");
        String dt_final = req.getParameter("dt_final");
        String nome = req.getParameter("nome");
        String local = req.getParameter("local");
        String preco = req.getParameter("preco");
        String fk_int_id_usuario = req.getParameter("fk_int_id_usuario");

        EventoDAO eventoDAO = new EventoDAO();

        double precoDouble = 0;
        if (preco.matches("[0-9]+([,.][0-9]+)?")) {
            precoDouble = Double.parseDouble(preco);
        } else {
            req.setAttribute("resultado","Você digitou o preço de maneira errada!");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        LocalDate dt_inicioDate = null;
        if (dt_inicio.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
            dt_inicioDate = LocalDate.parse(dt_inicio);
        } else {
            req.setAttribute("resultado","Você digitou a data de maneira errada!");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        LocalDate dt_finalDate = null;
        if (dt_final.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
            dt_finalDate = LocalDate.parse(dt_inicio);
        } else {
            req.setAttribute("resultado","Você digitou a data de maneira errada!");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        if (!dt_inicioDate.isBefore(dt_finalDate)) {
            req.setAttribute("resultado","A data de início deve ser menor que a data de término");
            req.getRequestDispatcher("cadastrarEvento.jsp").forward(req, resp);
        }

        int fk_int_id_usuarioInt = 0;
        if (fk_int_id_usuario.matches("[0-9]+")) {
            Integer.parseInt(fk_int_id_usuario);
        }


        Evento evento = new Evento(nome, local, precoDouble, fk_int_id_usuarioInt, dt_inicioDate, dt_finalDate);
        eventoDAO.cadastrarEvento(evento);

    }

    public void destroy() {
    }
}