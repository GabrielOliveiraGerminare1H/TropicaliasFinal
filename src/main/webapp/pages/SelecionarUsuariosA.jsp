<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Importação das classes necessárias -->
<%@ page import="model.Usuario" %>
<%@ page import="daos.UsuarioDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title id="selecionarUsuarioA">Usuários</title>
    <style>
        /* Estilo para a tabela */
        table {
            width: 50%; /* Largura da tabela */
            margin: auto; /* Centraliza a tabela na página */
            border-collapse: collapse; /* Remove espaços entre bordas da tabela */
            font-family: Montserrat; /* Define a fonte da tabela */
        }
        th {
            color: #ebe6da; /* Cor do texto do cabeçalho */
        }
        th, td {
            border: 1px solid #E45F15; padding: 10px; text-align: left;
        }
        th {
            background-color: #ff7e32; /* Cor de fundo do cabeçalho */
        }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;" id="selecionarUsuariosI">LISTA DE USUÁRIOS ATIVOS</h2> <%-- Título principal da página, estilizado --%>

<div class="select-container" style="overflow-x: auto; margin: 40px;"> <%-- Contêiner para a tabela com rolagem horizontal --%>
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <%-- Início da tabela com sombra --%>
        <thead>
            <tr><%-- Cabeçalho da tabela --%>
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
                if (UsuAResultSet.next()) { // Verifica se há resultados e percorre eles
                    do {
        %>
        <tr>
            <td><p><%= UsuAResultSet.getInt("pk_int_id_usuario") %></p></td>
            <td><p><%= UsuAResultSet.getString("text_foto") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_email") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_senha") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_user_name") %></p></td>
            <td><p><%= UsuAResultSet.getDate("dt_nascimento") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_descricao_usuario") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_cpf") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_nome") %></p></td>
            <td><p><%= UsuAResultSet.getString("createdat") %></p></td>
            <td><p><%= UsuAResultSet.getString("deletedat") %></p></td>
            <td><p><%= UsuAResultSet.getInt("fk_int_id_endereco") %></p></td>
            <td><p><%= UsuAResultSet.getString("updateat") %></p></td>
            <td><p><%= UsuAResultSet.getString("var_role") %></p></td>
        </tr>
        <%
            } while (UsuAResultSet.next()); // Continua a iteração enquanto houver mais registros
        } else { // Caso não haja resultados
        %>
        <tr>
            <td colspan="14"><p>Nenhum registro encontrado.</p></td>
        </tr>
        <%
            }
        } catch (SQLException sql) { // Tratamento de exceção em caso de erro no SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="14"><p>Erro no banco de dados!</p></td> <%-- Mensagem de erro exibida na tabela --%>
        </tr>
        <%
            } // Fim do bloco try-catch
        %>
        </tbody>
    </table>
</div>
<br><br><br>
<footer class="container3"> <%-- Rodapé da página --%>
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>
</body>
</html>
