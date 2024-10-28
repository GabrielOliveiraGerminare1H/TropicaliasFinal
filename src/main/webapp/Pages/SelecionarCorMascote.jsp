<%--
  Created by IntelliJ IDEA.
  User: isabelaneu-ieg
  Date: 25/10/2024
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="Model.Usuario" %>
<%@ page import="Model.CorMascote" %>
<%@ include file="Menu.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cores Mascote</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2 style="text-align: center;">Lista de Cores do Mascote</h2>

<div id="tabSelecionarMascote">
    <table>
        <tr>
            <th>Cor Fundo</th>
            <th>Cor Primária</th>
            <th>Cor Secundária</th>
        </tr>
        <%
            List<CorMascote> corMascotes = (List<CorMascote>) request.getAttribute("cores");
            for (CorMascote corMascote : corMascotes) {
        %>
        <tr>
            <td><%= corMascote.getTextoFundo() %></td>
            <td><%= corMascote.getTextoPri() %></td>
            <td><%= corMascote.getTextoSec() %></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>