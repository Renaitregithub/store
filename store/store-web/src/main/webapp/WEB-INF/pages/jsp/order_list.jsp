<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

		<jsp:include page="header.jsp" />

		<div class="container">

            <c:if test="${empty pageInfo.list}">
                <div class="col-md-12" style="border: 1px solid gray;height: 300px;box-shadow:0 0 5px pink inset" >
                    <center><h3>暂无数据</h3></center>
                </div>
            </div>
            </c:if>
            <c:if test="${not empty pageInfo.list}">
			    <div class="row">

				<div style="margin: 10px auto 0;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
                        <c:forEach items="${pageInfo.list}" var="orders">
						    <tbody>
							<tr class="success">
								<th colspan="5">
                                    订单编号:${orders.oid},${orders.state}
                                    <c:if test="${orders.state==1}">
                                        <a href="${pageContext.request.contextPath}/orders/findByOid/${orders.oid}">付款</a>

                                    </c:if>
                                    <c:if test="${orders.state==2}">
                                        等待发货
                                    </c:if>
                                    <c:if test="${orders.state==3}">
                                        确认收货
                                    </c:if>
                                    <c:if test="${orders.state==4}">
                                        订单结束
                                    </c:if>
                                </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
                            <c:forEach var="orderItem" items="${orders.list}">

							    <tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/${orderItem.product.pimage}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> ${orderItem.product.pname}</a>
								</td>
								<td width="20%">
									￥${orderItem.product.shop_price}
								</td>
								<td width="10%">
									${orderItem.quantity}
								</td>
								<td width="15%">
									<span class="subtotal">￥${orderItem.total}</span>
								</td>
							</tr>
                            </c:forEach>
						</tbody>
                        </c:forEach>
					</table>
				</div>
			</div>

            <!--分页 -->
            <div style="width:380px;margin: 50px auto 0;">

                <ul class="pagination" style="text-align:center; margin-top:10px;">
                    <li><a href="">共${pageInfo.pageNum}页/第${pageInfo.lastPage}页</a></li>
                    <c:if test="${pageInfo.pageNum!=pageInfo.firstPage}">
                        <li><a href="${pageContext.request.contextPath}/orders/findByUid/${uid}">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/orders/findByUid/${uid}?page=${pageInfo.prePage}">上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${pageInfo.pages}" varStatus="status" >
                        <li><a href="${pageContext.request.contextPath}/orders/findByUid/${uid}?page=${status.count}">${status.count}</a></li>
                    </c:forEach>
                    <c:if test="${pageInfo.pageNum!=pageInfo.lastPage}">
                        <li><a href="${pageContext.request.contextPath}/orders/findByUid/${uid}?page=${pageInfo.nextPage}">下一页</a></li>
                        <li><a href="${pageContext.request.contextPath}/orders/findByUid/${uid}?page=${pageInfo.lastPage}">末页</a></li>
                    </c:if>
                </ul>

            </div>
            <!-- 分页结束=======================        -->
            </c:if>
		</div>

		<jsp:include page="footer.jsp" />
	</body>

</html>