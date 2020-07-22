<#import "header.ftlh" as c/>
<@c.page title="Компании">
    <link rel="stylesheet" href="/css/tag.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="application/javascript">
        function search() {
            var form = $("#search")[0];
            var data = new FormData(form);
            var url = "\"" + form.action + "\"";
            let students = document.getElementById('students')
            $.ajax({
                method: "POST",
                url: form.action,
                data: data,
                processData: false,
                contentType: false,
                complete: function (response) {
                    students.innerHTML = "";
                    for (let i = 0; i < response.responseJSON.length; i++) {
                        var temp = "";
                        var temp1 = "";
                        for (let l = 0; l < response.responseJSON[i].languages.length; l++) {
                            temp += "<li>" + response.responseJSON[i].languages[l].language + "</li>";
                        }
                        for (let j = 0; j < response.responseJSON[i].skills.length; j++) {
                            temp1 += "<li>" + response.responseJSON[i].skills[j].skill + "</li>";
                        }
                        students.innerHTML += "<tr> " +
                            "<td>" + response.responseJSON[i].name + " " + response.responseJSON[i].lastName + "</td>" +
                            "<td> " +
                            "<ol>" + temp + "</ol></td>" +
                            "<td> <ol>" + temp1 + "</ol></td>" +
                            "<td> <a href=" + "/profile/" + response.responseJSON[i].id + ">Profile</a>" + "</td>" +
                            "</tr>";
                    }
                },
                error: function (err) {
                    alert(err.responseText);
                }
            });
        }
    </script>
    <header class="page-header header container-fluid with-small-margin">

        <form id="search" action="/search" method="POST" align="center">
            <div class="checkselect" id="skills">
                <#list skills! as skill>
                     <label for='${skill!}'><input type="checkbox" name="skills" id='${skill!}' value='${skill!}'>${skill!}</label>
                </#list>
            </div>
             
            <div class="checkselect" id="languages">
                <#list languages! as language>
                    <label for='${language!}'><input type="checkbox" name="languages" id='${language!}' value='${language!}'>${language!}</label>
                </#list>
            </div>
            <button type="button" name="ok" onclick="search()">Search</button>
             
        </form>

        <style type="text/css">

            .checkselect {
                position: relative;
                display: inline-block;
                min-width: 200px;
                text-align: left;
            }

            .checkselect-control {
                position: relative;
                padding: 0 !important;
            }

            .checkselect-control select {
                position: relative;
                display: inline-block;
                width: 100%;
                margin: 0;
                padding-left: 5px;
                height: 30px;
            }

            .checkselect-over {
                position: absolute;
                left: 0;
                right: 0;
                top: 0;
                bottom: 0;
                cursor: pointer;
            }

            .checkselect-popup {
                display: none;
                box-sizing: border-box;
                margin: 0;
                padding: 0;
                width: 100%;
                height: auto;
                max-height: 200px;
                position: absolute;
                top: 100%;
                left: 0px;
                border: 1px solid #dadada;
                border-top: none;
                background: #fff;
                z-index: 9999;
                overflow: auto;
                user-select: none;
            }

            .checkselect label {
                position: relative;
                display: block;
                margin: 0;
                padding: 4px 6px 4px 25px;
                font-weight: normal;
                font-size: 1em;
                line-height: 1.1;
                cursor: pointer;
            }

            .checkselect-popup input {
                position: absolute;
                top: 5px;
                left: 8px;
                margin: 0 !important;
                padding: 0;
            }

            .checkselect-popup label:hover {
                background: #03a2ff;
                color: #fff;
            }

            .checkselect-popup fieldset {
                display: block;
                margin: 0;
                padding: 0;
                border: none;
            }

            .checkselect-popup fieldset input {
                left: 15px;
            }

            .checkselect-popup fieldset label {
                padding-left: 32px;
            }

            .checkselect-popup legend {
                display: block;
                margin: 0;
                padding: 5px 8px;
                font-weight: 700;
                font-size: 1em;
                line-height: 1.1;
            }
        </style>

        <script src="https://snipp.ru/cdn/jquery/2.1.1/jquery.min.js"></script>
        <script>
            (function ($) {
                function setChecked(target) {
                    var checked = $(target).find("input[type='checkbox']:checked").length;
                    if (checked) {
                        $(target).find('select option:first').html('Выбрано: ' + checked);
                    } else {
                        $(target).find('select option:first').html('Выберите из списка');
                    }
                }

                $.fn.checkselect = function () {
                    this.wrapInner('<div class="checkselect-popup"></div>');
                    this.prepend(
                        '<div class="checkselect-control">' +
                        '<select class="form-control"><option></option></select>' +
                        '<div class="checkselect-over"></div>' +
                        '</div>'
                    );

                    this.each(function () {
                        setChecked(this);
                    });
                    this.find('input[type="checkbox"]').click(function () {
                        setChecked($(this).parents('.checkselect'));
                    });

                    this.parent().find('.checkselect-control').on('click', function () {
                        $popup = $(this).next();
                        $('.checkselect-popup').not($popup).css('display', 'none');
                        if ($popup.is(':hidden')) {
                            $popup.css('display', 'block');
                            $(this).find('select').focus();
                        } else {
                            $popup.css('display', 'none');
                        }
                    });

                    $('html, body').on('click', function (e) {
                        if ($(e.target).closest('.checkselect').length == 0) {
                            $('.checkselect-popup').css('display', 'none');
                        }
                    });
                };
            })(jQuery);

            $('.checkselect').checkselect();
        </script>

        <#--onclick="search()"-->
        <#--                <div id="students">-->

        <#--                </div>-->
        <header class="header">
            <div class="container events">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Full name</th>
                        <th scope="col">Languages</th>
                        <th scope="col">Skills</th>
                        <th scope="col">Link to profile</th>
                    </tr>
                    </thead>
                    <tbody id="students">

                    </tbody>
                </table>
            </div>
        </header>
    </header>
<#--    students.innerHTML += "<div class=\"col-6\" style=\"text-align:left;\">\n" +-->
<#--    response.responseJSON[i].name + response.responseJSON[i].lastName +-->
<#--    "            <p> 2 курс\n";-->
<#--        for (let j = 0; j < response.responseJSON[i].skills.length; j++)-->
<#--        students.innerHTML += "<p style=\"margin-right:10px;\">" + response.responseJSON[i].skills[j].skill + "</p>\n";-->
<#--    students.innerHTML += "</div>\n" +-->
<#--    "              <div class=\"col-3\">\n" +-->
<#--    "                <button type=\"button\" class=\"btn btn-outline-dark\" style=\"margin-right:10px; margin-top:50px;\">\n" +-->
<#--    "                  <a href=" + "/profile/" + response.responseJSON[i].id + ">Profile</a>" +-->
<#--    "                </button>\n" +-->
<#--    "              </div>";-->

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

</@c.page>




