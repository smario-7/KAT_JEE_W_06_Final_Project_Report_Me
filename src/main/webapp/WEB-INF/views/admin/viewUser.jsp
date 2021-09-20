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
    <div class="container-fluid justify-content-start">
        <nav class="col">
            <div class="nav-bottons">
                <div class="row justify-content-between">
                    <div class="row justify-content-start">
                        <div class="col">
                            <a href="/report/view">
                                <button type="button" class="btn btn-primary btn-sm">Raporty</button>
                            </a>
                        </div>


                    </div>
                    <div class="row align-items-center">
                        <div class="col report-table-sm">
                            Twója lokalizacja: ${basicUserData[2]}
                        </div>
                    </div>
                </div>
            </div>
        </nav>

    </div>

    <div class="container-fluid user-list">
        <div class="row justify-content-start user-list-head">
            <div class="col-md-1">
                Imię
            </div>
            <div class="col-md-1">
                Nazwisko
            </div>
            <div class="col-md-2">
                email
            </div>
            <div class="col-md-1">
                Uprawnienia
            </div>
            <div class="col-md-1">
                Lokalizacja
            </div>
        </div>

        <div class="container-fluid">

            <c:forEach items="${users}" var="reportUser" varStatus="rowCouter">
            <c:if test="${rowCouter.count % 2 == 1}">
            <div class="row justify-content-start">
                </c:if>
                <c:if test="${rowCouter.count % 2 == 0}">
                <div class="row justify-content-start data-print">
                    </c:if>

                    <div class="col-md-1">
                            ${reportUser.firstName}
                    </div>
                    <div class="col-md-1">
                            ${reportUser.lastName}
                    </div>
                    <div class="col-md-2">
                            ${reportUser.email}
                    </div>
                    <div class="col-md-1">
                        <c:forEach items="${reportUser.role}" var="r">
                            <div class="row">
                                    ${r.name}
                            </div>

                        </c:forEach>
                            <%--                            ${reportUser.role}--%>
                    </div>
                    <div class="col-md-1">
                            ${reportUser.shop}
                    </div>
                    <div class="row justify-content-start">
                        <div class="col">

                            <a href="/admin/edit?id=${reportUser.id}">
                                <button type="button" class="btn btn-outline-primary btn-sm">Edytuj</button>
                            </a>
                        </div>
                        <div class="col">
                            <a href="/admin/delete/${reportUser.id}">
                                <button type="button" class="btn btn-outline-danger btn-sm">Usuń</button>
                            </a>
                        </div>
                    </div>
                </div>

                </c:forEach>
            </div>
        </div>
    </div>


    <%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>