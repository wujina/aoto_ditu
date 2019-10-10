<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<link rel="stylesheet" href="${staticPath}/static/lib/easyui/themes/default/easyui.css" />
<link rel="stylesheet" href="${staticPath}/static/lib/easyui/themes/icon.css" />
<link rel="stylesheet" href="${staticPath}/static/lib2/css/font-awesome.min.css" />
<script src="${staticPath}/static/lib/jquery/jquery.js"></script>
<script src="${staticPath}/static/lib/jquery/plugins/jquery.string.js"></script>
<script src="${staticPath}/static/lib/jquery/plugins/jquery.json.js"></script>
<%--
<script src="${staticPath}/static/lib/jquery/plugins/jquery.base64.js"></script>
<script src="${staticPath}/static/lib/jquery/plugins/jquery.jcryption.js"></script>
--%>
<script src="${staticPath}/static/lib/jquery/plugins/jquery.i18n.properties.js"></script>
<script src="${staticPath}/static/lib/easyui/jquery.easyui.js"></script>
<script src="${staticPath}/static/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="${staticPath}/static/lib/date.js"></script>
<script>var logBehaviorEnabled = ${logBehaviorEnabled};var contextPath = "${contextPath}";var staticPath = "${staticPath}";var locale ="<%= request.getLocale().getLanguage() %>";</script>
<script src="${staticPath}/static/js/aotoframework.js"></script>
<%--
<div id="loading" style="position:absolute;z-index:2000;width:100%;height:100%;background:#F4F4F4;text-align:center;padding-top: 20%;">
  <div style="width:174px; height:43px; border:1px #95B8E7 solid; font-size:14px; color:#000; line-height:43px; display:inline-block;">
    <image src='${staticPath}/static/lib/easyui/themes/default/images/loading.gif' />  正在处理，请稍等...
  </div>
</div> 
--%>