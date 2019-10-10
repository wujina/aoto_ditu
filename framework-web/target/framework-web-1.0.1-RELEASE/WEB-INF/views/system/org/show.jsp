<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
  <form class="form-grid">
    <div class="title">
      <fmt:message key="org.info" />
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="parentName"><fmt:message key="org.parentName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="parentName" disabled="disabled" />
      </div>
      <div class="col-1"></div>
      <div class="col-2 control-label">
        <label for="orgName"><fmt:message key="org.orgName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="orgName" disabled="disabled" />
      </div>
      <div class="col-1"></div>
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="sortNum"><fmt:message key="org.sortNum" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="sortNum" disabled="disabled" />
      </div>
      <div class="col-1"></div>
      <div class="col-2 control-label">
        <label for="levelNum"><fmt:message key="org.levelNum" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="levelNum" disabled="disabled" />
      </div>
      <div class="col-1"></div>
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="orgCode"><fmt:message key="org.orgCode" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="orgCode" disabled="disabled" />
      </div>
      <div class="col-1"></div>
      
      <div class="col-2 control-label">
        <label for="tel"><fmt:message key="org.tel" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="tel" disabled="disabled" />
      </div>
      <div class="col-1"></div>
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="createdByName"><fmt:message key="createdBy" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="createdByName" disabled="disabled" />
      </div>
      <div class="col-1"></div>
      <div class="col-2 control-label">
        <label for="createdDate"><fmt:message key="createdDate" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="createdDate" disabled="disabled" />
      </div>
      <div class="col-1"></div>
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="lastUpdatedByName"><fmt:message key="lastUpdatedBy" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="lastUpdatedByName" disabled="disabled" />
      </div>
      <div class="col-1"></div>
      <div class="col-2 control-label">
        <label for="lastUpdatedDate"><fmt:message key="lastUpdatedDate" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-3">
        <input class="form-control" name="lastUpdatedDate" disabled="disabled" />
      </div>
      <div class="col-1"></div>
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="address"><fmt:message key="org.address" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-9">
        <textarea class="form-control" name="address" style="height:35px;" readonly></textarea>
      </div>
      <div class="col-1"></div>
    </div>
    <div class="form-group">
      <div class="col-2 control-label">
        <label for="remark"><fmt:message key="org.remark" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-9">
        <textarea class="form-control" name="remark" style="height:35px;" readonly></textarea>
      </div>
      <div class="col-1"></div>
    </div>
  </form>