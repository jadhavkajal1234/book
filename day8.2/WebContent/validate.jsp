<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="cust" class="beans.CustomerBean" scope="session" />
<jsp:setProperty property="*" name="cust" />
<body>
	<%-- <jsp:forward page="${sessionScope.cust.validateCustomer()}.jsp" />
 --%>
	<c:redirect url="${sessionScope.cust.validateCustomer()}.jsp" />
</body>
</html>