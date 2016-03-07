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
	<script src="${basePath}/resources/js/echart/echarts.js"></script>
 </head>
 <body>
	

	<div class="wrap">
		 <%@include file="/WEB-INF/pages/common/left.jsp"%>

		<div class="content">
			 <%@include file="/WEB-INF/pages/common/header.jsp"%>
			<div class="channel"> 位置 >日志管理</div>
			<div class="cnt">
				<div class="tabwrap">
						<select onchange="loadStatDate(this.value)">
						  <option>请选择年份</option>
						  <c:forEach begin="2010" end="2020" var="year">
						      <option value="${year}">${year}</option>
						  </c:forEach>
						</select>
						<!-- 显示对应的统计图形的位置 -->
						    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
					    <div id="main" style="width:1200px;height:400px;"></div>
					    
					    
				<!--展示月份数据表格start-->
				<table class="tztab">
					  <thead>
							<tr>
								<th>主键</th>
								<th>标题 <span class="up"></span> <span class="down"></span></th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody">
							<tr>
								<td id="loading" colspan="50">还未查询显示统计数据</td>
							</tr>
						</tbody>
					</table>
				<div id="myfenye" class="myfenye"></div>
				<!-- 展示月份数据表格end -->
				
				
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
        
        $(function(){
        	loadStatDate(new Date().getFullYear());
        });
         
        //调用总查询的图 
         function loadStatDate(year){
	         $.ajax({
	        	  url:adminPath+"/MyStat/list",
	        	  type:"POST",
	        	  data:{year:year},
	        	  success:function(data){
	        		  var json ={
	        		        	 title:"mycms后台日志管理统计",
	        		        	 datas: getArr(data)
	        		        } ;
	        		  //开始初始化条形统计图
	        		  ininTxt("main",json);
	        	  },
	        	  error:function(){
	        		  loading("统计的数据出现错误",2);
	        	  }
	         });
          
         }
         
        
        //转换数据格式
        function getArr(jsonArr){
	   		 var jsonObj = {};
	   		 for(var key in jsonArr){
	   			var num = jsonArr[key].num;
	   			var m = jsonArr[key].m; 
	   			jsonObj["s"+parseInt(m)] = num;
	   		 }
	   		 var arr = [];
	   		 
	   		 for(var i = 1; i<=12; i++){
	   			 arr.push(jsonObj["s"+i]||0);
	   		 }
	   		 return arr;
   	    }
        
      
        //通过模块的模式进行初始化
        function ininTxt(main,json){
			require.config({
	            paths: {
	                echarts: basePath+'/resources/js/echart'
	            }
	        });
	        require(
	            [
	                'echarts',
	                'echarts/chart/bar',
					'echarts/chart/pie'
	            ],
	           function (ec) {
	                var myChart = ec.init(document.getElementById(main));
	                var option  = {
						    title : {
						    	x: "center",
						        text: json.title,
						        subtext: "月份/总数"
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						   
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {show: true, type: ['line', 'bar']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    
						    calculable : true,
						    xAxis : [
						        {
						            type : 'category',
						            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'访问人数',
						            type:'bar',
						            data:json.datas,
						            markPoint : {
						                data : [
						                    {type : 'max', name: '最大值'},
						                    {type : 'min', name: '最小值'}
						                ]
						            },
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
					myChart.setOption(option);
					var ecConfig = require('echarts/config');
					myChart.on(ecConfig.EVENT.CLICK, eConsole);
	            }
	        );
	}
		
	
	function eConsole(da) {
		//获取用户点击的数据
		var month = parseInt(da.name);
		//var sort = document.getElementById("sort").value||"desc";	
		var parmas = {
			month:month,
		    pageNo:0,
		    pageSize:1,
		};
		loadDataByMonth(parmas,function(itemCount){
			pageData(parmas,itemCount);
		});
	}
	
	//初始化数据
	function loadDataByMonth(parmas,callback){
		$.ajax({
			url:adminPath+"/MyStat/contentlist",
			type:"post",
			data:parmas,
			beforeSend:function(){
				loading("请稍后数据正在加载",1);
			},
			success:function(data){
				var len = data.length-1;
 				var itemCount = data[len].ccount;
 				var html="";
 				for(var i=0;i<len;i++){
 					html+="<tr>"+
 					"	<td>"+data[i].id+"</td>"+
 					"	<td>"+data[i].title+"</td>"+
 					"	<td>"+data[i].create_time+"</td>"+
 					"	<td>操作</td>"+
 					"</tr>";
 				}
 				$("#tbody").html(html);
 				if(callback)callback(itemCount);
			},
			error:function(){
				loading("服务器出现对应的错误",3);
			}
		});
	}
	
	//分页进行初始化
	function pageData(parmas,itemCount){
		var m = parmas.month;
		$("#myfenye").tzPage(itemCount, {
			num_edge_entries : 1, //边缘页数
			num_display_entries : 4, //主体页数
			num_edge_entries : 4,
			current_page : 0,
			items_per_page :1, //每页显示X项
			prev_text : "前一页",
			next_text : "后一页",
			callback : function(pageNo, psize) {
				var parmas1 = {
						month:m,
					    pageNo:pageNo*psize,
					    pageSize:psize,
					};	
				loadDataByMonth(parmas1);
			}
		});
	}

    </script>
 </body>
</html>
