<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../head.jsp" %>
    <title>Report Views</title>
</head>
<body>

<div class="fixed-top">
    <%@ include file="../header.jsp" %>

    <div class="nav-bottons">
        <div class="row">
            <div class="col-1">
                <a href="/report/view">
                    <button type="button" class="btn btn-primary btn-sm">Raporty</button>
                </a>
            </div>
            <div class="col-1">
                <a href="/reportUser/view">
                    <button type="button" class="btn btn-secondary btn-sm">Użytkownicy</button>
                </a>
            </div>
            <div class="col-1">
                <a href="/report/form">
                    <button type="button" class="btn btn-primary btn-sm">Nowy raport</button>
                </a>
            </div>

        </div>
    </div>

</div>

<div class="container-fluid">
    <div class="overflow-auto">
        <div class="row flex-row flex-nowrap" id="table1">
            <c:forEach items="${reports}" var="report">

                <div class="col-xl-2">
                    Użytkownik : ${report.userName} <br>
                    Sklep : ${report.shopName} <br>
                    Umowy : ${report.contract} <br>
                    Aneksy : ${report.annex} <br>
                    B2B : ${report.businessToBusiness} <br>
                    Handset : ${report.heandset} <br>
                    Play360 : ${report.play360} <br>
                    Telewizja : ${report.television} <br>
                    Dosprzedaż DDA : ${report.upSaleOnTheSameDay} <br>
                    TeleSales : ${report.teleSales} <br>
                    Ochrona Wyś. : ${report.displayProtection} <br>
                    Akcesoria : ${report.accessories} <br>

                    <div class="col">
                        <a href="/report/edit?id=${report.id}">
                            <button type="button" class="btn btn-primary btn-sm">Edytuj</button>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>