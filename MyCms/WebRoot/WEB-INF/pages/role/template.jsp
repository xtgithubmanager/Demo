<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!--身体部-->
	<c:forEach items="${roles}" var="role">
			<tr>
				<td>${role.id }</td>
				<td>${role.name }</td>
				<td>${role.userid }</td>
				<td class="tmui-tips" tip="${xt:formatdate(role.createtime,'yyyy-MM-dd HH:mm:ss') }">${xt:getTimeFormat(role.createtime)}</td>
				<td>${role.status }</td>
				<td>${role.description}</td>
				<td>
				  <c:if test="${role.isdelete==0 }"><a href="javascript:void(0)" val="1" onclick="xtAdmin.op(this);" opid="${role.id }" mark="isdelete" class="red">否</a></c:if>
				  <c:if test="${role.isdelete==1 }"><a href="javascript:void(0)" val="0" onclick="xtAdmin.op(this);" opid="${role.id}" mark="isdelete" class="green">是</a></c:if>
			   </td>
				<td><a href="javascript:void(0);" data-opid="${role.id }" onclick="xtRole.user(this);">分配角色</a></td>
				<td><a href="javascript:void(0);" data-opid="${role.id }" onclick="xtRole.permission(this)">授权</a></td>
				     <td>
		       <a href="javascript:void(0)" onclick="xtAdmin.remove(this);" data-opid="${role.id }">删除</a>
		     </td>
    </c:forEach>
	<script type="text/javascript">
	       $(function(){
		         $(".tmui-tips").tmTip();	
	        }); 
	 </script>
