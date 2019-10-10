<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
 <form class="form-grid">
	    <div class="title">
	      <fmt:message key="dic.info" />
	    </div>
	    <div class="form-group">
	      <div class="col-2 control-label">
	        <label for="dicName"><fmt:message key="dic.dicName" /><span class="required">*</span>&nbsp;&nbsp;<fmt:message key="colon" />&nbsp;&nbsp;</label>
	      </div>
	      <div class="col-3">
	        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="dicName"/>  																	
	      </div>
	      <div class="col-2 control-label">
	        <label for="dicType"><fmt:message key="dic.dicType" /><span class="required">*</span>&nbsp;&nbsp;<fmt:message key="colon" />&nbsp;&nbsp;</label>
	      </div>
	      <div class="col-3">
	        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['chrnum','length[1,32]'],novalidate:true" name="dicType"/>  																	
	      </div>
	    </div>
    
	    <div>
	        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" id="btnAppendDbEd" onclick="appendEd();"><fmt:message key="new" /></a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id="btnRemoveDbEd" onclick="removeitEd();"><fmt:message key="remove" /></a>
	 		<a class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" id="btnRejectDbEd" onclick="rejectEd();"><fmt:message key="repeal" /></a>
		</div>
    	<table  class="easyui-datagrid" style="width:650px;height:250px;" id="dgdbEd" data-options="idField:'dicId',rownumbers:true,singleSelect:true,onClickRow: onClickRowEd">					 
	      <thead>
	        <tr>
	          <th data-options="field:'dicKey',width:167,sortable:true,editor:{type:'validatebox',options:{required:true,validType:['chrnum','length[1,32]']}}"><fmt:message key="dic.dicKey" /><span class="required"  style="color:red;">*</span></th>
	          <th data-options="field:'dicValue',width:280,editor:{type:'validatebox',options:{required:true,validType:['length[1,64]']}}"><fmt:message key="dic.dicValue" /><span class="required"  style="color:red;">*</span></th>
	          <th data-options="field:'dicSymbol',width:150,editor:{type:'validatebox',options:{required:false,validType:['length[1,64]']}}"><fmt:message key="dic.dicSymbol" /></th>
			</tr>
	      </thead>
	    </table>
  </form>

<script type="text/javascript">
	function onClickRowEd(index){
		if (editIndexEd != index){
			if (endEditingEd()){
				$('#dgdbEd').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndexEd = index;
			} else {
				$('#dgdbEd').datagrid('selectRow', editIndexEd);
			}
		}
	}
	var editIndexEd = undefined;
	function endEditingEd(){
		if (editIndexEd == undefined){return true;}
		if ($("#dgdbEd").datagrid('validateRow', editIndexEd)){
			
			var ed = $('#dgdbEd').datagrid('getEditor', {index:editIndexEd,field:'fileId'});
			if(ed){
				var fileName = $(ed.target).combobox('getText');
				$('#dgdbEd').datagrid('getRows')[editIndexEd]['fileName'] = fileName;
			}
			$('#dgdbEd').datagrid('endEdit', editIndexEd);
			editIndexEd = undefined;
			return true;
			
		} else {
			return false;
		}
	}
	
	function appendEd(){
		if (endEditingEd()){
			$('#dgdbEd').datagrid('appendRow',{status:'P'});
			editIndexEd = $('#dgdbEd').datagrid('getRows').length-1;
			$('#dgdbEd').datagrid('selectRow', editIndexEd)     //选择最后一行
					.datagrid('beginEdit', editIndexEd);		//开始编辑一行
					
		}
	}
	
	function removeitEd(){
		if (editIndexEd == undefined){return;}
		$('#dgdbEd').datagrid('cancelEdit', editIndexEd)
				.datagrid('deleteRow', editIndexEd);
		editIndexEd = undefined;
	}
	function rejectEd(){
		$('#dgdbEd').datagrid('rejectChanges');
		editIndexEd = undefined;
	}
</script>

