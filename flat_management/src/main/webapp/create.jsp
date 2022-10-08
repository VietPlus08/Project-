<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>create</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<form action="/FlatController?action=doCreate" method="post">
<%--    <input type="hidden" name="action" value="doCreate">--%>
    <div class="mb-3">
        <label >ID</label>
        <input type="text" class="form-control" name="id" value="${list.id}">
        <c:if test="${error!=null}">${error.get("id")}</c:if>
    </div>
    <div class="mb-3">
        <label >AREA</label>
        <input type="number" class="form-control" name="area" value="${list.area}">
        <c:if test="${error!=null}">${error.get("area")}</c:if>
    </div>
    <div class="mb-3">
        <label >STATUS</label>
        <select name="status" class="form-select" aria-label="Default select example">
            <c:choose>
                <c:when test="${list.status == 'full'}">
                    <option value="1" selected>Full</option>
                    <option value="2">Empty</option>
                    <option value="3">Can be rent</option>
                </c:when>
                <c:when test="${list.status == 'empty'}">
                    <option value="1">Full</option>
                    <option value="2" selected>Empty</option>
                    <option value="3">Can be rent</option>
                </c:when>
                <c:when test="${list.status == 'can be rent'}">
                    <option value="1">Full</option>
                    <option value="2">Empty</option>
                    <option value="3" selected>Can be rent</option>
                </c:when>
                <c:otherwise>
                    <option selected>Open this select menu</option>
                    <option value="1">Full</option>
                    <option value="2">Empty</option>
                    <option value="3">Can be rent</option>
                </c:otherwise>
            </c:choose>
        </select>
    </div>
    <div class="mb-3">
        <label >STAGE</label>
        <select name="stage" class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <c:forEach begin="1" end="15" varStatus="item">
                <c:if test="${list.stage == item.count}">
                    <option value="${item.count}" selected>${item.count}</option>
                </c:if>
                <c:if test="${list.stage != item.count}">
                    <option value="${item.count}">${item.count}</option>
                </c:if>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label >TYPE</label>
        <select name="type" class="form-select" aria-label="Default select example">
            <c:if test="${list.type == null}">
                <option selected>Open this select menu</option>
                <option value="1" >private</option>
                <option value="2">public</option>
            </c:if>
            <c:if test="${list.type == 'private'}">
                <option value="1" selected>private</option>
                <option value="2">public</option>
            </c:if>
            <c:if test="${list.type == 'public'}">
                <option value="1" >private</option>
                <option value="2" selected>public</option>
            </c:if>

        </select>
    </div>
    <div class="mb-3">
        <label >PRICE</label>
        <input type="number" class="form-control" name="price" value="${list.price}">
        <c:if test="${error!=null}">${error.get("price")}</c:if>
    </div>
    <div class="mb-3">
        <label >DATE IN </label>
        <input type="date" class="form-control" name="date_in" value="${list.date_in}">
    </div>
    <div class="mb-3">
        <label >DATE OUT</label>
        <input type="date" class="form-control" name="date_out" value="${list.date_out}">
        <c:if test="${error!=null}">${error.get("date")}</c:if>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
