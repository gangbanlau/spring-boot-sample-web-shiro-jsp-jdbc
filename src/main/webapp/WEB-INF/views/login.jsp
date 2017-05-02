<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style>
    .error { color: red; }
  </style>  
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="loginFormBean">
		<div class="header">
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">User:</td>
        <td width="20%">
          <form:input path="user"/>
        </td>
        <td width="60%">
          <form:errors path="user" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">Password:</td>
        <td width="20%">
          <form:input type="password" path="password"/>
        </td>
        <td width="60%">
          <form:errors path="password" cssClass="error"/>
        </td>
    </tr>    
  </table>
  <br>
  <input type="submit" align="center" value="Submit">
</form:form>  
</body>
</html>