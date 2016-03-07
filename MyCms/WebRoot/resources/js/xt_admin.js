$(function(){
	$(".tmui-tips").tmTip();	
});



//加载时候的loading 图标的初始化
function loading2(target, mark) {
	$.loading({
		target : $(target),
		mark : 1
	});
};


//分页初始化--加载数据--搜索数据
var xtAdmin = {
	//定义一个全局的定时器
	xttimer:null,
	//分页的总数作为参数传入
	initPage : function(itemCount) {
		$("#myfenye").tzPage(itemCount, {
			num_edge_entries : 1, //边缘页数
			num_display_entries : 4, //主体页数
			num_edge_entries : 4,
			current_page : 0,
			items_per_page : 10, //每页显示X项
			prev_text : "前一页",
			next_text : "后一页",
			callback : function(pageNo, psize) {
				//点击分页后执行的函数
				xtAdmin.loadData(pageNo,psize);
			}
		});
	},
	loadData : function(pageNo, pageSize,callback) {
	    var keywords = $("#keywords").val();
	    var model = $("#tbody").data("model");
	    var $this = this;
		$.ajax({
			url : adminPath + "/"+model+"/template",
			type : "post",
			data : {
				pageNo : pageNo * pageSize,
				pageSize : pageSize,
				keywords:keywords
			},
			beforeSend:function(){
				loading2($("#tbody"),4);
			},
			success : function(data) {
				//将对应的data转换成jquery的对象
				var $data = $(data);
				//讲模版对应的数据进行渲染加载
				$("#tbody").html($data);
				var itemCount = $data.find("#itemCount").val();
				if(isNotEmpty(keywords))$this.heightlight(keywords);
			    if(callback)callback(itemCount);
			},
			error : function() {
				loading("服务器出现错误", 3);
			}
		});

	},
	search:function(){
		var keywords = $("#keywords").val();
		if(isEmpty(keywords)){
			loading("请输入搜索关键字",3);
			 $("#keywords").focus();
			 return;
		}
		xtAdmin.loadData(0, 10,function(itemCount){
			xtAdmin.initPage(itemCount);
		});
	},
	op:function(obj){
		var $this = $(obj);
		var opid = $this.attr("opid");
		var mark = $this.attr("mark");
		var val = $this.attr("val");
		var model = $("#tbody").data("model");
		var parmas = {};
		parmas[mark] = val;
		parmas["id"] = opid;
		clearTimeout(this.xttimer);
		/*定时器start (防止用户恶意的点击)*/
		this.xttimer = setTimeout(function(){			
			//进行更新ajax执行的操作start
			$.ajax({		
				url:adminPath+"/"+model+"/update",
			    type:"post",
			    data:parmas,
			    success:function(data){
			      if(data=="success"){
			    	  //更改对应的状态(修改状态和字体的颜色)
			    	  $this.attr({opid:opid,val:val==0?1:0}).removeClass().addClass(val==0?"red":"green").text(val==0?"否":"是");
			    	  loading("执行操作成功",2);
			      }else{
			    	  loading("执行操作失败",3);
			      }
			    },
			    error:function(){
			    	loading("服务器出现错误",2);
			    }
			});
			//进行更新ajax执行的操作end
			
		},500);
	   /*定时器end(防止用户恶意的点击)*/
	},
	remove:function(obj){
		var $this = $(obj);
		var opid = $this.data("opid");
		var model = $("#tbody").data("model");
		var parmas =  {};
		parmas["id"] = opid;
		//进行提示
		$.tzConfirm({
			title:"删除提示",
			drag:false,
			content:"您确定删除此条记录吗？",
			callback:function(ok){
				if(ok){
					$.ajax({
						url:adminPath+"/"+model+"/delete",
						type:"post",
						data:parmas,
						success:function(data){
							if(data=="success"){
							  loading("删除成功",2);
							  $this.parents("tr").remove();
							}else{
								loading("执行删除操作失败",2);
							}
						},
						error:function(){
							loading("服务器出现错误",2);
						}
					});
				}
			}
			
		});
	},
	//关键字搜索高亮
	heightlight:function(keywords){
		//对搜索的关键字进行替换
		$("#tbody").find(".keys").each(function(){
			var text = $(this).text();
			//var nt = text.replace(keywords,"<span class='red'>"+keywords+"</span>");//只能替换一个，需要进行全局的替换
			var regex = new RegExp(keywords,"ig");//忽略大小写
			var nt = text.replace(regex,"<span class='red'>"+keywords+"</span>");
			$(this).html(nt);
		});
	}
};
