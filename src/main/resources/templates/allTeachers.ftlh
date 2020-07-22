<#import "header.ftlh" as c/>
<@c.page title="Учителя">
<div class="container with-small-margin">



    <#list teachers! as teacher>
    <div class="row" style="background-color:#C0C0C0">
        <div class="col-3" style="padding:25px;">
            <img src="/images/avatar_2x.png" alt="" width="100" height="100"/>
        </div>
        <div class="col-6" style="text-align:left;">
            <p> <#if teacher.lastName?has_content>${teacher.lastName}<#else>Last name</#if>
                <#if teacher.name?has_content>${teacher.name}<#else>Name</#if>
                <#if teacher.patronymic?has_content>${teacher.patronymic}</#if>
            </p>
            <p> Position <#if teacher.position?has_content>${teacher.position}<#else>Position not specified</#if>
            <p> About: <#if teacher.about?has_content>${teacher.about}<#else>Not specified</#if>
        </div>
        <div class="col-3">
            <button type="button" class="btn btn-outline-dark" style="margin-right:10px; margin-top:50px;">
                <a href="profile/${teacher.id}">Profile</a>
            </button>
        </div>
    </div>
    </#list>
</div>

</@c.page>