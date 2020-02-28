<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
 </style>
</head>
<body>

    <jsp:include page="header.jsp" />

    <div class="container"  style="width:100%;height:460px;background:#FF2C4C url('${pageContext.request.contextPath}/img/loginbg.jpg') no-repeat;">
<div class="row"> 
	<div class="col-md-7">
		<!--<img src="image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
	</div>
	
	<div class="col-md-5">
				<div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
				<font>会员登录</font>USER LOGIN
				<div>
					<font style="color: #f00;">${msg}</font>
				</div>
				<div>&nbsp;</div>
<form action="${pageContext.request.contextPath}/user/login" method="post" class="form-horizontal" >
  
 <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-6">
      <input type="text" name="username" value="${cookie.remembermeCookie.value}" class="form-control" id="username" placeholder="请输入用户名">
    </div>
  </div>
   <div class="form-group">
    <label for="password" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-6">
      <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码">
    </div>
  </div>
   <div class="form-group">
        <label for="verifyCode" class="col-sm-2 control-label">验证码</label>
    <div class="col-sm-3">
      <input type="text" name="verifyCode" class="form-control" id="verifyCode" placeholder="请输入验证码">
    </div>
    <div class="col-sm-3">
      <img src="${pageContext.request.contextPath}/verify" name="verifyCode" onclick="checkImage(this)"/>
        <script type="text/javascript">
            function checkImage(img) {
                img.src = "${pageContext.request.contextPath}/verify?"+new Date().getTime();
            }
        </script>
    </div>
    
  </div>
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="autoLogin" value="1" ${not empty cookie.autoLoginCookie?"checked='checked'":""}> 自动登录
        </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label>
          <input type="checkbox" name="rememberme" value="1" ${not empty cookie.remembermeCookie?"checked='checked'":""}> 记住用户名
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <input type="submit"  width="100" value="登录" name="submit" border="0"
    style="background: url('${pageContext.request.contextPath}/img/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    height:35px;width:100px;color:white;">
    </div>
  </div>
</form>
</div>			
	</div>
</div>
</div>

    <jsp:include page="footer.jsp" />
</body></html>