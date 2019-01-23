<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html lang="en">
<body>
 <h2>Spring Security Example</h2>
 <h1>Welcome! <sec:authentication property="principal.userId"/></h1>
  <form action="/logout" method="post">
  <!-- for csrf. 
     <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
   -->
  <input type="submit" value="Logout">
	</form>
</body>
</html>