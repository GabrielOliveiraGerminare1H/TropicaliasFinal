<!-- Define o tipo de conteúdo como HTML com codificação UTF-8 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (request.getSession().getAttribute("logado") == null) {
    request.getRequestDispatcher("../Pages/Login.jsp").forward(request, response);
    return;
} %>
<!-- Importação das classes necessárias -->
<%@ page import="Model.Anuncio" %>
<%@ page import="Daos.AnuncioDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Anúncios</title>
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
            background-color: #ff7e32; /* Cor de fundo do cabeçalho */
        }
        th, td {
            border: 1px solid #E45F15;
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px; font-family: Oswald, sans-serif;" id="selecionarAnuncioI">LISTA DE ANÚNCIOS INATIVOS</h2> <!-- Título da lista de anúncios inativos -->
<br>
<div class="select-container" style="overflow-x: auto; margin: 40px;"> <!-- Container para a tabela com rolagem horizontal -->
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <!-- Tabela de anúncios com sombra -->
        <thead>
            <tr> <!-- Cabeçalho da tabela -->
                <th>var_nota_fiscal</th>
                <th>dt_data</th>
                <th>num_valor</th>
                <th>var_produto</th>
                <th>int_quantidade</th>
                <th>pk_int_id_anuncio</th>
                <th>var_status_venda</th>
                <th>createdat</th>
                <th>deletedat</th>
                <th>fk_int_id_usuario</th>
                <th>updateat</th>
            </tr>
        </thead>
        <tbody>
        <%
            AnuncioDAO anuncioDAO = new AnuncioDAO(); // Criação de uma instância do DAO para acessar os anúncios inativos
            ResultSet AnuncioResulSet = anuncioDAO.selecionarAnuncioI(); // Chamada ao método que retorna anúncios inativos
            try {
                // Verifica se o ResultSet não é nulo e se há resultados
                if (AnuncioResulSet != null && AnuncioResulSet.next()) {
                    // Loop para percorrer todos os registros retornados
                    do {
        %>
        <tr> <!-- Início de uma linha na tabela para cada anúncio inativo -->
            <td><%= AnuncioResulSet.getString("var_nota_fiscal") %></td>
            <td><%= AnuncioResulSet.getDate("dt_data") %></td>
            <td><%= AnuncioResulSet.getDouble("num_valor") %></td>
            <td><%= AnuncioResulSet.getString("var_produto") %></td>
            <td><%= AnuncioResulSet.getInt("int_quantidade") %></td>
            <td><%= AnuncioResulSet.getInt("pk_int_id_anuncio") %></td>
            <td><%= AnuncioResulSet.getString("var_status_venda") %></td>
            <td><%= AnuncioResulSet.getDate("createdat") %></td>
            <td><%= AnuncioResulSet.getDate("deletedat") %></td>
            <td><%= AnuncioResulSet.getInt("fk_int_id_usuario") %></td>
            <td><%= AnuncioResulSet.getDate("updateat") %></td>
        </tr>
        <%
            } while (AnuncioResulSet.next()); // Continua enquanto houver mais resultados
        } else { // Se não houver resultados
        %>
        <tr>
            <td colspan="11">Nenhum registro encontrado.</td> <!-- Mensagem indicando que não há anúncios inativos -->
        </tr>
        <%
            }
        } catch (SQLException sql) { // Tratamento de exceções SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="11">Erro no banco de dados!</td> <!-- Mensagem de erro se houver uma exceção -->
        </tr>
        <%
            } // Fecha o bloco do catch
        %>
        </tbody>
    </table>
</div>
<br><br><br>
<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p> <!-- Texto do rodapé -->
    <img src="${pageContext.request.contextPath}/Assets/mocBranco.png" alt="Imagem de logo" width="10%"> <!-- Imagem do rodapé -->
</footer>
</body>
</html>
