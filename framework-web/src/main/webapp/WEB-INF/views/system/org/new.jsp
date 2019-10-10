<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <form class="form-grid">
    <div class="title">
      <fmt:message key="org.info" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="parentName"><fmt:message key="org.parentName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="parentName" disabled /> <input name="parentId" type="hidden" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="orgName"><fmt:message key="org.orgName" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="orgName" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="sortNum"><fmt:message key="org.sortNum" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control"  maxlength="3" data-options="required:true,validType:['integer[3]'],novalidate:true" name="sortNum" />
      </div>
      <div class="col-2"></div>
    </div>
    
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="orgCode"><fmt:message key="org.orgCode" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="16" data-options="required:true,validType:['text','length[1,16]'],novalidate:true" name="orgCode" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="tel"><fmt:message key="org.tel" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="16" data-options="validType:['phone','length[1,16]'],novalidate:true" name="tel"/>
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="address"><fmt:message key="org.address" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <textarea class="easyui-validatebox form-control" maxlength="128" data-options="validType:['text','length[1,128]'],novalidate:true" name="address" style="height:35px;"></textarea>
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="remark"><fmt:message key="org.remark" />
          <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <textarea class="easyui-validatebox form-control" maxlength="128" data-options="validType:['text','length[1,128]'],novalidate:true" name="remark" style="height:35px;"></textarea>
      </div>
      <div class="col-2"></div>
    </div>
  </form>