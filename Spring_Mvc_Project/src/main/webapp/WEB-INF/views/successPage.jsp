<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--Obtaining user name from Session scope against the name:
loggedInUser
 --%>
 
 <%
 Object loggedInUserName = session.getAttribute("loggedInUser");
 %>
 
<h1 style="background-color: green; color:white">
Hey<%= loggedInUserName %>
Congratulations!!! You are IN.🎉🎉

</h1>
</body>
</html>