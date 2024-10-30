<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mensagem</title>

</head>

<body>
<<<<<<< HEAD
< include page="/Pages/Menu.jsp" />

>>>>>>> dd1658816a47f0ca0ad83346fc2007d8422aa25a

<%
    Boolean verifica = (Boolean) request.getAttribute("verifica");
    String mensagem = (String) request.getAttribute("mensagem");
    String cor = verifica ? "green" : "red";
%>

<p style="color: <%= cor %>"> MENSAGEM:<%=mensagem%></p>

</body>
</html>
