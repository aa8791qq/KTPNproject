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
    <link rel="stylesheet" href="resources/css/edit_Nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/edit_Nam.js"></script>
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
                글수정
            </span>
        </div>
        <hr>
        <div class="dom">
            <div class="editprocess">
                <div class='viewdom'>
                    <!-- <form action="writeview_Nam.html" method="get" id="summit"> -->
                        <div class = 'title-con'>
                            <span class='text'>제목</span>
                            <input type="text" id='title' placeholder="제목을 입력하시오" value="${dto.TTL_NM }">
                        </div>
                        <div class = 'content-con'>
                            <span class='text'>내용</span>
                            <textarea type="text" id="content" placeholder="내용을 입력하세요">
                            ${dto.BRD_DESC }
							</textarea>
                        </div>
                        <div id='time'>
                    		<!-- 작성일자가 들어오는곳 -->
                   			<fmt:formatDate value="${dto.MOD_DTTM }" pattern="yyyy-MM-dd HH:mm:ss" />
                		</div>
                		<div id='user'>
		                    <!-- 작성자가 들어오는곳 -->
		                    ${dto.ID }
		                </div>
                    <!-- </form> -->
            </div>
            <div id='writemsg'>
                <!-- 메시지 -->
            </div>
            <div class='screat'>
                <div id='screat'>
                    <!-- 글이 들어오는곳 -->
                    비밀글여부 : ${dto.BLND_YN }
                </div>
            </div>
            <div class='buttons'>
                <button type='submit' class = 'button edit'>수정</button>
                <button type='submit' class = 'button cancel'>취소</button>
            </div>
        </div>
    </div>
    </div>
</body>

</html>