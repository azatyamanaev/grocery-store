<#import "header.ftl" as c/>
<@c.page title="${company.name}'s page">

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
                <button type="button" onclick="location.href='/editCompany'" class="btn btn-light">
                    Изменить профиль
                </button>
                <button type="button" onclick="location.href='/changePassword/${company.id}'"class="btn btn-light">
                    Изменить пароль
                </button>
                <button type="button" onclick="location.href='/delete/${company.id}'" class="btn btn-light">
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
                <p><#if company.name?has_content>${company.name}<#else>Название</#if></p>
                <p><#if company.linkToSite?has_content>${company.linkToSite}<#else>Ссылка на сайт</#if></p>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> О нас:


            </div>
            <div class="col-9">
                <#if company.additionalInformation?has_content>${company.additionalInformation}<#else>О нас</#if>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> Телефон


            </div>
            <div class="col-9">
                <#if company.number?has_content>${company.number}<#else>Телефон</#if>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> Почта


            </div>
            <div class="col-9">
                <#if company.email?has_content><a href="${company.email}">${company.email}</a><#else><a
                        href="">Почта</a></#if>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> Доп. информация


            </div>
            <div class="col-9">
                <#--                Сделать переменную под доп инфу.-->
                <#if company.additionalInformation?has_content>${company.additionalInformation}<#else>Доп. информация</#if>
            </div>

        </div>

    </div>


</@c.page>