<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!--身体部-->
	<c:forEach items="${contents}" varStatus="contentindex" var="con">
		<tr>
			<td class="keys">${con.title }
			<c:if test="${contentindex.index==0 }"><input type="hidden" id="itemCount" value="${count }"/></c:if>
			</td>
			<td>${con.channelid }</td>
			<td>${con.userid }</td>
			<td class="tmui-tips" tip="${xt:formatdate(con.createtime,'yyyy-MM-dd HH:mm:ss') }">${xt:getTimeFormat(con.createtime)}</td>
			<td>
			<c:if test="${con.istop==0 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="1" opid="${con.id }" mark="istop" class="red">否</a></c:if>
			<c:if test="${con.istop==1 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="0" opid="${con.id }" mark="istop" class="green">是</a></c:if>
			</td>
			<td>
			<c:if test="${con.iscomment==0 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="1" opid="${con.id }" mark="iscomment" class="red">否</a></c:if>
			<c:if test="${con.iscomment==1 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="0" opid="${con.id }" mark="iscomment" class="green">是</a></c:if>
			</td>
			<td>
			<c:if test="${con.status==0 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="1" opid="${con.id }" mark="status" class="red">否</a></c:if>
			<c:if test="${con.status==1 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="0" opid="${con.id }" mark="status" class="green">是</a></c:if>
		   </td>
			<td>
			<c:if test="${con.push==0 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="1" opid="${con.id }" mark="push" class="red">否</a></c:if>
			<c:if test="${con.push==1 }"><a href="javascript:void(0)" onclick="xtAdmin.op(this);" val="0" opid="${con.id }" mark="push" class="green">是</a></c:if>
			</td>
			<td>
			  <c:if test="${con.isdelete==0 }"><a href="javascript:void(0)" val="1" onclick="xtAdmin.op(this);" opid="${con.id }" mark="isdelete" class="red">否</a></c:if>
			  <c:if test="${con.isdelete==1 }"><a href="javascript:void(0)" val="0" onclick="xtAdmin.op(this);" opid="${con.id}" mark="isdelete" class="green">是</a></c:if>
			</td>
		     
		     <td>
		       <a href="javascript:void(0)" onclick="xtAdmin.remove(this);" data-opid="${con.id }">删除</a>
		     </td>
		</tr>
	</c:forEach>
	<script type="text/javascript">
       $(function(){
	         $(".tmui-tips").tmTip();	
        }); 
    </script>
