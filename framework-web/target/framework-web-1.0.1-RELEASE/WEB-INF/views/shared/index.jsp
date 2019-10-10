<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<sec:authentication property="principal" var="currentUser" />
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="app.indexName" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/index.css" />
<!-- <link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" /> -->
<%@ include file="/WEB-INF/views/shared/bootstrapui.jsp"%>
<!-- <script src="${staticPath}/static/js/shared/outlook.js"></script> -->
<script>var currentUserId = ${currentUser.userId};var heartbeatInterval = ${heartbeatInterval};</script>

</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try{ace.settings.check('navbar' , 'fixed')}catch(e){}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand">
					<small>
						<i class="icon-leaf"></i>
						<fmt:message key="index.application" />&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="font-size:12px">${currentUser.orgName} | IP<fmt:message key="colon" />${currentUser.lastLoginIp} | <fmt:message key="log.login.loginDate" /><fmt:message key="colon" /><fmt:formatDate value="${currentUser.lastLoginDate}" type="both" pattern="yyyy-MM-dd HH:mm" />
						</span>
					</small>
				</a><!-- /.brand -->
			</div><!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue">
						<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							<img class="nav-user-photo" id="userPicImgId" src="<c:choose><c:when test='${null != currentUser.userPicDataStr}'>${currentUser.userPicDataStr}</c:when><c:otherwise>${staticPath}/static/lib2/avatars/user.jpg</c:otherwise></c:choose>"/>
							<span class="user-info">
								<small><fmt:message key="index.navbar.welcome" />,</small>
								<span id="realNameSpan">${currentUser.realName}</span>
							</span>

							<i class="icon-caret-down"></i>
						</a>

						<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li>
								<a href="#" data-toggle='modal' data-target='#myModal'>
									<i class="icon-user"></i>
									<fmt:message key="user.changePassword" />
								</a>
							</li>
							
							<li>
								<a href="${contextPath}/system/commuser/edit" target='mainframe'>
									<i class="icon-cog"></i>
									<fmt:message key="user.setting" />
								</a>
							</li>

							<li class="divider"></li>

							<li>
								<a href="${contextPath}/logout">
									<i class="icon-off"></i>
									<fmt:message key="logout" />
								</a>
							</li>
						</ul>
					</li>
				</ul><!-- /.ace-nav -->
			</div><!-- /.navbar-header -->
		</div><!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<ul class="nav nav-list" id="wnav">
					<li class='active'>
						<a href="#">
							<i class="icon-dashboard"></i>
							<span class="menu-text"><fmt:message key="index.menu.homepage"/></span>
						</a>
					</li>
				</ul><!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb" id="breadcrumbId">
						<li class="active">
							<i class="icon-home home-icon"></i>
							<fmt:message key="index.menu.homepage"/>
						</li>							
					</ul><!-- .breadcrumb -->
				</div>
				
				<iframe id="mainframe" name="mainframe" style="width:100%;height:500px;border:0px"></iframe>
			</div>
			
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width:500px">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel"><fmt:message key="user.changePassword"/></h4>
							<span id="changeSuccess" class="label label-success" style="display:none"></span>
							<span id="changeFailed" class="label label-danger" style="display:none"></span>
						</div>						
						<form id="changePasswordForm" class="form-horizontal" role="form">
							<br>							
							<div class="form-group">
								<label for="oldpass" class="col-sm-3 control-label"><fmt:message key="user.oldPassword"/></label>
								<div class="col-sm-8">
									<input type="password" class="form-control" style="width:260px;" name="oldpass" id="oldpass" placeholder="<fmt:message key="user.oldPassword.palceholder" />"><span id="oldpassTip" style="display:none;color:red;"></span>
								</div>
								<div class="col-sm-1"></div>
							</div>
							<div class="form-group">
								<label for="newpass" class="col-sm-3 control-label"><fmt:message key="user.newPassword"/></label>
								<div class="col-sm-8">
									<input type="password" class="form-control" style="width:260px;" name="newpass" id="newpass" placeholder="<fmt:message key="user.newPassword.palceholder" />"><span id="newpassTip" style="display:none;color:red;"></span>
								</div>
								<div class="col-sm-1"></div>
							</div>
							<div class="form-group">
								<label for="newpassAgain" class="col-sm-3 control-label"><fmt:message key="user.confirmPassword"/></label>
								<div class="col-sm-8">
									<input type="password" class="form-control" style="width:260px;" name="newpassAgain" id="newpassAgain" placeholder="<fmt:message key="user.confirmPassword.palceholder" />"><span id="newpassAgainTip" style="display:none;color:red;"></span>
								</div>
								<div class="col-sm-1"></div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="close"/></button>
								<button type="button" class="btn btn-primary" onclick="saveUpdate()"><fmt:message key="submit"/></button>
							</div>							
						</form>						
					</div>
				</div>
			</div>
			
			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; <fmt:message key="index.ace.setting.chooseSkin"/></span>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
						<label class="lbl" for="ace-settings-navbar"><fmt:message key="index.ace.setting.fixNavBar"/></label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
						<label class="lbl" for="ace-settings-sidebar"><fmt:message key="index.ace.setting.fixScrollBar"/></label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
						<label class="lbl" for="ace-settings-rtl"><fmt:message key="index.ace.setting.switchToLeft"/></label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
						<label class="lbl" for="ace-settings-add-container"><fmt:message key="index.ace.setting.switchNarrow"/>							
							<b></b>
						</label>
					</div>
				</div>
			</div><!-- /#ace-settings-container -->
		</div><!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div><!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="${staticPath}/static/lib2/js/jquery-2.0.3.min.js"></script>
	<!-- <![endif]-->

	<!--[if IE]>
	<script src="${staticPath}/static/lib2/js/jquery-1.10.2.min.js"></script>
	<![endif]-->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='${staticPath}/static/lib2/js/jquery-2.0.3.min.js'>"+"<"+"script>");
	</script>
	<!-- <![endif]-->

	<!--[if IE]>
	<script type="text/javascript">
			window.jQuery || document.write("<script src='${staticPath}/static/lib2/js/jquery-1.10.2.min.js'>"+"<"+"script>");
	</script>
	<![endif]-->

	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${staticPath}/static/lib2/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
	</script>
	<script src="${staticPath}/static/lib2/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.slimscroll.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${staticPath}/static/lib2/js/jquery.sparkline.min.js"></script>
	<script src="${staticPath}/static/lib/jquery/plugins/jquery.i18n.properties.js"></script>
	<script src="${staticPath}/static/lib/jquery/plugins/jquery.string.js"></script>
	<script src="${staticPath}/static/lib/jquery/plugins/jquery.json.js"></script>
	<script src="${staticPath}/static/lib2/js/flot/jquery.flot.min.js"></script>
	<script src="${staticPath}/static/lib2/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${staticPath}/static/lib2/js/flot/jquery.flot.resize.min.js"></script>
	<script src="${staticPath}/static/lib2/js/bootstrap.min.js"></script>
	<script src="${staticPath}/static/lib2/js/bootstrapValidator.min.js"></script>
	<script src="${staticPath}/static/lib2/js/typeahead-bs2.min.js"></script>

	<!--[if lte IE 8]>
	  <script src="${staticPath}/static/lib2/js/excanvas.min.js"></script>
	<![endif]-->

	<!-- ace scripts -->

	<script src="${staticPath}/static/lib2/js/ace-elements.min.js"></script>
	<script src="${staticPath}/static/lib2/js/ace.min.js"></script>
	
	<script src="${staticPath}/static/js/aotoframeworknew.js"></script>
	<script src="${staticPath}/static/js/shared/index.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">	
	</script>	
</body>
</html>