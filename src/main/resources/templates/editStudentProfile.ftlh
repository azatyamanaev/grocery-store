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
                    <input type="text" class="form-control" id="lastName" placeholder="" value="${user.lastname}"
                           required>
                    <label for="fatherName">Отчество</label>
                    <input type="text" class="form-control" id="fatherName" placeholder="" value="${user.patronymic}"
                           required>
                </div>

            </div>


            <div class="row">
                <div class="col-3">
                    <p> Пол


                </div>

                <div class="col-9">
                    <div class="custom-control custom-radio">
                        <input id="male" name="sex" type="radio" class="custom-control-input" checked required>
                        <label class="custom-control-label" for="male">Мужчина</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="female" name="sex" type="radio" class="custom-control-input" required>
                        <label class="custom-control-label" for="female">Женщина</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="otherSex" name="sex" type="radio" class="custom-control-input" required>
                        <label class="custom-control-label" for="otherSex">Другой</label>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Дата рождения


                </div>
                <div class="col-9">
                    <input type="date" class="form-control" id="birthDate" placeholder="" value="${user.birthDate}">
                </div>

            </div>
            <div class="row">
                <div class="col-3">
                    <p> Город


                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="city" placeholder="" value="${user.city}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Ключевые навыки:


                </div>
                <div class="col-9">
                    <#if student.skills?has_content>
                        <ul>
                            <#list student.skills as skill>
                                <li>
                                    <input value="${skill.skill}">
                                </li>
                            </#list>
                        </ul>
                    <#else> Skills
                    </#if>
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Ссылка на гит:


                </div>
                <div class="col-9">
                    <input type="url" class="form-control" id="gitUrl" placeholder="" value="${user.linkToGit}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Опыт работы:


                </div>
                <div class="col-9">
                    <#if student.workExperiences?has_content>
                        <ul>
                            <#list student.workExperiences as workExperience>
                                <li>
                                    С <input type="date" value="${workExperience.startDate}"> до <input type="date"
                                                                                                        value="{workExperience.endDate}">$
                                    <br>
                                    В компании : <input value="${workExperience.organization}"> <br>
                                    На позиции : <input value="${workExperience.position}"> <br>
                                    Обязанности : <input value="${workExperience.duties} "> <br>
                                    <br>
                                </li>
                            </#list>
                        </ul>
                    <#else> Без опыта
                    </#if>
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> О себе:


                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="aboutMe" placeholder="" value="${user.about}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Образование:


                </div>
                <div class="col-9">
                    <input value="<#if student.educationalLevel?has_content>${student.educationalLevel}<#else>Образование</#if>">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Владение языками


                </div>
                <div class="col-9">
                    <#if student.languages?has_content>
                        <ul>
                            <#list student.languages as language>
                                <li>
                                    <input value="${language.language}">
                                </li>
                            </#list>
                        </ul>
                    <#else> Языки
                    </#if>
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
