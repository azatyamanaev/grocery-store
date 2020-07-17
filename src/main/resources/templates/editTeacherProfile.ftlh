<html lang="ru">

<head>


    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">


</head>

<body>


<div class="container-fluid">
    <div class="header">


        <button type="button" class="btn btn-light">Главная</button>
        <button type="button" class="btn btn-light">Мой профиль</button>
        <button type="button" class="btn btn-light">Найти студента</button>
        <button type="button" class="btn btn-light">События компании</button>
        <button type="button" class="btn btn-light">Лента событий</button>

    </div>

    <div class="container">
        <div>
            <button type="button" class="btn btn-light">
                Назад
            </button>
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Получать уведомления о событиях-->
            <!--            </button>-->
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Изменить профиль-->
            <!--            </button>-->
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Изменить пароль-->
            <!--            </button>-->
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Удалить профиль-->
            <!--            </button>-->
        </div>

        <!-- <div class="row">
          <div class="col-3">
            <button type="button" class="btn btn-light">
              Назад
            </button>
          </div>
          <div class="col-9" style="background-color:#D3D3D3">
            <p> Иван Иванов
          </div>

        </div> -->

        <!--
                <p> Иван Иванов -->
        <form>
            <div class="row" style="margin-top:60px;">
                <div class="col-3">
                    <label for="photo">Photo</label>
                    <input type="file" id="photo" width="150" height="150"><!-- фото или базовое фото  -->


                </div>
                <div class="col-9">
                    <label for="firstName">Имя</label>
                    <input type="text" class="form-control" id="firstName" placeholder="" value="${user.name}" required>
                    <label for="lastName">Фамилия</label>
                    <input type="text" class="form-control" id="lastName" placeholder="" value="${user.lastname}" required>
                    <label for="fatherName">Отчество</label>
                    <input type="text" class="form-control" id="fatherName" placeholder="" value="${user.patronymic}" required>
                </div>

            </div>


            <div class="row">
                <div class="col-3">
                    <p> О себе:


                </div>
                <div class="col-9">
                    <label for="aboutMe"></label>
                    <input type="text" class="form-control" id="aboutMe" placeholder="" value="${user.about}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Должность


                </div>
                <div class="col-9">
                    <label for="position"></label>
                    <input type="text" class="form-control" id="position" placeholder="" value="${user.position}">
                </div>

            </div>

            <button type="button" class="btn btn-light" type="submit">Готово</button>
        </form>
    </div>

</div>


</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</body>
</html>
