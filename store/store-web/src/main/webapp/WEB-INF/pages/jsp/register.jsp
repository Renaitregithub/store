<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>会员注册</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
</head>
<style>
	body{
		margin: 0 auto;
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
		color: #3164af;
		font-size: 18px;
		font-weight: normal;
		padding: 0 10px;
	}
</style>
</head>
<body>

    <jsp:include page="header.jsp" />

    <div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
	<div class="row">

		<div class="col-md-2"></div>

		<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
			<font>会员注册</font>USER REGISTER
			<form action="${pageContext.request.contextPath}/user/regist" method="post" class="form-horizontal" style="margin-top:5px;">
				<%--username--%>
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                        <span id="s1"></span>
					</div>
				</div>
				<%--password--%>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" name="password" id="inputPassword3" placeholder="请输入密码">
					</div>
				</div>
				<%--confirmpwd--%>
				<div class="form-group">
					<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="confirmpwd" name="confirmpwd" placeholder="请输入确认密码">
					</div>
				</div>
				<%--Email--%>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-6">
						<input type="email" class="form-control" name="email" id="inputEmail3" placeholder="Email">
					</div>
				</div>
                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">手机</label>
                    <div class="col-sm-6">
                        <input type="tel" class="form-control" name="telephone" id="telephone" placeholder="请输入联系方式">
                    </div>
                </div>
				<%--name--%>
				<div class="form-group">
					<label for="usercaption" class="col-sm-2 control-label">姓名</label>
					<div class="col-sm-6">
						<input type="text" name="name" class="form-control" id="usercaption" placeholder="请输入姓名">
					</div>
				</div>
				<%--sex--%>
				<div class="form-group opt">
					<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-6">
						<label class="radio-inline">
							<input type="radio" name="sex" id="inlineRadio1" value="1"> 男
						</label>
						<label class="radio-inline">
							<input type="radio" name="sex" id="inlineRadio2" value="0"> 女
						</label>
					</div>
				</div>
				<%--birthday--%>
				<div class="form-group">
					<label for="birthday" class="col-sm-2 control-label">出生日期</label>
					<div class="col-sm-6">
						<input type="date" name="birthday" id="birthday" class="form-control"  >
					</div>
				</div>
                <%--verifyCode--%>
				<div class="form-group">
					<label for="verifyCode" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-3">
						<input type="text" name="verifyCode" id="verifyCode" class="form-control"  >
                        <div><font style="color: #f00">${msg}</font></div>
					</div>
					<div class="col-sm-2">
						<img src="${pageContext.request.contextPath}/verify" onclick="checkImage(this)" style="cursor: pointer;" />
                        <script type="text/javascript">
                            function checkImage(img) {
                                img.src = "${pageContext.request.contextPath}/verify?"+new Date().getTime();
                            }
                        </script>
					</div>

				</div>
				<%--注册--%>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" id="regBut"  width="100" value="注册" name="submit" border="0" style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
									   height:35px;width:100px;color:white;">
					</div>
				</div>
			</form>
		</div>

		<div class="col-md-2"></div>

	</div>
</div>

    <jsp:include page="footer.jsp" />

<script type="text/javascript">

    $(function(){
       $("#username").blur(function () {

           var val = $(this).val();
           if(val != ""){
               var url = "${pageContext.request.contextPath}/user/checkUsername";
               var params = {"username":val};
               $.post(url,params,function(data){
                  if(data==1){
                      $("#s1").html("用户名不可以使用").css("color","#f00");
                      $("#regBut").attr("disabled",true);
                  } else if(data==2){
                      $("#s1").html("用户名可以使用").css("color","#0f0");
                      $("#regBut").attr("disabled",false);
                  }
               });
           }

       });
    });

</script>
</body>
</html>




