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
        table { width: 50%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #000; padding: 10px; text-align: left; }
        th { background-color: #ff7e32; }
    </style>
</head>
<body>
<h2 style="color: #3d59e7;" style="text-align: center;">Lista de Anuncios Inativos</h2>

<div class="select-container">
    <table class="select">
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

</body>
</html>

