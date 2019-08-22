<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="basics/head.jsp" %>
<body>
<header>
    <%@include file="basics/header.jsp" %>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form method="post" action="/login">
        <div class="form-group">
            <input type="email" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <input class="btn" type="submit">Zaloguj się</input>
        </div>
    </form:form>
</section>

<%@include file="basics/footer.jsp" %>
</body>
</html>