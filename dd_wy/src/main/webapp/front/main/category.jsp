<%@page contentType="text/html;charset=utf-8" isErrorPage="false" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
<c:forEach var="type1" items="${type }">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath }/book/secondPage?id=${type1.id}'>${type1.name }</a>]
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
						<c:forEach var="type2" items="${type1.type1 }">
						<li>
							<a href='${pageContext.request.contextPath }/book/secondPage?id=${type2.id}'>${type2.name }</a>
						</li>
						</c:forEach>
						<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		<!--1级分类结束-->
		</c:forEach>
		

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
