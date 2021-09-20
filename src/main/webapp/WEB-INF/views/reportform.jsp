<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Report Form</title>
</head>
<body>
<%--@elvariable id="report" type="dto"--%>
<form:form method="post" modelAttribute="report">
    <p>
        Nowe Umowy: <form:input path="contract" />
    </p>
    <p>
        Aneksy: <form:input path="annex" />
    </p>
    <p>
        Handset (z telefonem): <form:input path="heandset" />
    </p>
    <p>
        Play 360: <form:input path="play360" />
    </p>
    <p>
        Telewizja: <form:input path="television" />
    </p>
    <p>
        DDA (dosprzedaż do aneksu): <form:input path="upSaleOnTheSameDay" />
    </p>
    <p>
        Telesales: <form:input path="teleSales" />
    </p>
    <p>
        Ochrona wyświetlacza: <form:input path="displayProtection" />
    </p>
    <p>
        Akcesoria: <form:input path="accessories" />
    </p>

    <input type="submit" value="Raportuj" />
</form:form>
</body>
</html>