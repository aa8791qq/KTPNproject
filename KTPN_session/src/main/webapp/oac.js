function getCookie(name) { // 가져올때
    let cookies = document.cookie.split('; ');
    console.log("cookies : ", cookies);
    
    for (let cookie of cookies) {
        let [key, value] = cookie.split('=');
		console.log("현재 쿠키 : ", key, value);
		
		if (key === name) return value;
    }
    return null;
}

window.onload = function(){
	let popupClosed1 = getCookie("oac1");
	console.log("popupClosed1 : " , popupClosed1);
}

function closePopup() {
    let popupClosed1 = getCookie("oac1");   //팝업안보임
    
    console.log("popupClosed1 : " , popupClosed1);

    console.log(document.cookie);
	// 바꿔서 작동하는 것을 코딩안함.
	
    if (popupClosed1 === "false") { // 문자로 받은거...
        document.cookie = "oac1=true";
        document.getElementById("popup").style.display = "none";
        // popupClosed1 = true;
    } else if(popupClosed1 === "true") {
        document.cookie = "oac1=false";
        document.getElementById("popup").style.display = "none";
    }
}


// 1. 햄버거 메뉴 버튼을 누르면 세션쿠키의 값이 바뀐다
// document.cookie = "oac1=true";
// document.cookie = "oac1=false";

// 2. 바뀐 세션 값에 따라 사이드메뉴가 보이고 안보인다.
// document.getElementById("popup").style.display = "none";	
// document.getElementById("popup").style.display = "block";	

