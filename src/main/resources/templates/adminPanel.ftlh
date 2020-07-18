<#import "header.ftlh" as c/>
<@c.page title="Админская панель">
<form action="/admin" method="post">
    <div><p>Создать профиль компании</p>
    </div>
    <div class="row" style="margin-top:60px;">
        <div class="col-9">
            <label for="login">Логин</label>
            <input type="text" class="form-control" id="login" placeholder="" value="" required>
            <label for="password">Пароль</label>
            <input type="password" class="form-control" id="password" placeholder="" value="" required>
        </div>
    </div>
    <button type="button" class="btn btn-light" type="submit">Создать</button>
</form>

</@c.page>