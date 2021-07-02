<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Première page JSP</title>
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
