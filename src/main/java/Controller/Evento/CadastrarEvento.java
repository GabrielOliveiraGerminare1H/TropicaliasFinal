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
                setErrorMessage(request, response, "Formato de preço inválido!");
            }

            // Converte e valida a data de início
            LocalDate dt_inicioDate = null;
            try {
                dt_inicioDate = LocalDate.parse(dt_inicio);
            } catch (DateTimeParseException e) {
                setErrorMessage(request, response, "Data de início inválida!");
            }

            // Converte e valida a data de término
            LocalDate dt_finalDate = null;
            try {
                dt_finalDate = LocalDate.parse(dt_final);
            } catch (DateTimeParseException e) {
                setErrorMessage(request, response, "Data de término inválida!");
            }

            // Verifica se a data de início é anterior à data de término
            if (!dt_inicioDate.isBefore(dt_finalDate)) {
                setErrorMessage(request, response, "A data de início deve ser anterior à data de término.");
            }

            // Converte o ID do usuário para inteiro e verifica validade
            int fk_int_id_usuarioInt = 0;
            try {
                fk_int_id_usuarioInt = Integer.parseInt(fkUsuario);
            } catch (NumberFormatException e) {
                setErrorMessage(request, response, "ID do usuário inválido!");
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
            setErrorMessage(request, response, "Erro ao cadastrar o evento: " + e.getMessage());
        }
    }

    // Método auxiliar para definir a mensagem de erro e redirecionar
    private void setErrorMessage(HttpServletRequest request, HttpServletResponse response, String mensagem) throws ServletException, IOException {
        request.setAttribute("verifica", false);
        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
    }
}
