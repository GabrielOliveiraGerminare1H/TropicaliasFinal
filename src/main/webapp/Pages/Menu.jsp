<%--
  Created by IntelliJ IDEA.
  User: isabelaneu-ieg
  Date: 25/10/2024
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CSSdosAps/telasadmin (1).css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">

        <title>Telas de Administrador</title>
    </head>
<body>

<main>
    <div class="navbar">
        <ul>
            <img src="../Im/Araci (1).png" alt="">
            <li class="lado">Tropicalias</li>
            <li><a href="/index.html">Inicio</a></li>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="Termos.html">Termos</a></li>
        </ul>
    </div>

    <div class="menuTitulo">
        <h2>SELECIONE UM ITEM</h2>
    </div>
    <div class="menu">
        <div>
            <ul>
                <li><a href="#tabUsuariosAtivos">Selecionar usuários ativos</a></li>
                <li><a href="#tabSelecionarMascote">Selecionar cor do mascote</a></li>
                <li><a href="#tabNovaCor">Cadastrar cor do mascote</a></li>
                <li><a href="#tabDeletarCor">Deletar cor do mascote</a></li>
                <li><a href="#tabAtualizarCor">Atualizar cores do mascote</a></li>

            </ul>
        </div>

        <div>
            <ul>
                <li><a href="#tabUsuariosInativos">Selecionar usuários inativos</a></li>
                <li><a href="#tabEventosAtivos">Selecionar eventos ativos</a></li>
                <li><a href="#tabCriarEvento">Cadastrar evento</a></li>
                <li><a href="#tabDeletarEvento">Deletar evento</a></li>
                <li><a href="#tabAtualizarEvento">Atualizar evento</a></li>
            </ul>
        </div>

        <div>
            <ul>
                <li><a href="#tabAnunciosAtivos">Selecionar anúncios ativos</a></li>
                <li><a href="#tabBarracaAtiva">Selecionar barracas ativas</a></li>
                <li><a href="#tabCadastrarBarraca">Cadastrar barraca</a></li>
                <li><a href="#tabDeletarBarraca">Deletar barraca</a></li>
                <li><a href="#tabAtualizarBarraca">Atualizar barraca</a></li>
            </ul>
        </div>

    </div>
</main>
</body>
</html>
