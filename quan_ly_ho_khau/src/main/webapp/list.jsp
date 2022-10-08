<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    </script>
    <style>
        /*div{*/
        /*    margin: 0px 300px 0 300px;*/
        /*}*/

    </style>
</head>
<body>
<div>
    <nav class="navbar navbar-expand-sm navbar-dark rounded">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <%--                <button href="action" class="btn btn-success" type="submit" >+ Add product</button>--%>
                <a class="btn btn-primary m-1" href="/productServlet?action=create" role="button">+ Them ho khau</a>
            </li>
            <li class="nav-item">
                <form action="/ServletController" method="get">
                <input type="text" hidden name="action" value="search">
                <input name="name" type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button type="submit" class="btn btn-outline-primary">search</button>
                </form>
            </li>
        </ul>
    </nav>
</div>


<div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>No</th>
            <th>So ho khau</th>
            <th>Ten chu ho</th>
            <th>So thanh vien</th>
            <th>Ngay lap so</th>
            <th>Dia chi nha</th>
            <th colspan="2">Chuc nang</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${item}" var="item" varStatus="state">
            <tr>
                <th><c:out value="${state.count}"></c:out></th>
                <th><c:out value="${item.id}"></c:out></th>
                <th><c:out value="${item.name}"></c:out></th>
                <th><c:out value="${item.numPerson}"></c:out></th>
                <th><c:out value="${item.date}"></c:out></th>
                <th><c:out value="${item.address}"></c:out></th>
                <th><a href="/ServletController?action=update&id=${item.id}" role="button" class="btn btn-light">Chinh
                    sua</a></th>
                    <%--                <th><a href="#" role="button" class="btn btn-primary"></a></th>--%>

                <!-- Button trigger modal -->
                <th>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                        onclick="showConfirmModalDialog('${item.listPersonInHouse}')">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-7-square" viewBox="0 0 16 16">
                        <path d="M5.37 5.11V4.001h5.308V5.15L7.42 12H6.025l3.317-6.82v-.07H5.369Z"/>
                        <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2Zm15 0a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2Z"/>
                    </svg>
                </button>
                </th>
                    <%--                <th><button type="button" class="btn btn-primary">Xem thanh vien</button>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%--    -- modal -- --%>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p id="display_name"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <nav aria-label="Search results pages">
        <ul class="pagination">
            <c:choose>
                <c:when test="${pageIndex == 1}">
                    <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Previous</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="/ServletController?action=display&pageIndex=${pageIndex - 1}">Previous</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="1" end="${maxPage}" var="item">
                <li class="page-item">
                    <a class="page-link" href="/ServletController?action=display&pageIndex=${item}">${item}</a>
                </li>
            </c:forEach>
            <c:choose>
                <c:when test="${pageIndex == maxPage}">
                    <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Next</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="/ServletController?action=display&pageIndex=${pageIndex + 1}">Next</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <%--</div>--%>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script>
        function showConfirmModalDialog(name) {
            console.log(name);
            document.getElementById("display_name").innerHTML = name;
        }
    </script>
</body>
</html>