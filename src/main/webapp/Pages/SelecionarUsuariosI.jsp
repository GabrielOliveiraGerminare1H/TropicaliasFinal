<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Importação das classes necessárias -->
<%@ page import="Model.Usuario" %>
<%@ page import="Daos.UsuarioDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp" %>  <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Usuários</title>
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
font-family: Oswald, sans-serif;" id="selecionarEventosI">LISTA DE USUÁRIOS INATIVOS</h2> <%-- Título principal da página, estilizado --%>

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
                <th>updatat</th>
                <th>var_role</th>
            </tr>
        </thead>
        <tbody>
        <%
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ResultSet UsuIResultSet = usuarioDAO.selecionarUsuarioI();
            try {
                // Verifica se há resultados e percorre eles
                if (UsuIResultSet.next()) {
                    do {
        %>
        <tr>
            <td><%= UsuIResultSet.getString("pk_int_id_usuario") %></td>
            <td><%= UsuIResultSet.getString("text_foto") %></td>
            <td><%= UsuIResultSet.getString("var_email") %></td>
            <td><%= UsuIResultSet.getString("var_senha") %></td>
            <td><%= UsuIResultSet.getString("var_user_name") %></td>
            <td><%= UsuIResultSet.getDate("dt_nascimento") %></td>
            <td><%= UsuIResultSet.getString("var_descricao_usuario") %></td>
            <td><%= UsuIResultSet.getString("var_cpf") %></td>
            <td><%= UsuIResultSet.getString("var_nome") %></td>
            <td><%= UsuIResultSet.getString("createdat") %></td>
            <td><%= UsuIResultSet.getString("deletedat") %></td>
            <td><%= UsuIResultSet.getInt("fk_int_id_endereco") %></td>
            <td><%= UsuIResultSet.getInt("updatat") %></td>
            <td><%= UsuIResultSet.getString("var_role") %></td>
        </tr>
        <%
            } while (UsuIResultSet.next()); // Continua a iteração enquanto houver mais registros
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
    <img src="../Assets/mocBranco.png" alt="img6" width="10%">
</footer>
</body>
</html>
