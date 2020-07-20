<#import "header.ftlh" as c/>
<@c.page title="Компании">
    <div class="container">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <#list companies! as company>
            <div class="row" style="background-color:#C0C0C0">
                <div class="col-3" style="padding:25px;">
                    <img src="/images/avatar_2x.png" alt="" width="100" height="100"/>
                </div>
                <div class="col-6" style="text-align:left;">
                    <p> Название : <#if company.name?has_content>${company.name}<#else>Название не указано</#if>
                    <p> Личный сайт : <#if company.linkToSite?has_content>
                            <a href="${company.linkToSite}">${company.linkToSite}</a> <#else> Ссылка на сайт</#if>
                    <p> О нас: <#if company.about?has_content>${company.about}<#else>Данные о компании не указаны</#if>
                    <p> Дополнительная информация : <#if company.additionalInformation?has_content>${company.additionalInformation}</#if>
                </div>

                <div class="col-3">
                    <button type="button" class="btn btn-outline-dark" style="margin-right:10px; margin-top:50px;">
                        <a href="profile/${company.id}">Перейти на страницу</a>
                    </button>
                </div>
            </div>
        </#list>
    </div>

</@c.page>