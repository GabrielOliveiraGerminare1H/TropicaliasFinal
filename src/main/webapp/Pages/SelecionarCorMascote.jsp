<%@ page import="java.util.List" %>
<%@ page import="Model.CorMascote" %>
<%--<%@ include file="../ADM.jsp"%>--%>
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
            if (corMascotes != null) {
                for (CorMascote corMascote : corMascotes) {
        %>
        <tr>
            <td><p><%= corMascote.getTextoFundo() %></p></td>
            <td><p><%= corMascote.getTextoPri() %></p></td>
            <td><p><%= corMascote.getTextoSec() %></p></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3" style="text-align: center;">Nenhuma cor encontrada</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
