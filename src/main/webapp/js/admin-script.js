document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("sidebarCollapse").addEventListener("click", function () {
        document.getElementById("sidebar").classList.toggle("active");
        if (document.getElementById("sidebar").classList.contains("active")) {
            document.getElementById("content").style.marginLeft = "0";
        } else {
            document.getElementById("content").style.marginLeft = "250px";
        }
    });
});
