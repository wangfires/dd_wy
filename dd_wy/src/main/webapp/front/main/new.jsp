<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach var="book" items="${news }">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/book/detail?book.id=${book.id}" target='_blank'>
				<img class="aa" src="${pageContext.request.contextPath}/book/download?coverFileName=${book.cover}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">${book.name }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：${book.price }
		</div>
		<div class="price">
			当当价：${book.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${book.sale }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</c:forEach>
</div>

<div class="clear"></div>