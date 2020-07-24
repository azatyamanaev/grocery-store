<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/profile.css">
    <link rel="stylesheet" href="/css/modal.css">
    <script src="/js/profile.js"></script>
    <script src="/js/upload_photo.js"></script>
</head>

<body>
<hr>
<nav class="navbar navbar-expand-lg fixed-top ">
    <div class="navbar-brand"><img src="/images/logo.png" alt=""/></div>
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
                <a class="nav-link " href="/search">Students</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/companies">Companies</a></li>
            <li class="nav-item">
                <a class="nav-link" href="/teachers">Teachers</a></li>
        </ul>
    </div>
</nav>
<div class="container emp-profile">
    <div class="row">
        <div class="col-md-4">
            <div class="profile-img">
                <img id="image" src="/images/avatar_2x.png" alt=""/>
                <!--<button class="file btn btn-lg btn-primary" data-toggle="modal" data-target="#pModal">Change Photo
                </button>-->
            </div>
        </div>
        <div class="col-md-6">
            <div class="profile-head">
                <h5>
                    <#if student.lastName?has_content>${student.lastName}<#else>Last Name</#if>
                    <#if student.name?has_content>${student.name}<#else>Name</#if>
                    <#if student.patronymic?has_content>${student.patronymic}<#else>Patronymic</#if>
                </h5>

                <h6 id="workSearch">
                    <#if student.workSearching == true>Looking for work<#else>Working</#if>
                </h6>
                <#if user.id == student.id>
                    <button onclick="changeStatus()">Change status</button>
                </#if>
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
                    <#if user.id = student.id>
                        <li class="nav-item">
                            <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab"
                               aria-controls="settings" aria-selected="false">Settings</a>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
        <#if user.role == "COMPANY" || user.role == "TEACHER">
            <div class="col-md-2">
                <button type="button" class="profile-edit-btn" name="btnAddMore" data-toggle="modal"
                        data-target="#myModal">Invite to work
                </button>

            </div>

        </#if>

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
                <div id="skills">
                    <#if student.skills?has_content>
                        <#list student.skills as skill>
                            <h6 id="skill${skill.id}">${skill.skill}
                                <#if user.id == student.id>
                                    <button class="close" onclick="deleteSkill(${skill.id})">×</button>
                                </#if>

                            </h6>
                        </#list>
                    </#if>
                </div>
                <#if user.id == student.id>
                    <button data-toggle="modal"
                            data-target="#sModal">Add
                    </button>
                </#if>
            </div>
        </div>
        <div class="col-md-2">
            <div class="profile-work">
                <p>LANGUAGES</p>
                <div id="languages">
                    <#if student.languages?has_content>
                        <#list student.languages as language>
                            <h6 id="language${language.id}">${language.language}
                                <#if user.id == student.id>
                                    <button class="close" onclick="deleteLanguage(${language.id})">×</button>
                                </#if>

                            </h6>
                        </#list>
                    </#if>
                </div>
                <#if user.id == student.id>
                    <button data-toggle="modal"
                            data-target="#lModal">Add
                    </button>
                </#if>
                <p>ACHIEVEMENTS</p>
                <#if student.achievements?has_content>
                    <div id="achievements">
                        <#list student.achievements as achievement>
                            <a id="achievement${achievement.id}" href="${achievement.achievement}">
                                ${achievement.achievement}
                            </a>
                            <#if user.id == student.id>
                                <button class="close" onclick="deleteAchievement(${achievement.id})">×</button>
                            </#if>
                        </#list>
                    </div>
                <#else>
                </#if>
                <#if user.id == student.id>
                    <button data-toggle="modal"
                            data-target="#aModal">Add
                    </button>
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
                                <ul id="workExps">
                                    <#list student.workExperiences as workExperience>
                                        <li id="work${workExperience.id}">
                                            Start date : ${workExperience.startDate}
                                            End date : ${workExperience.endDate} <br>
                                            Company : ${workExperience.organization} <br>
                                            Position : ${workExperience.position} <br>
                                            Duties : ${workExperience.duties} <br>
                                            <button onclick="deleteWorkExp(${workExperience.id})">Delete</button>
                                            <br>
                                        </li>
                                    </#list>
                                </ul>
                            </#if>
                        </div>
                    </div>
                    <#if user.id == student.id>
                        <div class="col-md-5">
                            <button type="button" class="profile-edit-btn" name="btnAddMore" data-toggle="modal"
                                    data-target="#workModal">Add work experience
                            </button>
                        </div>
                    </#if>
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
                                        <li id="recomLet${recommendationLetter.id}">
                                            От: ${recommendationLetter.author} <br>
                                            <#--                                Заменить на ссылку с письмом-->
                                            Письмо: ${recommendationLetter.text} <br>
                                            <br>
                                            <#if user.role == "COMPANY" || user.role == "TEACHER" && user.login == recommendationLetter.author>
                                                <button onclick="deleteRecomLet(${recommendationLetter.id})">
                                                    Delete
                                                </button>
                                            <#elseif user.id == student.id>
                                                <button onclick="deleteRecomLet(${recommendationLetter.id})">
                                                    Delete
                                                </button>
                                            </#if>
                                        </li>
                                    </#list>
                                </ul>
                            </#if>
                        </div>
                    </div>
                    <#if user.role == "COMPANY" || user.role == "TEACHER">
                        <div class="col-md-7">
                            <button type="button" class="profile-edit-btn with-small-margin" name="btnAddMore"
                                    data-toggle="modal"
                                    data-target="#rModal">Write recommendational letter
                            </button>
                        </div>
                    </#if>
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
                                    onclick="location.href='/createNewPassword'">Change Password
                            </button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <button class="delete-profile-btn with-margin" name="deleteProfile"
                                    onclick="location.href='/delete'">Delete Profile
                            </button>
                        </div>
                        <div class="col-md-4">
                            <button class="profile-edit-btn with-margin" name="logout"
                                    onclick="location.href='/logout'">Logout
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Invite to work</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">
                                    <form class="form" method="post" action="/api/inviteStudent">
                                        <div class="form-group">
                                            <label for="message">Message</label>
                                            <textarea class="form-control" name="message"
                                                      placeholder="Enter additional information about the job"
                                                      required=""> </textarea>
                                        </div> <!-- form-group.// -->
                                        <div class="form-group">
                                            <label for="type">Type of job</label>
                                            <select name="type" class="form-control">
                                                <option disabled>Выберите тип работы</option>
                                                <option value="INTERNSHIP">Internship</option>
                                                <option value="FULL">Full time</option>
                                                <option value="PART">Part time</option>
                                            </select>
                                        </div> <!-- form-group.// -->

                                        <div class="form-group">
                                            <label for="start">Start date:</label>
                                            <input type="date" name="start" class="form-control"
                                                   value="2020-07-19"
                                                   min="2020-01-19" max="2022-12-31">
                                        </div> <!-- form-group.// -->

                                        <button class="subscribe btn btn-primary btn-block" type="submit"> Confirm
                                        </button>
                                    </form>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="workModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Add work experience</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">
                                    <form id="workExpForm" class="form" method="post" action="/addWorkExp">
                                        <div class="form-group">
                                            <label for="start">Start date:</label>
                                            <input id="end" type="date" name="start" class="form-control"
                                                   value="2017-01-19"
                                                   min="2017-01-19" max="2019-12-05">
                                        </div> <!-- form-group.// -->

                                        <div class="form-group">
                                            <label for="end">End date:</label>
                                            <input type="date" name="end" class="form-control"
                                                   value="2020-02-25"
                                                   min="2018-01-19" max="2020-02-25">
                                        </div> <!-- form-group.// -->

                                        <div class="form-group">
                                            <label for="company">Company</label>
                                            <input type="text" class="form-control" name="company"
                                                   required="">
                                        </div> <!-- form-group.// -->

                                        <div class="form-group">
                                            <label for="position">Position</label>
                                            <input type="text" class="form-control" name="position"
                                                   required="">
                                        </div> <!-- form-group.// -->

                                        <div class="form-group">
                                            <label for="duties">Duties</label>
                                            <input type="text" class="form-control" name="duties"
                                                   required="">
                                        </div> <!-- form-group.// -->

                                        <button onclick="addWorkExp()" class="subscribe btn btn-primary btn-block">
                                            Confirm
                                        </button>
                                    </form>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div><!-- Modal -->

    <!-- Modal -->
    <div class="modal fade" id="rModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Write recommendational letter</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">
                                    <form id="rForm" class="form" action="/writeRecomLet" method="post">

                                        <div class="form-group">
                                            <label for="text">Text</label>
                                            <textarea class="form-control" name="text"
                                                      placeholder="Enter text of letter"
                                                      required=""> </textarea>
                                        </div> <!-- form-group.// -->

                                        <input hidden name="studentId" value="${student.id}">

                                        <button id="sButton" type="submit"
                                                class="subscribe btn btn-primary btn-block"> Confirm
                                        </button>
                                    </form>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div><!-- Modal -->


    <!-- Modal -->
    <div class="modal fade" id="lModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Add Language</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">
                                    <form id="lForm" class="form" method="post" action="/addLanguage">

                                        <div class="form-group">
                                            <label for="language">Language</label>
                                            <input type="text" class="form-control" name="language"
                                                   required="">
                                        </div> <!-- form-group.// -->


                                        <button type="submit" class="subscribe btn btn-primary btn-block"> Confirm
                                        </button>
                                    </form>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div><!-- Modal -->


    <!-- Modal -->
    <div class="modal fade" id="sModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Add Skill</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">
                                    <form id="sForm" class="form" action="/addSkill" method="post">

                                        <div class="form-group">
                                            <label for="skill">Skill</label>
                                            <input id="skill" type="text" class="form-control" name="skill"
                                                   required="">
                                        </div> <!-- form-group.// -->


                                        <button id="sButton" type="submit"
                                                class="subscribe btn btn-primary btn-block"> Confirm
                                        </button>
                                    </form>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div><!-- Modal -->

    <!-- Modal -->
    <div class="modal fade" id="aModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Add Achievement</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">
                                    <form id="aForm" class="form" action="/addAchievement" method="post">

                                        <div class="form-group">
                                            <label for="achievement">Achievement</label>
                                            <input id="achievement" type="text" class="form-control"
                                                   name="achievement"
                                                   required="">
                                        </div> <!-- form-group.// -->


                                        <button id="sButton" type="submit"
                                                class="subscribe btn btn-primary btn-block"> Confirm
                                        </button>
                                    </form>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div><!-- Modal -->

    <!-- Modal -->
    <div class="modal fade" id="pModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <p>Change Photo</p>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <!-- h4 class="modal-title">Modal Header</h4 -->
                </div>
                <div class="modal-body">

                    <!-- card -->
                    <article class="card">
                        <div class="card-body p-5">

                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="nav-tab-card">

                                    <div class="form-group">
                                        <input type="file" class="form-control" name="file" id="file" required="">
                                        <input type="hidden" id="file_hidden">
                                    </div> <!-- form-group.// -->


                                    <button type="submit" onclick="sendFile()"
                                            class="subscribe btn btn-primary btn-block"> Confirm
                                    </button>
                                </div> <!-- tab-pane.// -->
                            </div> <!-- tab-content .// -->

                        </div> <!-- card-body.// -->
                    </article> <!-- card.// -->


                </div>

            </div>

        </div>
    </div><!-- Modal -->


</div>
<script src="/js/profile.js">
</script>
</body>
</html>
