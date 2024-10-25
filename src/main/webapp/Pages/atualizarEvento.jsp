<%--
  Created by IntelliJ IDEA.
  User: isabelaneu-ieg
  Date: 25/10/2024
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSSdosAps/telasadm.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">

    <title>Telas de Administrador</title>
</head>
<body>
<div class="container2" id="tabAtualizarEvento">
    <div class="titulo">
        <h1>ATUALIZAR EVENTO</h1>
    </div>
    <section class="deletarEvento">
        <form action="deletarEvento">
            <input type="text" name="campoEvento" id="campoEvento" placeholder="Campo" required>
            <input type="text" name="atualizaoEvento" id="atualizaoEvento" placeholder="Campo atualizado" required>
            <input type="number" name="pk_int_id_evento" min="1" id="pk_int_id_evento" placeholder="PK do evento" required>
            <button type="submit">Atualizar</button>
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
