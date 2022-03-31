<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<%
session.invalidate();//destroy session
response.sendRedirect("login.jsp");
%>
<script>
          alert('Successfully Logout');
          window.location='login.jsp';
        </script>
</body>
</html>