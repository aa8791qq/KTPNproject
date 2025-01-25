window.addEventListener('load', function () {
    let login = document.querySelector('.login_area')
    console.log('접근중....')
})

document.querySelector('#login').addEventListener('click', login)
function login() {
    let login = document.querySelector('#login')
    login.addEventListener('click', function () {
        console.log('로그인 버튼 클릭')

        const id = document.querySelector('#uid')
        const pw = document.querySelector('#upw')
        console.log(id, id.value)
        console.log(pw, pw.value)

        if ((id.value == "admin" && pw.value == 1234) || (id.value == "admin" && pw.value == 5678)) {
            // 메인페이지로 점프
        } else {
            console.log('회원정보 없음')
            document.querySelector('#uchkmessege').textContent = '회원정보가 일치하지 않습니다.'
        }

        if (id.value == '') {
            console.log('미입력된 항목이 있음')
            document.querySelector('#uchkmessege').style.color = '#f00';
            document.querySelector('#uchkmessege').textContent = '아이디는 필수입니다';
        } else if (pw.value == '') {
            console.log('미입력된 항목이 있음')
            document.querySelector('#uchkmessege').style.color = '#f00';
            document.querySelector('#uchkmessege').textContent = '비밀번호는 필수입니다';
        }
    }
    )}

// document.addEventListener('click', idfind)
// function idfind() {
//     let idfind = document.querySelector('#idfind')
//     console.log('아이디 찾는중')
// }