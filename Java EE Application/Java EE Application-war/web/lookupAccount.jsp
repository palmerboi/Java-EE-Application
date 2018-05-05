<%-- 
    Document   : lookupAccount
    Created on : 3/05/2018, 5:55:19 PM
    Author     : reube
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Account Lookup</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="${pageContext.request.contextPath}/accountLookupServlet" method="GET">
            <label>Account ID number:</label>
            <input type="text" id="bankID" name="bankID" />
            <button type="submit" name="search" value="search">Search Account</button>
            <P><A HREF="index.jsp">Back to homepage</A></P>
        </form>
    </body>
</html>
