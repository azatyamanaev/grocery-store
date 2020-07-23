<#import "header.ftlh" as c/>
<@c.page title="Компании">
    <div class="container emp-profile">
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
                        <#if teacher.lastName?has_content>${teacher.lastName}<#else>Last Name</#if>
                        <#if teacher.name?has_content>${teacher.name}<#else>Name</#if>
                        <#if teacher.patronymic?has_content>${teacher.patronymic}<#else>Patronymic</#if>
                    </h5>

                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                               aria-controls="home" aria-selected="true">Info</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="about-tab" data-toggle="tab" href="#about" role="tab"
                               aria-controls="about" aria-selected="false">About</a>
                        </li>
                        <#if user.id == teacher.id>
                            <li class="nav-item">
                                <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab"
                                   aria-controls="settings" aria-selected="false">Settings</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
            <#if user.id = teacher.id>
                <div class="col-md-2">
                    <button type="button" class="profile-edit-btn" name="btnAddMore" data-toggle="modal"
                            data-target="#myModal">Create Event
                    </button>
                </div>
            </#if>
        </div>
        <div class="row">
            <div class="col-md-4">

            </div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if teacher.email?has_content>${teacher.email}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Position</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if teacher.position?has_content>${teacher.position}</#if></p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="about" role="tabpanel" aria-labelledby="about-tab">
                        <p>
                            <#if teacher.about?has_content>${teacher.about}</#if>
                        </p>
                    </div>
                    <div class="tab-pane fade" id="settings" role="tabpanel" aria-labelledby="settings-tab">
                        <div class="row">
                            <div class="col-md-4">
                                <button class="profile-edit-btn" name="editProfile" onclick="location.href='/edit'">
                                    Edit Profile
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
                                <button class="delete-profile-btn with-margin" name="deleteProfile">Delete Profile
                                </button>
                            </div>
                            <div class="col-md-4">
                                <button class="profile-edit-btn with-margin" onclick="location.href='/logout'"
                                        name="logout">Logout
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">


        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <p>Create an event</p>
                        <button type="button" class="close" data-dismiss="modal">×</button>
                        <!-- h4 class="modal-title">Modal Header</h4 -->
                    </div>
                    <div class="modal-body">

                        <!-- card -->
                        <article class="card">
                            <div class="card-body p-5">

                                <div class="tab-content">
                                    <div class="tab-pane fade show active" id="nav-tab-card">
                                        <form id="eventForm" role="form" action="/createEvent" method="post">
                                            <div class="form-group">
                                                <label for="name">Name</label>
                                                <input type="text" class="form-control" name="name" placeholder=""
                                                       required="">
                                            </div> <!-- form-group.// -->
                                            <div class="form-group">
                                                <label for="information">Description</label>
                                                <input type="text" class="form-control" name="description"
                                                       placeholder="" required="">
                                            </div> <!-- form-group.// -->

                                            <div class="form-group">
                                                <label for="link">Link</label>
                                                <input type="text" class="form-control" name="link" placeholder=""
                                                       required="">
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
        </div><!-- Modal -->

    </div>
</@c.page>