<#import "header.ftlh" as c/>
<@c.page title="Учителя">
<div class="container">

    <#list teachers! as teacher>
    <div class="row" style="background-color:#C0C0C0">
        <div class="col-3" style="padding:25px;">
            <img src="/img/cop.jpg" width="100" height="100">
        </div>
        <div class="col-6" style="text-align:left;">
            <p> <#if teacher.lastName?has_content>${teacher.lastName}<#else>Фамилия</#if>
                <#if teacher.name?has_content>${teacher.name}<#else>Имя</#if>
                <#if teacher.patronymic?has_content>${teacher.patronymic}</#if>
            </p>
            <p> Должность <#if teacher.position?has_content>${teacher.position}<#else>Должность не указана</#if>
            <p> Обо мне: <#if teacher.about?has_content>${teacher.about}<#else>Данные о себе не указаны</#if>
        </div>
        <div class="col-3">
            <button type="button" class="btn btn-outline-dark" style="margin-right:10px; margin-top:50px;">
                <a href="profile/${teacher.id}">Перейти на страницу</a>
            </button>
        </div>
    </div>
    </#list>
</div>

</@c.page>