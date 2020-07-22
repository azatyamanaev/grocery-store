<#import "header.ftlh" as c/>
<@c.page title="Edit company profile">


    <div class="container-fluid">

        <div class="container">
            <form action="/editTeacher" method="post">
                <div class="row" style="margin-top:60px;">
                    <div class="col-3">
                        <label for="photo">Photo</label>
                        <input type="file" id="photo" width="150" height="150"><!-- фото или базовое фото  -->


                    </div>
                    <div class="col-9">
                        <label for="firstName">Name</label>
                        <input type="text" class="form-control" name="name"
                               value="<#if user.name?has_content>${user.name}</#if>" required>
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" name="lastName"
                               value="<#if user.lastName?has_content>${user.lastName}</#if>" required>
                        <label for="fatherName">Patronymic</label>
                        <input type="text" class="form-control" name="patronymic"
                               value="<#if user.patronymic?has_content>${user.patronymic}</#if>" required>
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email"
                               value="<#if user.email?has_content>${user.email}</#if>" required>
                        <label for="login">Login</label>
                        <input type="text" name="login" class="form-control" id="login"
                               value="<#if user.login?has_content>${user.login}</#if>" required>
                        <label for="aboutMe">About</label>
                        <#if user.about?has_content>
                            <textarea name="about" class="form-control">${user.about}
                            </textarea>
                        <#else>
                            <textarea name="about" type="text" class="form-control" id="aboutUs">
                            </textarea>
                        </#if>
                        <label for="position">Position</label>
                        <input type="text" class="form-control" name="position"
                               value="<#if user.position?has_content>${user.position}</#if>">
                    </div>

                </div>

                <button class="btn btn-light" type="submit">Save</button>
            </form>
        </div>

    </div>


</@c.page>
