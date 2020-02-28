<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

			<jsp:include page="header.jsp"/>


			<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/">首页</a></li>
					<%--产品--%>
				</ol>
			</div>
			<c:if test="${empty pageInfo.list}">
					<div class="col-md-12" style="border: 1px solid gray;height: 300px;box-shadow:0 0 5px pink inset" >
						<center><h3>暂无数据</h3></center>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty pageInfo.list}">
				<c:forEach items="${pageInfo.list}" var="product">
				<div class="col-md-2">
				<a href="${pageContext.request.contextPath}/product/findById/${product.pid}">
					<img src="${pageContext.request.contextPath}/${product.pimage}" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/product/findById/${product.pid}" title="${product.pname}" style='color:green'>${fn:substring(product.pname,0,12)}...</a></p>
				<p><font color="#FF0000">商城价：&yen;${product.shop_price}</font></p>
			</div>
			</c:forEach>
			</c:if>
		</div>

			<!--分页 -->
			<div style="width:380px;margin: 50px auto 0;">

					<ul class="pagination" style="text-align:center; margin-top:10px;">
						<li><a href="">共${pageInfo.pageNum}页/第${pageInfo.lastPage}页</a></li>
						<c:if test="${pageInfo.pageNum!=pageInfo.firstPage}">
						<li><a href="${pageContext.request.contextPath}/product/findByCid/${cid}">首页</a></li>
						<li><a href="${pageContext.request.contextPath}/product/findByCid/${cid}?page=${pageInfo.prePage}">上一页</a></li>
						</c:if>
						<c:forEach begin="1" end="${pageInfo.pages}" varStatus="status" >
							<li><a href="${pageContext.request.contextPath}/product/findByCid/${cid}?page=${status.count}">${status.count}</a></li>
						</c:forEach>
						<c:if test="${pageInfo.pageNum!=pageInfo.lastPage}">
						<li><a href="${pageContext.request.contextPath}/product/findByCid/${cid}?page=${pageInfo.nextPage}">下一页</a></li>
						<li><a href="${pageContext.request.contextPath}/product/findByCid/${cid}?page=${pageInfo.lastPage}">末页</a></li>
						</c:if>
					</ul>

			</div>
			<!-- 分页结束=======================        -->

			<!--
				商品浏览记录:
			-->
			<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h4 style="width: 50%;float: left;font: 14px/30px '微软雅黑'">浏览记录</h4>
			<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
			<div style="clear: both;"></div>

			<div style="overflow: hidden;">


				<ul style="list-style: none;">
					<li style="width: 150px;height: 216px;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
						<img src="${pageContext.request.contextPath}/products/1/cs10001.jpg" width="130px" height="130px" /></li>
				</ul>

			</div>
		</div>

			<jsp:include page="footer.jsp" />

	</body>

</html>