<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css">
	<link rel="stylesheet" href="css/login.css" type="text/css">
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript" src="script/jquery.validate.js"></script>
	<style>
		label.error{
			padding-left: 16px;
			padding-bottom: 2px;
			font-weight: bold;
			color: #EA5200;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			//点击更换验证码：
			// $("#captchaImage").click(function(){//点击更换验证码
            //     //点击更换验证码
			// });
            $.validator.setDefaults({
                submitHandler: function() {
                    //表单的异步提交
					var data=$("#loginForm").serialize();
					$.ajax({
						type:"post",
						url:"/manager/login",
						data:data,
						dataType:"json",
						success:function (result) {
						    if(result.perror==null&&result.nerror==null){
                                window.location.href = '/back/main.jsp';
							}else{
                                $("#nerror").text(result.nerror);
                                $("#perror").text(result.perror);
							}
                        }
					})
                }
            });
			// 表单验证
			$().ready(function () {
				$("#loginForm").validate({
					rules:{
					    username:{required:true},
					    password:{required:true},
						code:{
					        required:true,
							remote:{
					            url:"/code/checkcode",
								type:"post",
								dataType:"json",
								data:{
					                code:function () {
										return $("#code").val();
                                    }
								}
							}
						}
					},
					messages:{
					    username:{
					        required:"请输入用户名"
						},
						password:{
					        required:"请输入密码"
						},
						code:{
					        required:"验证码不能为空",
							remote:"验证码错误"
						}
					}
				})
            })
		});
	</script>
</head>
<body>
		<div class="login">
			<form id="loginForm" action="" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								<label for="username">用户名</label>
							</th>
							<td>
								<input type="text" id="username" name="username"  maxlength="20" data-tip="请输入您的邮箱" />
								<span id="nerror"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								<label for="password">密&nbsp;&nbsp;&nbsp;码:</label>
							</th>
							<td>
								<input type="password" id="password" name="password"  maxlength="20" autocomplete="off"/>
								<span id="perror"></span>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th><label for="code">验证码</label></th>
							<td>
								<input type="text" id="code" name="code"  maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="/code/showcode" onclick="this.src='/code/showcode?'+Math.random()" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
				</div>
			</form>
		</div>
</body>
</html>