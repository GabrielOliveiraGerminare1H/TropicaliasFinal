package Controller.Evento;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import Daos.EventoDAO;
import Daos.JDBC.Conexao;
import Model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "criarEvento", value = "/cadastrarEvento")
public class CadastrarEvento extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Instanciando a classe de conexão
        Conexao conexao = new Conexao();

        try {
            // Obtém os parâmetros da requisição para o cadastro do evento
            LocalDate dt_inicio;
            LocalDate dt_final;
            try {
                dt_inicio = LocalDate.parse(request.getParameter("dt_inicio"));
                dt_final = LocalDate.parse(request.getParameter("dt_final"));
            } catch (DateTimeParseException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Formato de data inválido.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            String nome = request.getParameter("var_nome");
            String local = request.getParameter("var_local");
            int preco = Integer.parseInt(request.getParameter("preco"));
            int fkUsuario = Integer.parseInt(request.getParameter("fk_int_id_usuario"));
            String imagem = request.getParameter("var_imagem");
            String descricao = request.getParameter("var_descricao");

            // Verifica se a data de início é anterior à data de término
            if (!dt_inicio.isBefore(dt_final)) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "A data de início deve ser anterior à data de término.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Verifica se a FK é válida
            if (!conexao.isPkValida("tb_evento", "fk_int_id_usuario", fkUsuario)) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "FK de usuário inválida.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Cria um objeto Evento e realiza o cadastro no banco de dados
            Evento evento = new Evento(dt_inicio, dt_final, nome, local, preco, fkUsuario, imagem, descricao);
            EventoDAO eventoDAO = new EventoDAO();
            boolean verifica = eventoDAO.cadastrarEvento(evento);

            if (verifica) {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Evento cadastrado com sucesso!");
            } else {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Falha ao cadastrar evento.");
            }

            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (Exception e) {
            // Captura qualquer exceção não tratada e exibe a mensagem de erro genérica
            e.printStackTrace();
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro interno no servidor.");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }
    }
}
