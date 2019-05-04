<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="个人信息管理">
<meta name="keywords" content="个人信息管理">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>个人信息管理系统</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script src="${APP_PATH }/static/js/jquery.min.js"></script>
<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
<link href="${APP_PATH }/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/common.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/slide.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/flat-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/jquery.nouislider.css">
<script src="${APP_PATH }/static/js/jquery.cookie.js"></script>

<script src="${APP_PATH }/static/js/jquery-solarlunar.js"></script>
<style>
	.nav ul li{
		background-color: #0970a9;
		border: 1px solid #084a58;
	}
</style>

<!--页面初始化配置1-->
<script>
	$(function() {
		$(".meun-item").click(function() {
			$(".meun-item").removeClass("meun-item-active"); //先移除上次点击后造成的颜色改变
			$(this).addClass("meun-item-active"); //为此次附加点击颜色改变
			var itmeObj = $(".meun-item").find("img");//找到左边所有的显示结点
			itmeObj.each(function() { //为找到的所有结点替换图片，进行区分
				var items = $(this).attr("src");
				items = items.replace("_grey.png", ".png");
				items = items.replace(".png", "_grey.png")
				$(this).attr("src", items);
			});
			var attrObj = $(this).find("img").attr("src"); //保证被点击结点处于正确图片
			attrObj = attrObj.replace("_grey.png", ".png");
			$(this).find("img").attr("src", attrObj);
		});
	})

</script>
</head>

<body>
	<div id="wrap">
		<!-- 左侧菜单栏目块 -->
		<div class="leftMeun" id="leftMeun">
			<div id="logoDiv">
				<p id="logoP">
					<img id="logo" alt="模板随即配" src="${APP_PATH }/static/images/logo.png"><span>个人信息管理系统</span>
				</p>
			</div>
			<div id="personInfor">
				<p id="username_show"></p>
				<p>
					<a href="${APP_PATH }/exitLogin" id="exit_login_btn">
						
					</a>
				</p>
			</div>
			<div class="meun-item" href="#magager_password" aria-controls="magager_password" role="tab"
				data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_change_grey.png">修改密码
			</div>
			<div class="meun-item meun-item-active" href="#user"
				aria-controls="user" role="tab" data-toggle="tab" id="user_btn">
				<img src="${APP_PATH }/static/images/icon_source.png">用户管理
			</div>
		</div>
		<!-- 右侧具体内容栏目 -->
		<div id="rightContent">
			<a class="toggle-btn" id="nimei"> <i
				class="glyphicon glyphicon-align-justify"></i>
			</a>
			<!-- Tab panes -->
			<div class="tab-content">
					<!-- 修改密码模块 -->
					<div role="tabpanel" class="tab-pane" id="magager_password">
							<div class="check-div">预留位置</div>
							<div
								style="padding: 50px 0; margin-top: 50px; background-color: #fff; text-align: right; width: 420px; margin: 50px auto;">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="old_password" class="col-xs-4 control-label">原密码：</label>
										<div class="col-xs-5">
											<input type="password" class="form-control input-sm duiqi" id="old_manager_password"
												placeholder="" style="margin-top: 7px;">
											<span class="help-block"></span>
										</div>
										
									</div>
									<div class="form-group">
										<label for="new_password" class="col-xs-4 control-label">新密码：</label>
										<div class="col-xs-5">
											<input type="password" class="form-control input-sm duiqi" id="new_manager_password"
												placeholder="" style="margin-top: 7px;">
											<span class="help-block"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
										<div class="col-xs-5">
											<input type="password" class="form-control input-sm duiqi" id="new_manager_password_again"
												placeholder="" style="margin-top: 7px;">
											<span class="help-block"></span>									
										</div>
									</div>
									<div class="form-group text-right">
										<div class="col-xs-offset-4 col-xs-5"
											style="margin-left: 169px;">
											<button type="reset" class="btn btn-xs btn-white">取 消</button>
											<button type="button" class="btn btn-xs btn-green" id="edit_manager_password_btn">保存</button>
										</div>
									</div>
								</form>
							</div>
		
						</div>
				<!-- 用户管理模块 -->
				<div role="tabpanel" class="tab-pane active" id="user">
					<div class="check-div form-inline row">
						<button class="btn btn-yellow btn-xs" id="query_user_all_btn">查询所有</button>
						<input type="text" class="form-control input-sm"
							placeholder="用户名查询" id="user_name_query_input">
						<button class="btn btn-white btn-xs" id="user_name_query_btn">查 询</button>
					</div>
						

					<div class="data-div row" id="user_table">
							<table class="table table-striped table-hover text-center">
									<thead>
										<tr>
											<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">userId</th>
											<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">userName</th>
											<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">userPassword</th>
											<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3"></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
					</div>
					<!-- 显示分页信息 -->
		<div class="row text-center">
				<!-- 分页文字信息 -->
				<div class="col-md-6 text-primary info" id="=user_page_info"></div>
				<!-- 分页条信息 -->
				<div class="col-md-6 nav" id="user_page_nav"></div>
			</div>
					

					<!--修改资源弹出窗口-->
					<div class="modal fade" id="editUser" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">修改用户</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
												<label  class="col-xs-3 control-label">用户名：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="edit_user_name_input"
														 placeholder="" name="user_name" disabled>
													<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">用户密码：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="edit_user_password_input"
														 placeholder="" name="user_password">
													<span class="help-block"></span>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-xs btn-green" id="edit_user_btn">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
		
				</div>

	<script src="${APP_PATH }/static/js/jquery.nouislider.js"></script>

	<!--页面初始化配置2-->
	<script>
		//获取cookie
		var user_string = $.cookie("user");
		var user_array = user_string.split('_');

		//获取cookie中值载入用户名字
		$("#username_show").text(user_array[1]);

		//根据cookie显示是登陆还是退出
		if($.cookie("user") == "null") $("#exit_login_btn").text("登陆");else $("#exit_login_btn").text("退出登陆");

		//点击退出登陆删除cookie
		$("#exit_login_btn").click(function(){
			$.cookie("user",null);
		});

	</script>

	<!--表格构建显示分页栏和点击分页条,以及前往页面请求，显示校验结果提示的信息及消除-->
	<script>
			
		//构建查询后表格的显示分页栏
		function build_page_info(result,ele) {
			$(ele).empty();
			$(ele).append(
					"当前" + result.extend.page.pageNum + "页,总"
							+ result.extend.page.pages + "页，总共"
							+ result.extend.page.total + "条记录");
			currentPage = result.extend.page.pageNum;
		}

		//构建显示分页条,点击分页要能去下一页。。。。。。
		function build_page_nav(result,ele,url,data,method) { 
			$(ele).empty();
			var ul = $("<ul></ul>").addClass("pagination");
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
			//设置有没有前一页或后一页没有禁止点击
			if (result.extend.page.isFirstPage == true) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加点击翻页的事件
				firstPageLi.click(function() {
					data.pn=1;
					to_page(url,data,method);
				});
				prePageLi.click(function() {
					data.pn=result.extend.page.pageNum - 1;
					to_page(url,data,method);
				});
			}
			if (result.extend.page.isLastPage == true) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					data.pn=result.extend.page.pageNum + 1;
					to_page(url,data,method);
				});
				lastPageLi.click(function() {
					data.pn=result.extend.page.pages;
					to_page(url,data,method);
				});
			}
			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.page.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append(
						$("<a></a>").append(item).attr("href", "#"));
				if (result.extend.page.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					data.pn=item;
					to_page(url,data,method);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul)
					.addClass("Page navigation");
			navEle.appendTo(ele);
		}

		//构建查询请求函数，传入请求路径和对应数据和后续处理函数对应字符串
		function to_page(url,data,method){
			$.ajax({
				url:url,
				type:"get",
				data: data,
				success:function(result){
					switch(method){
						case "user" :
								 user_query_url = url;
								 user_query_data = data;
								 build_user_table_body(result);
								 build_page_info(result,"#user_page_info");
								 build_page_nav(result,"#user_page_nav",url,data,method);break;

						default : console.log("出错了");break;
					}
				}
			});
		}

		//显示校验结果提示的信息
		function show_validate_msg(ele,status,msg){
			//清楚当前元素的校验状态
			clear_show_validate(ele);
			if("success" == status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error == status"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}

		//清除传入结点校验结果校验状态
		function clear_show_validate(ele){
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
		}

	</script>

	<!--修改密码配置-->
	<script>
			$("#edit_manager_password_btn").click(function(){
			var old_password = $("#old_manager_password").val();
			var new_password = $("#new_manager_password").val();
			var new_password_again = $("#new_manager_password_again").val();
			var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ]");
			if(old_password != user_array[2]){
				show_validate_msg("#old_manager_password","error","Please input right password!");
				return false;
			}else{
				show_validate_msg("#old_manager_password","success","");
			}

			if(pattern.test(new_password)){
				show_validate_msg("#new_manager_password","error","Please do not enter special characters!");
				return false;
			}else if(new_password != new_password_again){
				show_validate_msg("#new_manager_password","error","Two password inconsistencies!");
				show_validate_msg("#new_manager_password_again","error","Two password inconsistencies!");
				return false;
			}else if(old_password == new_password){
				show_validate_msg("#old_manager_password","error","Two passwords can't be the same!");
				show_validate_msg("#new_manager_password","error","Two passwords can't be the same!");
				return false;
			}else{
				show_validate_msg("#new_manager_password","success","");
				show_validate_msg("#new_manager_password_again","success","");
				show_validate_msg("#old_manager_password","success","");
			}

			$.ajax({
				url:"${APP_PATH}/updateUser",
				type:"POST",
				data:{
					userId : user_array[0],
					userPassword:new_password
				},
				success:function(result){
					alert(result.msg);
					//根据更新的cookie值,更新所取值
					user_string = $.cookie("user_update");
					user_array = user_string.split('_');
					window.location.href = "${APP_PATH }/login?username="+user_array[1]+"&password="+user_array[2];
				}
			})
		});
	</script>

	<!--用户管理配置-->
	<script>
			var user_query_url ; //用户最近通过to_page查询的路径和数据
			var user_query_data;

			//查询所有用户
			$("#query_user_all_btn").click(function(){
				to_page("${APP_PATH }/queryUserAll",{'pn':1},"user");
			})

			//用户表构建
			//构建查询后用户的表格的数据栏
			function build_user_table_body(result){
			$("#user_table tbody").empty();
			var things = result.extend.page.list;
			$.each(things, function(index, item) {
				var userIdTd = $("<td></td>").append(item.userId);
				var userNameTd = $("<td></td>").append(item.userName);
				var userPasswordTd = $("<td></td>").append(item.userPassword);
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm user_edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性,来表示当前事件id
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm user_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(userIdTd).append(userNameTd).append(userPasswordTd).append(
					btnTd).appendTo("#user_table tbody");
			});
		}

			//用户名查询
			$("#user_name_query_btn").click(function(){
				var user_name_query_value = $("#user_name_query_input").val();
				
				to_page("${APP_PATH }/queryUserByUsername",{'username':user_name_query_value},"user");
			})

			//编辑用户模态框
			$(document).on("click",".user_edit_btn",function(){
			var userId = $(this).parents("tr").find("td:eq(0)").text();
			var userName =  $(this).parents("tr").find("td:eq(1)").text();
			var userPassword = $(this).parents("tr").find("td:eq(2)").text();
			$("#edit_user_btn").attr("user_edit_id",userId);
			$("#edit_user_name_input").val(userName);
			$("#edit_user_password_input").val(userPassword);
			$('#editUser').modal({
				backdrop : 'static'
			});

			//模态框上传用户
			$("#edit_user_btn").click(function(){
				var userId = $("#edit_user_btn").attr("user_edit_id");
				var edit_user_name_value = $("#edit_user_name_input").val();
				var edit_user_password_vale = $("#edit_user_password_input").val();

				$.ajax({
					url:"${APP_PATH }/updateByManager",
					type:"POST",
					data:{
						'userId':userId,
						'userName':edit_user_name_value,
						'userPassword':edit_user_password_vale
					},
					success:function(result){
						alert(result.msg);
						$("#editUser").modal("hide");
						to_page(user_query_url,user_query_data,"user");
					}
				})
			})
		});
			
			//删除用户
			$(document).on("click",".user_delete_btn",function(){
				var userName = $(this).parents("tr").find("td:eq(1)").text();
				var userId =  $(this).parents("tr").find("td:eq(0)").text();
				if(confirm("确认删除【"+userName+"】吗？")){
					//确认，发送ajax请求删除即可
					$.ajax({
						url:"${APP_PATH}/deleteUser",
						type:"POST",
						data:"userId=" + userId,
						success:function(result){
							alert(result.msg);
							to_page(user_query_url,user_query_data,"user");
						}
					})
				}
			})


	</script>

</body>

</html>