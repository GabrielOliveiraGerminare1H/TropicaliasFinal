<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Importação das classes necessárias -->
<%@ page import="Model.Barraca" %>
<%@ page import="Daos.BarracaDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Barraca</title>
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
font-family: Oswald, sans-serif;" id="selecionarBarracaI">LISTA DE BARRACAS INATIVAS</h2> <%-- Título da lista de barracas inativas --%>
<br>
<div class="select-container" style="overflow-x: auto; margin: 40px;"> <%-- Container para a tabela com rolagem horizontal --%>
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <%-- Tabela de barracas com sombra --%>
        <thead>
        <tr> <%-- Cabeçalho da tabela --%>
            <th>pk_int_id_barraca</th>
            <th>var_nome</th>
            <th>createdat</th>
            <th>deletedat</th>
            <th>fk_int_id_evento</th>
            <th>updateat</th>
        </tr>
        </thead>
        <tbody>
        <%
            BarracaDAO barracaDAO = new BarracaDAO(); // Criação de uma instância do DAO para acessar as barracas inativas
            ResultSet BarracaResultSet = barracaDAO.selecionarBarracaI(); // Chamada ao método que retorna as barracas inativas
            try {
                // Verifica se há resultados e percorre  eles
                if(BarracaResultSet.next() && BarracaResultSet != null){
                    // Loop para percorrer todos os registros retornados
                    do {
        %>
        <tr> <%-- Linha da tabela para cada barraca inativa --%>
            <td><p><%=BarracaResultSet.getString("pk_int_id_barraca") %></p></td>
            <td><p><%=BarracaResultSet.getString("var_nome") %></p></td>
            <td><p><%=BarracaResultSet.getString("createdat") %></p></td>
            <td><p><%=BarracaResultSet.getString("deletedat") %></p></td>
            <td><p><%= BarracaResultSet.getInt("fk_int_id_evento") %></p></td>
            <td><p><%=BarracaResultSet.getString("updateat") %></p></td>
        </tr>
        <%
            } while(BarracaResultSet.next()); // Continua enquanto houver mais resultados
        } else { // Se não houver resultados
        %>
        <tr>
            <td colspan="6"><p>Nenhum registro encontrado.</p></td> <%-- Mensagem indicando que não há barracas inativas --%>
        </tr>
        <%}
        } catch (SQLException sql) { // Tratamento de exceções SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="6"><p>Erro no banco de dados!</p></td> <%-- Mensagem de erro se houver uma exceção --%>
        </tr>
        <%
            } // Fim do bloco do catch
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
