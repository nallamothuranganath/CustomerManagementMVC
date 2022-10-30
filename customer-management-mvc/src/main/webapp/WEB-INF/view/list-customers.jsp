<%--
  Created by IntelliJ IDEA.
  User: ranganath
  Date: 11/09/22
  Time: 8:53 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CUSTOMER RELATIONSHIP MANAGEMENT</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>

                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
