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
	        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" id="btnAppendDb" onclick="append();"><fmt:message key="new" /></a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id="btnRemoveDb" onclick="removeit();"><fmt:message key="remove" /></a>
	 		<a class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" id="btnRejectDb" onclick="reject();"><fmt:message key="repeal" /></a>
		</div>
    	<table  class="easyui-datagrid" style="width:650px;height:250px;" id="dgdb"
    			data-options="idField:'dicId',rownumbers:true,singleSelect:true,onClickRow: onClickRow">					 
	      <thead>
	        <tr>
	          <th data-options="field:'dicKey',width:167,sortable:true,editor:{type:'validatebox',options:{required:true,validType:['chrnum','length[1,32]']}}"><fmt:message key="dic.dicKey" /><span class="required" style="color:red;">*</span></th>
	          <th data-options="field:'dicValue',width:280,editor:{type:'validatebox',options:{required:true,validType:['length[1,64]']}}"><fmt:message key="dic.dicValue" /><span class="required"  style="color:red;">*</span></th>
	          <th data-options="field:'dicSymbol',width:150,editor:{type:'validatebox',options:{required:false,validType:['length[1,64]']}}"><fmt:message key="dic.dicSymbol" /></th>
			</tr>
	      </thead>
	    </table>
  </form>

<script type="text/javascript">
	function onClickRow(index){
		if (editIndex != index){
			if (endEditing()){
				$('#dgdb').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#dgdb').datagrid('selectRow', editIndex);
			}
		}
	}
	var editIndex = undefined;
	function endEditing(){
		if (editIndex == undefined){return true;}
		if ($("#dgdb").datagrid('validateRow', editIndex)){
			
			var ed = $('#dgdb').datagrid('getEditor', {index:editIndex,field:'fileId'});
			if(ed){
				var fileName = $(ed.target).combobox('getText');
				$('#dgdb').datagrid('getRows')[editIndex]['fileName'] = fileName;
			}
			$('#dgdb').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
			
		} else {
			return false;
		}
	}
	
	function append(){
		if (endEditing()){
			$('#dgdb').datagrid('appendRow',{status:'P'});
			editIndex = $('#dgdb').datagrid('getRows').length-1;
			$('#dgdb').datagrid('selectRow', editIndex)     //选择最后一行
					.datagrid('beginEdit', editIndex);		//开始编辑一行
					
		}
	}
	
	function removeit(){
		if (editIndex == undefined){return;}
		$('#dgdb').datagrid('cancelEdit', editIndex)
				.datagrid('deleteRow', editIndex);
		editIndex = undefined;
	}
	function reject(){
		$('#dgdb').datagrid('rejectChanges');
		editIndex = undefined;
	}
</script>