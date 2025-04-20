<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="writeview_Nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="writeview_Nam.js"></script>
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>

<body>
    <div class="menuPage-con">
        <!-- html 들어갈 곳 -->
	        <div class='pagecon'>
	            <span id='pageinfo'>
	                글조회
	            </span>
	        </div>
	        <hr>
	        <div id='area'>
	            <div class='viewarea'>
	                <div class='titlemenu'>
	                    <!-- <span class='title'> 제목 </span> -->
	                    <div id='title'>
	                        <!-- 글이 들어오는곳 -->
	                        신규직원 오리엔테이션 안내
	                    </div>
	                    <div id='user'>
	                        <!-- 작성자가 들어오는곳 -->
	                        직원1
	                    </div>
	                    <div id='time'>
	                        <!-- 작성일자가 들어오는곳 -->
	                        2025.02.03 02:00:57
	                    </div>
	                </div>
	                <div class='contentmenu'>
	                    <!-- <span class=content> 내용 </span> -->
	                    <div id='content'>
	                        <!-- 글이 들어오는곳 -->
	                        신규직원들은 2025.2.20 14:30까지 테스트관으로 와주시기 바랍니다.<br>
	                        <br>
	                        장소 : 본 회사 테스트관<br>
	                        시간 : 2025.2.20 14:30 <br>
	                        준비물 : 필기구, 신분증, 반명함사진 1매
	                    </div>
	                </div>
	                <div class = 'button'>
	                    <button type="button" id = 'remove'> 삭제 </button>
	                    <button type="button" id = 'edit'> 수정</button>
	                    <button type="button" id = 'list'> 목록</button>
	                </div>
	            </div>
	        </div>
        </div>
    </body>

</body>

</html>