<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎光临</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!--Web路径
 不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
 以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-image: url(${APP_PATH}/static/images/index-background.jpg);
	background-size: 100% 100%;
	background-attachment: fixed;
}

#login_box {
	padding: 35px;
	border-radius: 15px; /*div圆角*/
	background: rgba(255, 255, 255, 0.2); /*#56666B*/
	/* background-color:transparent; */
	color: #fff;
}

#login_title {
	color: #fff;
}

#register_title {
	text-decoration: underline;
	font-size: 15px;
	color: aqua;
	cursor: pointer;
}
</style>
<body>

	<div class="container" id="top">
		<div class="row" style="margin-top: 120px;">
			<div class="col-md-offset-4 col-md-4">
				<div class="col-md-offset-3 col-md-9">
					<h1 id='login_title'>用户登录</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4" id='login_box'>
				<form class="form-horizontal" action="${APP_PATH}/login" method="post">
					<div class="form-group">
						<label class="col-md-3 control-label">用户账户</label>
						<!--control-label标签对齐 -->
						<div class="col-md-9">
							<input class="form-control" type="text" name="username"
								id="username" placeholder="请输入名字" /> <span class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">用户密码</label>
						<div class="col-md-9">
							<input class="form-control" type="password" name="password"
								id="password" placeholder="请输入密码" /> <span class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6">
							<input type="submit" class="form-control btn-default"
								id="user_login_btn" value="登录" />
						</div>
						<div class="col-md-6">
							<input type="reset" class="form-control btn-default" value="重置" />
						</div>
					</div>
					<div id="register_title" class="col-md-3 col-md-offset-9">注册</div>
					<c:if test="${msg.code == 200}">
						<font color="red">${msg.msg }</font>
					</c:if>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

	<!-- 注册模态框 -->
	<div class="modal fade" id="user_add_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">用户注册</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户账号</label>
							<div class="col-sm-7">
								<input type="email" class="form-control" id="username_add"
									placeholder="Email"> <span class="help-block"></span>
							</div>
							<div class="col-sm-3">
								<input type="button" ajax-va="error" value="发送验证码"
									id="sendMailCode">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">用户密码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="password_add"
									placeholder="Password"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="password2_add"
									placeholder="AgainPassword"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="idCode"
									placeholder="idCode"> <span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary" id="user_add_btn">注册</button>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		
		//发送邮件
		$("#sendMailCode").click(function(){
			//在点击之前判断用户是否存在
			if($(this).attr("ajax-va") == "error"){
				return false;
			}
			var email = $('#username_add').val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			//检验用户名是否符合邮箱
			if(!regEmail.test(email)){
				show_validate_msg("#username_add","error","请输入正确邮箱"); 
				return false;
			}else{
				show_validate_msg("#username_add","success","");
			}
			//进行样式设置
			$("#sendMailCode").attr("value","正在发送");
      $("#sendMailCode").attr("disabled","true");
			$.ajax({
				url:"${APP_PATH}/sendMailCode",
				data:"mail="+email,
				type:"POST",
				timeout:5000,
				success:function(result) {
					$("#sendMailCode").attr("value","验证码已发送");
				},
				error : function(){
					$("#sendMailCode").attr("value","重新发送");
      		$("#sendMailCode").removeAttr("disabled");
				}
			});
		});

		//为模态框用户名输入时查询用户名是否已存在
		$("#username_add").change(function(){
			var username = this.value;
			$.ajax({
				url:"${APP_PATH}/checkUser",
				type:"POST",
				data:"username=" + username,
				success: function(result){
					console.log(result);
					if(result.code == 200){
						show_validate_msg("#username_add","error",result.msg);
						$("#sendMailCode").attr("ajax-va","error");
					}else{
						show_validate_msg("#username_add","success",result.msg);
						$("#sendMailCode").attr("ajax-va","success");
					}
				}
			})
		});

		//为页面注册标签加上点击事件打开模态框
		$("#register_title").click(function(){
			//清除上次模态框样式
			$("#sendMailCode").attr("value","发送验证码");
      $("#sendMailCode").removeAttr("disabled");
			$("#user_add_modal form")[0].reset();
			$("#user_add_modal form").find("*").removeClass("has-error has-success");
			$("#user_add_modal form").find(".help-block").text("");

			$('#user_add_modal').modal({
				backdrop : 'static'
			});
		});
		
		//为注册模态框中的注册按钮添加点击事件
		$("#user_add_btn").click(function(){
			var username = $('#username_add').val();
			var password = $('#password_add').val();
			var idCode = $("#idCode").val();
			var password2 = $('#password2_add').val();
			var regUsername = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			//检验用户名是否符合邮箱
			if(!regUsername.test(username)){
				show_validate_msg("#username","error","请输入正确邮箱"); 
				return false;
			}else{
				show_validate_msg("#username","success",""); 
			}
			//检验两次密码是否一致
			if(password != password2){
				show_validate_msg("#password2_add","error","两次密码不一致");
				show_validate_msg("#password_add","error","");
				return false;
			}else{
				show_validate_msg("#password_add","success","");
				show_validate_msg("#password2_add","success","");
			}
			$.ajax({
				  url: "${APP_PATH}/regist",
					data:{
						idCode : $("#idCode").val(),
						username : $("#username_add").val(),
						password : $("#password_add").val()
					},
					type : "POST",
					success:function(result){
						if(result.code == 100){
							alert("注册成功");
							//关闭模态框
							$("#user_add_modal").modal('hide');
						}else{
							alert("注册失败-->" + result.msg);
						}
					}
			});
		});
		
		//因为使用ajax请求，后台的跳转页面请求会失效，所以只进行用户名验证
		$("#username").change(function(){
			var username = $("#username").val();
			//验证用户名是否符合邮箱
			var regUsername = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regUsername.test(username)){
				show_validate_msg("#username","error","请输入正确邮箱");
				return false;
			}else{
				show_validate_msg("#username","success","");
			}
		});

		//显示校验结果提示的信息
		function show_validate_msg(ele,status,msg){
			//清楚当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success" == status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error == status"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
	</script>
</body>
</html>