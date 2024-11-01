<%@ page import="Model.CorMascote" %>
<%@ page import="Daos.CorMascoteDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cor Mascote</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #3d59e7;" style="text-align: center;">Lista de Cores Mascote</h2>

<div class="select-container">
    <table class="select">
        <thead>
        <tr>
            <th>pk_int_id_cor_mascote</th>
            <th>text_fundo</th>
            <th>createdat</th>
            <th>deletedat</th>
            <th>text_secundaria</th>
            <th>text_primaria</th>
            <th>updateat</th>


        </tr>
        </thead>
        <tbody>
        <%
            CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
            ResultSet CorAResultSet = corMascoteDAO.selecionarCorMascoteA();
            try {
                if(CorAResultSet.next() && CorAResultSet != null){

                    do {
        %>
        <tr>
            <td><p> <%= CorAResultSet.getInt("pk_int_id_cor_mascote") %>></p></td>
            <td><p> <%= CorAResultSet.getString("text_fundo") %>></p></td>
            <td><p> <%= CorAResultSet.getString("createdat") %>></p></td>
            <td><p> <%= CorAResultSet.getString("deletedat") %>></p></td>
            <td><p><%= CorAResultSet.getString("text_secundaria") %></p></td>
            <td><p><%= CorAResultSet.getString("text_primaria") %></p></td>
            <td><p> <%= CorAResultSet.getString("updateat") %>></p></td>

        </tr>



        <%
            } while(CorAResultSet.next());
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

