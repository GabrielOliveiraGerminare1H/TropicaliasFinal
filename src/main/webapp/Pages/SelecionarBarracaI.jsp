<%@ page import="Model.Barraca" %>
<%@ page import="Daos.BarracaDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Barraca</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #3d59e7;" style="text-align: center;">Lista de Barracas Ativas</h2>

<div class="select-container">
    <table class="select">
        <thead>
        <tr>
            <th>pk_int_id_barraca</th>
            <th>var_nome</th>
            <th>createdat</th>
            <th>deletedat</th>
            <th>fk_int_id_evento</th>
            <th>updateat</th>

        </tr>
        </thead>
        <tbody>
        <%
            BarracaDAO barracaDAO = new BarracaDAO();
            ResultSet BarracaResultSet = barracaDAO.selecionarBarracaI();
            try {
                if(BarracaResultSet.next() && BarracaResultSet != null){

                    do {
        %>
        <tr>
            <td><p><%=BarracaResultSet.getString("pk_int_id_barraca") %>></p></td>
            <td><p><%=BarracaResultSet.getString("var_nome") %>></p></td>
            <td><p><%=BarracaResultSet.getString("createdat") %>></p></td>
            <td><p><%=BarracaResultSet.getString("deletedat") %>></p></td>
            <td><p><%= BarracaResultSet.getInt("fk_int_id_evento") %>/<p></td>
            <td><p><%=BarracaResultSet.getString("updateat") %>></p></td>

        </tr>



        <%
            } while(BarracaResultSet.next());
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

