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
    <div class="container2" id="NovaCor">
        <div class="titulo">
            <h1>CADASTRAR COR DO MASCOTE</h1>
        </div>
        <section class="corMascote">
            <form action="../cadastrarCor" method="post">
                <input type="text" name="text_fundo" id="text_fundo" placeholder="Cor do fundo" required>
                <input type="text" name="text_secundaria" id="text_secundaria" placeholder="Cor secundária" required>
                <input type="text" name="text_primaria" id="text_primaria" placeholder="Cor primária" required>
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


