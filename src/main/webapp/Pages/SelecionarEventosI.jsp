<%@ page import="Model.Evento" %>
<%@ page import="Daos.EventoDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Eventos</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #3d59e7;" style="text-align: center;">Lista de Eventos Ativos</h2>

<div class="select-container">
    <table class="select">
        <thead>
        <tr>
            <th>dt_inicio</th>
            <th>dt_final</th>
            <th>var_nome</th>
            <th>var_local</th>
            <th>num_preco_ticket</th>
            <th>createdat</th>
            <th>deletedat</th>
            <th>pk_int_id_evento</th>
            <th>fk_int_id_usuario</th>
            <th>updateat</th>

        </tr>
        </thead>
        <tbody>
        <%
            EventoDAO eventoDAO = new EventoDAO();
            ResultSet EventoResultSet = eventoDAO.selecionarEventoI();
            try {
                if(EventoResultSet.next() && EventoResultSet != null){

                    do {
        %>
        <tr>
            <td><p> <%= EventoResultSet.getString("dt_inicio") %>></p></td>
            <td><p><%= EventoResultSet.getString("dt_final") %></p></td>
            <td><p><%= EventoResultSet.getString("var_nome") %></p></td>
            <td><p><%= EventoResultSet.getString("var_local") %></p></td>
            <td><p><%= EventoResultSet.getString("num_preco_ticket") %></p></td>
            <td><p><%= EventoResultSet.getString("createdat") %></p></td>
            <td><p><%= EventoResultSet.getString("deletedat") %></p></td>
            <td><p><%= EventoResultSet.getString("pk_int_id_evento") %></p></td>
            <td><p><%= EventoResultSet.getString("fk_int_id_usuario") %></p></td>
            <td><p><%= EventoResultSet.getString("updateat") %></p></td>
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


