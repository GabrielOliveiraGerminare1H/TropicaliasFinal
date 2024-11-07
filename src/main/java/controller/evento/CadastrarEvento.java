package controller.evento;

import java.io.*;
import java.sql.SQLException;

import daos.EventoDAO;
import daos.JDBC.Conexao;
import model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(name = "criarEvento", value = "/cadastrarEvento")
public class CadastrarEvento extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexao conexao = new Conexao();

        // Obtém os parâmetros da requisição para o cadastro do evento
        String dt_inicio = request.getParameter("dt_inicio");
        String dt_final = request.getParameter("dt_final");
        String nome = request.getParameter("var_nome");
        String local = request.getParameter("var_local");
        int preco = Integer.parseInt(request.getParameter("preco"));
        int fkUsuario = Integer.parseInt(request.getParameter("fk_int_id_usuario"));
        String imagem = request.getParameter("var_imagem");
        String descricao = request.getParameter("var_descricao");

        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dataInicio = sdf.parse(dt_inicio);
            Date dataFinal = sdf.parse(dt_final);

            // Verifica se a data de início é anterior à data de término
            if (dataInicio.after(dataFinal)) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "A data de início deve ser anterior à data de término.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Verifica se a FK do usuário é válida
            try{
            if (!conexao.isFkValida("tb_evento", "fk_int_id_usuario", fkUsuario)) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "FK do usuário errada.");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            }
            else {
                Evento evento = new Evento(dataInicio, dataFinal, nome, local, preco, fkUsuario, imagem, descricao);
                EventoDAO eventoDAO = new EventoDAO();
                boolean verifica = eventoDAO.cadastrarEvento(evento);
                if (verifica) {
                    request.setAttribute("verifica", true);
                    request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
                    request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                } else {
                    request.setAttribute("verifica", false);
                    request.setAttribute("mensagem", "Erro ao cadastrar!");
                    request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                }
            }

            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
        } catch (ParseException e) {
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", "Erro ao formatar as datas.");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }
    }
}
