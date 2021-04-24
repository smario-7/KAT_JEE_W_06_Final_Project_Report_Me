<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../head.jsp" %>
    <title>Report Views</title>
</head>
<body>
<div class="container-sm"><h2><p>Report Me</p></h2></div>

<div class="row justify-content-md-left">
    <div class="col">
        <a href="/report/form"><button type="button" class="btn btn-primary btn-sm">Nowy raport</button></a>
    </div>
    <div class="col" >
        <a href="/user/view"><button type="button" class="btn btn-secondary btn-sm">Konsultantci</button></a>
    </div>

</div>
<br>
<div class="container-fluid">
<div class="row" id="table1" >
    <c:forEach items="${reports}" var="report">

        <div class="col">
            Użytkownik : ${report.userName}     <br>
            Sklep : ${report.shopName}  <br>
            Umowy : ${report.contract}  <br>
            Aneksy : ${report.annex}  <br>
            B2B : ${report.businessToBusiness}  <br>
            Handset : ${report.heandset}  <br>
            Play360 : ${report.play360}  <br>
            Telewizja : ${report.television}  <br>
            Dosprzedaż DDA : ${report.upSaleOnTheSameDay}  <br>
            TeleSales : ${report.teleSales}  <br>
            Ochrona Wyś. : ${report.displayProtection}  <br>
            Akcesoria : ${report.accessories}  <br>

        </div>
     <a href="/report/edit?id=${report.id}"><button type="button" class="btn btn-primary btn-sm">Edytuj</button></a>
    </c:forEach>
</div>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>