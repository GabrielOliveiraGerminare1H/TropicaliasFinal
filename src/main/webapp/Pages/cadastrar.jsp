<%--
  Created by IntelliJ IDEA.
  User: isabelaneu-ieg
  Date: 25/10/2024
  Time: 08:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<main>
    <div class="navbar">
        <ul>
            <img src="../Im/Araci (1).png" alt="">
            <li class="lado">Tropicalias</li>
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


    <div class="container2" id="tabCriarEvento">
        <div class="titulo">
            <h1>CADASTRAR EVENTO</h1>
        </div>
        <section class="cadastrar">
            <form action="evento" method="post">
                <input type="date" name="dataini" id="dataini" placeholder="Data de início" required>
                <input type="date" name="datafim" id="datafim" placeholder="Data de término" required>
                <input type="text" name="nomeEvento" id="nomeEvento" placeholder="Nome" required>
                <input type="text" name="local" id="local" placeholder="Local" required>
                <input type="text" name="preco" id="preco" placeholder="Preço" required>
                <button type="submit">Cadastrar</button>
                <p>${resultadoCadastrarEvento}</p>
            </form>
        </section>
    </div>
    <div class="container2" id="tabCadastrarBarraca">
        <div class="titulo">
            <h1>CADASTRAR BARRACA</h1>
        </div>
        <section class="cadastrar">
            <form action="barraca" method="post">
                <input type="text" name="nome" id="nome" placeholder="Nome" required>
                <input type="text" name="fk" id="fk" placeholder="FK do evento" required>
                <button type="submit">Cadastrar</button>
                <p>${resultadoCadastrarBarraca}</p>
            </form>
        </section>
    </div>

    <div class="container2" id="tabNovaCor">
        <div class="titulo">
            <h1>COR DO MASCOTE</h1>
        </div>
        <section class="cor">
            <form action="mascote" method="post">
                <input type="text" name="text_fundo" id="text_fundo" placeholder="Cor do fundo" required>
                <input type="text" name="text_secundaria" id="text_secundaria" placeholder="Cor secundária" required>
                <input type="text" name="text_primaria" id="text_primaria" placeholder="Cor primária" required>
                <button type="submit">Cadastrar</button>
                <p>${resultadoCadastrarCor}</p>
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
