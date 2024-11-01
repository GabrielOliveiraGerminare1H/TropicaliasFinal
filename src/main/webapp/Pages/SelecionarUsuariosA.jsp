<%@ page import="java.util.List" %>
<%@ page import="Model.Usuario" %>
<%@ page import="Daos.UsuarioDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%--<%@ include file="../ADM.jsp"%>--%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Usuários</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #3d59e7;" style="text-align: center;">Lista de Usuários Ativos</h2>

<div class="select-container">
    <table class="select">
        <thead>
    <tr>
        <th>text_foto</th>
        <th>var_email</th>
        <th>var_senha</th>
        <th>var_user_name</th>
        <th>dt_nascimento</th>
        <th>var_descricao_usariio</th>
        <th>var_cpf</th>
        <th>var_nome</th>
        <th>fk_int_id_endereco</th>

    </tr>
        </thead>
        <tbody>
    <%
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ResultSet UsuAResultSet = usuarioDAO.selecionarUsuarioA();
        try {
            if(UsuAResultSet.next() && UsuAResultSet != null){

                do {
    %>
    <tr>
        <td><p> <%= UsuAResultSet.getString("text_foto") %>></p></td>
        <td><p><%= UsuAResultSet.getString("var_email") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_senha") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_user_name") %>/<p></td>
        <td><p><%= UsuAResultSet.getDate("dt_nascimento") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_descricao_usuario") %></p></td>
        <td><p><%= UsuAResultSet.getLong("var_cpf") %>/<p></td>
        <td><p><%= UsuAResultSet.getString("var_nome") %></p></td>
        <td><p><%= UsuAResultSet.getInt("fk_int_id_endereco") %>/<p></td>
    </tr>



    <%
            } while(UsuAResultSet.next());
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

