<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ include file="../head.jsp" %>
    <title>Report Edit</title>
</head>
<body>
<h>
    <p>Report Me</p>
</h>

<%--@elvariable id="reportEditDto" type="dto"--%>
<form:form method="post" modelAttribute="reportEditDto">
    <form:hidden path="id"/>
    Nowe Umowy: <form:input path="contract" />
    <br>
    Aneksy: <form:input path="annex" />
    <br>
    Handset (z telefonem): <form:input path="heandset" />
    <br>
    Play 360: <form:input path="play360" />
    <br>
    Telewizja: <form:input path="television" />
    <br>
    DDA (dosprzedaż do aneksu): <form:input path="upSaleOnTheSameDay" />
    <br>
    Telesales: <form:input path="teleSales" />
    <br>
    Ochrona wyświetlacza: <form:input path="displayProtection" />
    <br>
    Akcesoria: <form:input path="accessories" />
    <br>

    <button class="btn btn-secondary btn-sm" type="submit">Zapisz</button>
</form:form>

<%@ include file="../footer.jsp" %>
</body>
</html>