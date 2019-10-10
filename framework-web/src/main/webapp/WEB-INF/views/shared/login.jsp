<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="app.name" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/lib2/css/bootstrap.min.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/bootstrapValidator.min.css" />
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/login.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/font-awesome.min.css" />
<!--[if IE 7]>
  <link rel="stylesheet" href="${staticPath}/static/lib2/css/font-awesome-ie7.min.css" />
<![endif]-->
<script src="${staticPath}/static/lib2/js/jquery-2.0.3.min.js"></script>
<script src="${staticPath}/static/lib/jquery/plugins/jquery.i18n.properties.js"></script>
<script src="${staticPath}/static/lib2/js/bootstrap.min.js"></script>
<script src="${staticPath}/static/lib2/js/bootstrapValidator.min.js"></script>
<script src="${staticPath}/static/lib/date.js"></script>
<script>var contextPath = "${contextPath}";var locale ="<%= request.getLocale().getLanguage() %>";</script>
<script src="${staticPath}/static/js/aotoframeworknew.js"></script>
<script src="${staticPath}/static/js/shared/login.js"></script>
</head>
<body class="form-bg" style="background:url('${staticPath}/static/themes/default/images/login/login.jpg') top center no-repeat">
<div class="container">	
    <div class="row">
        <div class="col-md-8 vertical-center center">            
            <h1>
                <i class="icon-leaf green"></i>
                <span class="red"><fmt:message key="login.company" /></span>
                <span class="white"><fmt:message key="login.application" /></span>
            </h1>
            <h4 class="blue">&copy; <fmt:message key="login.remark" /></h4>            
        </div>
        <div class="col-md-4 vertical-center">
            <form id="loginForm" class="form-horizontal" action="${contextPath}/j_spring_security_check" method="post">
                <span class="heading"><fmt:message key="login.title" /></span>                
                <div class="form-group">
                    <input class="form-control" id="username" name="j_username" placeholder="<fmt:message key="login.username" /><fmt:message key="colon" />" tabindex="1" />
                </div>
                <div class="form-group">
                    <input class="form-control" id="password" name="j_password" type="password" placeholder="<fmt:message key="login.password" /><fmt:message key="colon" />" tabindex="2"/>
                </div>
                <div class="form-group">
                    <span class="text">${errorMessage}</span>
                    <button type="submit" class="btn btn-default"><fmt:message key="login" /></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>