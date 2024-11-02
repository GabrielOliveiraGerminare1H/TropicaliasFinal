<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Mensagem</title>--%>

<%--</head>--%>

<%--<body>--%>
<%--<jsp:include page="telasadmin.html">--%>
<%--</jsp:include>>--%>

<%--<%--%>
<%--    Boolean verifica = (Boolean) request.getAttribute("verifica");--%>
<%--    String mensagem = (String) request.getAttribute("mensagem");--%>
<%--    String cor = verifica ? "green" : "red";--%>
<%--%>--%>

<%--<p style="color: <%= cor %>"> MENSAGEM:<%=mensagem%></p>--%>

<%--</body>--%>
<%--</html>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Mensagem</title>--%>
<%--    <link rel="stylesheet" href="../CSSdosAps/telasAdmim.css">--%>

<%--    <link rel="preconnect" href="https://fonts.googleapis.com">--%>
<%--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">--%>

<%--</head>--%>

<%--<body>--%>
<%--<jsp:include page="/Pages/ADM.jsp">--%>
<%--</jsp:include>--%>

<%--<%--%>
<%--    Boolean verifica = (Boolean) request.getAttribute("verifica");--%>
<%--    String mensagem = (String) request.getAttribute("mensagem");--%>
<%--    String cor = verifica ? "green" : "red";--%>
<%--%>--%>

<%--<p style="color: <%= cor %>"> MENSAGEM:<%=mensagem%></p>--%>

<%--</body>--%>
<%--</html>--%>

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
<%-- Remova ou modifique o include conforme necessário --%>
 <jsp:include page="/Pages/ADM.jsp" />


<%
    Boolean verifica = (Boolean) request.getAttribute("verifica");
    String mensagem = (String) request.getAttribute("mensagem");
    String cor = verifica != null && verifica ? "green" : "red";
%>

<p style="color: <%= cor %>"> MENSAGEM: <%= mensagem != null ? mensagem : "Nenhuma mensagem disponível" %></p>

</body>
</html>

