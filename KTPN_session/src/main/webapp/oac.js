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
    console.log("getCookie(oac1) : ", getCookie("oac1"))
	console.log("popupClosed1 : " , popupClosed1);

    if(popupClosed1 == "true"){
        /// 팝업창 유지
        // document.cookie = "oac1=false";
        console.log("팝업을 띄운다.") 
        document.querySelector("#popup").style.display = "block"
    } else if(popupClosed1 == "false") {
        // document.cookie = "oac1=true";
        console.log("팝업을 지운다.") 
        document.querySelector("#popup").style.display = "none"
    }
}

function closePopup() {
    let popupClosed1 = getCookie("oac1");
    
    if (popupClosed1 === "false") {
        document.cookie = "oac1=true";
        console.log("팝업을 나타낸다.") 
        console.log("popupClosed1 : 1" , popupClosed1);
        document.getElementById("popup").style.display = "block";
    } else if (popupClosed1 === "true") {
        document.cookie = "oac1=false";
        console.log("팝업을 지운다.") 
        console.log("popupClosed1 : 2" , popupClosed1);
        document.getElementById("popup").style.display = "none";
    }
}

// 1. 햄버거 메뉴 버튼을 누르면 세션쿠키의 값이 바뀐다
// document.cookie = "oac1=true";
// document.cookie = "oac1=false";

// 2. 바뀐 세션 값에 따라 사이드메뉴가 보이고 안보인다.
// document.getElementById("popup").style.display = "none";	
// document.getElementById("popup").style.display = "block";	

