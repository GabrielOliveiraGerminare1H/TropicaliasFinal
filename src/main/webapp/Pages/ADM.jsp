<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSSdosAps/telasAdmim.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <title>Telas de Administrador</title>
</head>
<body>

<div class="container1">
    <div class="navbar">
        <ul>
            <img src="assets/Araci (1).png" alt="">
            <li><a href="${pageContext.request.contextPath}/index.html">Inicio</a></li>
            <li><a href="${pageContext.request.contextPath}/Evento.html">Evento</a></li>
            <li><a href="${pageContext.request.contextPath}/Suporte.html">Ajuda</a></li>
            <li><a href="${pageContext.request.contextPath}/Termos.html">Termos</a></li>
            <li><a href="${pageContext.request.contextPath}/Login.html">Área restrita</a></li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="menuCima">
        <div class="opcaoEvento">
            <img src="assets/Date range.png" alt="">
            <h1>Evento</h1>
            <ul>
                <li><a href="SelecionarUsuariosA.jsp">Selecionar usuários ativos</a></li>
                <li><a href="CadastrarEvento.jsp">Cadastrar evento</a></li>
                <li><a href="DeletarEvento.jsp">Deletar evento</a></li>
                <li><a href="AtualizarEvento.jsp">Atualizar evento</a></li>
            </ul>
        </div>

        <div class="opcaoEventoBlur"></div>

        <div class="opcaoMascote">
            <img src="assets/Colors.png" alt="">
            <h1>Mascote</h1>
            <ul>
                <li><a href="SelecionarCorMascote.jsp">Selecionar cor do mascote</a></li>
                <li><a href="CadastrarCorMascote.jsp">Cadastrar cor do mascote</a></li>
                <li><a href="DeletarCorMascote.jsp">Deletar cor do mascote</a></li>
                <li><a href="AtualizarCorMascote.jsp">Atualizar cores do mascote</a></li>
            </ul>
        </div>

    </div>

    <div class="menuBaixo">

        <div class="opcaoAnuncio">
            <img src="assets/Bookmark add.png" alt="">
            <h1>Anúncios</h1>
            <ul>
                <li><a href="SelecionarUsuariosA.jsp">Selecionar anúncios ativos</a></li>
            </ul>
        </div>

        <div class="opcaoUsuario">
            <img src="assets/Person.png" alt="">
            <h1>Usuários</h1>
            <ul>
                <li><a href="SelecionarUsuariosA.jsp">Selecionar usuários ativos</a></li>
                <li><a href="SelecionarUsuariosI.jsp">Selecionar usuários inativos</a></li>
            </ul>
        </div>

        <div class="opcaoBarraca">
            <img src="assets/Warehouse.png" alt="">
            <h1>Barraca</h1>
            <ul>
                <li><a href="SelecionarBarraca.jsp">Selecionar barracas ativas</a></li>
                <li><a href="CadastrarBarraca.jsp">Cadastrar barraca</a></li>
                <li><a href="DeletarBarraca.jsp">Deletar barraca</a></li>
                <li><a href="AtualizarBarraca.jsp">Atualizar barraca</a></li>
            </ul>
        </div>

    </div>
</div>

<div class="container2" id="tabCriarEvento">
    <div class="titulo">
        <h1>CADASTRAR EVENTO</h1>
    </div>
    <form action="cadastrarEvento">
        <input type="date" name="dt_inicio" id="dt_inicio" placeholder="Data de início" required>
        <input type="date" name="dt_final" id="dt_final" placeholder="Data de término" required>
        <input type="text" name="var_nome" id="var_nome" placeholder="Nome" required>
        <input type="text" name="var_local" id="var_local" placeholder="Local" required>
        <input type="text" name="num_preco_ticket" id="preco" placeholder="Preço" required>
        <button type="submit">Cadastrar</button>
    </form>
</div>

<footer class="display1">
    <p>Desenvolvido por</p>
    <img src="assets/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>

</body>
</html>