window.addEventListener('load',init)

                
                
function init(){

    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#ham').addEventListener('click',function(){
        
        
        if(document.querySelector('.mainmenu').classList.length == 1){
            document.querySelector('.mainmenu').classList.add('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 열기'
        } else if (document.querySelector('.mainmenu').classList.length == 2){
            document.querySelector('.mainmenu').classList.remove('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 닫기'
        }

    }) //메뉴 열었다 닫았다 하기<끝>
    // 탑 버튼 내용나오게 하기 <시작>
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus) {//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click', function (e) {

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            // 클릭했을때 해당 페이지로 넘어가는 Java Script
            if (e.target.textContent == '작업관리') {
                // 작업관리 메인
                window.location.href = "workManage_main_kwak.jsp"
            } else if (e.target.textContent == '생산관리') {
                // 생산관리 메인 
                window.location.href = "Production management_tak.jsp"
            } else if (e.target.textContent == '생산리포팅') {
                // 생산리포팅 메인 
                window.location.href = "Production reporting_tak.jsp"
            } else if (e.target.textContent == '자재관리') {
                // 자재관리 메인 
                window.location.href = "TestMM_main_park.jsp"
            } else if (e.target.textContent == '품질관리') {
                // 품질관리 메인 
                window.location.href = "TestQA_main_park.jsp"
            } else if (e.target.textContent == '기준관리') {
                // 기준관리 메인
                window.location.href = "masterdataManage_main_kwak.jsp"
            }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for (button of buttons) {
        button.addEventListener('click', function (e) {
            if (e.target.textContent == '대시보드') {
                // 대시보드 메인
                window.location.href = "dashBoard_kwak.jsp"
            } else if (e.target.textContent == '게시판') {
                // 게시판 메인
                window.location.href = "free"
            } else if (e.target.textContent == '공지사항') {
                // 공지사항 메인
                window.location.href = "notice"
            } 
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>

    let edit = document.querySelector('#edit')

    edit.addEventListener('click', editprocess)
    
    function editprocess(){
        console.log('수정화면으로 넘어갑니다')
        window.location.href = "edit_Nam.jsp"
    }

    let list = document.querySelector('#list')

    list.addEventListener('click', listviewprocess)
    
    function listviewprocess(){
        console.log('목록페이지로 넘어갑니다')
        // 목록화면으로 넘어가게 하기(공지사항, 자유게시판)
    }

	const brdno = "${dto.BRD_NO}";
        console.log(brdno)
    
    const remove = document.querySelector('#remove')
    remove.addEventListener('click', removeprocess)
    
    function removeprocess(){
        console.log('삭제되었습니다.')
        alert('삭제되었습니다.')
        location.href = "ndelete_Nam?BRD_NO=" + brdno;
        // 목록화면으로 넘어가게 하기(공지사항, 자유게시판)
    }
    
       // 로그아웃 버튼 
       document.querySelector('.subBut').addEventListener('click',function(){
        window.location.href = "loginpage_Nam.jsp"
      })
  
      // 로고버튼
      document.querySelector('.logo').addEventListener('click',function(){
        window.location.href = 'dashBoard_kwak.jsp'
      })
}
