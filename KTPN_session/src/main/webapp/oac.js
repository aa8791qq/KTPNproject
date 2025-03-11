function getCookie(name) {
    let cookies = document.cookie.split('; ');
    for (let cookie of cookies) {
        let [key, value] = cookie.split('=');
        if (key === name) return value;
    }
    return null;
}

function closePopup() {
    // 서버에 쿠키 설정 요청
    fetch('/scookie')
        .then(() => {
            document.getElementById("popup").style.display = "none";
        });
}

window.onload = function () {
    let popupClosed = getCookie("popupClosed");
    if (!popupClosed) {
        document.getElementById("popup").style.display = "block";
    }
};