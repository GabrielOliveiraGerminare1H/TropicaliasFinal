<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSSdosAps/Login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <title>Navegação Tropicalias</title>
</head>
<body>

<div class="container1">
    <ul class="navbar">
        <img src="${pageContext.request.contextPath}/Assets/araci.png" alt="Logo do site">
        <li><a href="${pageContext.request.contextPath}/index.html">Inicio</a></li>
        <li><a href="${pageContext.request.contextPath}/Eventos.html">Evento</a></li>
        <li><a href="${pageContext.request.contextPath}/Suporte.html">Ajuda</a></li>
        <li><a href="${pageContext.request.contextPath}/Termos.html">Termos</a></li>
        <li><a href="${pageContext.request.contextPath}/Login.jsp">Área restrita</a></li>
    </ul>

    <div class="display1">
        <div class="conjunto">
            <h2 id="cima">ACESSE</h2>
            <h2 id="debaixo">SUA CONTA!</h2>
        </div>

        <section class="criar">
            <!-- Formulário para login -->
            <form action="${pageContext.request.contextPath}/acessarConta" method="post">
                <!-- Campo para email -->
                <input type="email" name="email" id="email" placeholder="email" required>
                <br><br>

                <!-- Campo para senha -->
                <input type="password" name="senha" id="senha" placeholder="senha" required>
                <br><br>

                <!-- Botão de login -->
                <button type="submit">Login</button>
                <br>

                <!-- Mensagem de erro, se houver -->
                <p style="margin-left: 20%; color: #ebe6da">
                    <% String mensagemErro = (String) request.getAttribute("mensagemErro"); %>
                    <% if (mensagemErro != null) { %>
                    <%= mensagemErro %>
                    <% } %>
                </p>
                <br>
            </form>
        </section>
    </div>
</div>

<div class="container2">
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/Assets/mocBranco.png" alt="Imagem do logo" width="10%">
</div>

</body>
</html>
