<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Importação das classes necessárias -->
<%@ page import="Model.Evento" %>
<%@ page import="Daos.EventoDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Eventos</title>
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
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px; font-family: Oswald, sans-serif;" id="selecionarEventosA">LISTA DE EVENTOS ATIVOS</h2> <%-- Título da seção centralizado e com cor personalizada --%>

<div class="select-container" style="overflow-x: auto; margin: 40px;"> <%-- Contêiner para a tabela --%>
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"><%-- Início da tabela para exibir os dados dos eventos --%>
        <thead> <%-- Cabeçalho da tabela --%>
            <tr>
                <th>dt_inicio</th>
                <th>dt_final</th>
                <th>var_nome</th>
                <th>var_local</th>
                <th>num_preco_ticket</th>
                <th>createdat</th>
                <th>deletedat</th>
                <th>pk_int_id_evento</th>
                <th>fk_int_id_usuario</th>
                <th>updateat</th>
                <th>var_imagem</th>
                <th>var_descricao</th>
            </tr>
        </thead>
        <tbody> <%-- Corpo da tabela onde os dados serão exibidos --%>
        <%
            // Cria uma instância do DAO para acessar os dados dos eventos
            EventoDAO eventoDAO = new EventoDAO();
            // Chama o método que seleciona os eventos ativos
            ResultSet EventoResultSet = eventoDAO.selecionarEventoA();
            try {
                // Verifica se há resultados e percorre eles
                if (EventoResultSet != null && EventoResultSet.next()) {
                    // Loop para percorrer todos os registros retornados
                    do {
        %>
        <tr> <%-- Início da linha da tabela para cada evento ativo --%>
            <td><%= EventoResultSet.getString("dt_inicio") %></td>
            <td><%= EventoResultSet.getString("dt_final") %></td>
            <td><%= EventoResultSet.getString("var_nome") %></td>
            <td><%= EventoResultSet.getString("var_local") %></td>
            <td><%= EventoResultSet.getString("num_preco_ticket") %></td>
            <td><%= EventoResultSet.getString("createdat") %></td>
            <td><%= EventoResultSet.getString("deletedat") %></td>
            <td><%= EventoResultSet.getString("pk_int_id_evento") %></td>
            <td><%= EventoResultSet.getString("fk_int_id_usuario") %></td>
            <td><%= EventoResultSet.getString("updateat") %></td>
            <td><%= EventoResultSet.getString("var_imagem") %></td>
            <td><%= EventoResultSet.getString("var_descricao") %></td>
        </tr>
        <%
            } while (EventoResultSet.next()); // Continua a iteração enquanto houver mais registros
        } else { // Caso não haja resultados
        %>
        <tr>
            <td colspan="12"><p>Nenhum registro encontrado.</p></td>
        </tr>
        <%
            }
        } catch (SQLException sql) { // Tratamento de exceção em caso de erro no SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="12"><p>Erro no banco de dados!</p></td> <%-- Mensagem de erro exibida na tabela --%>
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
    <img src="${pageContext.request.contextPath}/Assets/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>
</body>
</html>
