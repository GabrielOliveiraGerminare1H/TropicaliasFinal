package Controller.Evento;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import Daos.EventoDAO;
import Model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "criarEvento", value = "/cadastrarEvento")
public class CadastrarEvento extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Obtém os parâmetros da requisição para o cadastro do evento
            String dt_inicio = request.getParameter("dt_inicio");
            String dt_final = request.getParameter("dt_final");
            String nome = request.getParameter("var_nome");
            String local = request.getParameter("var_local");
            String preco = request.getParameter("preco");
            String fkUsuario = request.getParameter("fk_int_id_usuario");
            String imagem = request.getParameter("var_imagem");
            String descricao = request.getParameter("var_descricao");


            // Declara a variável de preço como double para conversão posterior
            double precoDouble = 0;
            try {
                precoDouble = Double.parseDouble(preco.replace(",", "."));
            } catch (NumberFormatException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Formato de preço inválido!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            // Converte e valida a data de início
            LocalDate dt_inicioDate = null;
            try {
                dt_inicioDate = LocalDate.parse(dt_inicio);
            } catch (DateTimeParseException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Data de início inválida!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            // Converte e valida a data de término
            LocalDate dt_finalDate = null;
            try {
                dt_finalDate = LocalDate.parse(dt_final);
            } catch (DateTimeParseException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Data de término inválida!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            // Verifica se a data de início é anterior à data de término
            if (!dt_inicioDate.isBefore(dt_finalDate)) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "A data de início deve ser anterior à data de término.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            // Converte o ID do usuário para inteiro e verifica validade
            int fk_int_id_usuarioInt = 0;
            try {
                fk_int_id_usuarioInt = Integer.parseInt(fkUsuario);
            } catch (NumberFormatException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "ID do usuário inválido!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }

            // Cria um objeto Evento e realiza o cadastro no banco de dados
            Evento evento = new Evento(dt_inicioDate, dt_finalDate, nome, local, precoDouble, fk_int_id_usuarioInt, imagem, descricao);
            EventoDAO eventoDAO = new EventoDAO();
            eventoDAO.cadastrarEvento(evento);

            // Define mensagem de sucesso e redireciona para a página de confirmação
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Evento cadastrado com sucesso!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (Exception e) {
            // Em caso de erro geral, define mensagem de erro e redireciona

            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Não foi possível criar o evento!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }
    }

}
