<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Importação das classes necessárias -->
<%@ page import="Model.CorMascote" %>
<%@ page import="Daos.CorMascoteDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cor Mascote</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; font-family: Montserrat }
        th { color: #ebe6da }
        th, td { border: 1px solid #E45F15; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;" id="selecionarCoresI">LISTA CORES INATIVAS DO MASCOTE</h2> <%-- Título da seção centralizado e com cor personalizada --%>
<div class="select-container" style="overflow-x: auto; margin: 40px;"> <%-- Contêiner para a tabela --%>
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <%-- Início da tabela para exibir os dados das cores dos mascotes --%>
        <thead> <%-- Cabeçalho da tabela --%>
        <tr>
            <th>pk_int_id_cor_mascote</th>
            <th>text_fundo</th>
            <th>createdat</th>
            <th>deletedat</th>
            <th>text_secundaria</th>
            <th>text_primaria</th>
            <th>updateat</th>
        </tr>
        </thead>
        <tbody> <%-- Corpo da tabela onde os dados serão exibidos --%>
        <%
            // Cria uma instância do DAO para acessar os dados das cores de mascote
            CorMascoteDAO corMascoteDAO = new CorMascoteDAO();
            // Chama o método que seleciona as cores de mascote
            ResultSet CorAResultSet = corMascoteDAO.selecionarCorMascoteI();
            try {
                // Verifica se há resultados no ResultSet
                if (CorAResultSet.next() && CorAResultSet != null) {
                    // Loop para percorrer todos os registros retornados
                    do {
        %>
        <tr> <%-- Início da linha da tabela para cada cor do mascote --%>
            <td><p> <%= CorAResultSet.getInt("pk_int_id_cor_mascote") %></p></td>
            <td><p> <%= CorAResultSet.getString("text_fundo") %></p></td>
            <td><p> <%= CorAResultSet.getString("createdat") %></p></td>
            <td><p> <%= CorAResultSet.getString("deletedat") %></p></td>
            <td><p><%= CorAResultSet.getString("text_secundaria") %></p></td>
            <td><p><%= CorAResultSet.getString("text_primaria") %></p></td>
            <td><p> <%= CorAResultSet.getString("updateat") %></p></td>
        </tr>
        <%
            } while (CorAResultSet.next()); // Continua a iteração enquanto houver mais registros
        } else { // Caso não haja resultados
        %>
        <tr>
            <td colspan="7"><p>Nenhum registro encontrado.</p></td> <%-- Mensagem exibida se não houver registros --%>
        </tr>
        <% } // Fim da verificação de resultados
        } catch (SQLException sql) { // Tratamento de exceção em caso de erro no SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="7"><p>Erro no banco de dados!</p></td> <%-- Mensagem de erro exibida na tabela --%>
        </tr>
        <%
            } // Fim do bloco try-catch
        %>
        </tbody>
    </table>
</div>
<br><br><br>
<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%">
</footer>
</body>
</html>
