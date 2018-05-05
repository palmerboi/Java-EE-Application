<%-- 
    Document   : createAccount
    Created on : 3/05/2018, 5:55:07 PM
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
        <h1>Create Account Page</h1>



        <form action="${pageContext.request.contextPath}/accountCreateServlet" method="GET">
            <% out.println("Enter accountID"); %>
            <input type="number" name="accountID"/>
            <br/>
            <% out.println("BranchID 1-4 "); %>
            <input type="number" name="branchID"/> 
            <br/>
            <% out.println("Enter balance");%>
            <input type="number" name="balance"/>
            <input type="submit" name="submitButton"/>
            <P><A HREF="index.jsp">Back to homepage</A></P>
        </form>
    </body>
</html>
