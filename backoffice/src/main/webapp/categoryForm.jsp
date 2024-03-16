<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 13:21
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
            <h1 class="mt-4">${category != null && category.id != null ? "Edit category" : "Add new category"}</h1>
        </h1>
        <div class="row mt-4 d-flex justify-content-center">
            <div class="col-md-6">
                <form action="${category != null && category.id != null ? 'update' : 'save'}" method="post" class="form-horizontal">
                    <input type="hidden" name="id" value="${category != null ? category.id : ''}"/>
                    <div class="col-md-12">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Category name" value="${category != null ? category.name : ''}" required>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="description" class="form-label">Description</label>
                        <textarea class="form-control" id="description" name="description" placeholder="Category description" required>${category != null ? category.description : ''}</textarea>
                    </div>
                    <div class="mt-2 float-end">
                        <a href="${pageContext.request.contextPath}/categories" type="button" class="btn btn-default">Cancel</a>
                        <button type="submit" class="btn btn-primary">${category != null && category.id != null ? "Update" : "Save"}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@ include file="include/footer.jsp" %>
</body>
</html>
