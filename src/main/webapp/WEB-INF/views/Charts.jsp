<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Charts Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body ng-app="myApp">
<div class="generic-container" ng-controller="ChartsController">
    <div id="status_ok_chart"></div>
    <div id="delay_chart"></div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/controllers/ChartsController.js' />"></script>
<script src="<c:url value='/static/js/service/HttpBinRequestService.js' />"></script>
</body>
</html>