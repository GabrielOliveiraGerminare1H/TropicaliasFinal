package Controller.Evento;
import java.io.*;
import java.time.LocalDate;

import Daos.EventoDAO;
import Model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "cadastrarEvento", value = "/cadastrarEvento")
public class CadastrarEvento extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response  )
            throws ServletException, IOException {

        try {

            String dt_inicio = request.getParameter("dt_inicio");
            String dt_final = request.getParameter("dt_final");
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");
            String preco = request.getParameter("preco");
            String fk_int_id_usuario = request.getParameter("fk_int_id_usuario");

            boolean verifica;

            double precoDouble = 0;
            if (preco.matches("[0-9]+([,.][0-9]+)?")) {
                precoDouble = Double.parseDouble(preco);
                verifica = true;
            } else {
                request.setAttribute("mensagem","Você digitou o preço de maneira errada!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            LocalDate dt_inicioDate = null;
            if (dt_inicio.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                dt_inicioDate = LocalDate.parse(dt_inicio);
                verifica = true;
            } else {
                request.setAttribute("mensagem","Você digitou a data de maneira errada!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            LocalDate dt_finalDate = null;
            if (dt_final.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                dt_finalDate = LocalDate.parse(dt_inicio);
                verifica = true;
            } else {
                request.setAttribute("mensagem","Você digitou a data de maneira errada!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            if (dt_inicioDate.isBefore(dt_finalDate)) {
                verifica = true;
            } else {
                request.setAttribute("mensagem","A data de início deve ser menor que a data de término");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            int fk_int_id_usuarioInt = 0;
            if (fk_int_id_usuario.matches("[0-9]+")) {
                Integer.parseInt(fk_int_id_usuario);
            }

            EventoDAO eventoDAO = new EventoDAO();
            Evento evento = new Evento(nome, local, precoDouble, fk_int_id_usuarioInt, dt_inicioDate, dt_finalDate);
            eventoDAO.cadastrarEvento(evento);

        } catch (NumberFormatException nfe){
            request.setAttribute("verifica",false);
            request.setAttribute("mensagem",nfe.getMessage());
            request.getRequestDispatcher("mensagem.jsp").forward(request,response);
        }

    }

    public void destroy() {
    }
}