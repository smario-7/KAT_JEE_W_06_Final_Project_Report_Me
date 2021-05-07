<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../head.jsp" %>
    <title>Konsultanci</title>
</head>
<body>
<div class="fixed-top">
    <%@ include file="../header.jsp" %>

    <div class="nav-bottons">
        <div class="row">
            <div class="col-1">
                <a href="/report/view">
                    <button type="button" class="btn btn-primary btn-sm">Rapory</button>
                </a>
            </div>
            <div class="col-1">
                <a href="/user/view">
                    <button type="button" class="btn btn-secondary btn-sm">Użytkownicy</button>
                </a>
            </div>
            <div class="col-1">
                <a href="/user/form">
                    <button type="button" class="btn btn-secondary btn-sm">Nowa Osoba</button>
                </a>
            </div>

        </div>
    </div>

</div>
<div class="container-fluid">
    <div class="overflow-auto">
        <div class="row lex-row flex-nowrap" id="table1">
            <c:forEach items="${users}" var="user">

                <div class="col-3">
                    Imię : ${user.firstName} <br>
                    Nazwisko : ${user.lastName} <br>
                    email : ${user.email} <br>

                    <div>
                        <a href="/user/edit?id=${user.id}">
                            <button type="button" class="btn btn-primary btn-sm">Edytuj</button>
                        </a>
                        <a href="/user/delete/${user.id}">
                            <button type="button" class="btn btn-primary btn-sm">Usuń</button>
                        </a>
                    </div>

                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>