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
	<!-- 引入对应统计报表的js -->
	<script src="${basePath}/resources/js/echart/echarts1.js"></script>
 </head>
 <body>
	

	<div class="wrap">
		 <%@include file="/WEB-INF/pages/common/left.jsp"%>

		<div class="content">
			<div class="header">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎逗逗来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/loginout"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
				</div>
			</div>
			<div class="channel"> 位置 > 日志管理</div>
			<div class="cnt">
				<div class="tabwrap">
						<select onchange="">
						  <option>请选择年份</option>
						  <c:forEach begin="2010" end="2020" var="year">
						      <option value="${year}">${year}</option>
						  </c:forEach>
						</select>
						<!-- 显示对应的统计图形的位置 -->
						    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
					    <div id="main" style="width:1200px;height:400px;"></div>
				</div>
			</div>

		</div>
	
	</div>


	<script type="text/javascript">
		$(function(){
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
    
    <script type="text/javascript">  
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
    	    title : {
    	        text: '用户日志统计',
    	        subtext: '年/月'
    	    },
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data:['意向']
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            boundaryGap : false,
    	            data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'用户总数',
    	            type:'line',
    	            smooth:true,
    	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
    	            data:[10, 12, 21, 54, 260, 830, 710,100,200,400,450,700]
    	        }
    	    ]
    	};
    	                    
    
     myChart.setOption(option);
    </script>
      
 </body>
</html>
