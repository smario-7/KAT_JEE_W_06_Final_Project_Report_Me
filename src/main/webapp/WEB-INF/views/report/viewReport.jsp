<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="row justify-content-start">
                <div class="col-1">
                    <a href="/report/view">
                        <button type="button" class="btn btn-primary btn-sm">Raporty</button>
                    </a>
                </div>

                <div class="col-1">
                    <a href="/report/form">
                        <button type="button" class="btn btn-primary btn-sm">Nowy raport</button>
                    </a>
                </div>
                <div class="col-1 dropdown">
                    <a class="btn btn-outline-primary btn-sm dropdown-toggle" href="#" id="dataMenu"
                       data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">
                        data
                    </a>
                    <div class="dropdown-menu">
                        <div class="dropdown-item" href="">rok</div>
                    </div>
                </div>

            </div>
        </div>
    </nav>

    <div class="row justify-content-md-center data-print">
        <div class="col">Wrzesień 2021</div>
    </div>

    <div class="container-fluid">
        <div class="row justify-content-start">
            <c:forEach items="${reports}" var="report">
                <div class="col-2">
                    <div class="row justify-content-center">
                        <div class="col">${report.shopName}</div>
                    </div>
                    <div class="container-fluid report-table-sm" id="table${report.id}">

                        <div class="row justify-content-start">
                            <div class="col">Użytkownik</div>
                            <div class="col">${report.userName}</div>
                        </div>

                        <div class="row">
                            <div class="col">Umowy</div>
                            <div class="col">${report.contract}</div>
                        </div>
                        <div class="row">
                            <div class="col">Aneksy</div>
                            <div class="col">${report.annex}</div>
                        </div>
                        <div class="row">
                            <div class="col">B2B</div>
                            <div class="col">${report.businessToBusiness}</div>
                        </div>
                        <div class="row">
                            <div class="col">Handset</div>
                            <div class="col">${report.heandset}</div>
                        </div>
                        <div class="row">
                            <div class="col">Play360</div>
                            <div class="col">${report.play360}</div>
                        </div>
                        <div class="row">
                            <div class="col">Telewizja</div>
                            <div class="col">${report.television}</div>
                        </div>
                        <div class="row">
                            <div class="col">Dosprzedaż DDA</div>
                            <div class="col">${report.upSaleOnTheSameDay}</div>
                        </div>
                        <div class="row">
                            <div class="col">TeleSales</div>
                            <div class="col">${report.teleSales}</div>
                        </div>
                        <div class="row">
                            <div class="col">Ochrona Wyś.</div>
                            <div class="col">${report.displayProtection}</div>
                        </div>
                        <div class="row">
                            <div class="col">Akcesoria</div>
                            <div class="col">${report.accessories}</div>
                        </div>
                        <div class="col">
                            <a href="/report/edit?id=${report.id}">
                                <button type="button" class="btn btn-primary btn-sm">Edytuj</button>
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@ include file="../includesJSP/footer.jsp" %>
</body>
</html>