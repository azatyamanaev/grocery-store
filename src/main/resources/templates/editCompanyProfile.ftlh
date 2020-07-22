<#import "header.ftlh" as c/>
<@c.page title="Edit company profile">


    <div class="container-fluid">

        <div class="container">
            <form action="/editCompany" method="post">
                <div class="row" style="margin-top:60px;">
                    <div class="col-3">
                        <label for="photo">Logo</label>
                        <input type="file" id="photo" width="100" height="100"><!-- фото или базовое фото  -->


                    </div>
                    <div class="col-9">
                        <label for="companyName">Name</label>
                        <input type="text" name="name" class="form-control" id="companyName"
                               value="<#if user.name?has_content>${user.name}</#if>" required>
                        <label for="companySite">Link to site</label>
                        <input type="url" name="link" class="form-control" id="companySite"
                               value="<#if user.linkToSite?has_content>${user.linkToSite}</#if>" required>
                        <label for="about">About</label>
                        <#if user.about?has_content>
                            <textarea name="about" class="form-control">${user.about}
                            </textarea>
                        <#else>
                            <textarea name="about" type="text" class="form-control" id="aboutUs">
                            </textarea>
                        </#if>

                        <label for="email">Email</label>
                        <input name="email" type="email" class="form-control" id="email" placeholder="you@example.com"
                               value="<#if user.email?has_content>${user.email}</#if>">
                        <label for="login">Login</label>
                        <input type="text" name="login" class="form-control" id="login"
                               value="<#if user.login?has_content>${user.login}</#if>" required>
                        <label for="number">Number</label>
                        <input name="number" type="tel" class="form-control" id="phone" placeholder="+79999999999"
                               value="<#if user.number?has_content>${user.number}</#if>">
                        <label for="additionalInformation">AdditionalInformation</label>
                        <#if user.additionalInformation?has_content>
                            <textarea name="additionalInformation" class="form-control">${user.additionalInformation}
                            </textarea>
                        <#else>
                            <textarea name="about" type="text" class="form-control" id="aboutUs">
                            </textarea>
                        </#if>
                    </div>

                </div>

                <button type="submit" class="btn btn-light">Save</button>
            </form>
        </div>

    </div>

</@c.page>
