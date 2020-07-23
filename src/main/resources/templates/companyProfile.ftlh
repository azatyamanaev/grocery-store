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
                        <#if company.name?has_content>${company.name}<#else>Name</#if>
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
                        <li class="nav-item">
                            <a class="nav-link" id="extra-tab" data-toggle="tab" href="#extra" role="tab"
                               aria-controls="extra" aria-selected="false">Extra</a>
                        </li>
                        <#if user.id == company.id>
                            <li class="nav-item">
                                <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab"
                                   aria-controls="settings" aria-selected="false">Settings</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
            <#if user.id = company.id>
                <div class="col-md-2">
                    <button type="button" class="profile-edit-btn" name="btnAddMore" data-toggle="modal"
                            data-target="#myModal">Create Event
                    </button>
                </div>
            </#if>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-work">
                    <p>WORK LINK</p>
                    <a href="<#if company.linkToSite?has_content>${company.linkToSite}</#if>">Site</a><br/>
                    <!--<a href="">Bootsnipp Profile</a><br/>
                    <a href="">Bootply Profile</a>-->
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
                                <p><#if company.email?has_content>${company.email}</#if></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Number</label>
                            </div>
                            <div class="col-md-6">
                                <p><#if company.number?has_content>${company.number}</#if></p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="about" role="tabpanel" aria-labelledby="about-tab">
                        <p>
                            <#if company.about?has_content>${company.about}</#if>
                        </p>
                    </div>
                    <div class="tab-pane fade" id="extra" role="tabpanel" aria-labelledby="extra-tab">
                        <p>
                            <#if company.additionalInformation?has_content>${company.additionalInformation}</#if>
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
                                <button class="delete-profile-btn with-margin" name="deleteProfile"
                                        onclick="location.href='/delete'">Delete Profile
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
                                        <form role="form" method="post" action="/createEvent">
                                            <div class="form-group">
                                                <label for="name">Name</label>
                                                <input type="text" class="form-control" name="name" placeholder=""
                                                       required="">
                                            </div> <!-- form-group.// -->
                                            <div class="form-group">
                                                <label for="description">Description</label>
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