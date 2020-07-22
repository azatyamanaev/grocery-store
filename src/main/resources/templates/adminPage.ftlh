<#import "header.ftlh" as c/>
<@c.page title="Админская панель">
    <form class="form" action="/admin" method="post">
        <div><p>Создать профиль компании</p></div>
        <#if message??>
            <div class="alert">
                <div class="alert success" role="alert">
                    ${message}
                </div>
            </div>
        </#if>
        <div class="row" style="margin-top:60px;">
            <div class="col-9">
                <div class="form-group">
                    <label for="login">Логин</label>
                    <input type="text" class="form-control" name="login" placeholder="Логин компании">
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" name="password" placeholder="Пароль">
                </div>
            </div>
        </div>
        <button class="btn btn-light" type="submit" name="admin" id="admin">Создать</button>
    </form>

</@c.page>