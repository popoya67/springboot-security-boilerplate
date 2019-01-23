<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My Custom Login Page</title>
</head>
<body style='margin:50px;'>
  <h2>My Custom Login Page</h2>
  <form action="/login" method="post">
    	<c:if test="${param.error != null}">
    		<p style='color:red'>
    			Invalid username and password.
    		</p>
    	</c:if>
    	<c:if test="${param.logout != null}">
    		<p style='color:blue'>
    			You have been logged out.
    		</p>
    	</c:if>
    	<p>
    		<label for="userId">userId</label>
    		<input type="text" id="userId" name="userId"/>
    	</p>
    	<p>
    		<label for="password">Password</label>
    		<input type="password" id="password" name="password"/>
    	</p>
    	<button type="submit">Log in</button>
    </form>
</body>
</html>