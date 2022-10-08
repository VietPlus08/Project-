<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registry list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <style>
        .form-group{
            margin: 20px 300px 0 300px;
        }
    </style>
</head>
<body>
<form action="/productServlet?action=registry" method="post">
<input type="hidden" name="action" value="registry">
<div class="form-group">
    <label >Name</label>
    <input type="text" name = "name" class="form-control" value="${item.name}">
    <c:if test="${error!=null}"><p>${error.get("name")}</p></c:if>
    <label >Price</label>
    <input type="number" name= "price" class="form-control" value="${item.price}">
    <c:if test="${error!=null}"><p>${error.get("price")}</p></c:if>
    <label >Quantity</label>
    <input type="number" name= "quantity" class="form-control" value="${item.quantity}">
    <c:if test="${error!=null}"><p>${error.get("quantity")}</p></c:if>
    <label >Color</label>
    <input type="text" name= "color" class="form-control" value="${item.color}">
    <label >Description</label>
    <input type="text" name= "des" class="form-control" value="${item.des}">
    <label >Category</label>
    <select name="category" class="form-control">
        <option selected>Choose...</option>
        <option value="1">Phone</option>
        <option value="2">Television</option>
        <option value="3">Ipad</option>
        <option value="4">Laptop</option>
    </select>
    <c:if test="${error!=null}"><p>${error.get("category")}</p></c:if>
<%--    <a class="btn btn-primary m-1" href="/productServlet?action=registry" role="button">Registry</a>--%>
    <button type="submit" class="btn btn-primary">Registry</button>
<%--    <form action="/productServlet" method="get">    <button type="submit" class="btn btn-secondary">Cancel</button>--%>
<%--    </form>--%>
    <a class="btn btn-secondary m-1" href="/productServlet" role="button">Cancel</a>
</div>
</form>
</body>
</html>
