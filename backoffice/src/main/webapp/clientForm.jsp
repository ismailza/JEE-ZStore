<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 13:59
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
        <h1 class="mt-4">${client != null && client.id != null ? "Edit client" : "Add new client"}</h1>
    </h1>
    <div class="row mt-4 d-flex justify-content-center">
        <div class="col-md-6">
            <form action="${client != null && client.id != null ? 'update' : 'save'}" method="post" class="form-horizontal">
                <input type="hidden" name="id" value="${client != null ? client.id : ''}"/>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="firstname" class="form-label">Firstname</label>
                        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Client firstname" value="${client != null ? client.firstname : ''}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="lastname" class="form-label">Lastname</label>
                        <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Client lastname" value="${client != null ? client.lastname : ''}" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Client email" value="${client != null ? client.email : ''}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Client username" value="${client != null ? client.username : ''}" required>
                    </div>
                </div>
                <div class="mt-2 float-end">
                    <a href="${pageContext.request.contextPath}/clients" type="button" class="btn btn-default">Cancel</a>
                    <button type="submit" class="btn btn-primary">${client != null && client.id != null ? "Update" : "Save"}</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>
