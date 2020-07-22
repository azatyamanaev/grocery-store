<#import "header.ftlh" as c/>
<@c.page title="Компании">
<header class="header">
    <div class="container events">
        <table class="table">
            <tbody>
            <tr>
                <td>Event name</td>
                <td>${event.name}</td>
            </tr>
            <tr>
                <td>Information</td>
                <td>${event.information}</td>
            </tr>
            <tr>
                <td>Host</td>
                <td>${event.host}</td>
            </tr>
            <tr>
                <td>More</td>
                <td><a href="${event.link}">${event.link}</a></td>
            </tr>
            </tbody>
        </table>
        <#if login == event.host>
            <button type="button" class="btn btn-danger" data-toggle="modal"
                    data-target="#sem-reg">
                Edit
            </button>
        </#if>

    </div>
</header>
<!-- The Modal -->
<div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-reg">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- Modal body -->
            <div class="modal-body seminor-login-modal-body">
                <h5 class="modal-title text-center">EDIT EVENT</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>


                <form id="eventForm" class="seminor-login-form" action="/editEvent" method="post">
                    <div class="form-group">
                        <input type="text" name="name" class="form-control" required autocomplete="off" value="${event.name}">
                        <label class="form-control-placeholder" for="name">Event name</label>
                    </div>
                    <div class="form-group">
                        <input type="text" name="information" class="form-control" required autocomplete="off" value="${event.information}">
                        <label class="form-control-placeholder" for="information">Description</label>
                    </div>
                    <div class="form-group">
                        <input type="text" name="link" class="form-control" required autocomplete="off" value="${event.link}">
                        <label class="form-control-placeholder" for="link">Link to site</label>
                    </div>
                    <input hidden type="text" value="${event.id}" name="id">
                    <div class="btn-check-log">
                        <button type="submit" class="btn-check-login">CONFIRM</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
</@c.page>