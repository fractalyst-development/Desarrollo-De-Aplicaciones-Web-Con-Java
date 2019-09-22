<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="hm" uri="/WEB-INF/tlds/HolaMundo" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String m = "Pedro";
            request.setAttribute("m", m);
        %>
        <h1>Hello World!</h1>
        <hm:HolaMundoTag nombre="cazucito" />
        <hm:HolaMundoTag nombre="${m}" />
        <h:SimpleTaf message="Simpple"/>
        <h:saludo nombre="${m}" predeterminado="WORLD" />
        
    </body>
</html>
