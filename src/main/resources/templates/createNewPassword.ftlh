<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/auth.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Создание нового пароля</title>
</head>
<body>
<header>

</header>
<div class="main_info">
    <div class="border border-primary">
        <form class="form" method="post" action="/createNewPassword">
            <div class="form-group">
                <label for="inputPassword">New Password</label>
                <input type="password" name="inputPassword" placeholder="Enter a new password">
            </div>
            <div class="form-group">
                <label for="confirmPassword">Repeat new password</label>
                <input type="password" name="confirmPassword" placeholder="Enter a new password again">
            </div>
            <input type="submit" value="Save">
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