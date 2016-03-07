<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>大型门户后台cms</title>
    <meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<link rel="stylesheet" href="${basePath}/resources/sg/tree/tm_tree.css">
	<script type="text/javascript" src="${basePath}/resources/sg/tree/tm_tree.js"></script>
 </head>
 <body>
	<div class="wrap">
	<%@include file="/WEB-INF/pages/common/left.jsp"%>
		<div class="content">
		<%@include file="/WEB-INF/pages/common/header.jsp"%>
			<div class="channel"> 位置 > 权限管理</div>
			<div class="cnt">
				<div class="tabwrap">
					<div id="permissionTree">
					
					</div>
					<!--表格-->
<!-- 					<table class="tztab"> -->
<!-- 						<caption> -->
<!-- 							2015年度一周统计报表数据 -->
<!-- 							<div class="fr sbtn"> -->
<!-- 								<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a> -->
<!-- 							</div> -->
<!-- 						</caption> -->
<!-- 						头部
<!-- 						<colgroup id="days"> -->
<!-- 							<col/> -->
<!-- 							<col style="background:green;width:200px;"/> -->
<!-- 							<col id="t"/> -->
<!-- 						</colgroup>-->
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th>名称 <span class="up"></span> <span class="down"></span></th>	 -->
<!-- 								<th>描述</th>	 -->
<!-- 								<th>创建时间</th>	 -->
<!-- 								<th>所属模块</th>	 -->
<!-- 								<th>访问链接</th> -->
<!-- 								<th>用户id</th>	 -->
<!-- 								<th>删除状态</th>	 -->
<!-- 							</tr> -->
<!-- 						</thead> -->
						<!--身体部-->
<!-- 						<tbody> -->
<!-- 							<c:forEach items="${permissions}" var="con"> -->
<!-- 								<tr> -->
<!-- 									<td>${con.name }</td> -->
<!-- 									<td>${con.description }</td> -->
<!-- 									<td class="tmui-tips" tip="${xt:formatdate(con.createtime,'yyyy-MM-dd HH:mm:ss') }">${xt:getTimeFormat(con.createtime)}</td> -->
<!-- 									<td>${con.model}</td> -->
<!-- 									<td>${con.url }</td> -->
<!-- 									<td>${con.userid }</td> -->
<!-- 									<td><a href="javascript:void(0);">${con.isdelete }</a></td> -->
<!-- 								</tr> -->
<!-- 							</c:forEach> -->
<!-- 						</tbody> -->
<!-- 					</table> -->
				</div>
				</div>
		</div>
	
	</div>


	<script type="text/javascript">
		$(function(){
		   
			//展示根节点
			$.ajax({
				url:adminPath+"/permission/getroot",
				type:"post",
			    success:function(data){
			    	var root = data.root;
			    	var children = data.children;
			    		 $("#permissionTree").tmTree(
			    				 {outhtml:"<a href='javascript:void(0);' class='remove'><i class='fa fa-remove'></i></a>",
			    				 root:root,
			    				 children:children,
			    				 type:"checkbox",
			    				 callback:function(opid){
			    			     var $this = $(this);
				    			 $.tzConfirm({callback:function(ok){		 
				    				 if(ok){
				    					$this.closest("li").remove(); 
				    				 }
				    			 }
			    			 });		 
			    		 },onclick:function($obj,data){
			    			 //alert(data);
			    		 }
			    				 });
			    	
			    },
			    error:function(){
			    	loading("服务器出现错误",2);
			    }
			});
			 
		
			$(".nav").find("li.items").find("a").click(function(){
				var len = $(this).next().length;
				if(len>0){
					$(this).next().stop(true,true).slideToggle()
					.end().parents("li")
					.addClass("active")
					.siblings().removeClass("active")
					.find("ul").slideUp("slow");
				}
			});
		});
	</script>
 </body>
</html>
