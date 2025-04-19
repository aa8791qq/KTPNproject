<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>mbr_nm</th>
				<th>mbr_senm</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list}">
			<tr>
<%-- 				<td> dto: ${dto} </td> --%>
				<td> ${dto.id} </td>
				<td> ${dto.pw} </td>
				<td> ${dto.mbr_nm} </td>
				<td> ${dto.mbr_senm} </td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<p> list가 null이거나 비어 있습니다</p>
		</c:if>
	</tbody>
	</table>

</body>
</html>