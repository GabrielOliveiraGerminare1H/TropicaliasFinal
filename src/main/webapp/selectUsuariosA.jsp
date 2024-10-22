<%@ page import="java.util.List" %>
<%@ page import="Daos.Model.Usuario" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Usuários</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2 style="text-align: center;">Lista de Usuários</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Status</th>
    </tr>
    <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        for (Usuario usuario : usuarios) {
    %>
    <tr>
        <td><%= usuario.getTextFoto() %></td>
        <td><%= usuario.getVarEmail() %></td>
        <td><%= usuario.getSenha() %></td>
        <td><%= usuario.getUserName() %></td>
        <td><%= usuario.getDt_nascimento() %></td>
        <td><%= usuario.getDescricaoUsua() %></td>
        <td><%= usuario.getCpf() %></td>
        <td><%= usuario.getNome() %></td>
        <td><%= usuario.getFk_int_id_endereco() %></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>

