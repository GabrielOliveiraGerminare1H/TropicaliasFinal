<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.CorMascote" %> <%-- Importa a classe CorMascote do pacote Model --%>
<%@ page import="Daos.CorMascoteDAO" %> <%-- Importa a classe CorMascoteDAO do pacote Daos --%>
<%@ page import="java.sql.ResultSet" %> <%-- Importa a classe ResultSet para manipulação de resultados de consultas SQL --%>
<%@ page import="java.sql.SQLException" %> <%-- Importa a classe SQLException para tratamento de exceções SQL --%>
<%@ include file="ADM.jsp"%> <%-- Inclui um arquivo JSP existente para o cabeçalho ou menu da área administrativa --%>
<!DOCTYPE html>
<html lang="pt-br"> <%-- Declaração do tipo de documento HTML e definição do idioma --%>
<head>
    <meta charset="UTF-8"> <%-- Define a codificação de caracteres para a página --%>
    <title>Cor Mascote</title> <%-- Título da página exibido na aba do navegador --%>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; font-family: Montserrat }
        th { color: #ebe6da }
        th, td { border: 1px solid #E45F15; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;">LISTA CORES INATIVAS DO MASCOTE</h2> <%-- Título da seção centralizado e com cor personalizada --%>
<div class="select-container" style="overflow-x: auto; margin: 40px;"> <%-- Contêiner para a tabela --%>
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <%-- Início da tabela para exibir os dados das cores dos mascotes --%>
        <thead> <%-- Cabeçalho da tabela --%>
        <tr>
            <th>pk_int_id_cor_mascote</th> <%-- Coluna para a PK da cor do mascote --%>
            <th>text_fundo</th> <%-- Coluna para a cor do fundo --%>
            <th>createdat</th> <%-- Coluna para a data de criação --%>
            <th>deletedat</th> <%-- Coluna para a data de exclusão (caso tenha) --%>
            <th>text_secundaria</th> <%-- Coluna para a cor secundária --%>
            <th>text_primaria</th> <%-- Coluna para a cor primária --%>
            <th>updateat</th> <%-- Coluna para a data de atualização --%>
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
            <td><p> <%= CorAResultSet.getInt("pk_int_id_cor_mascote") %></p></td> <%-- Exibe a PK da cor do mascote --%>
            <td><p> <%= CorAResultSet.getString("text_fundo") %></p></td> <%-- Exibe a cor do fundo --%>
            <td><p> <%= CorAResultSet.getString("createdat") %></p></td> <%-- Exibe a data de criação --%>
            <td><p> <%= CorAResultSet.getString("deletedat") %></p></td> <%-- Exibe a data de exclusão (se houver) --%>
            <td><p><%= CorAResultSet.getString("text_secundaria") %></p></td> <%-- Exibe a cor secundária --%>
            <td><p><%= CorAResultSet.getString("text_primaria") %></p></td> <%-- Exibe a cor primária --%>
            <td><p> <%= CorAResultSet.getString("updateat") %></p></td> <%-- Exibe a data de atualização --%>
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
            sql.printStackTrace(); // Exibe o erro no console
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
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img src="../Assets/mocBrancaSemFUndo.png" alt="img6" width="10%"> <%-- Imagem no footer --%>
</footer>
</body>
</html>
