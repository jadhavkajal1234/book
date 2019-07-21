<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="book" class="beans.BookBean" scope="session" />
<body>
	<h4>${sessionScope.cust.message}</h4>
	<h4>Hello, ${sessionScope.cust.validCustomer.name}</h4>
	<form action="category_dtls.jsp">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Choose Category</td>
				<td><select name="cat">
						<c:forEach var="s" items="${sessionScope.book.listCategories()}">
							<option value="${s}">${s}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose Category" /></td>
				<td><input type="submit" value="Show Cart"
					formaction="show_cart.jsp" /></td>
			</tr>
		</table>
	</form>
	<h5>
		<a href="check_out.jsp">Log Me Out </a>
	</h5>
</body>
</html>