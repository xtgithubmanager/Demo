<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>后台cms主页</title>
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<style type="text/css">
		select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input, .label, .dropdown-menu, .btn, .well, .progress, .table-bordered, .btn-group > .btn:first-child, .btn-group > .btn:last-child, .btn-group > .btn:last-child, .btn-group > .dropdown-toggle, .alert{ border-radius:0px;}
		.btn, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input{ box-shadow:none;}
		.progress, .progress-success .bar, .progress .bar-success, .progress-warning .bar, .progress .bar-warning, .progress-danger .bar, .progress .bar-danger, .progress-info .bar, .progress .bar-info, .btn, .btn-primary{background-image:none;}
		.accordion-heading h5{ width:70%; }
		.label-important, .badge-important{ background:#f74d4d;}
		/*Metro Background color class*/
		.bg_lb{ background:#27a9e3;}
		.bg_db{ background:#2295c9;}
		.bg_lg{ background:#28b779;}
		.bg_dg{ background:#28b779;}
		.bg_ly{ background:#ffb848;}
		.bg_dy{ background:#da9628;}
		.bg_ls{ background:#2255a4;}
		.bg_lo{ background:#da542e;}
		.bg_lr{ background:#f74d4d;}
		.bg_lv{ background:#603bbc;}
		.bg_lh{ background:#b6b3b3;}
	
		body { background:radial-gradient(circle,#2E363F,#28B779) repeat-y; background-size:cover;  padding: 0;    margin-top:10%;}
		#logo, #loginbox {width: 32%; min-width:280px;  margin-left: auto;    margin-right: auto;    position: relative;}
		#logo img {  margin: 0 auto;    display: block;}
		#loginbox { overflow: hidden !important;    text-align: left;    position: relative; }
		#loginbox form{ position:relative; top:0; left:0; }
		#loginbox .form-actions { padding: 14px 20px 15px;}
		#loginbox .form-actions .pull-left { margin-top:0px;}
		#loginbox form#loginform { z-index: 200; display:block;}
		#loginbox form#recoverform { z-index: 100;     display:none;}
		#loginbox form#recoverform .form-actions {    margin-top: 10px;}
		#loginbox .main_input_box { margin:0 auto; text-align:center; font-size:13px;}
		#loginbox .main_input_box .add-on{  padding:9px 9px; *line-height:31px; color:#fff;  width:30px; display:inline-block;}
		#loginbox .main_input_box input{ height:42px; border:0px; display:inline-block; width:75%; line-height:42px;  margin-bottom:3px;padding-left:6px;}
		#loginbox .controls{ padding:0 20px;}
		#loginbox .control-group{ padding:20px 0; margin-bottom:0px;}
		.form-vertical, .form-actions {  margin-bottom: 0; background:none; text-align:center}
		#loginbox .normal_text{ padding:15px 10px; text-align:center; font-size:14px; line-height:20px;  color:#fff; }
		
	.btn {
	    display: inline-block;
	    padding: 4px 12px;
	    margin-bottom: 0;
	    font-size: 14px;
	    line-height: 20px;
	    color: #333;
	    text-align: center;
	    text-shadow: 0 1px 1px rgba(255,255,255,0.75);
	    vertical-align: middle;
	    cursor: pointer;
	    background-color: #f5f5f5;
	    background-image: -moz-linear-gradient(top, #fff, #e6e6e6);
	    background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#fff), to(#e6e6e6));
	    background-image: -webkit-linear-gradient(top, #fff, #e6e6e6);
	    background-image: -o-linear-gradient(top, #fff, #e6e6e6);
	    background-image: linear-gradient(to bottom, #fff, #e6e6e6);
	    background-repeat: repeat-x;
	    border: 1px solid #ccc;
	    border-color: #e6e6e6 #e6e6e6 #bfbfbf;
	    border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);
	    border-bottom-color: #b3b3b3;
	    -webkit-border-radius: 4px;
	    -moz-border-radius: 4px;
	    border-radius: 4px;
	    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);
	    filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
	    -webkit-box-shadow: inset 0 1px 0 rgba(255,255,255,0.2), 0 1px 2px rgba(0,0,0,0.05);
	    -moz-box-shadow: inset 0 1px 0 rgba(255,255,255,0.2), 0 1px 2px rgba(0,0,0,0.05);
	    box-shadow: inset 0 1px 0 rgba(255,255,255,0.2), 0 1px 2px rgba(0,0,0,0.05);
	}
	
	.btn-success {
	    color: #fff;
		padding:6px 40%;
	    text-shadow: 0 -1px 0 rgba(0,0,0,0.25);
	    background-color: #5bb75b;
	    background-image: -moz-linear-gradient(top, #62c462, #51a351);
	    background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#62c462), to(#51a351));
	    background-image: -webkit-linear-gradient(top, #62c462, #51a351);
	    background-image: -o-linear-gradient(top, #62c462, #51a351);
	    background-image: linear-gradient(to bottom, #62c462, #51a351);
	    background-repeat: repeat-x;
	    border-color: #51a351 #51a351 #387038;
	    border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);
	    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff62c462', endColorstr='#ff51a351', GradientType=0);
	    filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
	}
	</style>
  </head>
  <body>
  
  	<div id="loginbox">
		<form id="loginform" action="" method="post">
			<div class="normal_text"> <h3><img src="${basePath}/resources/images/logo.png" alt="Logo">管理后台</h3></div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_lg"><i class="fa fa-user"></i></span><input type="text" id="account" autocomplete="off" autofocus="autofocus" maxlength="60" placeholder="请输入账号...">
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly"><i class="fa fa-lock"></i></span><input type="password" id="password" autocomplete="off" placeholder="请输入密码...">
					</div>
				</div>
			</div>
			
			<div class="control-group" id="kcode" style="display:none;">
				<div class="controls">
					<div class="main_input_box" style="position:relative;">
						<span class="add-on bg_ly"><i class="fa fa-lock"></i></span><input type="text" id="code" autocomplete="off" placeholder="请输入验证码...">
						<img alt="验证码" src="${basePath}/kaptcha/code" onclick="this.src=basePath+'/kaptcha/code?d='+new Date().getTime;" style="position:absolute;right:30px;top:1px;cursor: pointer;">
					</div>
				</div>
			</div>
			<div class="form-actions">
				<span><a  href="javascript:void(0);" onclick="xt_login(this)" class="btn btn-success">登陆</a></span>
			</div>
		</form>
	</div>
	  <script type="text/javascript">
	 	 $(function(){
	 		$(document).keydown(function(e){
	 			if(e.keyCode == 13){ 
	 				//调用进行登录的函数
	 				xt_login();
	 			}
	 		});
	 		$("#account").keyup(function(){
				tzMap.put("xt_admin_account",$(this).val(),1);	 			
	 		});
	 		
	 		var username = tzMap.get("xt_admin_account",1);
	 		if(username)$("#account").val(username);
	 		
	  	});
	 	 
	 	 //处理用户登录
	 	        var codeindex = 0;
				function xt_login(obj) {
					var account = $("#account").val();
					var password = $("#password").val();
					var code = $("#code").val();
					var codemark = $("#kcode").is(":hidden");
					if(isEmpty(account)){
						loading("请输入帐号",2);
						$("#account").focus();
						return;
					}				
					if(isEmpty(password)){
						alert(2);
						loading("请输入密码",2);
						$("#password").focus();
						return;
					} 
					if(codeindex == 3){
						$("#kcode").show();
					}
					
					//验证码框显示的时候需要对验证码进行判断  只对为空进行判断，还需要对验证码是否正确进行相应的判断 
					if(!codemark){
						if(isEmpty(code)){
							loading("验证码不能为空",2);
							$("#code").focus();
							return;
						}					
					}	
					
					var parmas = {
						account : account,
						password : password,
						code:code,	
					};

					$.ajax({
						url : basePath+"/logined",
						type : "post",
						data : parmas,
						success : function(data) {
							if(data == "error" || data == "null"){
								 loading("请填写帐号和密码",2);
								 $("#password").val("");
								 $("#account").select();
								 codeindex++;	
							}else if(data == "fail"){
								loading("请输入正确的帐号和密码",2);
								 $("#password").val("");
								 $("#account").select();
								 codeindex++;	
							}else if(data == "code_error"){
								loading("请输入正确的验证码",2); 
								$("#code").val("").focus();
								return;
							}else{
								var rer = document.referrer;
								window.location.href = isNotEmpty(rer)?rer:basePath+"/index";
							}
						},
						error : function() {
							 loading("访问服务器出错..",2);
						}
					});
				}
			</script>
  </body>
</html>
