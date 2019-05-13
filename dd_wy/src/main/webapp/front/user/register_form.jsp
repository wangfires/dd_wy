<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		

<script type="text/javascript">

/**
 * 使用jquery在前台页面验证邮箱输入是否正确
 */
$(function(){
	$("#txtEmail").blur(function(){
		if(!$("#txtEmail").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
			
        var m="邮箱格式不正确，请重新输入";
        //获取id为#emailInfo的标签对象，并向jquery对象中写入
        $("#emailInfo").html("<font style='color:red;'>"+m+"</font>");
        return false;
    } else {
                var m = "邮箱格式正确";
                  $("#emailInfo").html("<font style='color:red;'>"+m+"</font>");
        }
	});
	$("#txtNickName").blur(function(){
	
	if(	$("#txtNickName").val().length >= 4 && $("#txtNickName").val().length<=20){
	var n="昵称长度合适";
	 $("#nameInfo").html("<font style='color:green;'>"+n+"</font>");
	 
	}else{
		var n="昵称长度不符合要求，请重新输入";
	 $("#nameInfo").html("<font style='color:red;'>"+n+"</font>");
	 return false;
	}
	});
	$("#txtPassword").blur(function(){

	if($("#txtPassword").val().length>=6 &&$("#txtPassword").val().length<=20){
		var p = "密码长度符合规范";
		 $("#passwordInfo").html("<font style='color:green;'>"+p+"</font>");
		 
	}else{
	var p = "密码长不度符合规范";
		 $("#passwordInfo").html("<font style='color:red;'>"+p+"</font>");
		 return false;
	}
	});
	$("#txtRepeatPass").blur(function(){
	
	if($("#txtPassword").val()==$("#txtRepeatPass").val()){
		var p1="与原密码相同";
		 $("#password1Info").html("<font style='color:green;'>"+p1+"</font>");
	}else{
	var p1="与原密码不相同，请重新输入！！";
	 $("#password1Info").html("<font style='color:red;'>"+p1+"</font>");
	}
	});
	
});

</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息></span>  2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath }/user/regist" id="f" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email"  type="text" id="txtEmail" class="text_input"/>
							
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname"  type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" class="text_input"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath }/user/getImage" />
							<input name="code" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="#" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

