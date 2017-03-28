<%-- 
    Document   : result
    Created on : 28-Jun-2016, 12:47:31
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="5;URL=http://localhost:8080/webbank/options?action=transactions">
        <link href="<c:url value="resource/css/dialogs.css" />" rel="stylesheet" type="text/css">
        <title>Online Banking</title>
    </head>
    <body>
        <h1 id="<c:out value="${cssValue}" />"><c:out value="${message}" /></h1>
    </body>
</html>
