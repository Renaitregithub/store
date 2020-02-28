<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
描述：菜单栏
-->
<div class="container-fluid">
    <div class="col-md-4">
        <a href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath}/img/logo2.png" />
        </a>
    </div>
    <div class="col-md-5">
        <img src="${pageContext.request.contextPath}/img/header.png" />
    </div>
    <div class="col-md-3" style="padding-top:20px">
        <ol class="list-inline">
            <c:if test="${empty loginUserSession}">
                <li><a href="${pageContext.request.contextPath}/user/loginUI">登录</a></li>
                <li><a href="${pageContext.request.contextPath}/user/registUI">注册</a></li>
            </c:if>

            <li><a href="${pageContext.request.contextPath}/cart/showPage">购物车</a></li>
            <c:if test="${not empty loginUserSession}">
                欢迎：${loginUserSession.name}
                <li><a href="${pageContext.request.contextPath}/orders/findByUid/${loginUserSession.uid}">我的订单</a></li>
                <li><a href="${pageContext.request.contextPath}/user/logout">退出</a></li>
            </c:if>
        </ol>
    </div>
</div>
<!--
描述：导航条
-->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">首页</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="menu">

                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
        </div>
    </nav>
</div>
<script type="text/javascript">
    $(function(){
        $.ajax({
           type:"post",
           url: "${pageContext.request.contextPath}/category/findAll",
            data:{},
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function (data) {
                $.each(data,function(i,n){
                    $("#menu").append("<li value=''><a href='${pageContext.request.contextPath}/product/findByCid/"+n.cid+"'>"+n.cname+"</a></li>");
                });
            }
        });
    });
</script>