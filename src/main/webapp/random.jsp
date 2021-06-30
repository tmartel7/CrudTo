<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Première page JSP</title>
    <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">
</head>
<body>

<c:set var="randomNumber" value="<%= Math.random() %>"/>

<p>
    Le nombre est: <b> <c:out value="${randomNumber}"/> </b>
</p>
<c:choose>
    <c:when test="${randomNumber > 0.5}">
        <b style="color: green">Gagné 🏆</b>
    </c:when>
    <c:otherwise>
        <b style="color: red">Perdu 😱</b>
    </c:otherwise>
</c:choose>

</body>
</html>
