<%-- 
    Document   : createAccount
    Created on : 3/05/2018, 5:55:07 PM
    Author     : reube
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Account Page</h1>
        <form action="${pageContext.request.contextPath}/accountCreateServlet" method="GET">
            <input type="number" name="accountID"/>
            <input type="number" name="branchID"/>
            <input type="number" name="balance"/>
            <input type="submit" name="submitButton"/>
        </form>
    </body>
</html>
