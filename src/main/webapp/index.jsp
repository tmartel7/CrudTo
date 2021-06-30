<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Première page JSP</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">
</head>
<body>
<p>
    <%
        out.print("Votre addresse IP est " + request.getRemoteAddr());
    %>
</p>

<p>La date actuelle du serveur est 🕵️: <%= (new java.util.Date()).toString()%>
</p>

<a href="<c:url value = "jstl-demo.jsp"/>">demo jstl</a>
<a href="<c:url value = "random.jsp"/>">random</a>

</body>
</html>
