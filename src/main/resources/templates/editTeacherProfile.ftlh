<#import "header.ftlh" as c/>
<@c.page title="Edit company profile">


<div class="container-fluid">

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
        <form action="/editTeacher" method="post">
            <div class="row" style="margin-top:60px;">
                <div class="col-3">
                    <label for="photo">Photo</label>
                    <input type="file" id="photo" width="150" height="150"><!-- фото или базовое фото  -->


                </div>
                <div class="col-9">
                    <label for="firstName">Name</label>
                    <input type="text" class="form-control" id="firstName" value="<#if user.name?has_content>${user.name}<#else>name</#if>" required>
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" value="<#if user.lastName?has_content>${user.lastName}<#else>lastName</#if>" required>
                    <label for="fatherName">Patronymic</label>
                    <input type="text" class="form-control" id="fatherName" value="<#if user.patronymic?has_content>${user.patronymic}<#else>patronymic</#if>" required>
                    <label for="aboutMe">About</label>
                    <input type="text" class="form-control" id="aboutMe" value="<#if user.about?has_content>${user.about}<#else>about</#if>">
                    <label for="position">Position</label>
                    <input type="text" class="form-control" id="position" value="<#if user.position?has_content>${user.position}</#if>">
                </div>

            </div>

            <button class="btn btn-light" type="submit">Готово</button>
        </form>
    </div>

</div>


</@c.page>
