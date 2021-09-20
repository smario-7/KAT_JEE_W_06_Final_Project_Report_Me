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


    <form:form method="post" modelAttribute="editUser" action="/reportUser/edit">
        <form:hidden path="id"/>

        <div class="row">
            <div class="col-md-2">
                Edycja
            </div>
            <div class="col-md-2">
                    ${editUser.email}
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Imię
            </div>
            <div class="col-md-2">
                    ${editUser.firstName}
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Nazwisko
            </div>
            <div class="col-md-2">
                    ${editUser.lastName}
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                Wybierz Lakalizację
            </div>
            <div class="col-md-2">
                <form:select path="shopId" items="${shops}" itemLabel="shopName"
                             itemValue="id"/>
                <form:errors path="shopId" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Uprawnienia
            </div>
            <div class="col-md-2">
                <form:select path="role" items="${roles}" itemLabel="name" itemValue="id"/>
                <form:errors path="role" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <button class="btn btn-outline-primary btn-sm" type="button" href="#">Wstecz</button>
            </div>
            <div class="col-md-2">
                <button class="btn btn-outline-danger btn-sm" type="submit">Zapisz</button>
            </div>
        </div>

    </form:form>

</div>

<%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>