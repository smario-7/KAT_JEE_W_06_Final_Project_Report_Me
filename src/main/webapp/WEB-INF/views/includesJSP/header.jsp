<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-Secondary ">
    <div class="container-fluid">

        <a class="navbar-brand" href="/report/view">Report Me</a>

        <div class="collapse navbar-collapse align-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active align-content-lg-end font-weight-bold">
                    <a class="nav-link">${headername}</a>
                </li>

            </ul>
            <div class="d-flex align-items-center">
                <a href="/login">
                    <button type="button" class="btn btn-outline-dark btn-sm">
                    Logowanie
                    </button>
                </a>
            </div>

            <div class="d-flex align-items-center">
                <a href="/register">
                    <button type="button" class="btn btn-outline-dark btn-sm">
                    Rejestracja
                    </button>
                </a>
            </div>

        </div>
    </div>
</nav>



