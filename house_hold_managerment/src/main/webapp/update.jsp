<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>
<form action="/Controller" method="get">
    <input type="text" hidden name="action" value="doUpdate">
    <div class="form-group">
        <label>ID</label>
        <input class="form-control" name="id" type="text" value="${item.id}" readonly>
    </div>
    <div class="form-group">
        <label>Name</label>
        <input class="form-control" name="name" type="text" value="${item.name}">
    </div>
    <div class="form-group">
        <label>Date</label>
        <input class="form-control" name="date" type="date" value="${item.date}">
    </div>
    <div class="form-group">
        <label>Address</label>
        <input class="form-control" name="address" type="text" value="${item.address}">
    </div>
    <div class="form-group">
        <input class="form-control" name="numPerson" type="text" value="${item.numPerson}" readonly>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
