<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="slider">
			<div class="logo">
				<a href="#"><img src="${basePath}/resources/images/logo.png"/></a>
			</div>
			<div class="nav">

		  <ul>

			<c:choose>
				<c:when
					test="${xt:indexOf(pageContext.request.requestURI,'content/list')!=-1}">
					<li class="items  active"><a href="javascript:void(0)"><i
							class="fa fa-home"></i>内容管理</a></li>
				</c:when>
				<c:otherwise>
					<li class="items"><a href="${adminPath }/content/list"><i
							class="fa fa-home"></i>内容管理</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${xt:indexOf(pageContext.request.requestURI,'user/list')!=-1}">
					<li class="items  active"><a href="javascript:void(0)"><i
							class="fa fa-home"></i>用户管理</a></li>
				</c:when>
				<c:otherwise>
					<li class="items"><a href="${adminPath }/user/list"><i
							class="fa fa-home"></i>用户管理</a></li>
				</c:otherwise>
			</c:choose>
			
			
		  <c:choose>
				<c:when
					test="${xt:indexOf(pageContext.request.requestURI,'permission/list')!=-1}">
					<li class="items  active"><a href="javascript:void(0)"><i
							class="fa fa-home"></i>权限管理</a></li>
				</c:when>
				<c:otherwise>
					<li class="items"><a href="${adminPath }/permission/list"><i
							class="fa fa-home"></i>权限管理</a></li>
				</c:otherwise>
			</c:choose>
			
			
			  <c:choose>
				<c:when
					test="${xt:indexOf(pageContext.request.requestURI,'role/list')!=-1}">
					<li class="items  active"><a href="javascript:void(0)"><i
							class="fa fa-home"></i>角色管理</a></li>
				</c:when>
				<c:otherwise>
					<li class="items"><a href="${adminPath }/role/list"><i
							class="fa fa-home"></i>角色管理</a></li>
				</c:otherwise>
			</c:choose>

            
            
      
		  <c:choose>
		    <c:when test="${xt:indexOf(pageContext.request.requestURI,'stat')!=-1}">
		     	<li class="items"><a href="javascript:void(0);"><i class="fa fa-home "></i>日记统计</a>
			   
				<ul style="display:block">
					<c:choose>
						<c:when
							test="${xt:indexOf(pageContext.request.requestURI,'stat/list')!=-1}">
							<li class="citems active"><a href="javascript:void(0);"><i
									class="fa fa-inbox"></i>内容日志</a></li>
						</c:when>
						<c:otherwise>
							<li class="items"><a href="${adminPath }/stat/list"><i
									class="fa fa-home"></i>内容日志</a></li>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when
							test="${xt:indexOf(pageContext.request.requestURI,'stat/userlist')!=-1}">
							<li class="citems active"><a href="javascript:void(0);"><i
									class="fa fa-inbox"></i>用户日志</a></li>
						</c:when>
						<c:otherwise>
							<li class="items"><a href="${adminPath }/stat/userlist"><i
									class="fa fa-home"></i>用户日志</a></li>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when
							test="${xt:indexOf(pageContext.request.requestURI,'stat/loginlist')!=-1}">
							<li class="citems active"><a href="javascript:void(0);"><i
							class="fa fa-inbox"></i>登录日志</a></li>
						</c:when>
						<c:otherwise>
							<li class="items"><a href="${adminPath }/stat/userlist"><i
									class="fa fa-home"></i>登录日志</a></li>
						</c:otherwise>
					</c:choose>
			
				</ul> 
				<span class="numicon c5">3</span>
			</li>
		    </c:when>
		    
		    <c:otherwise>
		       	<li class="items"><a href="${adminPath }/stat/list"><i class="fa fa-home "></i>日志统计</a></li>
		    </c:otherwise>
		  </c:choose>
    
    
          
		

			<c:choose>
				<c:when
					test="${xt:indexOf(pageContext.request.requestURI,'gather/list')!=-1}">
					<li class="items  active"><a href="javascript:void(0)"><i
							class="fa fa-home"></i>爬虫管理</a></li>
				</c:when>
				<c:otherwise>
					<li class="items"><a href="${adminPath }/gather/list"><i
							class="fa fa-home"></i>爬虫管理</a></li>
				</c:otherwise>
			</c:choose>
			
		   	<c:choose>
				<c:when
					test="${xt:indexOf(pageContext.request.requestURI,'music/list')!=-1}">
					<li class="items  active"><a href="javascript:void(0)"><i
							class="fa fa-home"></i>音乐管理</a></li>
				</c:when>
				<c:otherwise>
					<li class="items"><a href="${adminPath }/music/list"><i
							class="fa fa-home"></i>音乐管理</a></li>
				</c:otherwise>
			</c:choose>

			<li class="items"><a href="javascript:void(0);"><i
					class="fa fa-th-list"></i>表单</a>
				<ul>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-inbox"></i>区块</a></li>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-th"></i>表格</a></li>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-send"></i>其他</a></li>
				</ul> <span class="numicon c5">3</span>
				
			</li>
			<li class="items"><a href="javascript:void(0);"><i
					class="fa fa-tint"></i>按钮组</a>
				<ul>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-inbox"></i>区块</a></li>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-th"></i>表格</a></li>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-send"></i>其他</a></li>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-th"></i>表格</a></li>
					<li class="citems"><a href="javascript:void(0);"><i
							class="fa fa-send"></i>其他</a></li>
				</ul> <span class="numicon c1">5</span></li>
			<li class="items"><a href="javascript:void(0);"><i
					class="fa fa-pencil"></i>元素</a></li>
			<li class="items"><a href="javascript:void(0);"><i
					class="fa fa-star"></i>Addons 5</a></li>
			<li class="items"><a href="javascript:void(0);"><i
					class="fa fa-file-o"></i>Error</a></li>
		</ul>
	</div>
		</div>