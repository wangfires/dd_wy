<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
  <head>
    <title>menu.html</title>	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
   	<style>
   		.aa{
   			height: 32px;
   			line-height:32px;
   			margin:0 auto;
   			width:150px;
   			margin-bottom:12px;
   			border:1px solid #b3d8ff;
			background: #ecf5ff;
   			border-radius:6px;
   		}
   		.aa a{
   			color:#409eff;
   		}
    </style>
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".aa").click(function(){
				$(".aa").css({"background":"#ecf5ff","border-color":"#b3d8ff"});
				$(".aa a").css("color","#409eff");
				$(this).css({"background": "#409eff","border-color": "#409eff"});
				$(this).children("a").css("color","#fff");			
			});
		});
	</script>
    
  </head>
  
  <body style="text-align: center;background-color: #d4e7f0">  <!-- #f0f9fd -->
  	
   	<h4>系统主菜单</h4><hr/><br/>
   	<div style="text-align: center" class="div1">
   		<div class="aa">
			<a style="text-decoration: none;" href="${pageContext.request.contextPath }/type/showAll" target="Homepage">类别管理</a><br/><br/>
		</div>
		<div class="aa">
  			<a style="text-decoration: none;" href="${pageContext.request.contextPath }/book/showAll"  target="Homepage">图书管理</a><br/><br/>
  		</div>
  		<div class="aa">
  			<a style="text-decoration: none;" href="${pageContext.request.contextPath }/order/showAll"  target="Homepage">订单管理</a><br/><br/>
  		</div>
  		<div class="aa">
  			<a style="text-decoration: none;" href="${pageContext.request.contextPath }/user/showAll" target="Homepage">用户管理</a><br/><br/>
  		</div>
  	</div>
  </body>
</html>
