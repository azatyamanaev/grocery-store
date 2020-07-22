function createEvent() {
    alert("in");
    var form = $('#eventForm');
    let event = {
        "name": form.find("input[name=name]").val(),
        "information": form.find("input[nameinformation]").val(),
        "link": form.find("input[name=link]").val()
    }
    $.ajax({
        url: "/createEvent",
        method: "POST",
        data: event,
        success:function (response) {
            alert(response);
        }
    })
}