<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="navbar fixed-top navbar-expand navbar-light bg-Secondary">
    <div class="container-fluid">

        <a class="navbar-brand" href="/report/view">Report Me</a>

        <div class="collapse navbar-collapse d-flex align-content-between" id="navbarSupportedContent">

            <ul class="navbar-nav mr-auto">
                <li class="nav-item active align-content-lg-end font-weight-bold">
                    <a class="nav-link">${headername}</a>
                </li>
            </ul>

            <div class="d-flex justify-content-center">
                <div class="dropdown">
                    <a class="btn btn-outline-dark btn-sm dropdown-toggle" href="#" id="navbarMenu" data-toggle="dropdown" role="b" aria-haspopup="true" aria-expanded="true">
                        Opcje
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/report/view">Raporty</a>
                        <a class="dropdown-item" href="/user/view">Użytkownicy</a>
                        <a class="dropdown-item" href="#">test</a>
                        <a class="dropdown-item" href="#">Salony</a>
                    </div>


                </div>

                <div class="d-flex align-items-center">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-toggle="modal"
                            data-target="#logoutModal">Wyloguj
                    </button>
                </div>
            </div>

        </div>

    </div>
</header>

<!--Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Wyloguj</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times</span>
                </button>
            </div>
            <div class="modal-body">
                Czy jesteś pewny ?
            </div>
            <div class="modal-footer">
                <form action="<c:url value="/logout"/>" method="post">
                    <button class="btn btn-primary small" type="submit">Tak</button>
                    <button class="btn btn-secondary small" type="button" data-dismiss="modal">Nie</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</div>





