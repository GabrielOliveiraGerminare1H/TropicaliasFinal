<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mensagem</title>
    <link rel="stylesheet" href="CSSdosAps/telasAdmim.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
</head>

<body>
 <jsp:include page="/pages/ADM.jsp"/>


<%

    String mensagem = (String) request.getAttribute("mensagem");
    Boolean verifica = (Boolean) request.getAttribute("verifica");
    String cor = verifica != null && verifica ? "green" : "red";
%>

<p style="color: <%= cor %>; font-family: Montserrat; text-align: center;"> MENSAGEM: <%= mensagem != null ? mensagem : "Nenhuma mensagem disponível" %></p>
<br><br><br>
</body>
</html>

