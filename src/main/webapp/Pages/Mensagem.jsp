<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mensagem</title>

</head>

<body>
<jsp:include page="/telasadmin%20(1).html"/>

<%
    Boolean verifica = (Boolean) request.getAttribute("verifica");
    String mensagem = (String) request.getAttribute("mensagem");
    String cor = verifica ? "green" : "red";
%>

<p style="color: <%= cor %>"> MENSAGEM:<%=mensagem%></p>

</body>
</html>
