<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../includesJSP/head.jsp" %>
    <title>Konsultanci</title>
</head>
<body>

<%@ include file="../includesJSP/headerUser.jsp" %>

<div class="container-fluid">

    <nav class="col">

        <div class="nav-bottons">
            <div class="row">
                <div class="col-1">
                    <a href="/report/view">
                        <button type="button" class="btn btn-primary btn-sm">Rapory</button>
                    </a>
                </div>
                <div class="col-1">
                    <a href="/reportUser/form">
                        <button type="button" class="btn btn-secondary btn-sm">Nowa Osoba</button>
                    </a>
                </div>

            </div>
        </div>

    </nav>
    <div class="container-fluid">
        <div class="overflow-auto">
            <div class="row lex-row flex-nowrap" id="table1">
                <c:forEach items="${users}" var="reportUser">

                    <div class="col-3">
                        Imię : ${reportUser.firstName} <br>
                        Nazwisko : ${reportUser.lastName} <br>
                        email : ${reportUser.email} <br>

                        <div>
                            <a href="/reportUser/edit?id=${reportUser.id}">
                                <button type="button" class="btn btn-primary btn-sm">Edytuj</button>
                            </a>
                            <a href="/reportUser/delete/${reportUser.id}">
                                <button type="button" class="btn btn-primary btn-sm">Usuń</button>
                            </a>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>