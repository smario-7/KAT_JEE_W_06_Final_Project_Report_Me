<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ include file="../head.jsp" %>
    <title>Report Views</title>
</head>
<body>
<h1>
    <p>Report Me</p>
</h1>

<%--@elvariable id="report" type="dto"--%>
<form:form method="post" modelAttribute="report" action="/report/form">

    Nowe Umowy: <form:input path="contract" />
    <form:errors path="contract" cssClass="error" />
        <br>
    Aneksy: <form:input path="annex" />
    <form:errors path="annex" cssClass="error" />
        <br>
    Handset (z telefonem): <form:input path="handset" />
    <form:errors path="handset" cssClass="error" />
        <br>
    Play 360: <form:input path="play360" />
    <form:errors path="play360" cssClass="error" />
        <br>
    Telewizja: <form:input path="television" />
    <form:errors path="television" cssClass="error" />
        <br>
    DDA (dosprzedaż do aneksu): <form:input path="upSaleOnTheSameDay" />
    <form:errors path="upSaleOnTheSameDay" cssClass="error" />
        <br>
    Telesales: <form:input path="teleSales" />
    <form:errors path="teleSales" cssClass="error" />
        <br>
    Ochrona wyświetlacza: <form:input path="displayProtection" />
    <form:errors path="displayProtection" cssClass="error" />
        <br>
    Akcesoria: <form:input path="accessories" />
    <form:errors path="accessories" cssClass="error" />
        <br>

    <button class="btn btn-secondary btn-sm" type="submit">Raportuj</button>

</form:form>

<%@ include file="../footer.jsp" %>
</body>
</html>