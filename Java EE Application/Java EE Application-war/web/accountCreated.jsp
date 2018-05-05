<%-- 
    Document   : accountCreated
    Created on : 3/05/2018, 7:08:03 PM
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
        <h1>Account Created Successfully!</h1>
        <jsp:useBean id="account" class="beans.Account" scope="session" />
        <p>Account ID: <%=account.getAccountID() %> </p>
        <p>Branch ID: <%=account.getBranchID() %> </p>
        <p>Balance: <%=account.getBalance() %> </p>
    </body>
</html>
