<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css">
    <title>Grocery Store</title>
</head>
<body>
<script>
    $(document).ready(function () {
        $('.header').height($(window).height());
    })
</script>
<nav class="navbar navbar-expand-lg fixed-top ">
    <div class="navbar-brand" ><img src="/images/logo.png" alt=""/></div>
    <a class="navbar-brand" href="/">Grocery Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-4">
            <#if auth == true>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Profile</a></li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/signIn">SignIn</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="/signUp">SignUp</a></li>
            </#if>
            <li class="nav-item">
                <a class="nav-link " href="/events">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/companies">Companies</a></li>
            <li class="nav-item">
                <a class="nav-link" href="/teachers">Teachers</a></li>
        </ul>
    </div>
</nav>
<header class="page-header header container-fluid">
    <div class="overlay"></div>
    <div class="description">
        <h1> Hello, Welcome To Grocery Store
        </h1>
    </div>
</header>
</body>
</html>