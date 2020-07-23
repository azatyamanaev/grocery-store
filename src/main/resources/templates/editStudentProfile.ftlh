<#import "header.ftlh" as c/>
<@c.page title="Edit company profile">


    <div class="container-fluid">


        <div class="container">
            <form action="/editStudent" method="post">
                <div class="row" style="margin-top:60px;">
                    <div class="col-3">
                        <label for="photo">Photo</label>
                        <input type="file" id="photo" width="150" height="150"><!-- фото или базовое фото  -->


                    </div>
                    <div class="col-9">
                        <label for="name">Name</label>
                        <input type="text" name="name" class="form-control" id="name" placeholder=""
                               value="<#if student.name?has_content>${student.name}</#if>" required>
                        <label for="lastName">Last name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName" placeholder=""
                               value="<#if student.lastName?has_content>${student.lastName}</#if>">
                        <label for="patronymic">Patronymic</label>
                        <input type="text" class="form-control" id="patronymic" placeholder=""
                               value="<#if student.patronymic?has_content>${student.patronymic}</#if>">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email"
                               value="<#if user.email?has_content>${user.email}</#if>" required>
                        <label for="login">Login</label>
                        <input type="text" name="login" class="form-control" id="login"
                               value="<#if user.login?has_content>${user.login}</#if>" required>
                        <label for="educationalLevel">EducationalLevel</label>
                        <input name="educationalLevel" class="form-control"
                               value="<#if student.educationalLevel?has_content>${student.educationalLevel}</#if>">
                        <label for="university">University</label>
                        <input name="university" class="form-control"
                               value="<#if student.uninversity?has_content>${student.university}</#if>">
                        <label for="faculty">Faculty</label>
                        <input name="faculty" class="form-control"
                               value="<#if student.faculty?has_content>${student.faculty}</#if>">
                        <label for="specialization">Specialization</label>
                        <input name="specialization" class="form-control"
                               value="<#if student.specialization?has_content>${student.specialization}</#if>">
                        <label for="educationEndYear">EducationEndYear</label>
                        <input name="educationEndYear" class="form-control"
                               value="<#if student.educationEndYear?has_content>${student.educationEndYear}</#if>">
                        <label for="citizenship">Citizenship</label>
                        <input type="text" name="citizenship" class="form-control" id="citizenship"
                               value="<#if user.citizenship?has_content>${user.citizenship}</#if>">
                        <label for="workSchedule">WorkSchedule</label>
                        <input type="text" name="workSchedule" class="form-control" id="move"
                               value="<#if user.workSchedule?has_content>${user.workSchedule}</#if>">
                        <label for="move">Move</label>
                        <input type="text" name="move" class="form-control" id="move"
                               value="<#if user.move?has_content>${user.move}</#if>">
                        <label for="linkToGit">Link to git</label>
                        <input name="linkToGit" type="url" class="form-control" id="gitUrl" placeholder=""
                               value="<#if student.linkToGit?has_content>${student.linkToGit}</#if>">
                        <label for="city">City</label>
                        <input name="city" type="text" class="form-control" id="city" placeholder=""
                               value="<#if student.city?has_content>${student.city}</#if>">
                        <label for="birthDate">Birthday</label>
                        <input name="birthDate" type="date" class="form-control" id="birthDate" placeholder=""
                               value="<#if student.birthDate?has_content>${student.birthDate}</#if>">
                    </div>

                </div>


                <div class="row">
                    <div class="col-3">
                        <p> Gender


                    </div>

                    <div class="col-9">
                        <div class="custom-control custom-radio">
                            <input id="male" name="gender" type="radio" class="custom-control-input" checked required>
                            <label class="custom-control-label" for="male">Male</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="female" name="gender" type="radio" class="custom-control-input" required>
                            <label class="custom-control-label" for="female">Female</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="otherSex" name="gender" type="radio" class="custom-control-input" required>
                            <label class="custom-control-label" for="otherSex">Other</label>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-3">
                        <p> About:


                    </div>
                    <div class="col-9">
                        <#if user.about?has_content>
                            <textarea name="about" class="form-control">${user.about}
                            </textarea>
                        <#else>
                            <textarea name="about" type="text" class="form-control" id="aboutUs">
                            </textarea>
                        </#if>
                    </div>

                </div>

                <input type="submit" value="Save">
            </form>
        </div>

    </div>
</@c.page>
