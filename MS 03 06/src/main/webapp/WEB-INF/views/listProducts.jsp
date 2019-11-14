<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/9/2019
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<div class = "container">
    <div class = "row">
        <!-- Would be to display sidebar -->
        <div class="col-md-3">
            <%@include file="shared/sidebar.jsp"%>
        </div>

        <!-- to display the actual products -->
        <div class = "col-md-9">
            <!-- Added breadcrumb component -->
            <div class="row">
                <div class="col-lg-12">

                    <c:if test = "${userClickAllProducts == true}">
                        <ol class="breadcrumb">
                            <thread>
                                <tr>
                                    <th><a href="${contextRoot}/home">Home</a> / </th>
                                    <th class="active">All Products / </th>
                                </tr>
                            </thread>
                        </ol>
                    </c:if>

                    <c:if test = "${userClickCategoryProducts == true}">
                        <ol class="breadcrumb">

                            <thread>
                                <tr>
                                    <th><a href="${contextRoot}/home">Home</a> / </th>
                                    <th class="active">Category / </th>
                                    <th class="active">${category.name}</th>
                                </tr>
                            </thread>

                        </ol>
                    </c:if>

                </div>
            </div>



        </div>

    </div>
</div>
</body>
</html>
