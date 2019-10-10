<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
fieldset {
	font-family: arial, helvetica, sans-serif;
	margin-bottom: 10px;
	padding: 10px;
}

fieldset legend {
	font-size: 18px;
	font-weight: bold;
}

fieldset div {
	width: 150px;
	font-weight: bold;
	padding: 5px;
}

fieldset ul {
	font-family: arial, helvetica, sans-serif;
	width: 100%;
}

fieldset ul,fieldset ul li {
	list-style: none;
	padding: 0;
	margin: 0;
	float: left;
}

fieldset ul li {
	width: 100px;
	text-align: left;
	padding-left: 40px;
	font-size: 12px;
	height: 20px;
	line-height: 20px;
	display: inline-block;
}
</style>
  <c:forEach items="${functions}" var="f">
    <fieldset id="fieldsetFun">
      <legend>
        <label for="chkFun${f.funId}"><input type="checkbox" id="chkFun${f.funId}" value="${f.funId}" />${f.funName}</label>
      </legend>
      <c:forEach items="${f.children}" var="c">
        <div>
          <label for="chkFun${c.funId}"><input type="checkbox" id="chkFun${c.funId}" name="chkFun${f.funId}" value="${c.funId}" />${c.funName}</label>
        </div>
        <ul>
          <c:forEach items="${c.children}" var="l">
            <li><label for="chkFun${l.funId}"><input type="checkbox" id="chkFun${l.funId}" name="chkFun${c.funId}" value="${l.funId}" />${l.funName}</label></li>
          </c:forEach>
        </ul>
      </c:forEach>
    </fieldset>
  </c:forEach>
