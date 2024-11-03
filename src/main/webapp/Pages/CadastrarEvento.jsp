<%--
  Created by IntelliJ IDEA.
  User: isabelaneu-ieg
  Date: 25/10/2024
  Time: 08:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSSdosAps/telasAdmim.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">

    <title>Telas de Administrador</title>
</head>
<body>

<main>
    <div class="container2" id="tabCriarEvento">
        <div class="titulo">
            <h1>CADASTRAR EVENTO</h1>
        </div>
        <section class="cadastrarEvento">
            <form action="../cadastrarEvento" method="post">
                <input type="date" name="dt_inicio" id="dt_inicio" placeholder="Data de início" required>
                <input type="date" name="dt_final" id="dt_final" placeholder="Data de término" required>
                <input type="text" name="var_nome" id="var_nome" placeholder="Nome" required>
                <input type="text" name="var_local" id="var_local" placeholder="Local" required>
                <input type="text" name="num_preco_ticket" id="preco" placeholder="Preço" required>
                <input type="int" name="fk_int_id_usuario" id="fk_int_id_usuario" placeholder="Fk do usuário" required>

                <button type="submit">Cadastrar</button>
            </form>
        </section>
    </div>

</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>

</body>
</html>
