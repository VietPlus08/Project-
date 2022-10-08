<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        div{
            margin: 0px 300px 0 300px;
        }

    </style>
</head>
<body>
<div>
    <nav class="navbar navbar-expand-sm navbar-dark rounded">
<%--    <nav class="navbar navbar-expand-sm navbar-dark bg-primary rounded">--%>
<%--        <a class="navbar-brand" href="#">Product Manager</a>--%>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
<%--                <button href="action" class="btn btn-success" type="submit" >+ Add product</button>--%>
                <a class="btn btn-primary m-1" href="/productServlet?action=create" role="button">+ Add product</a>
            </li>
            <li class="nav-item">
                <a class="btn btn-secondary m-1" role="button"> Nguyễn Ánh</a>
            </li>
        </ul>
        <!-- Navbar-nav with FORM -->
        <ul class="navbar-nav ml-auto">
            <form class="form-inline" action="/productServlet?action=search" method="post">
                <input class="form-control mr-sm-2" name="name" type="text" placeholder="Search">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </ul>
    </nav>
</div>
<div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th colspan="2">Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${item}" var="item" varStatus="state">
            <tr>
                <th><c:out value="${state.count}"></c:out></th>
                <th><c:out value="${item.name}"></c:out></th>
                <th><c:out value="${item.price}"></c:out></th>
                <th><c:out value="${item.quantity}"></c:out></th>
                <th><c:out value="${item.color}"></c:out></th>
                <th><c:out value="${item.category}"></c:out></th>
                <th><a href="/productServlet?action=update&name=${item.name}">Up</a></th>
                <th><a href="/productServlet?action=delete&name=${item.name}">Del</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Search results pages">
        <ul class="pagination">
            <c:choose>
                <c:when test="${index==1}">
                    <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Previous</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="/productServlet?action=paging&index=${index-1}" >Previous</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="1" end="${maxPage}" var="item">
                <li class="page-item">
                    <a class="page-link" href="/productServlet?action=paging&index=${item}">${item}</a>
                </li>
            </c:forEach>
            <c:choose>
                <c:when test="${index==maxPage}">
                    <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Next</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="/productServlet?action=paging&index=${index+1}" >Next</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>
</div>

</body>
</html>
