package Controller.Evento;

import java.io.*;
import java.time.LocalDate;

import Daos.EventoDAO;
import Model.Evento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "criarEvento", value = "/cadastrarEvento")
//public class CadastrarEvento extends HttpServlet {
//
//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            // Obtém os parâmetros da requisição para o cadastro do evento
//            String dt_inicio = request.getParameter("dt_inicio");  // Data de início do evento
//            String dt_final = request.getParameter("dt_final");    // Data de término do evento
//            String nome = request.getParameter("nome");            // Nome do evento
//            String local = request.getParameter("local");          // Local do evento
//            String preco = request.getParameter("preco");          // Preço do evento
//            String fk_int_id_usuario = request.getParameter("fk_int_id_usuario");  // ID do usuário associado ao evento
//
//            boolean verifica;
//
//            // Declara a variável de preço como double para conversão posterior
//            double precoDouble = 0;
//
//            // Verifica se o preço está em formato válido (números com ponto ou vírgula decimal)
//            if (!preco.matches("^\\d+([.,]\\d+)?$")) {
//                request.setAttribute("verifica", false);
//                request.setAttribute("mensagem", "Você digitou o preço de maneira errada!");
//                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//                return; // Sai do método
//            }
//            precoDouble = Double.parseDouble(preco.replace(",", "."));
//
//            // Declara a variável para a data de início
//            LocalDate dt_inicioDate = null;
//
//            // Verifica se a data de início está em formato válido (dd/MM/yyyy)
//            if (dt_inicio.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
//                dt_inicioDate = LocalDate.parse(dt_inicio); // Converte a data para LocalDate
//                verifica = true;
//            } else {
//                // Se o formato da data estiver incorreto, define mensagem de erro e redireciona
//                request.setAttribute("verifica", false);
//                request.setAttribute("mensagem", "Você digitou a data de maneira errada!");
//                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//                return; // Sai do método
//            }
//
//            // Declara a variável para a data de término
//            LocalDate dt_finalDate = null;
//
//            // Verifica se a data de término está em formato válido (dd/MM/yyyy)
//            if (dt_final.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
//                dt_finalDate = LocalDate.parse(dt_inicio); // Converte a data para LocalDate
//                verifica = true;
//            } else {
//                // Se o formato da data estiver incorreto, define mensagem de erro e redireciona
//                request.setAttribute("verifica", false);
//                request.setAttribute("mensagem", "Você digitou a data de maneira errada!");
//                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//                return; // Sai do método
//            }
//
//            // Verifica se a data de início é anterior à data de término
//            if (dt_inicioDate.isBefore(dt_finalDate)) {
//                verifica = true;
//            } else {
//                // Se a data de início não for anterior à data de término, define mensagem de erro e redireciona
//                request.setAttribute("verifica", false);
//                request.setAttribute("mensagem", "A data de início deve ser menor que a data de término");
//                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//                return; // Sai do método
//            }
//
//            // Declara a variável para o ID do usuário como inteiro para conversão posterior
//            int fk_int_id_usuarioInt = 0;
//
//            // Verifica se o ID do usuário é válido (composto apenas por números)
//            if (fk_int_id_usuario.matches("[0-9]+")) {
//                fk_int_id_usuarioInt = Integer.parseInt(fk_int_id_usuario); // Converte o ID para int
//            } else {
//                // Se o ID estiver incorreto, define mensagem de erro e redireciona
//                request.setAttribute("verifica", false);
//                request.setAttribute("mensagem", "ID inválido fornecido!");
//                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//                return; // Sai do método
//            }
//
//            // Cria uma instância do EventoDAO para salvar o evento no banco de dados
//            EventoDAO eventoDAO = new EventoDAO();
//
//            // Cria um objeto Evento com os dados obtidos da requisição
//            Evento evento = new Evento(dt_inicioDate, dt_finalDate, nome, local, precoDouble, fk_int_id_usuarioInt);
//
//            // Realiza o cadastro do evento no banco de dados
//            eventoDAO.cadastrarEvento(evento);
//
//            // Define mensagem de sucesso e redireciona para a página de confirmação
//            request.setAttribute("verifica", true);
//            request.setAttribute("mensagem", "Evento cadastrado com sucesso!");
//            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//
//        } catch (NumberFormatException nfe) {
//            // Em caso de erro na conversão de valores numéricos, define mensagem de erro e redireciona
//            request.setAttribute("verifica", false);
//            request.setAttribute("mensagem", nfe.getMessage());
//            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
//        }
//
//    }
//
//}

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
            String fk_int_id_usuario = request.getParameter("fk_int_id_usuario");

            // Verifica se os parâmetros obrigatórios não são nulos
            if (dt_inicio == null || dt_final == null || nome == null || local == null || preco == null || fk_int_id_usuario == null) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Todos os campos são obrigatórios!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Declara a variável de preço como double para conversão posterior
            double precoDouble = 0;

            // Verifica se o preço está em formato válido (números com ponto ou vírgula decimal)
            if (!preco.matches("^\\d+([.,]\\d+)?$")) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Você digitou o preço de maneira errada!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }
            precoDouble = Double.parseDouble(preco.replace(",", "."));

            // Declara a variável para a data de início
            LocalDate dt_inicioDate;

            // Verifica se a data de início está em formato válido e converte para LocalDate
            try {
                dt_inicioDate = LocalDate.parse(dt_inicio);
            } catch (Exception e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Data de início inválida!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Declara a variável para a data de término
            LocalDate dt_finalDate;

            // Verifica se a data de término está em formato válido e converte para LocalDate
            try {
                dt_finalDate = LocalDate.parse(dt_final);
            } catch (Exception e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "Data de término inválida!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Verifica se a data de início é anterior à data de término
            if (!dt_inicioDate.isBefore(dt_finalDate)) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "A data de início deve ser menor que a data de término");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Declara a variável para o ID do usuário como inteiro para conversão posterior
            int fk_int_id_usuarioInt;

            // Verifica se o ID do usuário é válido (composto apenas por números)
            try {
                fk_int_id_usuarioInt = Integer.parseInt(fk_int_id_usuario);
            } catch (NumberFormatException e) {
                request.setAttribute("verifica", false);
                request.setAttribute("mensagem", "ID inválido fornecido!");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                return;
            }

            // Cria uma instância do EventoDAO para salvar o evento no banco de dados
            EventoDAO eventoDAO = new EventoDAO();

            // Cria um objeto Evento com os dados obtidos da requisição
            Evento evento = new Evento(dt_inicioDate, dt_finalDate, nome, local, precoDouble, fk_int_id_usuarioInt);

            // Realiza o cadastro do evento no banco de dados
            eventoDAO.cadastrarEvento(evento);

            // Define mensagem de sucesso e redireciona para a página de confirmação
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Evento cadastrado com sucesso!");
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);

        } catch (NumberFormatException nfe) {
            // Em caso de erro na conversão de valores numéricos, define mensagem de erro e redireciona
            request.setAttribute("verifica", false);
            request.setAttribute("mensagem", nfe.getMessage());
            request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        }

    }
}

