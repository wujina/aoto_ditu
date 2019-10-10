<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link rel="stylesheet" href="${staticPath}/static/lib2/css/bootstrap.min.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/bootstrapValidator.min.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/font-awesome.min.css" />

<!--[if IE 7]>
  <link rel="stylesheet" href="${staticPath}/static/lib2/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->
<link rel="stylesheet" href="${staticPath}/static/lib2/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/jquery.gritter.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/select2.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/bootstrap-editable.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${staticPath}/static/lib2/css/ace.min.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/ace-skins.min.css" />

<!--[if lte IE 8]>
  <link rel="stylesheet" href="${staticPath}/static/lib2/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="${staticPath}/static/lib2/js/ace-extra.min.js"></script>
<script>var logBehaviorEnabled = ${logBehaviorEnabled};var contextPath = "${contextPath}";var staticPath = "${staticPath}";var locale ="<%= request.getLocale().getLanguage() %>";</script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="${staticPath}/static/lib2/js/html5shiv.js"></script>
<script src="${staticPath}/static/lib2/js/respond.min.js"></script>
<![endif]-->