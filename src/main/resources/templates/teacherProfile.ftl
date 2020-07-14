<#import "header.ftl" as c/>
<@c.page title="${teacher.name}'s page">
<div class="container">
    <div>
        <button type="button" class="btn btn-light">
            Назад
        </button>
        <#if user.role == "STUDENT">
            <button type="button" class="btn btn-light">
                Получать уведомления о событиях
            </button>
        </#if>
        <#if user.id == company.id>
            <button type="button" class="btn btn-light">
                Изменить профиль
            </button>
            <button type="button" class="btn btn-light">
                Изменить пароль
            </button>
            <button type="button" class="btn btn-light">
                Удалить профиль
            </button>
        </#if>
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

    <div class="row" style="margin-top:60px;">
        <div class="col-3">
            <img src="<#if user.image?has_content>${user.image}<#else>src/img/icons8-test-account-96.png</#if>" width="150"
                 height="150"><!-- фото или базовое фото  -->


        </div>
        <div class="col-9">
            <p> <#if teacher.lastname?has_content>${teacher.lastname}<#else>Фамилия</#if>
                <#if teacher.name?has_content>${teacher.name}<#else>Имя</#if>
                <#if teacher.patronymic?has_content>${teacher.patronymic}</#if>
            </p>
            <p><#if teacher.position?has_content>${teacher.position}<#else>Должность</#if>></p>
        </div>

    </div>


    <div class="row">
        <div class="col-3">
            <p> О себе:


        </div>
        <div class="col-9">
            <#if teacher.about?has_content>${teacher.about}<#else>Обо мне</#if>
        </div>

    </div>

    <div class="row">
        <div class="col-3">
            <p> Должность


        </div>
        <div class="col-9">
            <p><#if teacher.position?has_content>${teacher.position}<#else>Должность</#if>></p>
        </div>

    </div>

</div>

</@c.page>