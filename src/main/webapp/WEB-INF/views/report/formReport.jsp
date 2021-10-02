<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ include file="../includesJSP/head.jsp" %>
    <title>Report Views</title>
</head>
<body>
<%@ include file="../includesJSP/headerUser.jsp" %>

<div class="container-fluid">
    <nav class="col">
        <div class="nav-bottons">
            <div class="row justify-content-between">
                <div class="row justify-content-start">
                    <div class="col">
                        <a href="/report/view">
                            <button type="button" class="btn btn-primary btn-sm">Raporty</button>
                        </a>
                    </div>

                    <div class="col">
                        <a href="/report/form">
                            <button type="button" class="btn btn-primary btn-sm">Nowy raport</button>
                        </a>
                    </div>

                </div>
                <div class="row align-items-center">
                    <div class="col report-table-sm">
                        Twoja lokalizacja: ${basicUserData[2]}
                    </div>
                </div>
            </div>
        </div>
    </nav>


    <div class="col-2">

        <%--@elvariable id="report" type="dto"--%>

        <form:form method="post" modelAttribute="report" action="/report/form">

            <div class="form-group">
                <div class="row align-items-center">
                    <div class="col">Nowe Umowy (UM)</div>
                    <form:input class="col-3 form-control" path="contract"/>
                    <form:errors path="contract" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="row align-items-center">
                    <div class="col">Aneksy (AN)</div>
                    <form:input class="col-3 form-control" path="annex"/>
                    <form:errors path="annex" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="row align-items-center">
                    <div class="col">Handset (z telefonem)</div>
                    <form:input class="col-3 form-control" path="handset"/>
                    <form:errors path="handset" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="row align-items-center">
                    <div class="col">Play 360</div>
                    <form:input class="col-3 form-control" path="play360"/>
                    <form:errors path="play360" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="row align-items-center">
                    <div class="col">Telewizja</div>
                    <form:input class="col-3 form-control" path="television"/>
                    <form:errors path="television" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="row align-items-center">
                    <div class="col">DDA (dosprzedaż do aneksu)</div>
                    <form:input class="col-3 form-control" path="upSaleOnTheSameDay"/>
                    <form:errors path="upSaleOnTheSameDay" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                Telesales: <form:input path="teleSales"/>
                <form:errors path="teleSales" cssClass="error"/>
            </div>
            Ochrona wyświetlacza: <form:input path="displayProtection"/>
            <form:errors path="displayProtection" cssClass="error"/>
            <br>
            Akcesoria: <form:input path="accessories"/>
            <form:errors path="accessories" cssClass="error"/>
            <br>

            <button class="btn btn-secondary btn-sm" type="submit">Raportuj</button>

        </form:form>

    </div>
</div>

<%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>