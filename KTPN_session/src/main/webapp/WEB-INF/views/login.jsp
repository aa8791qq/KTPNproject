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
    <title>세션 정보</title>
    <script src="session.js"></script> <!-- JavaScript 파일 연결 -->
</head>
<body>
    <h2>세션 정보</h2>
    <p><strong>세션 ID:</strong> <span id="sessionId">로드 중...</span></p>
    <p><strong>저장된 username:</strong> <span id="username">로드 중...</span></p>
    <p><strong>세션 유지 시간 (초):</strong> <span id="sessionTimeout">로드 중...</span></p>
    <p><strong>세션 남은 시간:</strong> <span id="timer">로드 중...</span></p>
    
    <p><strong>세션 만료 여부:</strong> <span id="sessionExpired">확인 중...</span></p>
</body>
</html>
