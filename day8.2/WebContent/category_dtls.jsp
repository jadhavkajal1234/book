<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="book" />
<body>
	<h4>Books Under Category ${param.cat}</h4>
	<form action="add_to_cart.jsp">
		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="bk" items="${sessionScope.book.books}">
				<tr>
					<td><input type="checkbox" name="bkId" value="${bk.bookId}"></td>
					<td>${bk.title}</td>
					<td>${bk.author}</td>
					<td>${bk.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Add To Cart"></td>
			</tr>
		</table>
	</form>
</body>
</html>