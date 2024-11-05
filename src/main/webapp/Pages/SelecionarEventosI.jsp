<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Importação das classes necessárias --%>
<%@ page import="Model.Evento" %> <%-- Importa a classe Evento do pacote Model --%>
<%@ page import="Daos.EventoDAO" %> <%-- Importa a classe EventoDAO do pacote Daos --%>
<%@ page import="java.sql.ResultSet" %> <%-- Importa a classe ResultSet para manipulação de dados SQL --%>
<%@ page import="java.sql.SQLException" %> <%-- Importa a classe SQLException para tratamento de exceções SQL --%>
<%@ include file="ADM.jsp"%> <%-- Inclui o conteúdo da página ADM.jsp --%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8"> <%-- Define a codificação de caracteres como UTF-8 --%>
    <title>Eventos</title> <%-- Título da página --%>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; font-family: Montserrat } <%-- Estilo da tabela --%>
        th { color: #ebe6da } <%-- Cor do texto do cabeçalho da tabela --%>
        th, td { border: 1px solid #E45F15; padding: 10px; text-align: left; } <%-- Bordas e espaçamento das células --%>
        th { background-color: #ff7e32; } <%-- Cor de fundo do cabeçalho da tabela --%>
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;" id="selecionarEventosI">LISTA DE EVENTOS INATIVOS</h2> <%-- Título principal da página, estilizado --%>

<div class="select-container" style="overflow-x: auto; margin: 40px;"> <%-- Contêiner para a tabela com rolagem horizontal --%>
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);"> <%-- Início da tabela com sombra --%>
        <thead> <%-- Cabeçalho da tabela --%>
        <tr>
            <th>dt_inicio</th> <%-- Coluna para a data de início --%>
            <th>dt_final</th> <%-- Coluna para a data final --%>
            <th>var_nome</th> <%-- Coluna para o nome do evento --%>
            <th>var_local</th> <%-- Coluna para o local do evento --%>
            <th>num_preco_ticket</th> <%-- Coluna para o preço do ticket --%>
            <th>createdat</th> <%-- Coluna para a data de criação --%>
            <th>deletedat</th> <%-- Coluna para a data de exclusão --%>
            <th>pk_int_id_evento</th> <%-- Coluna para a chave primária do evento --%>
            <th>fk_int_id_usuario</th> <%-- Coluna para o ID do usuário responsável --%>
            <th>updateat</th> <%-- Coluna para a data de atualização --%>
        </tr>
        </thead>
        <tbody> <%-- Corpo da tabela onde os dados serão exibidos --%>
        <%
            EventoDAO eventoDAO = new EventoDAO(); <%-- Instancia a classe EventoDAO --%>
        ResultSet EventoResultSet = eventoDAO.selecionarEventoI(); <%-- Chama o método para selecionar eventos inativos --%>
        try {
        if (EventoResultSet != null && EventoResultSet.next()) { <%-- Verifica se há registros no ResultSet --%>
        do {
        %>
        <tr> <%-- Linha da tabela para exibir cada registro de evento --%>
            <td><p><%= EventoResultSet.getString("dt_inicio") %></p></td> <%-- Exibe a data de início --%>
            <td><p><%= EventoResultSet.getString("dt_final") %></p></td> <%-- Exibe a data final --%>
            <td><p><%= EventoResultSet.getString("var_nome") %></p></td> <%-- Exibe o nome do evento --%>
            <td><p><%= EventoResultSet.getString("var_local") %></p></td> <%-- Exibe o local do evento --%>
            <td><p><%= EventoResultSet.getString("num_preco_ticket") %></p></td> <%-- Exibe o preço do ticket --%>
            <td><p><%= EventoResultSet.getString("createdat") %></p></td> <%-- Exibe a data de criação --%>
            <td><p><%= EventoResultSet.getString("deletedat") %></p></td> <%-- Exibe a data de exclusão --%>
            <td><p><%= EventoResultSet.getString("pk_int_id_evento") %></p></td> <%-- Exibe o ID do evento --%>
            <td><p><%= EventoResultSet.getString("fk_int_id_usuario") %></p></td> <%-- Exibe o ID do usuário responsável --%>
            <td><p><%= EventoResultSet.getString("updateat") %></p></td> <%-- Exibe a data de atualização --%>
        </tr>
        <%
            } while (EventoResultSet.next()); <%-- Continua exibindo os registros enquanto houver dados --%>
        } else { // Caso não haja registros
        %>
        <tr>
            <td colspan="10"><p>Nenhum registro encontrado.</p></td> <%-- Mensagem exibida se não houver registros --%>
        </tr>
        <%
            }
            } catch (SQLException sql) { // Tratamento de exceção para erros de SQL
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="10"><p>Erro no banco de dados!</p></td> <%-- Mensagem de erro exibida na tabela --%>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<br><br><br>
<footer class="container3"> <%-- Rodapé da página --%>
    <p>Desenvolvido por</p> <%-- Texto no rodapé --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem no rodapé --%>
</footer>
</body>
</html>
