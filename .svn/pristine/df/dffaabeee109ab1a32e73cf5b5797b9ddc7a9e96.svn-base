<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<sec:authentication property="principal" var="currentUser" />
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="app.indexName" /></title>
<!-- <link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" /> -->
<%@ include file="/WEB-INF/views/shared/bootstrapui.jsp"%>
<!-- <script src="${staticPath}/static/js/shared/outlook.js"></script> -->
<script>var currentUserId = ${currentUser.userId};</script>
</head>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">				
				<div id="user-profile-1" class="user-profile row">
					<div class="col-xs-12 col-sm-3 center">
						<div>
							<span class="profile-picture">
								<img id="avatar" class="editable img-responsive" src="<c:choose><c:when test='${null != currentUser.userPicDataStr}'>${currentUser.userPicDataStr}</c:when><c:otherwise>${staticPath}/static/lib2/avatars/user.jpg</c:otherwise></c:choose>" />
							</span>

							<div class="space-4"></div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-9">
						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name"><fmt:message key="user.setting.realname"/></div>
								<div class="profile-info-value">
									<span class="editable" id="realName">${currentUser.realName}</span>
								</div>
							</div>
							
							<div class="profile-info-row">
								<div class="profile-info-name"><fmt:message key="user.setting.age"/></div>

								<div class="profile-info-value">
									<span class="editable" id="age"><c:choose><c:when test='${null != currentUser.age}'>${currentUser.age}</c:when><c:otherwise>16</c:otherwise></c:choose></span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name"><fmt:message key="user.setting.birthday"/></div>

								<div class="profile-info-value">
									<span class="editable" id="birthday">${currentUser.birthday}</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name"><fmt:message key="user.setting.about"/></div>

								<div class="profile-info-value">
									<span class="editable" id="about">${currentUser.about}</span>
								</div>
							</div>
						</div>
						<div class="space-20"></div>
					</div>
				</div>				
			</div>
		</div>
	</div>

	<!-- basic scripts -->
	<!--[if !IE]> -->
	<script src="${staticPath}/static/lib2/js/jquery-2.0.3.min.js"></script>
	<!-- <![endif]-->

	<!--[if IE]>
	<script src="${staticPath}/static/lib2/js/jquery-1.10.2.min.js"></script>
	<![endif]-->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='${staticPath}/static/lib2/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
	</script>
	<!-- <![endif]-->

	<!--[if IE]>
	<script type="text/javascript">
 		window.jQuery || document.write("<script src='${staticPath}/static/lib2/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
	</script>
	<![endif]-->

	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${staticPath}/static/lib2/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="${staticPath}/static/lib2/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.gritter.min.js"></script>	
	<script src="${staticPath}/static/lib2/js/jquery.slimscroll.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.hotkeys.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.maskedinput.min.js"></script>
	<script src="${staticPath}/static/lib/jquery/plugins/jquery.string.js"></script>
	<script src="${staticPath}/static/lib/jquery/plugins/jquery.i18n.properties.js"></script>
	<script src="${staticPath}/static/lib2/js/bootstrap.min.js"></script>
	<script src="${staticPath}/static/lib2/js/typeahead-bs2.min.js"></script>

	<!--[if lte IE 8]>
		<script src="${staticPath}/static/lib2/js/excanvas.min.js"></script>
	<![endif]-->

	<script src="${staticPath}/static/lib2/js/bootbox.min.js"></script>
	<script src="${staticPath}/static/lib2/js/bootstrap-wysiwyg.min.js"></script>
	<script src="${staticPath}/static/lib2/js/select2.min.js"></script>
	<script src="${staticPath}/static/lib2/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="${staticPath}/static/lib2/js/fuelux/fuelux.spinner.min.js"></script>
	<script src="${staticPath}/static/lib2/js/x-editable/bootstrap-editable.min.js"></script>
	<script src="${staticPath}/static/lib2/js/x-editable/ace-editable.min.js"></script>

	<!-- ace scripts -->

	<script src="${staticPath}/static/lib2/js/ace-elements.min.js"></script>
	<script src="${staticPath}/static/lib2/js/ace.min.js"></script>
	
	<script src="${staticPath}/static/js/aotoframeworknew.js"></script>
	<script src="${staticPath}/static/js/system/user/profile.js"></script>

	<!-- inline scripts related to this page -->
	<script>	
	</script>
</body>
</html>