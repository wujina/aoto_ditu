<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
  <form class="form-grid">
    <div class="title">
      <fmt:message key="role.info" />
    </div>
    <div class="form-group">
      <div class="col-4 control-label">
        <label for="roleName"><fmt:message key="commrole.roleName" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="roleName" />
      </div>
      <div class="col-1"></div>
    </div>    
    <div class="form-group">
      <div class="col-4 control-label">
        <label for="remark"><fmt:message key="user.remark" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <textarea class="easyui-validatebox form-control" data-options="validType:['text','length[0,128]'],novalidate:true" name="remark" style="height:35px;"></textarea>
      </div>
      <div class="col-1"></div>
    </div>
  </form>