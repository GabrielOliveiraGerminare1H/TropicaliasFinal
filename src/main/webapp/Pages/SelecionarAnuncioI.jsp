<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Anuncio" %>
<%@ page import="Daos.AnuncioDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="ADM.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Anúncios</title>
    <style>
        table { width: 50%; margin: auto; border-collapse: collapse; font-family: Montserrat }
        th { color: #ebe6da }
        th, td { border: 1px solid #E45F15; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #006996; font-size: 5rem; text-align: center; line-height: 80px;
font-family: Oswald, sans-serif;" id="selecionarAnuncioI">LISTA DE ANÚNCIOS INATIVOS</h2>
<br>
<div class="select-container" style="overflow-x: auto; margin: 40px;">
    <table class="select" style="box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);">
        <thead>
        <tr>
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
            AnuncioDAO anuncioDAO = new AnuncioDAO();
            ResultSet AnuncioResulSet = anuncioDAO.selecionarAnuncioI();
            try {
                if(AnuncioResulSet.next() && AnuncioResulSet != null){

                    do {
        %>
        <tr>
            <td><p><%= AnuncioResulSet.getInt("pk_int_id_anuncio") %></p></td>
            <td><p><%= AnuncioResulSet.getString("var_nota_fiscal") %></p></td>
            <td><p><%= AnuncioResulSet.getDate("dt_data") %></p></td>
            <td><p><%= AnuncioResulSet.getDouble("num_valor") %></p></td>
            <td><p><%= AnuncioResulSet.getString("var_produto") %></p></td>
            <td><p><%= AnuncioResulSet.getInt("int_quantidade") %></p></td>
            <td><p><%= AnuncioResulSet.getString("var_status_venda") %></p></td>
            <td><p><%= AnuncioResulSet.getDate("createdat") %></p></td>
            <td><p><%= AnuncioResulSet.getDate("deletedat") %></p></td>
            <td><p><%= AnuncioResulSet.getInt("fk_int_id_usuario") %></p></td>
            <td><p><%= AnuncioResulSet.getDate("updateat") %></p></td>

        </tr>



        <%
            } while(AnuncioResulSet.next());
        }
        else {
        %>
        <tr>
            <td colspan="5"><p>Nenhum registro encontrado.</p></td>
        </tr>
        <%}

        } catch (SQLException sql) {
            sql.printStackTrace();
        %>
        <tr>
            <td colspan="5"><p>Erro no banco de dados!</p></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<br><br><br>
<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem no footer --%>
</footer>
</body>
</html>

