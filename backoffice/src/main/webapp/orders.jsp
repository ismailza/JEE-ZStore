<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 14:15
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
        <h1>Orders</h1>
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
        <table class="table table-striped table-bordered my-2">
            <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Client</th>
                <th>Total</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.date}</td>
                    <td>${product.client.lastname} ${product.client.firstname}</td>
                    <td></td>
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
