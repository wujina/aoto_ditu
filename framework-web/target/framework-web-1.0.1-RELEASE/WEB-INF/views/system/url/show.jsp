<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
 <form class="form-grid">
    <div class="title">
      <fmt:message key="url.detail" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="urlName"><fmt:message key="url.urlName" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['text','length[1,32]'],novalidate:true" name="urlName" readOnly/>
      </div>
      <div class="col-2"></div>
    </div>
     
     <div class="form-group">
      <div class="col-3 control-label">
        <label for="urlPattern"><fmt:message key="url.urlPattern" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="urlPattern" readOnly/>
      </div>
      <div class="col-2"></div>
    </div>
    
    
     <div class="form-group">
      <div class="col-3 control-label">
        <label for="httpMethod"><fmt:message key="url.httpMethod" /><span class="required">*</span> <fmt:message key="colon" /></label>
        </div>
      <div class="col-1"></div>
      <div class="col-6">
        <select class="easyui-combobox myeasyui-searchParams" name="httpMethod"  style="width:185px;" data-options="editable:false,validType:['httpMethod','length[1,32]'],required:true,panelHeight:'auto'" readOnly>  
			<option>POST</option>
			<option >GET</option>  
			<option >DELETE</option>  
			<option >PUT</option> 
		</select>
      </div>
     <div class="col-2"></div>
    </div>
    
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="actionCode"><fmt:message key="url.actionCode" /><span class="required"></span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="actionCode" readOnly />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="argsCode"><fmt:message key="url.argsCode" /><span class="required"></span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="argsCode" readOnly />
      </div>
      <div class="col-2"></div>
    </div>
  </form>
