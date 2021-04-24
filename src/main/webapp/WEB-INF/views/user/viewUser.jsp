<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../head.jsp" %>
    <title>Konsultanci</title>
</head>
<body>
<div class="container-sm"><h2><p>Konsultanci</p></h2></div>

<div class="row justify-content-md-left">
    <div class="col" >
        <a href="/user/form"><button type="button" class="btn btn-secondary btn-sm">Nowy Konsultant</button></a>
    </div>
    <div class="col">
        <a href="/report/view"><button type="button" class="btn btn-primary btn-sm">Rapory</button></a>
    </div>

</div>
<br>
<div class="container-fluid">
    <div class="row" id="table1" >
        <c:forEach items="${users}" var="user">

            <div class="col">
                Imię : ${user.firstName}     <br>
                Nazwisko : ${user.lastName}  <br>
                email : ${user.email}  <br>

            </div>
            <a href="/user/edit?id=${report.id}"><button type="button" class="btn btn-primary btn-sm">Edytuj</button></a>
            <a href="/user/delete?id=${report.id}"><button type="button" class="btn btn-primary btn-sm">Usuń</button></a>
        </c:forEach>
    </div>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>