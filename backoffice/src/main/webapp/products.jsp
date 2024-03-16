<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ZStore</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <header>
        <%@ include file="include/navbar.jsp" %>
    </header>

    <div class="container">
        <h1>Products</h1>
        <c:if test="${not empty sessionScope.success}">
            <div class="alert alert-success" role="alert">
                    ${sessionScope.success}
                <% session.removeAttribute("success"); %>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.error}">
            <div class="alert alert-danger" role="alert">
                    ${sessionScope.error}
                <% session.removeAttribute("error"); %>
            </div>
        </c:if>
        <a href="${pageContext.request.contextPath}/product/new" class="btn btn-sm btn-primary my-2 float-end">Add product</a>
        <table class="table table-striped table-bordered my-2">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.category.name}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td class="col-2 text-end">
                        <a href="${pageContext.request.contextPath}/product/edit?id=${product.id}" class="btn btn-sm btn-warning">Edit</a>
                        <form action="${pageContext.request.contextPath}/product/delete" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${product.id}" />
                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this product?')">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@ include file="include/footer.jsp" %>
</body>
</html>
