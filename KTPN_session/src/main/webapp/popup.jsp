<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>팝업창 쿠키 설정</title>
    <script src="oac.js"></script>
    <style>
        #popup {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: white;
            padding: 20px;
            box-shadow: 0px 0px 10px gray;
        }
        button {
            margin-top: 10px;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <div id="popup">
        <p>이 팝업은 하루 동안 다시 보이지 않습니다.</p>
        <button id = "pop" onclick="closePopup()">닫기</button>
    </div>
    <div id="popdown">
    	<button id = "pop" onclick="openPopup()">열기</button>
    	<p> 다시 보이고 있습니다.</p>
    </div>
</body>
</html>
