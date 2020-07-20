<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/auth.css">
    <title>Document</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <div class="text-primary-fau fadeIn first">
            Sign In
        </div>

        <!-- Login Form -->
        <form method="post" action="/signIn">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Sign In">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
        <div class="form-check">
            <input type="checkbox" id="exampleCheck1" class="fadeIn fifth">
            <label for="exampleCheck1" class="fadeIn fifth">Запомнить меня</label>
        </div>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="/signUp">Don't have an account?</a>
        </div>

    </div>
</div>
</body>
</html>
