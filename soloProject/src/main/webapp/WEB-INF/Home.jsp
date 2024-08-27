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
        <div>
            <div class="d-flex justify-content-between">
                <h1>Welcome <c:out value="${user.userName}"/>!</h1>
                <a href="/logout">logout</a>
            </div>
            <div>
                <p><a href="/home">Home</a> | <a href="/yarn/all">Yarn</a> | <a href="/pattern/create">Add a Pattern</a> | <a href="/yarn/create">Add Yarn</a> | <a href="/pattern/all">All Patterns</a></p>
            </div>
            <div>
                <table class="table table-hover border-primary">
                    <thead>
                        <tr >
                            <th >Name</th>
                            <th >Price</th>
                            <th >Designer</th>
                            <th>Entered by</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach var="pattern" items="${pattern}">
                            <tr class="table-active">
                                <td><a href="/pattern/${pattern.id}"><c:out value="${pattern.patternName}"></c:out></a></td>
                                <td>$<c:out value="${pattern.price}"></c:out></td>
                                <td><c:out value="${pattern.designer}"></c:out></td>
                                <td><c:out value="${pattern.user.userName}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div>
                <table class="table table-hover border-primary">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Color</th>
                            <th>Entered by</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach var="yarn" items="${yarn}">
                            <tr class="table-active">
                                <td><a href="/yarn/${yarn.id}"><c:out value="${yarn.yarnName}"></c:out></a></td>
                                <td><c:out value="${yarn.brand}"></c:out></td>
                                <td><c:out value="${yarn.color}"></c:out></td>
                                <td><c:out value="${yarn.user.userName}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</body>
</html>