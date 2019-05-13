<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${pageContext.request.contextPath}/book/update" method="post" enctype="multipart/form-data">
			<table>
			
				<tr>
					
					<td>名称：</td>
					<input type="hidden" name="book.id" class="el-input__inner" value="${book.id }">
					<td><input type="text" name="book.name" class="el-input__inner" value="${book.name }"></td>
				
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="book.pageNum" class="el-input__inner" value="${book.pageNum }" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="book.typeId" class="el-select__inner inner2">
						<c:forEach var="t" items="${type }">
						<c:choose>
						<c:when test="${book.typeId eq t.id }">
						<option value="${t.id }" selected="selected">${t.name }</option>
						
						</c:when>
						<c:otherwise>
						<option value="${t.id }">${t.name }</option>
						</c:otherwise>
						</c:choose>
							
							
							
						
							</c:forEach>
							
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="book.wordNum" class="el-input__inner" value="${book.wordNum }" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="book.price" class="el-input__inner" value="${book.price }"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${pageContext.request.contextPath}/book/download?coverFileName=${book.cover}" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="cover" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="book.dprice" class="el-input__inner" value="${book.dprice }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="book.stock" class="el-input__inner" value="${book.stock }"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="book.author" class="el-input__inner" value="${book.author }"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.editorRecommend">${book.editorRecommend }</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="book.press" class="el-input__inner" value="${book.press}"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="book.pressDate" class="el-input__inner" value='<fmt:formatDate value="${book.pressDate }" pattern="yyyy-MM-dd"/>'></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.contentAbstract" >${book.contentAbstract }</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="book.edition" class="el-input__inner" value="${book.edition }"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="book.printDate" class="el-input__inner" value='<fmt:formatDate value="${book.printDate }" pattern="yyyy-MM-dd"/>'></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.authorAbstract">${book.authorAbstract }</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="book.impression" class="el-input__inner" value="${book.impression }"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="book.isbn" class="el-input__inner" value="${book.isbn }"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.director" >${book.director }</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="book.sizes" class="el-input__inner" value="${book.sizes }"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="book.paper" class="el-input__inner" value="${book.paper }"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.mediaCommentary">${book.mediaCommentary }</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="book.pack" class="el-input__inner" value="${book.pack }"></td>
					<td></td>
				</tr>
				
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

