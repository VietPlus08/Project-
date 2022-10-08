<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>
    <div>
        <form action="">
            <div class="input-group">
                <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button type="button" class="btn btn-outline-primary">search</button>
            </div>
        </form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">So ho khau</th>
                <th scope="col">Ten chu ho</th>
                <th scope="col">So nguoi trong ho</th>
                <th scope="col">Ngay lap so</th>
                <th scope="col">Dia chi </th>
                <th scope="col" colspan="2">Trang thai</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="list" varStatus="state">
            <tr>
                <th scope="row">${state.count}</th>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.numPerson}</td>
                <td>${list.date}</td>
                <td>${list.address}</td>
                <td><a href="/Controller?action=update&id=${list.id}">Sua TT</a></td>
                <td><button class="btn btn-primary"
                    data-bs-target="#exampleModal"
                    data-bs-toggle="modal"
                    onclick="showModal('${list.listPersonInHouse}')"
                    type="button">
                    Xem so nguoi
                </button></td>

            </tr>
            </c:forEach>
        </table>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p id="display"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
<%--    paging--%>
    <div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentPage ==1}">
                        <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Previous</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="/Controller?currentPage=${currentPage - 1}">Previous</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach begin="1" end="${maxPage}" var="item" >
                    <li class="page-item"><a class="page-link" href="/Controller?currentPage=${item}">${item}</a></li>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPage == maxPage}">
                        <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Next</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="/Controller?currentPage=${currentPage + 1}">Next</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </div>
<%--function modal--%>
    <script>
        function showModal(name) {
            console.log(name);
            document.getElementById("display").innerText = name;
        }

    </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
