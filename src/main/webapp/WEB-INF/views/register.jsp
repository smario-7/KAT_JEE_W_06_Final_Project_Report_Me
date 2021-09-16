<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="includesJSP/head.jsp" %>
    <title>Rejestracja</title>
</head>
<body>

<div class="fixed-top">
    <%@ include file="includesJSP/header.jsp" %>

</div>
<div class="container">

    <div class="row justify-content-center">
        Nowy Osoba
    </div>
    <div class="row">
        <div class="dropdown-divider"></div>
    </div>
    <div class="row justify-content-start">
        <form:form action="/register" method="post" modelAttribute="user">
            <div class="row">
                <div class="col-5">
                    <label class="form-label">Login (adres email)</label>
                </div>
                <div class="col-5">
                    <form:input type="email" name="email" path="email" placeholder="email"/>
                </div>
                <div class="col-5">
                    <span><form:errors path="email" cssClass="error"/></span>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="from-label">Hasło</label>
                </div>
                <div class="col-5">
                    <span><form:errors path="password" cssClass="error"/></span>
                    <form:input type="password" name="password" path="password" placeholder="min.6 znaków"/>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="col-form-label">Hasło</label>
                </div>
                <div class="col-5">
                    <span><form:errors path="passwordRepeat" cssClass="error"/></span>
                    <form:input type="password" name="passwordRepeat" path="passwordRepeat"
                                placeholder="Powtórz hasło"/>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="col-form-label">Imię</label>
                </div>
                <div class="col-5">
                    <span><form:errors path="firstName" cssClass="error"/></span>
                    <form:input type="text" name="firstName" path="firstName"/>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="col-form-label">Nazwisko</label>
                </div>
                <div class="col-5">
                    <span><form:errors path="lastName" cssClass="error"/></span>
                    <form:input type="text" name="lastName" path="lastName"/>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="col-form-label">Wybierz Salon</label>
                </div>
                <form:select class="form-control" path="shop" name="shopSelect">
                    <c:forEach items="${shops}" var="shop">
                        <option>${shop.shopName}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="row">
                <span><form:errors path="shop" cssClass="error"/></span>
            </div>
            <div class="container-fluid">
                <div class="row justify-content-end">
                    <button type="submit" class="btn btn-primary">Załóż konto</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<%@ include file="includesJSP/footer.jsp" %>
</body>
</html>
