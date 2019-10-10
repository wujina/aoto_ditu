<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<div class="form-grid">
   <div class="title">
     <fmt:message key="dic.info" />
   </div>
   <div class="form-group">
     <div class="col-2 control-label">
       <label for="dicName"><fmt:message key="dic.dicName" /><span class="required">*</span> &nbsp;&nbsp;<fmt:message key="colon" />&nbsp;&nbsp; </label>
     </div>
     <div class="col-3">
       <input class="form-control" name="dicName" disabled="disabled" />																
     </div>
     
     <div class="col-2 control-label">
       <label for="dicType"><fmt:message key="dic.dicType" /><span class="required">*</span> &nbsp;&nbsp;<fmt:message key="colon" />&nbsp;&nbsp; </label>
      </div>
      <div class="col-3">
        <input class="form-control" name="dicType" disabled="disabled" />														
      </div>
    </div>
</div>    
       	
<div data-options="region:'center',border:false,region:'center'" style="width:650px;height:300px;border: 0px solid #95B8E7; background: #F4F4F4; ">
 	
	<table style="width:650px;border:1px solid #95B8E7;" class="easyui-datagrid"  id="dicDgShow" data-options="idField:'dicId',title:'<fmt:message key="dic.list" />',pageSize:10,fit:true,fitColumns:true,rownumbers:true,pagination:true,singleSelect:true,toolbar:'#tbSelectDic'">					 
		<thead>
		  <tr>
		    <th data-options="field:'dicKey',width:167,sortable:true"><fmt:message key="dic.dicKey" /></th>
			<th data-options="field:'dicValue',width:300,sortable:true"><fmt:message key="dic.dicValue" /></th>
			<th data-options="field:'dicSymbol',width:150,sortable:true"><fmt:message key="dic.dicSymbol" /></th>
		  </tr>
		</thead>
	</table>
    
   	<div id="tbSelectDic" style="padding: 5px; height: auto">		        
	        <form class="form-inline" style="margin: 15px;">
		       <div class="form-group">
		        <label for="queryDicKey"><fmt:message key="dic.dicKey" /></label>
		        <fmt:message key="colon" />
				<input style="width:100px;" id="queryDicKey" name="queryDicKey"/>
		      </div>
		      <div class="form-group">
		        <label for="queryDicValue"><fmt:message key="dic.dicValue" /></label>
		        <fmt:message key="colon" />
				<input style="width:100px;" id="queryDicValue" name="queryDicValue"/>
		      </div>
		      <div class="form-group">
		        <label for="queryDicSymbol"><fmt:message key="dic.dicSymbol" /></label>
		        <fmt:message key="colon" />
				<input style="width:100px;" id="queryDicSymbol" name="queryDicSymbol"/>
		      </div>
		      <div class="form-group">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchDicDetail();"><fmt:message key="query" /></a>
		      </div>
		    </form>
     </div>
</div>   