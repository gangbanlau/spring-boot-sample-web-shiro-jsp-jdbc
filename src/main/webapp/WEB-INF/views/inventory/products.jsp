<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>

<html>
  <head><title><fmt:message key="products.title"/></title></head>
  <body>
    <h1><fmt:message key="products.heading"/></h1>
    <p><fmt:message key="products.greeting"/> <c:out value="${now}"/></p>
    <h3>Products</h3>
    <c:forEach items="${products}" var="prod">
      <c:out value="${prod.name}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    <br>
    <shiro:hasPermission name="product:manage">
    <a href="<c:url value="/inventory/priceincrease"/>">Increase Prices</a>
    </shiro:hasPermission>
    <br>
    <br>
    <a href="<c:url value="/logout"/>">Logout</a>
    <br>    
  </body>
</html>