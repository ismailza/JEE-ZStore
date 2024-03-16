<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 12:18
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
        <h1 class="mt-4">
            <h1 class="mt-4">${product != null && product.id != null ? "Edit product" : "Add new product"}</h1>
        </h1>
        <div class="row mt-4 d-flex justify-content-center">
            <div class="col-md-6">
                <form action="${product != null && product.id != null ? 'update' : 'save'}" method="post" class="form-horizontal">
                    <input type="hidden" name="id" value="${product != null ? product.id : ''}"/>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Product name" value="${product != null ? product.name : ''}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="category" class="form-label">Category</label>
                            <select id="category" class="form-control form-select" name="category" required>
                                <option selected>Choose...</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-12">
                            <label for="description" class="form-label">Description</label>
                            <textarea class="form-control" id="description" name="description" placeholder="Product description" required>${product != null ? product.description : ''}</textarea>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-12">
                            <label for="photo" class="form-label">Photo url</label>
                            <input type="text" class="form-control" id="photo" name="photo" placeholder="Product photo" value="${product != null ? product.photo : ''}" required>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="price" class="form-label">Price</label>
                            <input type="number" min="0" step="any" class="form-control" id="price" name="price" placeholder="Product price" value="${product != null ? product.price : ''}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="stock" class="form-label">Stock</label>
                            <input type="number" min="1" step="1" class="form-control" id="stock" name="stock" placeholder="Stock" value="${product != null ? product.stock : ''}" required>
                        </div>
                    </div>
                    <div class="mt-2 float-end">
                        <a href="${pageContext.request.contextPath}/products" type="button" class="btn btn-default">Cancel</a>
                        <button type="submit" class="btn btn-primary">${product != null && product.id != null ? "Update" : "Save"}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@ include file="include/footer.jsp" %>
</body>
</html>
