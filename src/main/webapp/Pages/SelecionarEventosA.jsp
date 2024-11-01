<%@ page import="java.util.List" %>
<%@ page import="Model.Evento" %>
<%@ page import="Daos.EventoDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDate" %>
<%--<%@ include =""%>--%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Evento Ativo</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #3d59e7;" style="text-align: center;">Lista de Evento Ativo</h2>

<div class="select-container">
    <table class="select">
        <thead>
        <tr>
            <th>dt_inicio</th>
            <th>dt_final</th>
            <th>var_nome</th>
            <th>var_local</th>
            <th>num_preco_ticket</th>
            <th>fk_int_id_usuario</th>


        </tr>
        </thead>
        <tbody>
        <%
            EventoDAO eventoDAO = new EventoDAO();
            ResultSet EventoResultSet = eventoDAO.selecionarEventoA();
            try {
                if(EventoResultSet.next() && EventoResultSet != null){

                    do {
        %>
        <tr>
            <td><p><%= EventoResultSet.getObject("dt_inicio", LocalDate.class) %>></p></td>
            <td><p><%= EventoResultSet.getObject("dt_final",LocalDate.class) %>/<p></td>
            <td><p><%= EventoResultSet.getString("var_nome") %>/<p></td>
            <td><p><%= EventoResultSet.getString("var_local") %>></p></td>
            <td><p><%= EventoResultSet.getDouble("num_preco_ticket") %>/<p></td>
            <td><p><%= EventoResultSet.getInt("fk_int_id_usuario") %>/<p></td>

        </tr>



        <%
            } while(EventoResultSet.next());
        }
        else {
        %>
        <tr>
            <td colspan="5"><p>Nenhum registro encontrado.</p></td>
        </tr>
        <%}

        } catch (SQLException sql) {
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="5"><p>Erro no banco de dados!</p></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>


</div>

</body>
</html>

