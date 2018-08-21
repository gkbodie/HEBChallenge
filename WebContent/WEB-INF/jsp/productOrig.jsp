<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Product Search</title>
</head>
<body>
	<form:form id="productForm" method="POST" commandName="product">
<!-- 		Last Date Sold Min:  -->
<%-- 		<form:input path="minLastSold"/> --%>
		
<!-- 		Last Date Sold Max: -->
<%-- 		<form:input path="maxLastSold"/> --%>
		
		Product ID:
		<form:select path="productID">
			<form:option value=""></form:option>
			<c:forEach var="row" items="${productIDList}">
			<form:option value="${row}"></form:option>
			</c:forEach>
		</form:select>
		
		Description:
		<form:select path="description">
			<form:option value=""></form:option>
			<c:forEach var="row" items="${descriptionList}">
			<form:option value="${row}"></form:option>
			</c:forEach>
		</form:select>
		
		Department:
		<form:select path="department">
			<form:option value=""></form:option>
			<c:forEach var="row" items="${departmentList}">
			<form:option value="${row}"></form:option>
			</c:forEach>
		</form:select>
		
		Shelf Life:
		<form:select path="shelfLife">
			<form:option value=""></form:option>
			<c:forEach var="row" items="${shelfLifeList}">
			<form:option value="${row}"></form:option>
			</c:forEach>
		</form:select>
		
		<form:button id="filterButton" value="filter" name="filter">Filter</form:button>
		<form:button id="resetButton" value="reset" name="reset">Reset</form:button>
		
		<table>
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Description</th>
					<th>Last Sold</th>
					<th>Shelf Life</th>
					<th>Department</th>
					<th>Price</th>
					<th>Unit</th>
					<th>x For</th>
					<th>Cost</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${product.products}" varStatus="status">
				<tr>
					<td>${row.productID}</td>
					<td>${row.description}</td>
					<td>${row.lastSold}</td>
					<td>${row.shelfLife}</td>
					<td>${row.department}</td>
					<td>$${row.price}</td>
					<td>${row.unit}</td>
					<td>${row.xFor}</td>
					<td>$${row.cost}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form:form>
</body>
</html>