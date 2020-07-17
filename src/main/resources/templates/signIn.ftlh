<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/auth.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Вход</title>
</head>
<body>
<header>

</header>
<div class="main_info">
    <div class="border border-primary">
    <div>
        <h3>
            Вход
        </h3>
        <form class="form" method="POST" action="signIn">
            <div class="form-group">
                <label for="login">Логин</label>
                <input name="login" placeholder="Введите свой логин">
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <input type="password" name="password" placeholder="Введите свой пароль">
            </div>
            <div class="form-check">
                <input type="checkbox"  id="exampleCheck1">
                <label for="exampleCheck1">Запомнить меня</label>
            </div>
            <button type="submit" name="signIn" id="signIn" class="btn btn-primary">Войти</button>
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
        <a href="/resetPassword">
            Забыли пароль?
        </a>
        <a href="/signUp">
            Ещё нет аккаунта?
        </a>
    </nav>
</div>
</div>
<footer>
    MRPT team, Kazan, 2020
</footer>
</body>
</html>
