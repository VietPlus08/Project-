<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer Registry</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            1 of 3
        </div>
        <div class="col-6">
            <h1>CUSTOMER REGISTRY</h1>

        </div>
        <div class="col">
            3 of 3
        </div>
    </div>
    <div class="row">
        <div class="col">
            1 of 3
        </div>
        <div class="col-6">
            <form action="/CustomerServlet" method="post">
                <c:choose>
                    <c:when test="${item.id == null || (item.id != null && message == 'Create is fail!!!')}">
                        <input type="hidden" name="action" value="doCreate">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="action" value="doUpdate">
                    </c:otherwise>
                </c:choose>
                <c:if test="${message!=null}"><p>${message}</p></c:if>
                <div class="mb-3">
                    <label class="form-label">ID</label>
                    <input type="text" class="form-control" name="id" value="${item.id}" >
                    <c:if test="${error!=nul}">${error.get("id")}</c:if>
                </div>
                <div class="mb-3">
                    <label class="form-label">NAME</label>
                    <input type="text" class="form-control" name="name" value="${item.name}">
                    <c:if test="${error!=nul}">${error.get("name")}</c:if>
                </div>
                <div class="mb-3">
                    <label class="form-label">ADDRESS</label>
                    <input type="text" class="form-control" name="address" value="${item.address}">
                    <c:if test="${error!=nul}">${error.get("address")}</c:if>
                </div>
                <div class="mb-3">
                    <label class="form-label">DATE</label>
                    <input type="date" class="form-control" name="date" value="${item.dob}">
                    <c:if test="${error!=nul}">${error.get("dob")}</c:if>
                </div>
                <div class="mb-3">
                    <label class="form-label">TEL</label>
                    <input type="tel" class="form-control" name="phone" value="${item.phone}">
                </div>
                <div class="mb-3">
                    <label class="form-label">GENDER</label><BR>
<%--                    <input type="radio" name="gender" value="1" ${item.gender=='Male'?checked:""}>--%>
<%--                    <label class="form-check-label" >Male</label> <br>--%>
<%--                    <input type="radio" name="gender" value="2" ${item.gender=='Female'?checked:""}>--%>
<%--                    <label class="form-check-label" >Female</label>--%>
                    <c:if test="${item.gender == 'Male'}">
                        <input type="radio" name="gender" value="1" checked>
                        <label class="form-check-label" >Male</label> <br>
                        <input type="radio" name="gender" value="2" >
                        <label class="form-check-label" >Female</label>
                    </c:if>
                    <c:if test="${item.gender == 'Female'}">
                        <input type="radio" name="gender" value="1" >
                        <label class="form-check-label" >Male</label> <br>
                        <input type="radio" name="gender" value="2" checked>
                        <label class="form-check-label" >Female</label>
                    </c:if>
                </div>
                <div class="mb-3">
                    <select aria-label="Default select example" class="form-select" name="cusType">

                        <c:choose>
                            <c:when test="${item.cusType==null}">
                                <option selected>Open this select menu</option>
                                <option value="1">VIP</option>
                                <option value="2">DIAMOND</option>
                                <option value="3">NORMAL</option>
                            </c:when>
                            <c:when test="${item.cusType == 'VIP'}">
                                <option value="1" selected>VIP</option>
                                <option value="2" >DIAMOND</option>
                                <option value="3" >NORMAL</option>
                            </c:when>
                            <c:when test="${item.cusType == 'DIAMOND'}">
                                <option value="1" >VIP</option>
                                <option value="2" selected>DIAMOND</option>
                                <option value="3" >NORMAL</option>
                            </c:when>
                            <c:otherwise>
                                <option value="1" >VIP</option>
                                <option value="2" >DIAMOND</option>
                                <option value="3" selected>NORMAL</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary" >Submit</button>
                <a href="/CustomerServlet" class="btn btn-secondary" role="button">Back</a>
            </form>
        </div>
        <div class="col">
            3 of 3
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
