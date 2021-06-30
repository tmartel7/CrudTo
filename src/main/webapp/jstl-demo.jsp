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

<p>La date actuelle du serveur est 🕵️: <%= (new java.util.Date()).toString()%>
</p>

<c:set var="now" value="<%= new java.util.Date()%>"/>

<p>Date formatée (1): <fmt:formatDate type="time" value="${now}"/></p>

<p>Date formatée (2): <fmt:formatDate type="date" value="${now}"/></p>

<p>Date formatée (3): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/></p>

<a href="https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm">Documentation</a>

</body>
</html>
