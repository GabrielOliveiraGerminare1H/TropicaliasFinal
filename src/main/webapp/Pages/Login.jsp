<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSSdosAps/Login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
            rel="stylesheet"
    />
    <title>Navegação Tropicalias</title>
</head>
<body>

<div class="container1">
    <ul class="navbar">
        <img src="../Assets/araci.png" alt="">

        <li><a href="../index.html">Inicio</a></li>
        <li><a href="../Eventos.html">Evento</a></li>
        <li><a href="../Suporte.html">Ajuda</a></li>
        <li><a href="../Termos.html">Termos</a></li>
        <li><a href="Login.jsp">Área Restrita</a></li>
    </ul>

    <div class="display1">
        <div class="conjunto">
            <h2 id="cima">ACESSE</h2>
            <h2 id="debaixo">SUA CONTA!</h2>
        </div>

        <section class="criar">
<%--            <form action="../conta" method="post">--%>
<%--                <input type="email" name="email" id="email" placeholder="abc@gmail.com" required>--%>
<%--                <br><br>--%>
<%--                <input type="password" name="senha" id="senha" placeholder="senha" required>--%>
<%--                <br><br>--%>
<%--                <button type="submit">Login</button>--%>
<%--            </form>--%>
<%--            <p>Não tem cadastro ainda? Crie sua conta!</p>--%>


        <%-- Verifica se existe uma mensagem de erro e a exibe --%>

         <form action="${pageContext.request.contextPath}/acessarConta" method="post">
             <!-- Campos de email e senha do formulário -->
            <input type="email" name="email" id="email" placeholder="email" required>
            <br><br>
            <input type="password" name="senha" id="senha" placeholder="senha" required>
            <br><br>
             <% String mensagemErro = (String) request.getAttribute("mensagemErro"); %>
             <% if (mensagemErro != null) { %>
                 <%= mensagemErro %>
             <% } %>
            <button type="submit">Login</button>
        </form>
        </section>

    </div>
</div>

<div class="container2">
    <p>Desenvolvido por</p>
    <img src="../Assets/mocBranco.png" alt="">
</div>

</body>
</html>