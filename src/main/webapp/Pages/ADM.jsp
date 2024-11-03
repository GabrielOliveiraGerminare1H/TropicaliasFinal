<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Metadados e links para estilos e fontes -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSSdosAps/telasAdmim.css">

    <!-- Links para fontes externas (Google Fonts) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <title>Telas de Administrador</title> <!-- Título da página -->
</head>
<body>

<!-- Barra de navegação principal -->
<div class="container1">
    <div class="navbar">
        <ul>
            <img src="../Assets/Araci%20(1).png" alt=""> <!-- Logo -->
            <!-- Links do menu -->
            <li><a href="../index.html">Inicio</a></li>
            <li><a href="../Eventos.html">Evento</a></li>
            <li><a href="../Suporte.html">Suporte</a></li>
            <li><a href="../Termos.html">Termos</a></li>
            <li><a href="../Login.html">Área restrita</a></li>
            <li><a href="ADM.jsp">ADM</a></li>
        </ul>
    </div>
</div>

<!-- Container principal da página -->
<div class="container">
    <!-- Menu superior -->
    <div class="menuCima">
        <!-- Seção de gerenciamento de eventos -->
        <div class="opcaoEvento">
            <img src="../Assets/Date range.png" alt="">
            <h1>Evento</h1>
            <ul>
                <!-- Links para ações de gerenciamento de eventos -->
                <li><a href="SelecionarEventosA.jsp">Selecionar eventos ativos</a></li>
                <li><a href="SelecionarEventosI.jsp">Selecionar eventos inativos</a></li>
                <li><a href="CadastrarEvento.jsp">Cadastrar evento</a></li>
                <li><a href="DeletarEvento.jsp">Deletar evento</a></li>
                <li><a href="AtualizarEvento.jsp">Atualizar evento</a></li>
            </ul>
        </div>

        <!-- Efeito de blur (desfoque) para o item do menu -->
        <div class="opcaoEventoBlur"></div>

        <!-- Seção de gerenciamento de mascotes -->
        <div class="opcaoMascote">
            <img src="../Assets/Colors.png" alt="">
            <h1>Mascote</h1>
            <ul>
                <!-- Links para ações de gerenciamento de mascotes -->
                <li><a href="SelecionarCorMascoteA.jsp">Selecionar cores ativas do mascote</a></li>
                <li><a href="SelecionarCorMascoteI.jsp">Selecionar cores inativas do mascote</a></li>
                <li><a href="CadastrarCorMascote.jsp#corMascote">Cadastrar cor do mascote</a></li>
                <li><a href="DeletarCorMascote.jsp">Deletar cor do mascote</a></li>
                <li><a href="AtualizarCorMascote.jsp">Atualizar cores do mascote</a></li>
            </ul>
        </div>

    </div>

    <!-- Menu inferior -->
    <div class="menuBaixo">

        <!-- Seção de gerenciamento de anúncios -->
        <div class="opcaoAnuncio">
            <img src="../Assets/Bookmark add.png" alt="">
            <h1>Anúncios</h1>
            <ul>
                <!-- Links para ações de gerenciamento de anúncios -->
                <li><a href="SelecionarAnuncioA.jsp">Selecionar anúncios ativos</a></li>
                <li><a href="SelecionarAnuncioI.jsp">Selecionar anúncios inativos</a></li>
            </ul>
        </div>

        <!-- Seção de gerenciamento de usuários -->
        <div class="opcaoUsuario">
            <img src="../Assets/Person.png" alt="">
            <h1>Usuários</h1>
            <ul>
                <!-- Links para ações de gerenciamento de usuários -->
                <li><a href="SelecionarUsuariosA.jsp">Selecionar usuários ativos</a></li>
                <li><a href="SelecionarUsuariosI.jsp">Selecionar usuários inativos</a></li>
            </ul>
        </div>

        <!-- Seção de gerenciamento de barracas -->
        <div class="opcaoBarraca">
            <img src="../Assets/Warehouse.png" alt="">
            <h1>Barraca</h1>
            <ul>
                <!-- Links para ações de gerenciamento de barracas -->
                <li><a href="SelecionarBarracaA.jsp">Selecionar barracas ativas</a></li>
                <li><a href="SelecionarBarracaI.jsp">Selecionar barracas inativas</a></li>
                <li><a href="CadastrarBarraca.jsp">Cadastrar barraca</a></li>
                <li><a href="DeletarBarraca.jsp">Deletar barraca</a></li>
                <li><a href="AtualizarBarraca.jsp">Atualizar barraca</a></li>
            </ul>
        </div>

    </div>
</div>
</body>
</html>
