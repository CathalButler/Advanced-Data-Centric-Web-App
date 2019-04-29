<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Stylesheet -->
    <link rel="stylesheet" href="/css/table.css">
    <meta charset="ISO-8859-1">
    <title>ADCWA Final Project</title>
</head>
<body>
<h1>List of Customer</h1>
<!-- Loop for all customer data -->
<c:forEach items="${customers}" var="customer">

    <!-- Customer ID and Name -->
    <h3>${customer.cId} ${customer.cName}</h3>
    <!-- Customer Loan Period -->
    <p>Loan Period = ${customer.loanPeriod}</p>

    <table>
        <!-- Table headings -->
        <tr>
            <th>Loan ID</th>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <!-- Table Data -->
        <!-- Loop for all loan data -->
        <c:forEach items="${customer.loans}" var="loan">
            <tr>
                <td>${loan.lid}</td>
                <td>${loan.book.bid}</td>
                <td>${loan.book.title}</td>
                <td>${loan.book.author}</td>
            </tr>
            <!--End loop for loans data -->
        </c:forEach>
    </table>
</c:forEach>
<!--End loop for customer data -->

<!-- Narration Links -->
<a href="/">Home</a>
<a href="/addBook">Add Book</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/logout">Logout</a>
</body>
</html>