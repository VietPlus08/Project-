<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Facility list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">RESORT MANAGEMENT</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/CustomerServlet">Customer</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/EmployeeServlet">Employee</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/FacilityServlet">Facility</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/BookServlet">Book</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/ContractServlet">Contract</a>
                            </li>

                        </ul>
                        <div  class="d-flex">
                            <div>
                                <a href="/EmployeeServlet?action=create" class="btn btn-outline-success" role="button">Create</a>
                            </div>
                            <div>
                                <form action="/EmployeeServlet" method="get" class="d-flex" role="search">
                                    <input type="hidden" name="action" value="search" >
                                    <input name="id" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>

    </div>
    <div class="row">
        <div class="col-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Period</th>
                    <th scope="col">Area</th>
                    <th scope="col">Max person</th>
                    <th scope="col">Price</th>
                    <th scope="col">Type</th>
                    <th scope="col">Floor</th>
                    <th scope="col">Pool Area</th>
                    <th scope="col" colspan="2">Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="list" varStatus="state">
                    <tr>
                        <th scope="row">${state.count}</th>
                        <td>${list.id}</td>
                        <c:forEach items="${period}" var="period">
                            <c:if test="${period.id == list.period}">
                                <td>${period.name}</td>
                            </c:if>
                        </c:forEach>
                        <td>${list.area}</td>
                        <td>${list.max_person}</td>
                        <td>${list.price}</td>
                        <c:forEach items="${type}" var="type">
                            <c:if test="${list.type == type.id}">
                                <td>${type.name}</td>
                            </c:if>
                        </c:forEach>
                        <td>${list.floor}</td>
                        <td>${list.pool_area}</td>
                        <td><a href="/FacilityServlet?action=update&id=${list.id}">UP</a></td>
                        <td><button onclick="showInfoDelete('${list.id}')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#delete">
                            DEL
                        </button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--modal delete--%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/FacilityServlet?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="deleteId" name="id" type="hidden">
                    <span>Are you delete </span><span id="deleteObject"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>



<script>
    function showInfoDelete(id) {
        console.log(id);
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteObject").innerText = id;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
