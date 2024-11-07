<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Importação das classes necessárias -->
<%@ page import="model.CorMascote" %>
<%@ page import="daos.CorMascoteDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cor Mascote</title>
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
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px; font-family: Oswald, sans-serif;" id="selecionarCoresA">LISTA CORES ATIVAS DO MASCOTE</h2> <%-- Título da seção centralizado e com cor personalizada --%>
<br>
<div class="select-container" style="overflow-x: auto; margin: 40px;">
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <%-- Início da tabela para exibir os dados das cores dos mascotes --%>
        <thead>
            <tr> <%-- Cabeçalho da tabela --%>
                <th>pk_int_id_cor_mascote</th>
                <th>text_fundo</th>
                <th>createdat</th>
                <th>deletedat</th>
                <th>text_secundaria</th>
                <th>text_primaria</th>
                <th>updateat</th>
            </tr>
        </thead>
        <tbody>
        <%
            // Instância do DAO para acessar os dados das cores de mascote
            CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
            // Chama o método que seleciona as cores de mascote que não foram deletadas
            ResultSet CorAResultSet = corMascoteDAO.selecionarCorMascoteA();
            try {
                // Verifica se o ResultSet não é nulo e se há resultados
                if (CorAResultSet != null && CorAResultSet.next()) {
                    // Loop para percorrer todos os registros retornados
                    do {
        %>
        <tr> <%-- Início da linha da tabela para cada cor do mascote ativa --%>
            <td><%= CorAResultSet.getInt("pk_int_id_cor_mascote") %></td>
            <td><%= CorAResultSet.getString("text_fundo") %></td>
            <td><%= CorAResultSet.getString("createdat") %></td>
            <td><%= CorAResultSet.getString("deletedat") %></td>
            <td><%= CorAResultSet.getString("text_secundaria") %></td>
            <td><%= CorAResultSet.getString("text_primaria") %></td>
            <td><%= CorAResultSet.getString("updateat") %></td>
        </tr>
        <%
            } while (CorAResultSet.next()); // Continua a iteração enquanto houver mais registros
        } else { // Caso não haja resultados
        %>
        <tr>
            <td colspan="7">Nenhum registro encontrado.</td> <%-- Mensagem exibida se não houver registros --%>
        </tr>
        <%
            }
        } catch (SQLException sql) { // Tratamento de exceção em caso de erro no SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="7">Erro no banco de dados!</td> <%-- Mensagem de erro exibida na tabela --%>
        </tr>
        <%
            } // Fim do bloco try-catch
        %>
        </tbody>
    </table>
</div>
<br><br><br>
<footer class="container3"> <%-- Footer da página --%>
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>
</body>
</html>
