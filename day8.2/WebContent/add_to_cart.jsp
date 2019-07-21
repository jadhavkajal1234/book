<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:setProperty property="*" name="book" />
<c:redirect url="${sessionScope.book.populateCart()}.jsp" />

