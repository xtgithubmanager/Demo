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
	<!-- 分页的js导入 -->
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
			<style type="text/css">
			  *{
			    margin:0px;
			    padding:0px;
			    font-size:12px;
			  }
               
               .box{
                 height:360px;
                 overflow:auto;
               }
               
			    #userbox li{
			     height:20px;
			     padding:5px;
			     border-bottom:1px dotted gray;
			     list-style:none;
			     line-height:20px;
              }
              
               #userbox li:hover{
                background:gray;
                color:#fff;
                cursor:pointer;
               }
              
               #userbox li .num{
                 dispaly:inline-block;
                 max-width:60px;
                 height:25px;
                 text-algin:right;
                 padding:0px 2px;
               }
              
             #userbox li .num .chek{
               position:relative;
               top:10px;
             }
              #userbox li.on{
               background:red;
               color:#fff;
              }
			</style>
	</head>
<body>
     <div class="box">
	     <ul id="userbox">
	      <c:forEach items="${users}" var="user"  varStatus="userIndex">      
	        <li>
	        <span class="num chek"><input type="checkbox" class="check" value="${user.id }"/></span>
	        <span class="num">${userIndex.count }:</span>
	           ${user.username}   745338417@qq.com
	        </li>
	      </c:forEach>
     </ul>
     </div>
      
      
      <script type="text/javascript">
      
         var tzUserRole = {
            //初始化用户的信息
            init:function(){
              	$("#userbox").find("li").on("click",function(){
              		$(this).toggleClass("on").find(".check").filter(function(){
              			$(this).prop("checked",!$(this).prop("checked"));
              		});
              	});
            },
            //保存用户角色信息
            save:function(roleId){
            	var arr = [];
            	var $check  = $("#userbox").find(".check:checked");
            	if($check.length == 0){
            		loading("当前您没有选择要分配的用户",2);
            		return;
            	}
            	$check.each(function(){
            		arr.push($(this).val());
            	});
            	var userstr = arr.toString(); 
            	$.ajax({
            		url:adminPath+"/role/saveUserRole",
            		type:"post",
            		data:{"rid":roleId,"userstr":userstr},
            		success:function(data){
            		  if(data=="success"){
            			  loading("角色分配成功",2);
            			  $check.parents("li").fadeOut("slow",function(){
            				  $(this).remove();
            			  });
            		  }
            		},
            		error:function(){
            			loading("服务器出错",2);
            		}
            	});
            }
         };
         //初始化对应的用户角色
         tzUserRole.init();
      </script>
     
</body>
</html>
