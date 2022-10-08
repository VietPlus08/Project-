<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        /*div{*/
        /*    margin: 0px 300px 0 300px;*/
        /*}*/



    </style>
</head>
<body>
    <form action="/ServletController" method="get">
        <input type="text" hidden name="action" value="doUpdate">
        <!-- Vertical -->
        <div class="form-group">
            <label>ID</label>
            <input type="text" name = "id" class="form-control" value="${item.id}">
            <label>Name</label>
            <input type="text" name="name" class="form-control" value="${item.name}">
            <label>Name</label>
            <input type="text" name="numPerson" class="form-control" value="${item.numPerson}">
            <label>Name</label>
            <input type="date" name="date" class="form-control" value="${item.date}">
            <label>Name</label>
            <input type="text" name="address" class="form-control" value="${item.address}">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
