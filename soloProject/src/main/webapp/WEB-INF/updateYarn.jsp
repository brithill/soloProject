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
                <h1>Update <c:out value="${yarn.yarnName}"/></h1>
                <a href="/logout">logout</a>
            </div>
            <div>
                <p><a href="/home">Home</a> | <a href="/yarn/all">Yarn</a> | <a href="/pattern/create">Add a Pattern</a> | <a href="/yarn/create">Add Yarn</a> | <a href="/pattern/all">All Patterns</a></p>
            </div>
            <div>
                <form:form action="/yarn/${yarn.id}/update" method="post" modelAttribute="yarn">
			<p>
				<form:label path="brand">Brand:</form:label>
				<form:errors class="text-danger" path="brand" />
				<form:input class="form-control" path="brand" />
			</p>
			<p>
				<form:label path="yarnName">Yarn Name:</form:label>
				<form:errors class="text-danger" path="yarnName" />
				<form:input class="form-control" path="yarnName" />
			</p>
            <p>
				<form:label path="color">Yarn Color:</form:label>
				<form:errors class="text-danger" path="color" />
				<form:input class="form-control" path="color" />
			</p>
            <p>
				<form:label path="lot">Lot:</form:label>
				<form:errors class="text-danger" path="lot" />
				<form:input class="form-control" path="lot" />
			</p>
            <p>
				<form:label path="material">Material:</form:label>
				<form:errors class="text-danger" path="material" />
				<form:input class="form-control" path="material" />
			</p>
            <p>
				<form:label path="weight">Weight:</form:label>
				<form:errors class="text-danger" path="weight" />
				<form:input class="form-control" path="weight" />
			</p>
			<p>
				<form:label path="care">Care:</form:label>
				<form:errors class="text-danger" path="care" />
				<form:textarea class="form-control" path="care" />
			</p>
			<input type="hidden" value="put" name="_method" />
		    <input class="btn btn-outline-primary" type="submit" value="Submit" />
		</form:form>
            </div>
        </div>
    </div>
</body>
</html>