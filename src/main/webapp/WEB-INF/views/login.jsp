<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="includesJSP/head.jsp" %>
    <title>Logowanie</title>
</head>
<body>

<div class="fixed-top">
    <%@ include file="includesJSP/header.jsp" %>

</div>
<div class="container">
    <div class="row justify-content-center">
    Logowanie
    </div>
    <div class="row justify-content-center">
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Login</label>
            <input type="email" name="email" placeholder="email"/>
        </div>
        <div class="mb-3">
            <label class="from-label">Hasło</label>
            <input type="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Zaloguj</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
    </div>
</div>

<%@ include file="includesJSP/footer.jsp" %>
</body>
</html>