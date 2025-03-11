function getCookie(name) {
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
	// if (!popupClosed1) {
	
    if (popupClosed1 === "false") { // 문자를 받은거...
        document.getElementById("popup").style.display = "none";
    }
   
}