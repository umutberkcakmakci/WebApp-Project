/**
 * Author: Umut Berk CAKMAKCI
 */

 var contextPath = 'https://movie-webapp-1.00';
 
 function sanitize(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}

$(document).ready(function() {
    let selectUser = document.getElementById('email')
    var urlUser = new URL(contextPath+"/user-login")
    //var urlCourses = new URL(contextPath+"/courses/list")
    console.log(urlUser)
    // uncomment to get rid of filling jsp based
    // getMesterDegress(urlMd)
    // getCourses(urlCourses)

    const togglePassword = document.getElementById('togglePassword');
    let password = document.getElementById('password');


    togglePassword.addEventListener(
            "click",
            function() {
                // toggle the type attribute
                let type = password.getAttribute("type") === "password" ? "text"  : "password";
                console.log('type',type)
                password.setAttribute("type", type);

                if (this.classList.contains("fa-eye-slash")) {
                    this.classList.replace("fa-eye-slash",
                        "fa-eye");
                } else {
                    this.classList.replace("fa-eye",
                        "fa-eye-slash");
                }
            });


} )


function getUser(url){
    // console.log('cerco i md')
    $.ajax({
        url:url,
        type: "GET",
        contentType: 'application/json', 
        dataType: 'json',
        success: function (data, status, request) {
            console.log('data',data)

            // var jsonData = JSON.parse(data);
            var mgLst = data['data']['mg-names-list'];

            let selectMastterdegrees = document.getElementById('degreebox')
            var option = document.createElement("option");
            option.text = "";
            option.value = "";
            selectMastterdegrees.appendChild(option);
            console.log(selectMastterdegrees)
            for (let i=0; i<mgLst.length; i++) {
                let name = sanitize(mgLst[i]['name']);
                let id = sanitize(mgLst[i]['id']);
                var option = document.createElement("option");
                option.text = name;
                option.value = id;
                selectMastterdegrees.appendChild(option);
            }
        },
        error: function (request, status, error) {
            console.error(request, error);

        }
    });

}