<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Usuario" %>
<%@ page import="Daos.UsuarioDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Usuários</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; font-family: Montserrat }
        th { color: #ebe6da }
        th, td { border: 1px solid #E45F15; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;" id="selecionarUsuarioA">LISTA DE USUÁRIOS ATIVOS</h2>
<div class="select-container" style="overflow-x: auto; margin: 40px;">
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);">
        <thead>
        <tr>
            <th>pk_int_id_usuario</th>
            <th>text_foto</th>
            <th>var_email</th>
            <th>var_senha</th>
            <th>var_user_name</th>
            <th>dt_nascimento</th>
            <th>var_descricao_usuario</th>
            <th>var_cpf</th>
            <th>var_nome</th>
            <th>createdat</th>
            <th>deletedat</th>
            <th>fk_int_id_endereco</th>
            <th>updateat</th>
            <th>var_role</th>
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
        <td><p><%= UsuAResultSet.getInt("pk_int_id_usuario") %>></p></td>
        <td><p><%= UsuAResultSet.getString("text_foto") %>></p></td>
        <td><p><%= UsuAResultSet.getString("var_email") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_senha") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_user_name") %>/<p></td>
        <td><p><%= UsuAResultSet.getDate("dt_nascimento") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_descricao_usuario") %></p></td>
        <td><p><%= UsuAResultSet.getString("var_cpf") %>/<p></td>
        <td><p><%= UsuAResultSet.getString("var_nome") %></p></td>
        <td><p><%= UsuAResultSet.getString("createdat") %>></p></td>
        <td><p><%= UsuAResultSet.getString("deletedat") %>></p></td>
        <td><p><%= UsuAResultSet.getInt("fk_int_id_endereco") %>/<p></td>
        <td><p><%= UsuAResultSet.getString("updateat") %>/<p></td>
        <td><p><%= UsuAResultSet.getString("var_role") %>/<p></td>
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
<br><br><br>
<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem no footer --%>
</footer>
</body>
</html>

