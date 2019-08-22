<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="basics/head.jsp" %>
<body>
<header>
    <%@include file="basics/header.jsp" %>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" action="/register" modelAttribute="userDto">
        <div class="form-group">
            <form:input path="username" type="text" name="username" placeholder="Nazwa użytkownika"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="email" type="email" name="email" placeholder="Email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password" placeholder="Hasło"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="basics/footer.jsp" %>
</body>
</html>
