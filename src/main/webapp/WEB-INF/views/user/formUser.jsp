<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../head.jsp" %>
    <title> Nowy konstultant </title>
</head>
<body>

<h1>
    <p>Nowy konstultant</p>
</h1>

<%--@elvariable id="user" type="dto"--%>
<form:form method="post" modelAttribute="user" action="/user/form">

    Wybierz Swój Salon : <form:select path="shopId" items="${shops}" itemLabel="shopName" itemValue="id" />
    <form:errors path="shopId" cssClass="error" />
    <br>
    Imię: <form:input path="firstName" />
    <form:errors path="firstName" cssClass="error" />
    <br>
    Nazwisko: <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" />
    <br>
    email: <form:input path="email" />
    <form:errors path="email" cssClass="error" />
    <br>

    <button class="btn btn-secondary btn-sm" type="submit">Dodaj</button>

</form:form>


<%@ include file="../footer.jsp" %>
</body>
</html>