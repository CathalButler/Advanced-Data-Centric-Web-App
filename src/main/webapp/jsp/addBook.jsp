<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Book information here</title>
</head>
<body>
<form:form modelAttribute="book" method="POST" acceptCharset="UTF-8">
    <table>
        <tr>
            <td>Book Title:</td>
            <td><form:input path="title"></form:input></td>
            <td><form:errors path="title"></form:errors></td>
        </tr>

        <tr>
            <td>Book Author:</td>
            <td><form:input path="author"></form:input></td>
            <td><form:errors path="author"></form:errors></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>