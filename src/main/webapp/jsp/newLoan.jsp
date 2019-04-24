<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Loan information here</title>
</head>
<body>
<form:form modelAttribute="loan">
    <table>
        <tr>
            <td>Customer ID</td>
            <td><form:input path="cust"></form:input></td>
        </tr>

        <tr>
            <td>Book ID:</td>
            <td><form:input path="book"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>