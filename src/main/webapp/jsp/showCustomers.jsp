<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>ADCWA Final Project</title>
</head>
<body>
<h1>List of Customer</h1>
<table>
    <tr>
        <th>Customer ID</th>
        <th>Customer Name</th>
        <th>Loan Period</th>
    </tr>
    <tr>
        <c:forEach items="${customers}" var="customer">
    <tr>
        <td>${customer.cId}</td>
        <td>${customer.cName}</td>
        <td>${customer.loanPeriod}</td>
    </tr>
    </c:forEach>
    </tr>
</table>
<a href="/">Home</a>
<a href="/addBook">Add Book</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/">Logout</a>
</body>
</html>