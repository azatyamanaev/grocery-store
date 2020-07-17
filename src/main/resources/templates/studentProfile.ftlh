<#import "header.ftlh" as c/>
<@c.page title="${student.name}'s page">
    <div class="container">
        <div>
            <button type="button" class="btn btn-light">
                Назад
            </button>
            <#if user.id == student.id>
                <button type="button" class="btn btn-light">
                    Скачать печатный вариант
                </button>
                <button type="button" onclick="location.href='/editStudent/${student.id}'" class="btn btn-light">
                    Изменить профиль
                </button>
                <button type="button" onclick="location.href='/changePassword/${student.id}'"class="btn btn-light">
                    Изменить пароль
                </button>
                <button type="button" onclick="location.href='/delete/${student.id}'" class="btn btn-light">
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
                <p> <#if student.lastname?has_content>${student.lastname}<#else>Фамилия</#if>
                    <#if student.name?has_content>${student.name}<#else>Имя</#if>
                    <#if student.patronymic?has_content>${student.patronymic}</#if>
                </p>
                <p> <#if student.gender?has_content>${student.gender}<#else>Пол</#if>
                    <#if student.birthDate?has_content>${student.birthDate}<#else>Дата рождения</#if></p>
                <p>Город, не готов к переезду, не готов к командировкам</p>
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
                                ${skill.skill}
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
                <#if student.linkToGit?has_content><a
                    href="${student.linkToGit}">${student.linkToGit}</a><#else>Ссылка на гит</#if>
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
                                С ${workExperience.startDate} до ${workExperience.endDate} <br>
                                В компании : ${workExperience.organization} <br>
                                На позиции : ${workExperience.position} <br>
                                Обязанности : ${workExperience.duties} <br>
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
                <#if student.about?has_content>${student.about}<#else>Обо мне</#if>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> Образование:


            </div>
            <div class="col-9">
                <#if student.educationalLevel?has_content>${student.educationalLevel}<#else>Образование</#if>
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
                                ${language.language}
                            </li>
                        </#list>
                    </ul>
                <#else> Языки
                </#if>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> Рекомендательные письма


            </div>
            <div class="col-9">
                <#if student.recommendationLetters?has_content>
                    <ul>
                        <#list student.recommendationLetters as recommendationLetter>
                            <li>
                                От: ${recommendationLetter.author} <br>
                                <#--                                Заменить на ссылку с письмом-->
                                Письмо: ${recommendationLetter.text} <br>
                                <br>
                            </li>
                        </#list>
                    </ul>
                <#else> Рекомендательные письма
                </#if>
            </div>

        </div>

        <div class="row">
            <div class="col-3">
                <p> Достижения в сфере:
            </div>
            <div class="col-9">
                <#if student.achievements?has_content>
                    <ul>
                        <#list student.achievements as achievement>
                            <li>
                                <a href="">${achievement.filename} </a>
                            </li>
                        </#list>
                    </ul>
                <#else> Достижения в сфере
                </#if>
            </div>
        </div>

        <div class="row" style="padding-left:400px; padding-top:50px;">


            <#if user.role == "COMPANY" || user.role == "TEACHER">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-light" data-toggle="modal" data-target="#exampleModal">
                    Пригласить на собеседование
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Приглашение на собеседование</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Мы отправили студенту на почту ваше приглашение. В скором времени он свяжется с вами!
                            </div>
                            <!-- <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                              <button type="button" class="btn btn-primary">Save changes</button>
                            </div> -->
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-light">
                    Написать рекомендательное письмо
                </button>
            </#if>
        </div>

    </div>


</@c.page>