<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/auth.css">
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
        <form class="form" method="POST" action="signUp">
            <div class="form-group">
                <label for="email">Почта</label>
                <input name="email" placeholder="Введите свою электронную почту">
            </div>
            <div class="form-group">
                <label for="login">Логин</label>
                <input name="login" placeholder="Введите свой логин">
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <input type="password" name="password" placeholder="Введите свой пароль">
            </div>
            <div class="form-group">
                <label for="password2">Подтвердите пароль</label>
                <input type="password" name="password2" placeholder="Введите свой пароль ещё раз">
            </div>
            <div class="form-group">
                <label for="role">Роль</label>
                <input name="role" placeholder="Введите свою роль">
            </div>
            <button type="submit" name="signUp" id="signUp" class="btn btn-primary">Зарегистрироваться</button>
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