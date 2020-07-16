<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="src/css/auth.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Регистрация</title>
</head>
<body>
<header>

</header>
<div class="main_info">
    <div class="border border-primary">
    <div>
        <h3>
            Регистрация
        </h3>
        <form class="form" method="post" action="signUp">
            <div class="form-group">
                <label for="inputEmail">Почта</label>
                <input name="inputEmail" placeholder="Введите свою электронную почту">
            </div>
            <div class="form-group">
                <label for="inputLogin">Логин</label>
                <input name="inputLogin" placeholder="Введите свой логин">
            </div>
            <div class="form-group">
                <label for="inputPassword">Пароль</label>
                <input type="password" name="inputPassword" placeholder="Введите свой пароль">
            </div>
            <div class="form-group">
                <label for="confirmPassword">Подтвердите пароль</label>
                <input type="password" name="confirmPassword" placeholder="Введите свой пароль ещё раз">
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </form>
    </div>
    <#if message??>
        <div class="alert">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>
    <nav>
        <a href="/signIn">
            Уже есть аккаунт?
        </a>
    </nav>
</div>
</div>
<footer>
    MRPT team, Kazan, 2020
</footer>
</body>
</html>