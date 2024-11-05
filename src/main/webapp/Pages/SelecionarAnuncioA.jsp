<!-- Define o tipo de conteúdo como HTML com codificação UTF-8 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px; font-family: Oswald, sans-serif;" id="selecionarAnuncioA">LISTA DE ANÚNCIOS ATIVOS</h2> <!-- Título da lista de anúncios inativos -->
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
            ResultSet anuncioResultSet = anuncioDAO.selecionarAnuncioA(); // Chamada ao método que retorna anúncios inativos
            try {
                // Verifica se o ResultSet não é nulo e se há resultados
                if (anuncioResultSet != null && anuncioResultSet.next()) {
                    // Loop para percorrer todos os registros retornados
                    do {
        %>
        <tr> <!-- Início de uma linha na tabela para cada anúncio inativo -->
            <td><%= anuncioResultSet.getString("var_nota_fiscal") %></td>
            <td><%= anuncioResultSet.getDate("dt_data") %></td>
            <td><%= anuncioResultSet.getDouble("num_valor") %></td>
            <td><%= anuncioResultSet.getString("var_produto") %></td>
            <td><%= anuncioResultSet.getInt("int_quantidade") %></td>
            <td><%= anuncioResultSet.getInt("pk_int_id_anuncio") %></td>
            <td><%= anuncioResultSet.getString("var_status_venda") %></td>
            <td><%= anuncioResultSet.getDate("createdat") %></td>
            <td><%= anuncioResultSet.getDate("deletedat") %></td>
            <td><%= anuncioResultSet.getInt("fk_int_id_usuario") %></td>
            <td><%= anuncioResultSet.getDate("updateat") %></td>
        </tr>
        <%
            } while (anuncioResultSet.next()); // Continua enquanto houver mais resultados
        } else { // Se não houver resultados
        %>
        <tr>
            <td colspan="11">Nenhum registro encontrado.</td> <!-- Mensagem indicando que não há anúncios inativos -->
        </tr>
        <%
            }
        } catch (SQLException sql) { // Tratamento de exceções SQL
            sql.printStackTrace(); // Exibe o stack trace do erro
        %>
        <tr>
            <td colspan="11">Erro no banco de dados!</td> <!-- Mensagem de erro se houver uma exceção -->
        </tr>
        <%
            } finally {
                // Fechar o ResultSet e a conexão, se necessário (não implementado, mas boa prática)
                if (anuncioResultSet != null) {
                    try {
                        anuncioResultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } // Fecha o bloco do finally
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
