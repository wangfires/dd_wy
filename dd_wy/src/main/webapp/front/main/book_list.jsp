<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/list.css" rel="stylesheet" type="text/css" />
				<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
  			$(".aa").mouseover(function(e){
  				//1.获取当前的图片
  				var width = this.width * 1.5;
  				var height = this.height * 1.5;
  				//2.获取鼠标当前位置
  				var x = e.pageX;
  				var y = e.pageY;
  				//3.创建一个div
  				var div = $("<div id='bigDiv'/>").css({
  														"position":"absolute",
  														"display":"none",
  														"width":width,
  														"height":height,
  														"top":y + 10,
  														"left":x + 10,
  														"border":"1px solid red"
  													});
  				//4.创建一个img
  				var img = $("<img/>").css({
  											"width":width,
											"height":height,
  										}).attr({
  											"src":this.src
  										});
  				//5.将img放到div中
  				div.append(img);
  				//6.将div放到body中
  				$("body").append(div);
  				div.show(1000);
  			}).mousemove(function(e){
  				//1.获取鼠标当前位置
  				var x = e.pageX;
  				var y = e.pageY;
  				//改变div的位置
  				$("#bigDiv").css({
  									"top":y + 10,
  									"left":x + 10
  								});
  			}).mouseout(function(e){
				$("#bigDiv").remove();  			
  			});
  	});		
  		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/book/mainPage'>当当图书</a> &gt;&gt;
			
			<font style='color: #cc3300'><strong>${t.name }</strong> </font>
		<c:forEach var="type1" items="${ t.type1}">
		<c:if test="${type1.id eq id}">
		>><font style='color: #cc3300'><strong>${type1.name }</strong> </font>
		</c:if>
		</c:forEach>
		</div>

		<div class="book">

			<!--左栏开始-->
			
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
								
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath }/book/secondPage?id=${t.id}"/>&middot;全部&nbsp;( ${t.count})
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="type2" items="${t.type1 }">
							<li>
								<div>
									<div class="second_fenlei">
										&middot;
									</div>
									<c:if test="${id eq type2.id}">
									<div class="second_fenlei3">
										<a href="${pageContext.request.contextPath }/book/secondPage?id=${type2.id}">${type2.name }&nbsp;( ${type2.count})</a>
									</div>
									</c:if>
									<c:if test="${id ne  type2.id}">
									<div class="second_fenlei">
										<a href="${pageContext.request.contextPath }/book/secondPage?id=${type2.id}">${type2.name }&nbsp;( ${type2.count})</a>
									</div>
									</c:if>
								</div>
							</li>
						   
							<div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
							
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">
	
				<!--图书列表开始-->
				
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
							<c:choose>
							<c:when test="${id eq t.id}">
								<a name=link_page_next href="${pageContext.request.contextPath }/book/secondPage?id=${id}&page=${page-1}">
								</c:when>
								<c:otherwise>
								<a name=link_page_next href="${pageContext.request.contextPath }/book/secondPage?id=${id}&page=${page-1}">
								</c:otherwise>
								</c:choose> 
								<c:if test="${page ne 1 }">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
									</c:if>
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
							<c:if test="${page eq 1 }">
								<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
								</c:if>
							</div>
				
							<div class='list_r_title_text3b'>
							<c:choose>
							<c:when test="${count%3 ne 0 }">
								第${page}页/共 <fmt:formatNumber type="number" value="${(count-count%3)/3+1}" maxFractionDigits="0" pattern="#"/>页
								<c:set var="maxpage" scope="session" value="${(count-count%3)/3+1}"/>
								</c:when>
								<c:otherwise>
								第${page}页/共 <fmt:formatNumber type="number" value="${(count-count%3)/3}" maxFractionDigits="0" pattern="#"/>页
								<c:set var="maxpage"  scope="session" value="${(count-count%3)/3}"/>
								</c:otherwise>
								</c:choose>
							</div>
							
							<div class='list_r_title_text3a'>
							<c:choose>
							<c:when test="${page eq maxpage}">
							<c:if test="${id eq t.id }">
							<a name=link_page_next href="${pageContext.request.contextPath }/book/secondPage?id=${t.id}&page=${page}">
								</c:if>
								<c:if test="${id ne t.id }">
								<a name=link_page_next href="${pageContext.request.contextPath }/book/secondPage?id=${id}&page=${page}">
								</c:if>
								
								</c:when>
								<c:otherwise>
								<c:if test="${id eq t.id }">
									<a name="link_page_next" href="${pageContext.request.contextPath }/book/secondPage?id=${t.id}&page=${page+1}">
									</c:if>
									<c:if test="${id ne t.id }">
								<a name="link_page_next" href="${pageContext.request.contextPath }/book/secondPage?id=${id}&page=${page+1}">
								</c:if>
								</c:otherwise>
								
								</c:choose>
								<c:if test="${page ne maxpage }">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
									</c:if>
								</a>
							</div>
			
							<div class='list_r_title_text3a'>
							<c:if test="${page eq maxpage }">
								<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />
								</c:if>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<c:forEach var="book" items="${list }">
							<div class="list_r_list">
							
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath}/book/detail?book.id=${book.id}'>
										<img class="aa" src="${pageContext.request.contextPath}/book/download?coverFileName=${book.cover}" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='#'>${book.name }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${book.author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${book.press }</a>
								</h4>
								<h4>
								
									出版时间：<fmt:formatDate value="${book.pressDate }" pattern="yyyy-MM-dd "/>
								</h4>
								<h5>
									${book.contentAbstract }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${book.price }</span>
									<span class="red">￥${book.dprice }</span>
									节省：￥${book.price-book.dprice }
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath}/cart/addCart?bookId=${book.id}"> 
									<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
								
							</div>
							</c:forEach>
						<div class="clear"></div>
		
						
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
