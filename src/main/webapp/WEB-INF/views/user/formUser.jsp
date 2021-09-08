<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../includesJSP/head.jsp" %>
    <title> Nowy konstultant </title>
</head>
<body>
<div class="fixed-top">
    <%@ include file="../includesJSP/headerUser.jsp" %>

    <div class="nav-bottons">
        <div class="row">
            <div class="col-1">
                <a href="/report/view">
                    <button type="button" class="btn btn-primary btn-sm">Rapory</button>
                </a>
            </div>
            <div class="col-1">
                <a href="/report/view">
                    <button type="button" class="btn btn-secondary btn-sm">Użytkownicy</button>
                </a>
            </div>

        </div>
    </div>

</div>


<%--@elvariable id="reportUser" type="dto"--%>
<div class="container-fluid">
    <div class="col-2">
        <form:form method="post" modelAttribute="reportUser" action="/reportUser/form">

            <div class="form-group">
                <label>Wybierz Swój Salon</label>
                <form:select class="form-control" path="shopId" items="${shops}" itemLabel="shopName" itemValue="id"/>
                <form:errors path="shopId" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Imię</label>
                <form:input class="form-control" path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Nazwisko</label>
                <form:input class="form-control" path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>email</label>
                <form:input class="form-control" path="email"/>
                <form:errors path="email" cssClass="error"/>
            </div>

            <button class="btn btn-secondary btn-sm" type="submit">Dodaj</button>

        </form:form>
    </div>
</div>

<%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>