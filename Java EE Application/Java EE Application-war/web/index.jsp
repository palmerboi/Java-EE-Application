<%-- 
    Document   : index
    Created on : 3/05/2018, 5:52:12 PM
    Author     : Reuben Palmer 1378847, Alex Alnaib 14874604
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
        <form action="Visitcount" method="Post">
            <input type="submit" value="number of visitors on site">
        </form>
    </body>
</html>
