<%-- 
    Document   : accountFound
    Created on : 4/05/2018, 1:22:41 PM
    Author     : Reuben Palmer 1378847, Alex Alnaib 14874604
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Account Found!</h1>
        <jsp:useBean id="account" class="beans.Account" scope="session" />
        <p>Account ID: <%= account.getAccountID()%></p>
        <p>Branch ID: <%= account.getBranchID()%></p>
        <p>Balance: <%= account.getBalance()%></p>
        <P><A HREF="lookupAccount.jsp">Lookup another account</A></P>
    </body>
</html>
