<#import "header.ftlh" as c/>
<@c.page title="Компании">
<header class="header">
    <div class="overlay"></div>
    <div class="container events">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Event</th>
                <th scope="col">Description</th>
                <th scope="col">Info</th>
            </tr>
            </thead>
            <tbody>
            <#list events as event>
                <tr>
                    <td>${event.name}</td>
                    <td>${event.information}</td>
                    <td>
                        <button class="btn btn-link" onclick="location.href='/event?event_name=${event.name}'">event info</button>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</header>
</body>
</@c.page>