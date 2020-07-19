<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="application/javascript">
    function search() {
        var form = $("#search")[0];
        var data = new FormData(form);
        var url = "\"" +form.action + "\"";
        let students = document.getElementById('students')
        $.ajax({
            method: "POST",
            url: form.action,
            data: data,
            processData: false,
            contentType: false,
            complete : function(response) {
                students.innerHTML = "";
                for (let i = 0; i < response.responseJSON.length; i++) {
                    students.innerHTML +="<div class=\"col-6\" style=\"text-align:left;\">\n" +
                        response.responseJSON[i].name + response.responseJSON[i].lastName +
                        "            <p> 2 курс\n";
                    for(let j = 0; j < response.responseJSON[i].skills.length; j++)
                        students.innerHTML += "<p> <button type=\"button\" class=\"btn btn-outline-dark\" style=\"margin-right:10px;\">"+ response.responseJSON[i].skills[j].skill   + "</button>\n";
                    students.innerHTML += "</div>\n" +
                        "              <div class=\"col-3\">\n" +
                        "                <button type=\"button\" class=\"btn btn-outline-dark\" style=\"margin-right:10px; margin-top:50px;\">\n" +
                        "                  <a href=" + "/profile/" + response.responseJSON[i].id + ">Profile</a>" +
                        "                </button>\n" +
                        "              </div>";
                }
                // console.log(response);
                // var a = JSON.stringify(response);
                // $('#students').innerHtml = JSON.parse(a);
            },
            error : function(err) {
                alert(err.responseText);
            }
        });
            }
</script>
<link rel="stylesheet" href="/css/style.css">
<form id="search" action="/search" method="POST">
    <table id="filters">
        <tr id="languages">
            <td>Languages</td>
            <#list languages! as language>
                <td><input type="checkbox" name="languages" id='${language!}' value='${language!}'>
                    <label for='${language!}'>${language!}</label><br/></td>
            </#list>
        </tr>
        <tr id="skills">
            <td>Skills</td>
            <#list skills! as skill>
                <td><input type="checkbox" name="skills" id='${skill!}' value='${skill!}'> <label
                            for='${skill!}'>${skill!}</label><br/></td>
            </#list>
        </tr>
    </table>
    <button type="button" name="ok" onclick="search()">Search</button>
</form>
<#--onclick="search()"-->
<div id="students">

</div>

<#--<#list students! as student>-->
<#--    <div class="row" style="background-color:#C0C0C0">-->
<#--        <div class="col-3" style="padding:25px;">-->
<#--            <img src="/img/bg.jpg" width="100" height="100">-->
<#--        </div>-->
<#--        <div class="col-6" style="text-align:left;">-->
<#--            <#if student.lastName?has_content>${student.lastName}<#else>Фамилия</#if>-->
<#--            <#if student.name?has_content>${student.name}<#else>Имя</#if>-->
<#--            <#if student.patronymic?has_content>${student.patronymic}</#if>-->
<#--            <p> <#if student.educationalLevel?has_content>${student.educationalLevel}<#else> Курс </#if>-->
<#--            <p> <#list student.skills! as skill>-->
<#--                <button type="button" class="btn btn-outline-dark" style="margin-right:10px;">${skill.skill}</button>-->
<#--                </#list>-->
<#--        </div>-->
<#--        <div class="col-3">-->
<#--            <button type="button" class="btn btn-outline-dark" style="margin-right:10px; margin-top:50px;">-->
<#--               <a href="profile/${student.id}">Profile</a>-->
<#--            </button>-->
<#--        </div>-->
<#--    </div>-->
<#--</#list>-->
