<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add/Update Product</title>
</head>
<body>
<h2>Add/Update product</h2>
<hr/>
	<form:form action="addProduct" method="post" modelAttribute="product">
	<form:hidden path="productID"/>
		<p />Product Name : <p />
		<form:input path="productName" />
		<p />Cost : <p />
		<form:input path="cost" />
		<p />
		<input type="submit" value="Add/Update Product">
	</form:form>
<hr/>
<a href="${pageContext.request.contextPath}/">Homepage</a>
</body>
</html>

