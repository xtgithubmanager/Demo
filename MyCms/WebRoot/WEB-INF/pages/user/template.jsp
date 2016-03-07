<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!--身体部-->
<c:forEach items="${users}" varStatus="userindex" var="user">
	<tr>
		<td>${user.id }<c:if test="${userindex.index==0 }">
				<input type="hidden" id="itemCount" value="${count }" />
			</c:if>
		</td>
		<td>${user.username }</td>
		<td class="keys">${user.account}</td>
		<td>
		  <c:if test="${user.male==0}">男</c:if>
		   <c:if test="${user.male==1}">女</c:if>
		</td>
		<td>${user.address }</td>
		<td>${xt:formatdate(user.createtime,'yyyy-MM-dd HH:mm:ss')}</td>
		<td><img width="20" height="20" src="${basePath}/resources/${user.headimg}"/></td>
		<td>
			<c:if test="${user.isdelete==0 }">
			   <a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="1" opid="${user.id }" mark="isdelete" class="red">否</a>
			</c:if>
			<c:if test="${user.isdelete==1 }">
			   <a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="0" opid="${user.id }" mark="isdelete" class="green">是</a>
			</c:if>
		</td>
		<td><a href="javascript:void(0)" onclick="xtAdmin.remove(this)" data-opid="${user.id}">删除</a></td>
	</tr>
</c:forEach>

	<script type="text/javascript">
       $(function(){
	         $(".tmui-tips").tmTip();	
        }); 
    </script>

