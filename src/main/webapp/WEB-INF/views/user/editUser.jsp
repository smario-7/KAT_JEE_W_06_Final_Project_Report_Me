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
                <a href="/reportUser/view">
                    <button type="button" class="btn btn-secondary btn-sm">Użytkownicy</button>
                </a>
            </div>
            <div class="col-1">
                <a href="/reportUser/form">
                    <button type="button" class="btn btn-secondary btn-sm">Nowa Osoba</button>
                </a>
            </div>

        </div>
    </div>

</div>
<div class="container-fluid">
    <form:form method="post" modelAttribute="editUser" action="/reportUser/edit">
        <form:hidden path="id"/>
        Wybierz Swój Salon : <form:select path="shopId" items="${shops}" itemLabel="shopName" itemValue="id"/>
        <form:errors path="shopId" cssClass="error"/>
        <br>
        Imię: <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
        <br>
        Nazwisko: <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br>
        email: <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
        <br>

        <button class="btn btn-secondary btn-sm" type="submit">Zapisz</button>

    </form:form>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>