<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
  <form class="form-grid">
    <div class="title">
      <fmt:message key="menu.info" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="parentName"><fmt:message key="menu.parentName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="parentName" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="menuId"><fmt:message key="menu.menuId" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="menuId" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">   
      <div class="col-3 control-label">
        <label for="menuName"><fmt:message key="menu.menuName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="menuName" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="menuUrl"><fmt:message key="menu.menuUrl" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="menuUrl" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="icon"><fmt:message key="menu.icon" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="icon" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="funId"><fmt:message key="menu.funId" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="funName" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="sortNum"><fmt:message key="menu.sortNum" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="sortNum" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">  
      <div class="col-3 control-label">
        <label for="levelNum"><fmt:message key="menu.levelNum" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="levelNum" disabled="disabled" />
      </div>
      <div class="col-2"></div>
    </div>
  </form>
