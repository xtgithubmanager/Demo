<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>ͼƬ�ü�����������</title>
<meta name="Keywords" content="�ؼ��ʣ��ؼ���">
<meta name="description" content="">

<!--��ʽ��-->
<style type="text/css">
img {
	border: 1px;
}

.cut {
	width: 1024px;
	height: 645px;
	background: blue;
	margin: 0 auto;
	margin-top: 100px;
}

.formdiv {
	margin: 0 0 0 580px;
	border: 1px;
	background-color: #FAFAD2;
	width: 600px;
}
</style>
<!--���òü����ߵ�js-->
<link rel="stylesheet" type="text/css" href="css/jquery.Jcrop.css" />
</head>

<body>
	<!--ҳ��ı�д-->
	<div class="cut">
	
		<img id="cutImg" src="images/complex.jpg" alt="�ü�ͼƬ" width="1024px" height="645px"></img>
		
	</div>

	<div class="formdiv">

		<form action="success.jsp" method="post">
			<input type="text" name="cutImg" value="images/complex.jpg" /> x:<input
				type="text" id="x1" size="4" name="x"> y:<input type="text"
				id="y1" size="4" name="y"> h:<input type="text" id="w"
				size="4" name="w"> w:<input type="text" id="h" size="4"
				name="h"> <input type="submit" value="ȷ�ϲü�" />
		</form>

	</div>
	<!--����jquery�ٷ�js-->
			<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
			<script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
			<script type="text/javascript">
				$(function() {
					$("#cutImg").Jcrop({
						onChange:showCoords,//��ȡѡ�е�ֵ
						onSelect:showCoords//��ק		
					}
					);
				});
				
				function showCoords(c){
					$("#x1").val(parseInt(c.x));
					$("#y1").val(parseFloat(c.y));
					$("#w").val(parseFloat(c.w));
					$("#h").val(parseFloat(c.h));
				}
			</script>
</body>
</html>