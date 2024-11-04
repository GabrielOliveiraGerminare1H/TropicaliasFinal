<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        table { width: 50%; margin: auto; border-collapse: collapse; font-family: Montserrat }
        th { color: #ebe6da }
        th, td { border: 1px solid #E45F15; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;" id="selecionarBarracaA">LISTA DE BARRACAS ATIVAS</h2>
<br>
<div class="select-container" style="overflow-x: auto; margin: 40px;">
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);">
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
            ResultSet BarracaResultSet = barracaDAO.selecionarBarracaA();
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
<br><br><br>
<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img ssrc="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem no footer --%>
</footer>
</body>
</html>

