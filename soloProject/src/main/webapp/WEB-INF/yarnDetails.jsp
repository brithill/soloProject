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
                <h1><c:out value="${yarn.yarnName}"/></h1>
                <a href="/logout">logout</a>
            </div>
            <div>
                <p><a href="/home">Home</a> | <a href="/yarn/all">Yarn</a> | <a href="/pattern/create">Add a Pattern</a> | <a href="/yarn/create">Add Yarn</a> | <a href="/pattern/all">All Patterns</a></p>
            </div>
            <div>
                <p>Brand: <c:out value="${yarn.brand}"/></p>
                <p>Color: <c:out value="${yarn.color}"/></p>
                <p>Lot: <c:out value="${yarn.lot}"/></p>
                <p>Weight: <c:out value="${yarn.weight}"/></p>
                <p>Material: <c:out value="${yarn.material}"/></p>
                <p>Care: <c:out value="${yarn.care}"/></p>
            </div>
            <div class="d-flex">
                <a href="/yarn/${yarn.id}/edit"><button class="btn btn-primary">Update</button></a>
                <form action="/yarn/${yarn.id}/delete" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" class="btn btn-outline-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</body>
</html>