<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="./includesJSP/head.jsp" %>
    <title>Report Views</title>
</head>
<body>
<%@ include file="./includesJSP/headerUser.jsp" %>

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
        <div class="row justify-content-center">

            Nie masz jeszcze przyznanych uprawnień <br>
            Zgłoś się do Koordynatora
        </div>
    </div>
</div>
<%@ include file="./includesJSP/footer.jsp" %>
</body>
</html>