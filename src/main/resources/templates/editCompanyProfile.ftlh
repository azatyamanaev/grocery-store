
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
        <form>
            <div class="row" style="margin-top:60px;">
                <div class="col-3">
                    <label for="photo">Логотип</label>
                    <input type="file" id="photo" width="100" height="100"><!-- фото или базовое фото  -->


                </div>
                <div class="col-9">
                    <label for="companyName">Название</label>
                    <input type="text" class="form-control" id="companyName" placeholder="" value="${user.name}" required>
                    <label for="companySite">Ссылка на сайт</label>
                    <input type="url" class="form-control" id="companySite" placeholder="" value="${user.linkToSite}" required>
                </div>

            </div>


            <div class="row">
                <div class="col-3">
                    <p> О нас:


                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="aboutUs" placeholder="" value="${user.about}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> email


                </div>
                <div class="col-9">
                    <input type="email" class="form-control" id="email" placeholder="you@example.com" value="${user.email}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Телефон


                </div>
                <div class="col-9">
                    <input type="tel" class="form-control" id="phone" placeholder="+79999999999" value="${user.number}">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Дополнительная информация


                </div>
                <div class="col-9">
                    <input type="a" class="form-control" id="extraInformation" placeholder="" value="${user.additionalInformation}">
                </div>

            </div>

            <button type="button" class="btn btn-light" type="submit">Готово</button>
        </form>
    </div>

</div>

</@c.page>
