<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Market Bin</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="\stylesheet.css" />
</head>
<body>
    <div class="container">
        <div >
            <div class="d-flex justify-content-between">
                <h1>Update <c:out value="${pattern.patternName}"/></h1>
                <a href="/logout">logout</a>
            </div>
            <div>
                <p><a href="/home">Home</a> | <a href="/yarn/all">Yarn</a> | <a href="/pattern/create">Add a Pattern</a> | <a href="/yarn/create">Add Yarn</a> | <a href="/pattern/all">All Patterns</a></p>
            </div>
        </div>
        <div>
            <form:form action="/pattern/${pattern.id}/update" method="post" modelAttribute="pattern">
        <p>
            <form:label path="patternName">Name:</form:label>
            <form:errors class="text-danger" path="patternName" />
            <form:input class="form-control" path="patternName" />
        </p>
        <p>
            <form:label path="designer">Pattern Designer:</form:label>
            <form:errors class="text-danger" path="designer" />
            <form:input class="form-control" path="designer" />
        </p>
        <p>
            <form:label path="price">Price:</form:label>
            <form:errors class="text-danger" path="price" />
            <form:input class="form-control" path="price" />
        </p>
        <p>
            <form:label path="time">Time to make:</form:label>
            <form:errors class="text-danger" path="time" />
            <form:input class="form-control" path="time" />
        </p>
        <p>
            <form:label path="other">Additional Supplies needed:</form:label>
            <form:errors class="text-danger" path="other" />
            <form:textarea class="form-control" path="other" />
        </p>
        <input type="hidden" value="put" name="_method" />
		<input class="btn btn-outline-primary" type="submit" value="Submit" />
    </form:form>
        </div>
    </div>
</body>
</html>