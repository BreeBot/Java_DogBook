<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Dogs, Dawgs, Doggs!</h1>

<c:forEach items="${requestScope.profiles}" var="puppy" >
  <h2><c:out value="${puppy.firstName}" />
  <c:out value="${puppy.lastName}" />
  <img src=<c:out value="${puppy.getPhotoUrl()}" /> />
  </h2>

</c:forEach>