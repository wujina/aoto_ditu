<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
  <form class="form-grid">
    <div class="title">
      <fmt:message key="user.info" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="username"><fmt:message key="user.username" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="username" disabled />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="realName"><fmt:message key="user.realName" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="realName" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="orgName"><fmt:message key="org.orgName" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" data-options="required:true,novalidate:true" name="orgName" value="${currentUser.orgName}" readonly onclick="selectOrg(this);" />
        <input name="orgId" type="hidden" value="${currentUser.orgId}" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="phone"><fmt:message key="user.phone" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" data-options="validType:['phone'],novalidate:true" name="phone" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="mobile"><fmt:message key="user.mobile" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" data-options="validType:['mobile'],novalidate:true" name="mobile" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="email"><fmt:message key="user.email" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" data-options="validType:['email'],novalidate:true" name="email" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="address"><fmt:message key="user.address" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <textarea class="easyui-validatebox form-control" data-options="validType:['text','length[1,128]'],novalidate:true" name="address" style="height:35px;"></textarea>
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="remark"><fmt:message key="user.remark" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <textarea class="easyui-validatebox form-control" data-options="validType:['text','length[1,128]'],novalidate:true" name="remark" style="height:35px;"></textarea>
      </div>
      <div class="col-2"></div>
    </div>
  </form>