<#import "header.ftlh" as c/>
<@c.page title="Edit company profile">


<div class="container-fluid">


    <div class="container">
        <div>
            <button type="button" class="btn btn-light">
                Назад
            </button>
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Получать уведомления о событиях-->
            <!--            </button>-->
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Изменить профиль-->
            <!--            </button>-->
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Изменить пароль-->
            <!--            </button>-->
            <!--            <button type="button" class="btn btn-light">-->
            <!--                Удалить профиль-->
            <!--            </button>-->
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
        <form action="/editStudent" method="post">
            <div class="row" style="margin-top:60px;">
                <div class="col-3">
                    <label for="photo">Photo</label>
                    <input type="file" id="photo" width="150" height="150"><!-- фото или базовое фото  -->


                </div>
                <div class="col-9">
                    <label for="firstName">Имя</label>
                    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="" value="<#if student.name?has_content>${student.name}<#else>name</#if>" required>
                    <label for="lastName">Фамилия</label>
                    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="" value="<#if student.lastName?has_content>${student.lastName}<#else>lastName</#if>">
                    <label for="fatherName">Отчество</label>
                    <input type="text" class="form-control" id="fatherName" placeholder="" value="<#if student.patronymic?has_content>${student.patronymic}<#else>patronymic</#if>">
                </div>

            </div>


            <div class="row">
                <div class="col-3">
                    <p> Пол


                </div>

                <div class="col-9">
                    <div class="custom-control custom-radio">
                        <input id="male" name="sex" type="radio" class="custom-control-input" checked required>
                        <label class="custom-control-label" for="male">Мужчина</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="female" name="sex" type="radio" class="custom-control-input" required>
                        <label class="custom-control-label" for="female">Женщина</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="otherSex" name="sex" type="radio" class="custom-control-input" required>
                        <label class="custom-control-label" for="otherSex">Другой</label>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Дата рождения


                </div>
                <div class="col-9">
                    <input type="date" class="form-control" id="birthDate" placeholder="" value="<#if student.birthDate?has_content>${student.birthDate}</#if>">
                </div>

            </div>
            <div class="row">
                <div class="col-3">
                    <p> Город


                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="city" placeholder="" value="<#if student.city?has_content>${student.city}<#else>city</#if>">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Ключевые навыки:


                </div>
                <div class="col-9">
                    <#if student.skills?has_content>
                        <ul>
                            <#list student.skills as skill>
                                <li>
                                    <input value="${skill.skill}">
                                </li>
                            </#list>
                        </ul>
                    <#else> Skills
                    </#if>
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Ссылка на гит:


                </div>
                <div class="col-9">
                    <input type="url" class="form-control" id="gitUrl" placeholder="" value="<#if student.linkToGit?has_content>${student.libnkToGit}</#if>">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Опыт работы:


                </div>
                <div class="col-9">
                    <#if student.workExperiences?has_content>
                        <ul>
                            <#list student.workExperiences as workExperience>
                                <li>
                                    С <input type="date" value="${workExperience.startDate}"> до <input type="date"
                                                                                                        value="{workExperience.endDate}">$
                                    <br>
                                    В компании : <input value="${workExperience.organization}"> <br>
                                    На позиции : <input value="${workExperience.position}"> <br>
                                    Обязанности : <input value="${workExperience.duties} "> <br>
                                    <br>
                                </li>
                            </#list>
                        </ul>
                    <#else> Без опыта
                    </#if>
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> О себе:


                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="aboutMe" placeholder="" value="<#if student.about?has_content>${student.about}</#if>">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Образование:


                </div>
                <div class="col-9">
                    <input value="<#if student.educationalLevel?has_content>${student.educationalLevel}</#if>">
                </div>

            </div>

            <div class="row">
                <div class="col-3">
                    <p> Владение языками


                </div>
                <div class="col-9">
                    <#if student.languages?has_content>
                        <ul>
                            <#list student.languages as language>
                                <li>
                                    <input value="${language.language}">
                                </li>
                            </#list>
                        </ul>
                    <#else> Языки
                    </#if>
                </div>
            </div>

            <input type="submit" value="Save">
        </form>
    </div>

</div>
</@c.page>
