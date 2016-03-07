<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!doctype html>
<html>
	<head>
		<title>用户分配权限</title>
			<meta name="pragma" content="no-cache">
			<meta name="cache-control" content="no-cache">
			<meta name="expires" content="0">
			<meta name="keywords" content="keyword1,keyword2,keyword3">
			<meta name="description" content="This is my page">
				<%@include file="/WEB-INF/pages/common/common.jsp" %>
		  <link rel="stylesheet" href="${basePath}/resources/sg/tree/tm_tree.css">
	      <script type="text/javascript" src="${basePath}/resources/sg/tree/tm_tree.js"></script>
	<!-- 分页的js导入 -->
		<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
		<style type="text/css">
			* {
				margin: 0px;
				padding: 0px;
				font-size: 12px;
			}
			
			#permissionTree {
				height: 320px;
				overflow: auto;
		}
		</style>
</head>
<body>

    	<div id="permissionTree"></div>

      
      <script type="text/javascript">
			//展示根节点
			function inintPermissionTree(callback){
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
					    			 $.tzConfirm({callback:function(ok){if(ok){$this.closest("li").remove();}}});},
					    			 onclick:function($obj,data){
					    				 //获取到选中的权限id
					    				 permissions = data.checkArr.opid;
					    			 }
				    	    });	
				    		 
				    	if(callback)callback();	 
				    },
				    error:function(){
				    	loading("服务器出现错误",2);
				    }
				});
			}
			
			//inintPermissionTree();//在ifram创建的时候进行初始化
		
			var permissions = "";
			
			function saveRolePermission(roleid,$dialog,opts){
				if(isEmpty(permissions)){
					loading("请至少选择一个权限进行操作!",2);
					return;
				}
				//进行权限的分配
				$.ajax({
					url:adminPath+"/role/saveRolePermission",
					type:"post",
					data:{roleid:roleid,permissions:permissions},
					success:function(data){
						if(data=="success"){
							parent.loading("权限分配成功...",2);
		 					$dialog.next().remove();//删除阴影层
		 					$dialog.remove();//删除ifram的弹窗
						}
					},
					error:function(){
						loading("服务器出现错误",2);
					}
				});
			}
			
	
	</script>
     
</body>
</html>
