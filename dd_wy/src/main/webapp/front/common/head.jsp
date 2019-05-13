<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath }/front/css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> 
				<span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的当当</a> | 
					<a href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>| 
				</span> 
			</span>
			<div class="cart gray4012">
				<a href="${pageContext.request.contextPath }/front/cart/cart_list.jsp">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>您好${User.nickname }，欢迎光临当当网</b>
		[&nbsp;<a href="${pageContext.request.contextPath }/user/logout" class="b">登出</a>&nbsp;]
		<c:if test="${empty User  }">
		[&nbsp;<a href="${pageContext.request.contextPath }/front/user/login_form.jsp" class="b">登录</a>|
		<a href="${pageContext.request.contextPath }/front/user/register_form.jsp" class="b">注册</a>&nbsp;]
		</c:if>
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo">
				<a href="#" name="backtobook">
					<img src="${pageContext.request.contextPath }/front/images/booksaleimg/book_logo.gif" /> 
				</a> 
			</span>
		</div>
		<div class="head_head_list_right">
			<div class="head_head_list_right_b"></div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
