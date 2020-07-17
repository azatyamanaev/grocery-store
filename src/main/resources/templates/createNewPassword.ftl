<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="auth.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Создание нового пароля</title>
</head>
<body>
<header>

</header>
<div class="main_info">
<div class="border border-primary">
    <form class="form" method="post" action="/createNewPassword/${id}">
        <div class="form-group">
            <label for="inputPassword">Новый Пароль</label>
            <input type="password" name="inputPassw5ord" placeholder="Введите новый пароль">
        </div>
        <div class="form-group">
            <label for="confirmPassword">Подтвердите новый пароль</label>
            <input type="password" name="confirmPassword" placeholder="Введите новый пароль ещё раз">
        </div>
        <button type="submit" class="btn btn-primary">Сохранить</button>
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
<footer>
    MRPT team, Kazan, 2020
</footer>
</body>
</html>