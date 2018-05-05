<%-- 
    Document   : index
    Created on : 3/05/2018, 5:52:12 PM
    Author     : reube
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AUT Bank Options Page</title>
    </head>
    <body>
        <h1>AUT Bank</h1>
        <form action="${pageContext.request.contextPath}/indexPageServlet" method="GET">
            <button type="submit" name="button" value="create">Create Account</button>
            <button type="submit" name="button" value="lookup">Lookup Account</button>
        </form>
    </body>
</html>
