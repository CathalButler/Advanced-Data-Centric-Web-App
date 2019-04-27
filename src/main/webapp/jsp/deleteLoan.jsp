<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>ADCWA Final Project</title>
</head>
<body>
<form:form modelAttribute="loan" method="POST" acceptCharset="UTF-8">
    <h3>Delete Loan</h3>
    <td>Loan ID: <form:input path="lid"></form:input></td>
    <td colspan="2"><input type="submit" value="Add" /></td>
</form:form>

<a href="/">Home</a>
<a href="/addBook">Add Book</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/">Logout</a>
</body>
</html>