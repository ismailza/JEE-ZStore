<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light w-100"style="padding-left: 25px; padding-right: 15px">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/">ZStore</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${pageContext.request.contextPath}/clients" class="nav-link px-2">Clients</a></li>
            <li><a href="${pageContext.request.contextPath}/products" class="nav-link px-2">Products</a></li>
            <li><a href="${pageContext.request.contextPath}/categories" class="nav-link px-2">Categories</a></li>
            <li><a href="${pageContext.request.contextPath}/orders" class="nav-link px-2">Orders</a></li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <c:choose>
                <c:when test="${not empty sessionScope.admin}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${sessionScope.client.username}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/account"><c:out value="Your account"/></a>
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/logout"><c:out value="Logout"/></a>
                        </div>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/signin">Sign in</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
