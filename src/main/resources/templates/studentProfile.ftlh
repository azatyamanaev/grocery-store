<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/profile.css">
</head>

<body>
<hr>
<nav class="navbar navbar-expand-lg fixed-top ">
    <div class="navbar-brand" ><img src="/images/logo.png" alt=""/></div>
    <a class="navbar-brand" href="/">Grocery Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-4">
            <li class="nav-item">
                <a class="nav-link" href="/profile">Profile</a></li>
            <li class="nav-item">
                <a class="nav-link " href="/events">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/edit"></a></li>
        </ul>
    </div>
</nav>
<div class="container emp-profile">
    <form method="post">
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="/images/avatar_2x.png" alt=""/>
                    <button class="file btn btn-lg btn-primary">
                        Change Photo
                    </button>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        <#if student.lastname?has_content>${student.lastname}<#else>Last Name</#if>
                        <#if student.name?has_content>${student.name}<#else>Name</#if>
                        <#if student.patronymic?has_content>${student.patronymic}<#else>Patronymic</#if>
                    </h5>

                    <h6>
                        <#if student.workSearching == true>Looking for work<#else>Working</#if>
                    </h6>
                    <!--<p class="proile-rating">RANKINGS : <span>8/10</span></p>-->
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                               aria-controls="home" aria-selected="true">Info</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="about-tab" data-toggle="tab" href="#about" role="tab"
                               aria-controls="about" aria-selected="false">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab"
                               aria-controls="profile" aria-selected="false">Background</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="extra-tab" data-toggle="tab" href="#extra" role="tab"
                               aria-controls="extra" aria-selected="false">Extra</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab"
                               aria-controls="settings" aria-selected="false">Settings</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <div class="profile-work">
                    <p>WORK LINK</p>
                    <a href="<#if student.linkToGit?has_content>${student.linkToGit}</#if>">Git</a><br/>
                    <!--<a href="">Bootsnipp Profile</a><br/>
                    <a href="">Bootply Profile</a>-->
                    <p>SKILLS</p>
                    <!--<a href="">Web Designer</a><br/>-->

                    <#if student.skills?has_content>
                        <#list student.skills as skill>
                            <h6>${skill.skill}</h6>
                        </#list>
                    </#if>
                </div>
            </div>
            <div class="col-md-2">
                <div class="profile-work">
                    <p>LANGUAGES</p>
                    <#if student.languages?has_content>
                        <#list student.languages as language>
                            <h6>${language.language}</h6>
                        </#list>
                    </#if>
                    <p>ACHIEVEMENTS</p>
                    <#if student.achievements?has_content>
                        <#list student.achievements as achievement>
                            <a href="">${achievement.filename} </a>
                        </#list>
                    <#else>
                    </#if>
                </div>
            </div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.email?has_content>${student.email}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Gender</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.gender?has_content>${student.gender}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Birthday</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.birthDate?has_content>${student.birthDate}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Citizenship</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.citizenship?has_content>${student.citizenship}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>City</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.city?has_content>${student.city}</#if></p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="about" role="tabpanel" aria-labelledby="about-tab">
                        <p>
                            <#if student.about?has_content>${student.about}</#if>
                        </p>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Educational Level</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.educationalLevel?has_content>${student.educationalLevel}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>University</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.university?has_content>${student.university}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Faculty</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.faculty?has_content>${student.faculty}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Specialization</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.specialization?has_content>${student.specialization}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Education End Year</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.educationEndYear?has_content>${student.educationEndYear}</#if></p>
                            </div>
                        </div>
                        <div class="row margin">
                            <div class="col-md-6">
                                <label>Work Experience</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
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
                    </div>
                    <div class="tab-pane fade" id="extra" role="tabpanel" aria-labelledby="extra-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Work Schedule</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.workSchedule?has_content>${student.workSchedule}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Move</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if student.move?has_content>${student.move}</#if></p>
                            </div>
                        </div>
                        <div class="row margin">
                            <div class="col-md-6">
                                <label>Recommendational letters</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
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
                                </#if>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="settings" role="tabpanel" aria-labelledby="settings-tab">
                        <div class="row">
                            <div class="col-md-4">
                                <button class="profile-edit-btn" name="editProfile" onclick="location.href='/edit'">Edit
                                    Profile
                                </button>
                            </div>
                            <div class="col-md-4">
                                <button class="profile-edit-btn" name="changePassword"
                                        onclick="location.href='/changePassword'">Change Password
                                </button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <button class="delete-profile-btn with-margin" name="deleteProfile">Delete Profile
                                </button>
                            </div>
                            <div class="col-md-4">
                                <button class="profile-edit-btn with-margin" name="logout" onclick="location.href='/logout'">Logout</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <button class="profile-edit-btn with-margin" name="download">Download Resume
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>