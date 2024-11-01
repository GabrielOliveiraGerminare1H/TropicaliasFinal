<%@ page import="java.util.List" %>
<%@ page import="Model.Barraca" %>
<%--<%@ include file="../ADM.jsp"%>--%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Barracas</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2 style="text-align: center;">Lista de Barracas</h2>

<div id="tabSelecionarBarraca">
    <table>
        <tr>
            <th>Nome</th>
            <th>Fk_Evento</th>
        </tr>
        <%
            List<Barraca> barracas = (List<Barraca>) request.getAttribute("barraca");
            if (barracas != null) {
                for (Barraca barraca : barracas) {
        %>
        <tr>
            <td><p><%= barraca.getNome() %></p></td>
            <td><p><%= barraca.getFk_int_id_evento() %></p></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3" style="text-align: center;">Nenhuma barraca encontrada</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
