<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-primary rounded">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/FlatController?action=create" role="button">Create</a>
        </li>

    </ul>
    <!-- Navbar-nav with FORM -->
    <ul class="navbar-nav ml-auto">
        <form class="form-inline" action="/FlatController" method="get">
                <input hidden name="action" type="text" value="search">
        <li>
                <input class="form-control mr-sm-2" name="id" placeholder="Search by id" type="text">
        </li>
        <li>
                <input class="form-control mr-sm-2" name="status" placeholder="Search by status" type="text">
                <button class="btn btn-success" type="submit">Search</button>
        </li>
        </form>
    </ul>
</nav>
<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">id</th>
            <th scope="col">AREA</th>
            <th scope="col">STATUS</th>
            <th scope="col">STAGE</th>
            <th scope="col">TYPE</th>
            <th scope="col">PRICE</th>
            <th scope="col">DATE IN </th>
            <th scope="col">DATE OUT</th>
            <th colspan="2">STATUS</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="list" varStatus="state">
            <tr>
                <th scope="row">${state.count}</th>
                <td>${list.id}</td>
                <td>${list.area}</td>
                <td>${list.status}</td>
                <td>${list.stage}</td>
                <td>${list.type}</td>
                <td>${list.price}</td>
                <td>${list.date_in}</td>
                <td>${list.date_out}</td>
                <td><a href="/FlatController?action=update&id=${list.id}">UP</a></td>
                <td><a href="/FlatController?action=delete&id=${list.id}">DEL</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
