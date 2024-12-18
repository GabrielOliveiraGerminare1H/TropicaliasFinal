<!-- Define o tipo de conteúdo e a codificação da página para suportar caracteres acentuados -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSSdosAps/telasAdmim.css">

    <!-- Links para fontes do Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;400;700;900&display=swap" rel="stylesheet">

    <title>Telas de Administrador</title>
</head>
<body>

<div class="container1">
    <div class="navbar"> <!-- Menu superior que contém links de navegação -->
        <ul>
            <li><img src="${pageContext.request.contextPath}/assets/araci.png" alt="Logo do aplicativo"></li> <!-- Logo do aplicativo -->
            <li><a href="${pageContext.request.contextPath}/index.html">Início</a></li> <!-- Link para a página inicial -->
            <li><a href="${pageContext.request.contextPath}/Eventos.html">Evento</a></li> <!-- Link para a página de eventos -->
            <li><a href="${pageContext.request.contextPath}/Suporte.html">Suporte</a></li> <!-- Link para a página de suporte -->
            <li><a href="${pageContext.request.contextPath}/Termos.html">Termos</a></li> <!-- Link para a página de termos de uso -->
            <li><a href="${pageContext.request.contextPath}/Login.jsp">Área restrita</a></li> <!-- Link para a página de login -->
            <li><a href="${pageContext.request.contextPath}/restrict-page/restrict-page.html">DashBoard</a></li>

        </ul>
    </div>
</div>

<div class="container"> <!-- Container principal da página -->
    <div class="menuCima"> <!-- Menu superior -->
        <div class="opcaoEvento"> <!-- Seção para opções de eventos -->
            <img src="${pageContext.request.contextPath}/assets/business-document-interface-symbol-with-text-lines-svgrepo-com%201.png" alt="Ícone de eventos"> <!-- Ícone de eventos -->
            <h1>Evento</h1>
            <!-- Links que redirecionam para as páginas .jsp de cada função dos botões de evento -->
            <ul>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarEventosA.jsp#selecionarEventosA">Selecionar eventos ativos</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarEventosI.jsp#selecionarEventosI">Selecionar eventos inativos</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/CadastrarEvento.jsp#cadastrarEvento">Cadastrar evento</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/DeletarEvento.jsp#deletarEvento">Deletar evento</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/AtualizarEvento.jsp#atualizarEvento">Atualizar evento</a></li>
            </ul>
        </div>

        <div class="opcaoMascote"> <!-- Seção para opções de mascote -->
            <img src="${pageContext.request.contextPath}/assets/corestrue.svg" alt="Ícone de cores"> <!-- Ícone de cores -->
            <h1>Mascote</h1>
            <!-- Links que redirecionam para as páginas .jsp de cada função dos botões de mascote -->
            <ul>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarCorMascoteA.jsp#selecionarCoresA">Selecionar cores ativas do mascote</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarCorMascoteI.jsp#selecionarCoresI">Selecionar cores inativas do mascote</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/CadastrarCorMascote.jsp#cadastrarCor">Cadastrar cor do mascote</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/DeletarCorMascote.jsp#deletarCor">Deletar cor do mascote</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/AtualizarCorMascote.jsp#atualizarCor">Atualizar cores do mascote</a></li> <!-- Corrigido o link para a página de atualizar cor -->
            </ul>
        </div>
    </div>

    <div class="menuBaixo"> <!-- Menu inferior -->
        <div class="opcaoAnuncio"> <!-- Seção para opções de anúncios -->
            <img src="${pageContext.request.contextPath}/assets/anuncios.png" alt="Ícone de anúncios"> <!-- Ícone de anúncios -->
            <h1>Anúncios</h1>
            <!-- Links que redirecionam para as páginas .jsp de cada função dos botões de anúncio -->
            <ul>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarAnuncioA.jsp#selecionarAnuncioA">Selecionar anúncios ativos</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarAnuncioI.jsp#selecionarAnuncioI">Selecionar anúncios inativos</a></li>
            </ul>
        </div>

        <div class="opcaoUsuario"> <!-- Seção para opções de usuários -->
            <img src="${pageContext.request.contextPath}/assets/user.png" alt="Ícone de usuários"> <!-- Ícone de usuários -->
            <h1>Usuários</h1>
            <!-- Links que redirecionam para as páginas .jsp de cada função dos botões de usuário -->
            <ul>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarUsuariosA.jsp#selecionarUsuarioA">Selecionar usuários ativos</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarUsuariosI.jsp#selecionarUsuarioI">Selecionar usuários inativos</a></li>
            </ul>
        </div>

        <div class="opcaoBarraca"> <!-- Seção para opções de barracas -->
            <img src="${pageContext.request.contextPath}/assets/Warehouse.png" alt="Ícone de barracas"> <!-- Ícone de barracas -->
            <h1>Barraca</h1>
            <!-- Links que redirecionam para as páginas .jsp de cada função dos botões de barraca -->
            <ul>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarBarracaA.jsp#selecionarBarracaA">Selecionar barracas ativas</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/SelecionarBarracaI.jsp#selecionarBarracaI">Selecionar barracas inativas</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/CadastrarBarraca.jsp#cadastrarBarraca">Cadastrar barraca</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/DeletarBarraca.jsp#deletarBarraca">Deletar barraca</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/AtualizarBarraca.jsp#atualizarBarraca">Atualizar barraca</a></li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
