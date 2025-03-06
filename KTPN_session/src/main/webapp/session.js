/**
 * 
 */
 
 var remainingTime = 0; // 초기값

// 서버에서 세션 남은 시간 가져오기
function fetchRemainingTime() {
    fetch('/session')
        .then(response => response.json())
        .then(data => {
            remainingTime = data.remainingTime;
            startTimer(); // 타이머 시작
        })
        .catch(error => console.error("세션 정보를 가져오는 중 오류 발생: ", error));
}

// 타이머 업데이트 함수
function startTimer() {
    if (window.timerInterval) clearInterval(window.timerInterval); // 기존 타이머 중지

    window.timerInterval = setInterval(function () {
        if (remainingTime > 0) {
            document.getElementById('timer').innerText = remainingTime + " 초";
            remainingTime--;
        } else {
            alert("세션 시간이 만료되었습니다. 시간을 초기화합니다.");
            fetchRemainingTime(); // 서버에서 최신 세션 시간 가져와 다시 시작
        }
    }, 1000);
}

// 페이지 로드 시 세션 시간 가져오기
window.onload = fetchRemainingTime;

// 3분마다 세션 유지 요청 보내기
setInterval(function () {
    fetch('/session')
        .then(response => response.json())
        .then(data => console.log("세션 유지됨:", data.message))
        .catch(error => console.error("세션 유지 중 오류 발생:", error));
}, 180000); // 5분마다 실행
 