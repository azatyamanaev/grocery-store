<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="auth.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Восстановление пароля</title>
</head>
<body>
<header>

</header>
<h3>
    Введите свою электронную почту, чтобы сбросить пароль.
</h3>
<div class="main_info">
    <div class="border border-primary">
        <form class="form" method="post" action="resetPassword">
    <div class="form-group">
        <label for="inputEmail">Почта</label>
        <input name="inputEmail" placeholder="Введите свою электронную почту">
    </div>
    <button type="submit" class="btn btn-primary">Отправить</button>
</form>
<#if message??>
        <div class="alert">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
</#if>
</div>
</div>
<a href="/signIn">
    Назад
</a>
<footer>
    MRPT team, Kazan, 2020
</footer>
</body>
</html>