$(document).ready(function () {
    $(".nav-sidebar li").on("click", function() {
        $(".nav-sidebar li").removeClass("active");
        $(this).addClass("active");
    });
});