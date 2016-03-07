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
    <!-- 分页的js导入 -->
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
 </head>
 <body>
	

	<div class="wrap">
	     <%@include file="/WEB-INF/pages/common/left.jsp"%>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp"%>
			<div class="channel"> 当前位置 > 用户角色</div>
			<div class="cnt">
				<div class="tabwrap">
					
					<!--表格-->
					<table class="tztab">
						<caption>
							2015年度一周统计报表数据
							<div class="fr sbtn">
								<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
							</div>
						</caption>
						<!--头部
						<colgroup id="days">
							<col/>
							<col style="background:green;width:200px;"/>
							<col id="t"/>
						</colgroup>-->
						<thead>
							<tr>
								<th>编号 <span class="up"></span> <span class="down"></span></th>	
								<th>名称</th>	
								<th>角色id</th>	
								<th>创建时间</th>	
								<th>角色状态</th>	
								<th>角色描述</th>
								<th>删除状态</th>
								<th>分配</th>
								<th>授权</th>
								<th>删除状态</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody"  data-model="role">
							
						</tbody>
					</table>
				</div>
					<span class="numicon c1">1</span>
					<span class="numicon c2">2</span>
					<span class="numicon c3">3</span>
					<span class="numicon c4">4</span>
					<span class="numicon c5">5</span>
					<span class="numicon c6">6</span>
			</div>

		</div>
	
	</div>


	<script type="text/javascript">
	   //权限角色处理的模块
	   var xtRole = {
			user:function(obj){
				var $obj = $(obj);
				var roleId = $obj.data("opid");
				//进行权限的分配
				$.tzIframe({drag:false,width:320,height:400,title:"用户分配角色",content:adminPath+"/role/user/"+roleId,
					callback:function(iframe,$dialog){
						if(iframe){
							iframe.tzUserRole.save(roleId);
						}
					}
				
				});
			},
			permission:function(obj){	
				var $obj = $(obj);
				var roleid = $obj.data("opid");
				$.tzIframe({drag:false,width:320,height:400,title:"用户权限的分配",content:adminPath+"/role/permission/",
					callback:function(iframe,$dialog,opts){
						//点确定的时候触发的事件
						if(iframe){
							iframe.saveRolePermission(roleid,$dialog,opts);
						}
					},loadSuccess:function(iframe){
						//存在的权限进行选中
						iframe.inintPermissionTree(function(){
							//查询该角色已选中的权限
							$.ajax({
								url:adminPath+"/role/findPermissionIds",
								type:"post",
								data:{roleid:roleid},
								success:function(data){
									var len = data.length;
									for(var i = 0; i<len; i++){
										$(iframe.document).find("body").find(".tm-tree-checkbox[opid="+data[i].permission_id+"]").addClass("tm-tree-checkbox-checked");
									}
								},
								error:function(){
									loading("服务器出现错误!",2);
									return;
								}
							});
						});
					}
				
				});
				
			}
	   };
		$(function(){
			  //进入主页第一次初始化数据 
			xtAdmin.loadData(0, 10,function(itemCount){
				xtAdmin.initPage(itemCount);
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
