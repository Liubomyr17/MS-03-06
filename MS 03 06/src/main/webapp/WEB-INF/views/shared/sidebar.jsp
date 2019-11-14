<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2019
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="logo">
    <img src="https://s3.eu-central-1.amazonaws.com/listmusor/production/41481/logo/big/5923c6bba5bb9.jpg?1309784296" alt="GZIMO"
         class="image-md-left">
</div>

<div class="list-group">

    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category_name}">${category.name}</a>
    </c:forEach>
</div>

