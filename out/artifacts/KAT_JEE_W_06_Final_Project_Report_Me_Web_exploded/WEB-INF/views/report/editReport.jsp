<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ include file="../includesJSP/head.jsp" %>
    <title>Report Edit</title>
</head>
<body>
<%@ include file="../includesJSP/headerUser.jsp" %>
<div class="container-fluid">
    <nav class="col">

        <div class="nav-bottons">
            <div class="row">
                <div class="col-1">
                    <a href="/report/view">
                        <button type="button" class="btn btn-primary btn-sm">Raporty</button>
                    </a>
                </div>


            </div>
        </div>
    </nav>
</div>

<%--@elvariable id="reportEditDto" type="dto"--%>
<div class="container-fluid">
    <div class="overflow-auto">
        <div class="row flex-row flex-nowrap">
            <form:form method="post" modelAttribute="reportEditDto" action="/report/edit">
                <form:hidden path="id"/>

                Nowe Umowy: <form:input path="contract"/>
                <form:errors path="contract" cssClass="error"/>
                <br>
                Aneksy: <form:input path="annex"/>
                <form:errors path="annex" cssClass="error"/>
                <br>
                B2B: <form:input path="businessToBusiness"/>
                <form:errors path="businessToBusiness" cssClass="error"/>
                <br>
                Handset (z telefonem): <form:input path="heandset"/>
                <form:errors path="heandset" cssClass="error"/>
                <br>
                Play 360: <form:input path="play360"/>
                <form:errors path="play360" cssClass="error"/>
                <br>
                Telewizja: <form:input path="television"/>
                <form:errors path="television" cssClass="error"/>
                <br>
                DDA (dosprzedaż do aneksu): <form:input path="upSaleOnTheSameDay"/>
                <form:errors path="upSaleOnTheSameDay" cssClass="error"/>
                <br>
                Telesales: <form:input path="teleSales"/>
                <form:errors path="teleSales" cssClass="error"/>
                <br>
                Ochrona wyświetlacza: <form:input path="displayProtection"/>
                <form:errors path="displayProtection" cssClass="error"/>
                <br>
                Akcesoria: <form:input path="accessories"/>
                <form:errors path="accessories" cssClass="error"/>
                <br>

                <button class="btn btn-secondary btn-sm" type="submit">Zapisz</button>
            </form:form>
        </div>
    </div>
</div>

<%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>