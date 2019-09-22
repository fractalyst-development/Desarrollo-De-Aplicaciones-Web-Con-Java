<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Desarrollo de Aplicaciones con Java (DEMO): JSP</title>
    </head>
    <body>
        <h1>Desarrollo de Aplicaciones con Java (DEMO): JSP</h1>
        <h2>Información desde la tabla</h2>
        <ul>
            <c:forEach items="${datosTabla}" var="dato">
                <li><c:out value = "${dato.id}"/>/<c:out value = "${dato.campo1}"/></li>
                </c:forEach>
        </ul>
    </body>
</html>
