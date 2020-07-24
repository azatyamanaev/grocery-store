function deleteWorkExp(id, e) {
    $.ajax({
        method: "POST",
        url: "/deleteWorkExp",
        data: "id=" + id,
        success: function () {
            let child = document.getElementById("work" + id);
            child.remove();
        }
    });
}

function deleteLanguage(id) {
    $.ajax({
        method: "POST",
        url: "/deleteLanguage",
        data: "id=" + id,
        success: function () {
            let child = document.getElementById("language" + id);
            child.remove();
        }
    })
}

function deleteAchievement(id) {
    $.ajax({
        method: "POST",
        url: "/deleteAchievement",
        data: "id=" + id,
        success: function () {
            let child = document.getElementById("achievement" + id);
            child.remove();
        }
    });
}


function deleteSkill(id) {
    $.ajax({
        method: "POST",
        url: "/deleteSkill",
        data: "id=" + id,
        success: function () {
            let child = document.getElementById("skill" + id);
            child.remove();
        }
    });
}

function deleteRecomLet(id) {
    $.ajax({
        method: "POST",
        url: "/deleteRecomLet",
        data: "id=" + id,
        success: function () {
            let child = document.getElementById("recomLet" + id);
            child.remove();
        }
    });
}

function changeStatus() {
    $.ajax({
        method: "POST",
        url: "/changeStatus",
        success: function () {
            if ($('#workSearch').text() == "Working") {
                $('#workSearch').empty();
                $('#workSearch').text("Looking for work");

            } else {
                $('#workSearch').empty();
                $('#workSearch').text("Working");
            }
        }
    });
}
