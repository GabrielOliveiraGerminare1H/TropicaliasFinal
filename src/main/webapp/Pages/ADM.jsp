<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSSdosAps/telasAdmim.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <title>Telas de Administrador</title>
</head>
<body>

<div class="container1">
    <div class="navbar">
        <ul>
            <img src="../Assets/araci.png" alt="">
            <li><a href="../index.html">Inicio</a></li>
            <li><a href="../Eventos.html">Evento</a></li>
            <li><a href="../Suporte.html">Suporte</a></li>
            <li><a href="../Termos.html">Termos</a></li>
            <li><a href="../Login.html">Área restrita</a></li>
            <li><a href="ADM.jsp">ADM</a></li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="menuCima">
        <div class="opcaoEvento">
            <img src="../Assets/calendario.png" alt="">
            <h1>Evento</h1>
            <ul>
                <li><a href="SelecionarEventosA.jsp#selecionarEventosA">Selecionar eventos ativos</a></li>
                <li><a href="SelecionarEventosI.jsp#selecionarEventosI">Selecionar eventos inativos</a></li>
                <li><a href="CadastrarEvento.jsp#cadastrarEvento">Cadastrar evento</a></li>
                <li><a href="DeletarEvento.jsp#deletarEvento">Deletar evento</a></li>
                <li><a href="AtualizarEvento.jsp#atualizarEvento">Atualizar evento</a></li>
            </ul>
        </div>

        <div class="opcaoMascote">
            <img src="../Assets/cores.png" alt="">
            <h1>Mascote</h1>
            <ul>
                <li><a href="SelecionarCorMascoteA.jsp#selecionarCoresA">Selecionar cores ativas do mascote</a></li>
                <li><a href="SelecionarCorMascoteI.jsp#selecionarCoresI">Selecionar cores inativas do mascote</a></li>
                <li><a href="CadastrarCorMascote.jsp#cadastrarCor" >Cadastrar cor do mascote</a></li>
                <li><a href="DeletarCorMascote.jsp#deletarCor">Deletar cor do mascote</a></li>
                <li><a href="AtualizarCorMascote.jsp#atualizarCor">Atualizar cores do mascote</a></li>
            </ul>
        </div>

    </div>

    <div class="menuBaixo">

        <div class="opcaoAnuncio">
            <img src="../Assets/anuncios.png" alt="">
            <h1>Anúncios</h1>
            <ul>
                <li><a href="SelecionarAnuncioA.jsp#selecionarAnuncioA">Selecionar anúncios ativos</a></li>
                <li><a href="SelecionarAnuncioI.jsp#selecionarAnuncioI">Selecionar anúncios inativos</a></li>

            </ul>
        </div>

        <div class="opcaoUsuario">
            <img src="../Assets/user.png" alt="">
            <h1>Usuários</h1>
            <ul>
                <li><a href="SelecionarUsuariosA.jsp#selecionarUsuarioA">Selecionar usuários ativos</a></li>
                <li><a href="SelecionarUsuariosI.jsp#selecionarUsuarioI">Selecionar usuários inativos</a></li>
            </ul>
        </div>

        <div class="opcaoBarraca">
            <img src="../Assets/barraca.png" alt="">
            <h1>Barraca</h1>
            <ul>
                <li><a href="SelecionarBarracaA.jsp#selecionarBarracaA">Selecionar barracas ativas</a></li>
                <li><a href="SelecionarBarracaI.jsp#selecionarBarracaI">Selecionar barracas inativas</a></li>
                <li><a href="CadastrarBarraca.jsp#cadastrarBarraca">Cadastrar barraca</a></li>
                <li><a href="DeletarBarraca.jsp#deletarBarraca">Deletar barraca</a></li>
                <li><a href="AtualizarBarraca.jsp#atualizarBarraca">Atualizar barraca</a></li>
            </ul>
        </div>

    </div>
</div>


</body>
</html>