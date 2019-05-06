<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<link rel="shortcut icon" href="${APP_PATH}/favicon.ico" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="个人信息管理">
<meta name="keywords" content="个人信息管理">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>个人信息管理系统</title>
<link href="${APP_PATH }/static/css/iconfont.css" rel="stylesheet" />
<link href="${APP_PATH }/static/css/imagesUpload.css" rel="stylesheet" />
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
	.limitNum{
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
	}
	.tupian{
		height: 70px;
		width: 70px;
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
			switch($(this).attr("id")){
				case "thing_btn" : to_page("${APP_PATH }/thingQueryAll",{'userId':user_array[0],'pn':1},"thing");break;
				case "account_btn" : to_page("${APP_PATH }/queryAccountAll",{'userId':user_array[0],'pn':1},"account");break;
				case "mind_btn"	: to_page("${APP_PATH }/queryMindAll",{'userId':user_array[0],'pn':1},"mind");break;
				case "wish_btn" : to_page("${APP_PATH }/queryWishAll",{'userId':user_array[0],'pn':1},"wish");break;
				case "journal_btn" : to_page("${APP_PATH }/queryJournalAll",{'userId':user_array[0],'pn':1},"journal");break;
				case "photo_btn" : select_photo_type();break;
			}
		});
		$("#topAD").click(function() {
			$("#topA").toggleClass(" glyphicon-triangle-right"); //.toggleClass存在此类就删除否则就添加
			$("#topA").toggleClass(" glyphicon-triangle-bottom");
		});
		$("#topBD").click(function() {
			$("#topB").toggleClass(" glyphicon-triangle-right");
			$("#topB").toggleClass(" glyphicon-triangle-bottom");
		});
		$("#topCD").click(function() {
			$("#topC").toggleClass(" glyphicon-triangle-right");
			$("#topC").toggleClass(" glyphicon-triangle-bottom");
		});
		$(".toggle-btn").click(function() {
			$("#leftMeun").toggleClass("show");
			$("#rightContent").toggleClass("pd0px");
		})
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
				<p id="userMind_show"></p>
				<p>
					<a href="${APP_PATH }/exitLogin" id="exit_login_btn">
						
					</a>
				</p>
			</div>
			<div class="meun-title">账号管理</div>
			<div class="meun-item" href="#password" aria-controls="password" role="tab"
				data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_change_grey.png">修改密码
			</div>
			<div class="meun-title">信息管理</div>
			<div class="meun-item meun-item-active" href="#thing"
				aria-controls="thing" role="tab" data-toggle="tab" id="thing_btn">
				<img src="${APP_PATH }/static/images/icon_source.png">事件管理
			</div>
			<div class="meun-item" href="#journal" aria-controls="journal" role="tab" id="journal_btn"
				data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_chara_grey.png">日记管理
			</div>
			<div class="meun-item" href="#wish" aria-controls="wish" role="tab" id="wish_btn"
				data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_user_grey.png">愿望管理
			</div>
			<div class="meun-item" href="#photo" aria-controls="photo" role="tab" id="photo_btn"
				data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_house_grey.png">照片管理
			</div>
			<div class="meun-item" href="#mind" aria-controls="mind" role="tab" id="mind_btn"
				data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_card_grey.png">心情记录
			</div>
			<div class="meun-item" href="#account" aria-controls="account" id="account_btn"
					role="tab"	data-toggle="tab">
				<img src="${APP_PATH }/static/images/icon_rule_grey.png">账号密码管理
			</div>
		</div>
		<!-- 右侧具体内容栏目 -->
		<div id="rightContent">
			<a class="toggle-btn" id="nimei"> <i
				class="glyphicon glyphicon-align-justify"></i>
			</a>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- 事件管理模块 -->
				<div role="tabpanel" class="tab-pane active" id="thing">
					<div class="check-div form-inline row">
						<button class="btn btn-yellow btn-xs" id="add_thing_modal_btn">添加事件</button>
						<button class="btn btn-yellow btn-xs" id="query_thing_all_btn">所有事件</button>
						<button class="btn btn-yellow btn-xs" id="query_thing_able_btn">有效事件</button>
						<button class="btn btn-yellow btn-xs" id="query_thing_disable_btn">失效事件</button>
						<input type="text" class="form-control input-sm"
							placeholder="输入参与人查询" id="thing_title_query_input">
						<button class="btn btn-white btn-xs" id="thing_title_query_btn">查 询</button>
					</div>
						

					<div class="data-div row" id="thing_table">
							<table class="table table-striped table-hover text-center table-bordered">
									<thead>
										<tr>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">事件对象</th>
											<th  class="text-center col-lg-3 col-md-2 col-sm-3 col-xs-3">事件内容</th>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">事件日期</th>
											<th  class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1">日期类型</th>
											<th  class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1">是否每年循环</th>
											<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">操作按钮</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
					</div>
					<!-- 显示分页信息 -->
		<div class="row text-center">
				<!-- 分页文字信息 -->
				<div class="col-md-6 text-primary info" id="thing_page_info"></div>
				<!-- 分页条信息 -->
				<div class="col-md-6 nav" id="thing_page_nav"></div>
			</div>
					<!--弹出窗口添加事件-->
					<div class="modal fade" id="addThing" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">添加事件</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
												<label  class="col-xs-3 control-label">事件对象：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="add_thing_title_input"
														 placeholder="" name="thingTitle" maxlength="60">
													<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">事件内容：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="add_thing_text_input"
														 placeholder="" name="thingText" maxlength="200">
													<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">事件日期：</label>
												<div class="col-xs-8">
													<input type="" class="form-control input-sm duiqi" id="add_thing_time_input"
														 placeholder="" name="thingTime">
												</div>
											</div>
											<div class="form-group">
													<label class="col-xs-3 control-label">日期类型：</label>
													<label class="radio-inline"> 
														<input type="radio"	name="timeType" id="add_thing_timeType_input1"  value="1" disabled>阳历
													</label>
													<label class="radio-inline"> 
														<input type="radio"	name="timeType" id="add_thing_timeType_input2"  value="2" disabled>农历 
													</label>
											</div>
											<div class="form-group">
												<label class="col-xs-3 control-label">是否每年循环提醒：</label>
												<label class="radio-inline"> 
													<input type="radio"	name="add_circulate_radio" id="add_thing_circulate_input1"  value="0">否
												</label>
												<label class="radio-inline"> 
													<input type="radio"	name="add_circulate_radio" id="add_thing_circulate_input2"  value="1" checked>是 
												</label>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-xs btn-green" id="add_thing_btn">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>

					<!--修改事件弹出窗口-->
					<div class="modal fade" id="editThing" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">修改事件</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
												<label  class="col-xs-3 control-label">事件对象：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="edit_thing_title_input"
														 placeholder="" name="thingTitle">
													<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">事件内容：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="edit_thing_text_input"
														 placeholder="" name="thingText">
													<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">事件日期：</label>
												<div class="col-xs-8">
													<input type="" class="form-control input-sm duiqi" id="edit_thing_time_input"
														 placeholder="" name="thingTime">
												</div>
											</div>
											<div class="form-group">
													<label class="col-xs-3 control-label">日期类型：</label>
													<label class="radio-inline"> 
														<input type="radio"	name="editTimeType" id="edit_thing_timeType_input1"  value="1" disabled>阳历
													</label>
													<label class="radio-inline"> 
														<input type="radio"	name="editTimeType" id="edit_thing_timeType_input2"  value="2" disabled>农历 
													</label>
											</div>
											<div class="form-group">
												<div class="form-group">
													<label class="col-xs-3 control-label">是否每年循环提醒：</label>
													<label class="radio-inline"> 
														<input type="radio"	name="edit_circulate_radio" id="edit_thing_circulate_input1"  value="0" >否
													</label>
													<label class="radio-inline"> 
														<input type="radio"	name="edit_circulate_radio" id="edit_thing_circulate_input2"  value="1" >是 
													</label>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-xs btn-green" id="edit_thing_btn">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
		
				</div>
				<!-- 日记管理模块 -->
				<div role="tabpanel" class="tab-pane" id="journal">

					<div class="check-div form-inline row">
						<button class="btn btn-yellow btn-xs" id="add_journal_modal_btn">写日记</button>
						<button class="btn btn-yellow btn-xs" id="query_journal_all_btn">浏览日记</button>
						<input type="text" class="form-control input-sm"
							placeholder="时间查询格式  yyyy-mm-dd" id="journal_time_query_input">
						<button class="btn btn-white btn-xs" id="journal_time_query_btn">查 询</button>
					</div>
						
					<div class="data-div row" id="journal_table">
							<table   style="table-layout:fixed" class="table table-striped table-hover text-center table-condensed table-bordered">
									<thead>
										<tr>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">日期</th>
											<th  class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1">星期</th>
											<th  class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1">天气</th>
											<th  class="text-center col-lg-5 col-md-5 col-sm-5 col-xs-5">内容</th>
											<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">操作按钮</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
					</div>
					<!-- 显示分页信息 -->
		<div class="row text-center">
				<!-- 分页文字信息 -->
				<div class="col-md-6 text-primary info" id="journal_page_info"></div>
				<!-- 分页条信息 -->
				<div class="col-md-6 nav" id="journal_page_nav"></div>
			</div>

				<!--弹出窗口添加事件-->
				<div class="modal fade" id="journal_change_thing" role="dialog"
				aria-labelledby="gridSystemModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="gridSystemModalLabel">记为事件</h4>
						</div>
						<div class="modal-body">
							<div class="container-fluid">
								<form class="form-horizontal">
									<div class="form-group ">
										<label  class="col-xs-3 control-label">事件对象：</label>
										<div class="col-xs-8 ">
											<input type="text" class="form-control input-sm duiqi" id="add_change_thing_title_input"
												 placeholder="" name="thingTitle" maxlength="60">
											<span class="help-block"></span>
										</div>
									</div>
									<div class="form-group">
										<label  class="col-xs-3 control-label">事件内容：</label>
										<div class="col-xs-8 ">
											<input type="text" class="form-control input-sm duiqi" id="add_change_thing_text_input"
												 placeholder="" name="thingText" maxlength="200">
											<span class="help-block"></span>
										</div>
									</div>
									<div class="form-group">
										<label  class="col-xs-3 control-label">事件日期：</label>
										<div class="col-xs-8">
											<input type="" class="form-control input-sm duiqi" id="add_change_thing_time_input"
												 placeholder="" name="thingTime">
										</div>
									</div>
									<div class="form-group">
											<label class="col-xs-3 control-label">日期类型：</label>
											<label class="radio-inline"> 
												<input type="radio"	name="add_change_thing_radio" id="add_change_thing_timeType_input1"  value="1" disabled>阳历
											</label>
											<label class="radio-inline"> 
												<input type="radio"	name="add_change_thing_radio" id="add_change_thing_timeType_input2"  value="2" disabled>农历 
											</label>
									</div>
									<div class="form-group">
										<label class="col-xs-3 control-label">是否每年循环提醒：</label>
										<label class="radio-inline"> 
											<input type="radio"	name="add_circulate_radio" id="add_change_thing_circulate_input1"  value="0">否
										</label>
										<label class="radio-inline"> 
											<input type="radio"	name="add_circulate_radio" id="add_change_thing_circulate_input2"  value="1" checked>是 
										</label>
									</div>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-xs btn-xs btn-white"
								data-dismiss="modal">取 消</button>
							<button type="button" class="btn btn-xs btn-xs btn-green" id="add_change_thing_btn">保
								存</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>

					<!--弹出窗口写日记-->
					<div class="modal fade" id="addJournal" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">今日记事</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
													<label  class="col-xs-3 control-label">日期：</label>
													<div class="col-xs-8 ">
														<div type="text" class="form-control input-sm duiqi" id="add_journal_time_input"
															 placeholder="" name="journalTime">我能说什么</div>
														<span class="help-block"></span>
													</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">星期：</label>
												<div class="col-xs-8 ">
													<div class="form-control  input-sm duiqi" id="add_journal_week_input"
													name="journalWeek">我能说什么</div>
											   		<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
													<label  class="col-xs-3 control-label">天气：</label>
													<div class="col-xs-3">
															<select class="form-control input-sm duiqi" id="add_journal_weather_input" name="journalWeather">
																	<option value="1">晴天</option>
																	<option value="2">阴天</option>
																	<option value="3">雨天</option>
															</select>
													</div>
											</div>
											<div class="form-group">
												<div class="col-xs-10">
													<textarea class="form-control" id="add_journal_text_input" maxlength="3000" rows="11" style="resize: none;padding: 5px; position: relative;left: 25px;">
													</textarea>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-xs btn-green" id="add_journal_btn">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>

						<!--浏览窗口-->
						<div class="modal fade" id="readJournal" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">今日记事</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
													<label  class="col-xs-3 control-label">日期：</label>
													<div class="col-xs-8 ">
														<div type="text" class="form-control input-sm duiqi" id="read_journal_time_input"
															 placeholder="" ></div>
														<span class="help-block"></span>
													</div>
											</div>
											<div class="form-group">
												<label  class="col-xs-3 control-label">星期：</label>
												<div class="col-xs-8 ">
													<div class="form-control  input-sm duiqi" id="read_journal_week_input"></div>
											   		<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
													<label  class="col-xs-3 control-label">天气：</label>
													<div class="col-xs-3">
															<div class="form-control  input-sm duiqi" id="read_journal_weather_input"></div>
															<span class="help-block"></span>
													</div>
											</div>
											<div class="form-group">
												<div class="col-xs-10">
													<textarea class="form-control" id="read_journal_text_input" maxlength="3000" rows="11" style="resize: none;padding: 5px; position: relative;left: 25px;">
													</textarea>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">关闭</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				</div>
				<!--愿望管理模块-->
				<div role="tabpanel" class="tab-pane" id="wish">
					<div class="check-div form-inline row">
						<button class="btn btn-yellow btn-xs" id="add_wish_modal_btn">增加心愿</button>
						<button class="btn btn-yellow btn-xs" id="query_wish_all_btn">所有心愿</button>
						<input type="text" class="form-control input-sm"
							placeholder="输入愿望标题" id="wish_title_query_input">
						<button class="btn btn-white btn-xs" id="wish_title_query_btn">查 询</button>
					</div>						

					<div class="data-div row" id="wish_table">
							<table class="table table-striped table-hover text-center">
									<thead>
										<tr>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">心愿标题</th>
											<th  class="text-center col-lg-5 col-md-5 col-sm-5 col-xs-5">详细内容</th>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">到期时间</th>
											<th  class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1">目前状态</th>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2"></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
					</div>
					<!-- 显示分页信息 -->
		<div class="row text-center">
				<!-- 分页文字信息 -->
				<div class="col-md-6 text-primary info" id="wish_page_info"></div>
				<!-- 分页条信息 -->
				<div class="col-md-6 nav" id="wish_page_nav"></div>
			</div>
					<!--弹出窗口添加愿望-->
					<div class="modal fade" id="addWish" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">添加愿望(请选择公历)</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
												<label  class="col-xs-3 control-label">愿望标题：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="add_wish_title_input"
													maxlength="12" placeholder="限制12字" name="wishTitle" >
													<span class="help-block"></span>
												</div>
											</div>

											<div class="form-group">
												<label for="add_wish_text_input" class="col-xs-3 control-label">愿望内容：</label>
												<div class="col-xs-8 ">
														 <textarea class="form-control input-sm duiqi" id="add_wish_text_input"
														 maxlength="60" placeholder="限制六十字" name="wishText"></textarea>
													<span class="help-block"></span>
												</div>
											</div>

											<div class="form-group ">
												<label  class="col-xs-3 control-label">到期时间：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="add_wish_over_time_input"
													placeholder="" name="wishTitle">
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-xs btn-green" id="add_wish_btn">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>

				</div>
				<!-- 修改密码模块 -->
				<div role="tabpanel" class="tab-pane" id="password">
					<div class="check-div">预留位置</div>
					<div
						style="padding: 50px 0; margin-top: 50px; background-color: #fff; text-align: right; width: 420px; margin: 50px auto;">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="old_password" class="col-xs-4 control-label">原密码：</label>
								<div class="col-xs-5">
									<input type="password" class="form-control input-sm duiqi" id="old_password"
										placeholder="" style="margin-top: 7px;">
									<span class="help-block"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label for="new_password" class="col-xs-4 control-label">新密码：</label>
								<div class="col-xs-5">
									<input type="password" class="form-control input-sm duiqi" id="new_password"
										placeholder="" style="margin-top: 7px;">
									<span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
								<div class="col-xs-5">
									<input type="password" class="form-control input-sm duiqi" id="new_password_again"
										placeholder="" style="margin-top: 7px;">
									<span class="help-block"></span>									
								</div>
							</div>
							<div class="form-group text-right">
								<div class="col-xs-offset-4 col-xs-5"
									style="margin-left: 169px;">
									<button type="reset" class="btn btn-xs btn-white">取 消</button>
									<button type="button" class="btn btn-xs btn-green" id="edit_password_btn">保存</button>
								</div>
							</div>
						</form>
					</div>

				</div>
				<!--照片管理模块-->
				<div role="tabpanel" class="tab-pane" id="photo">

					<div class="check-div form-inline">
						<button class="btn btn-yellow btn-xs" data-toggle="modal"
									id="add_photo_btn">添加图片</button>

						<button class="btn btn-yellow btn-xs" data-toggle="modal"
									id="all_photo_btn">所有图片</button>

						<select class="" id="photo_album_select"></select>
						<button class="btn btn-white btn-xs" id="photo_album_btn">查 询</button>
					</div>
					<div class="data-div row" id="photo_table">
						<table class="table table-striped table-hover text-center">
								<thead>
									<tr>
										<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">上传日期</th>
										<th  class="text-center col-lg-5 col-md-5 col-sm-5 col-xs-5">上传相册</th>
										<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">上传相片</th>
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
					<div class="col-md-6 text-primary info" id="photo_page_info"></div>
					<!-- 分页条信息 -->
					<div class="col-md-6 nav" id="photo_page_nav"></div>
				</div>

				<!--弹出窗口心情记录-->
				<div class="modal fade" id="addPhoto" role="dialog"
				aria-labelledby="gridSystemModalLabel">
				<div class="modal-dialog" role="document" style="width: 700px">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="gridSystemModalLabel">添加照片</h4>
						</div>
						<div class="modal-body" style="height:500px">
							<div class="container-fluid">
								<form class="form-horizontal">
									<div class="form-group ">
										<label  class="col-xs-3 control-label">添加时间：</label>
										<div class="col-xs-8 ">
											<input type="text" class="form-control input-sm duiqi" id="add_photo_time_input"
												 placeholder=""  disabled>
											<span class="help-block"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="add_photo_type_select" class="col-xs-3 control-label">选择相册：</label>
										<div class="col-xs-6">
											<select class="form-control input-sm duiqi" id="add_photo_type_select"></select>
											<input type="text" class="form-control input-sm duiqi" id="add_photo_type_input"
													 placeholder=""  style="display:none">
											<input type="checkbox" class=""  id="add_photo_type_checkbox" value="1">增加新相册 
											<span class="help-block"></span>
			 						 	</div>
									</div>
									<div class="form-group ">
										<label  class="col-xs-3 control-label">添加图片：</label>
										<div class="col-xs-8">
											<!--<input type="file" class="duiqi"  id="add_photo_file_input" value="请选择图片" placeholder="选择图片" />-->
											<div class="add_photo_file_input" id="add_photo_file_input"></div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-xs btn-xs btn-white"
								data-dismiss="modal">取 消</button>
							<!--<button type="button" class="btn btn-xs btn-xs btn-green" id="add_modal_photo_btn">保
								存</button>-->
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>

				</div>
				<!--账号密码管理模块-->
					<div role="tabpanel" class="tab-pane" id="account">
							<div class="check-div form-inline row">
								<button class="btn btn-yellow btn-xs" id="add_account_modal_btn">添加账户</button>
								<button class="btn btn-yellow btn-xs" id="query_account_all_btn">查询所有</button>
								<input type="text" class="form-control input-sm"
									placeholder="网站名查询" id="account_name_query_input">
								<button class="btn btn-white btn-xs" id="account_name_query_btn">查 询</button>
							</div>
								
		
							<div class="data-div row" id="account_table">
									<table class="table table-striped table-hover text-center">
											<thead>
												<tr>
													<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">服务厂家</th>
													<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">账	   号</th>
													<th  class="text-center col-lg-3 col-md-3 col-sm-3 col-xs-3">密	   码</th>
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
						<div class="col-md-6 text-primary info" id="account_page_info"></div>
						<!-- 分页条信息 -->
						<div class="col-md-6 nav" id="account_page_nav"></div>
					</div>
							<!--弹出窗口添加account-->
							<div class="modal fade" id="addAccount" role="dialog"
								aria-labelledby="gridSystemModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="gridSystemModalLabel">添加事件</h4>
										</div>
										<div class="modal-body">
											<div class="container-fluid">
												<form class="form-horizontal">
													<div class="form-group ">
														<label  class="col-xs-3 control-label">服务厂家：</label>
														<div class="col-xs-8 ">
															<input type="text" class="form-control input-sm duiqi" id="add_account_name_input"
																 placeholder="" name="add_account_name">
															<span class="help-block"></span>
														</div>
													</div>
													<div class="form-group">
														<label  class="col-xs-3 control-label">账	 户：</label>
														<div class="col-xs-8 ">
															<input type="text" class="form-control input-sm duiqi" id="add_account_user_input"
																 placeholder="" name="add_account_user">
															<span class="help-block"></span>
														</div>
													</div>
													<div class="form-group">
														<label  class="col-xs-3 control-label">密	  码：</label>
														<div class="col-xs-8">
															<input type="" class="form-control input-sm duiqi" id="add_account_password_input"
																 placeholder="" name="add_account_password">
														</div>
													</div>
												</form>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-xs btn-xs btn-white"
												data-dismiss="modal">取 消</button>
											<button type="button" class="btn btn-xs btn-xs btn-green" id="add_account_btn">保 存</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
		
							<!--弹出窗口修改account-->
							<div class="modal fade" id="editAccount" role="dialog"
								aria-labelledby="gridSystemModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="gridSystemModalLabel">修改事件</h4>
										</div>
										<div class="modal-body">
											<div class="container-fluid">
												<form class="form-horizontal">
													<div class="form-group ">
														<label  class="col-xs-3 control-label">服务厂家：</label>
														<div class="col-xs-8 ">
															<input type="text" class="form-control input-sm duiqi" id="edit_account_name_input"
																 placeholder="" name="edit_account_name">
															<span class="help-block"></span>
														</div>
													</div>
													<div class="form-group">
														<label  class="col-xs-3 control-label">账 	户：</label>
														<div class="col-xs-8 ">
															<input type="text" class="form-control input-sm duiqi" id="edit_account_user_input"
																 placeholder="" name="edit_account_user">
															<span class="help-block"></span>
														</div>
													</div>
													<div class="form-group">
														<label  class="col-xs-3 control-label">密 	码：</label>
														<div class="col-xs-8">
															<input type="" class="form-control input-sm duiqi" id="edit_account_password_input"
																 placeholder="" name="edit_account_password">
														</div>
													</div>
												</form>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-xs btn-xs btn-white"
												data-dismiss="modal">取 消</button>
											<button type="button" class="btn btn-xs btn-xs btn-green" id="edit_account_modal_btn">保 存</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
				
					</div>
				<!--心情记录模块-->
				<div role="tabpanel" class="tab-pane" id="mind">
					<div class="check-div form-inline row">
						<button class="btn btn-yellow btn-xs" id="add_mind_modal_btn">心情记录</button>
						<button class="btn btn-yellow btn-xs" id="query_mind_all_btn">查询所有</button>
					</div>						

					<div class="data-div row" id="mind_table">
							<table class="table table-striped table-hover text-center">
									<thead>
										<tr>
											<th  class="text-center col-lg-2 col-md-2 col-sm-2 col-xs-2">记录时间</th>
											<th  class="text-center col-lg-9 col-md-9 col-sm-9 col-xs-9">心情</th>
											<th  class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1"></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
					</div>
					<!-- 显示分页信息 -->
		<div class="row text-center">
				<!-- 分页文字信息 -->
				<div class="col-md-6 text-primary info" id="mind_page_info"></div>
				<!-- 分页条信息 -->
				<div class="col-md-6 nav" id="mind_page_nav"></div>
			</div>
					<!--弹出窗口心情记录-->
					<div class="modal fade" id="addMind" role="dialog"
						aria-labelledby="gridSystemModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="gridSystemModalLabel">心情记录</h4>
								</div>
								<div class="modal-body">
									<div class="container-fluid">
										<form class="form-horizontal">
											<div class="form-group ">
												<label  class="col-xs-3 control-label">记录时间：</label>
												<div class="col-xs-8 ">
													<input type="text" class="form-control input-sm duiqi" id="add_mind_time_input"
														 placeholder="" name="mindTime" disabled>
													<span class="help-block"></span>
												</div>
											</div>
											<div class="form-group">
												<label for="add_mind_text_input" class="col-xs-3 control-label">心	情：</label>
												<div class="col-xs-8 ">
														 <textarea class="form-control input-sm duiqi" id="add_mind_text_input"
														 placeholder="" name="mindText"></textarea>
													<span class="help-block"></span>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-xs btn-xs btn-white"
										data-dismiss="modal">取 消</button>
									<button type="button" class="btn btn-xs btn-xs btn-green" id="add_mind_btn">保
										存</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="${APP_PATH }/static/js/jquery.nouislider.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/js/imagesUpload.js"></script>

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

		//为心愿添加模态框中开启时间
		$("#add_wish_over_time_input").solarlunar();

		$.ajax({
			url:"${APP_PATH}/lastMind",
			data:"userId="+user_array[0],
			type:"POST",
			success:function(data){console.log(data);
				$("#userMind_show").text(data.extend.ming);
			}
		})
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
						case "thing" :
								 thing_query_url = url;
								 thing_query_data = data;
								 build_thing_table_body(result);
								 build_page_info(result,"#thing_page_info");
								 build_page_nav(result,"#thing_page_nav",url,data,method);break;
						case "account" :
								 account_query_url = url;
								 account_query_data = data;
								 build_account_table_body(result);
								 build_page_info(result,"#account_page_info");
								 build_page_nav(result,"#account_page_nav",url,data,method);break;

						case "mind"	:
								mind_query_url = url;
								mind_query_data = data;
								build_mind_table_body(result);
								build_page_info(result,"#mind_page_info");
								 build_page_nav(result,"#mind_page_nav",url,data,method);break;

						case "wish" :
								wish_query_url = url;
								wish_query_data = data;
								build_wish_table_body(result);
								build_page_info(result,"#wish_page_info");
								build_page_nav(result,"#wish_page_nav",url,data,method);break;

						case "journal" :
								journal_query_url = url;
								journal_query_data = data;
								build_journal_table_body(result);
								build_page_info(result,"#journal_page_info");
								build_page_nav(result,"#journal_page_nav",url,data,method);break;

						case "photo" :
								photo_query_url = url;
								photo_query_data = data;
								build_photo_table_body(result);
								build_page_info(result,"#photo_page_info");
								build_page_nav(result,"#photo_page_nav",url,data,method);break;

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

		//显出传入结点校验结果校验状态
		function clear_show_validate(ele){
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
		}

	</script>

	<!--事件配置-->
	<script>
		//我在jquery-solarlunar.js中设置了set_open_type_value(value)函数，
		//这样为代表日历类型的open_type赋值，在赋值之后直接为add_thing_timeType_input1/2进行选择处理。

		var currentPage; //构建分页信息时，对其赋值，代表当前页
		var thing_query_data; //最近一次事件查询请求的数据
		var thing_query_url; //最近一次事件查询的url

		//初始化userView后直接查询用户所有事件进行显示
		to_page("${APP_PATH }/thingQueryAll",{userId:user_array[0],pn:1},"thing");

		//为事件添加按钮附加点击事件打开模态框
		$("#add_thing_modal_btn").click(function(){
			//重置模态框样式
			$("#add_thing_text_input").val("");
			$("#add_thing_title_input").val("");
			$("#addThing form").find("*").removeClass("has-error has-success");
			$("#addThing form").find(".help-block").text("");
			$('#addThing').modal({
				backdrop : 'static'
			});
		})

		//为事件添加日期选择
		$("#add_thing_time_input").solarlunar();
		$("#edit_thing_time_input").solarlunar();

		//事件添加模态框添加用户
		$("#add_thing_btn").click(function(){
			var add_thing_title_value = $("#add_thing_title_input").val();
			var add_thing_text_value = $("#add_thing_text_input").val();
			var pattern = new RegExp("[`~!@#$^&*()=|{}''\\[\\]<>/?~！@#￥……&*（）——|{}【】‘”“'？]") ;
			var circulate = $(':radio[name = "add_circulate_radio"]:checked').val();
			if(pattern.test(add_thing_text_value)){
				show_validate_msg("#add_thing_text_input","error","存在特殊字符");
				return false;
			}else{
				show_validate_msg("#add_thing_text_input","success","");
			}
			if(pattern.test(add_thing_title_value)){
				show_validate_msg("#add_thing_title_input","error","存在特殊字符");
				return false;
			}else{
				show_validate_msg("#add_thing_title_input","success","");
			}
			$.ajax({
				url:"${APP_PATH }/thingAdd",
				type:"POST",
				data:{
					thingTitle : add_thing_title_value,
					thingText : add_thing_text_value,
					thingTime : $("#add_thing_time_input").val(),
					timeType : open_type,
					circulate: circulate,
					ability : 1,
					userId : user_array[0]
				},
				success:function(result){
					alert(result.msg);
					$("#addThing").modal("hide");
				}
			})
			
		});

		//事件查询对应用户所有事件
		$("#query_thing_all_btn").click(function(){
			var userId = user_array[0];
			var data = {userId:userId,pn:1};
			var result = to_page("${APP_PATH }/thingQueryAll",data,"thing");
		});

		//有效事件查询
		$("#query_thing_able_btn").click(function(){
			to_page("${APP_PATH}/thingQueryAble",{userId :user_array[0],pn:1},"thing");
		})
		
		//失效事件查询
		$("#query_thing_disable_btn").click(function(){
			to_page("${APP_PATH}/thingQueryDisable",{userId :user_array[0],pn:1},"thing");
		})

		//事件参与人查询
		$("#thing_title_query_btn").click(function(){
			var query_thing_title_data = {thingTitle:$("#thing_title_query_input").val(),pn:1,userId:user_array[0]}
			to_page("${APP_PATH }/thingQueryByTitle",query_thing_title_data,"thing");
		})


		//事件删除功能
		$(document).on("click",".thing_delete_btn",function(){
			var thingContent = $(this).parents("tr").find("td:eq(0)").text() + "  " + $(this).parents("tr").find("td:eq(1)").text();
			var thingId =  $(this).attr("thing_del_id");
			if(confirm("确认删除【"+thingContent+"】吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/thingDelete",
					type:"POST",
					data:"thingId=" + thingId,
					success:function(result){
						alert(result.msg);
						to_page(thing_query_url,thing_query_data,"thing");
					}
				})
			}
		});

		//事件修改按钮打开模态框
		$(document).on("click",".thing_edit_btn",function(){
			var thingTitle = $(this).parents("tr").find("td:eq(0)").text();
			var thingText =  $(this).parents("tr").find("td:eq(1)").text();
			var timeType = $(this).parents("tr").find("td:eq(3)").text() == '阳历'?1:2;
			var time = $(this).parents("tr").find("td:eq(2)").text();
			var circulate = $(this).parents("tr").find("td:eq(4)").text() == '是' ? 1 : 0;
			var thingId = $(this).attr("thing_edit_id");
			$("#edit_thing_btn").attr("thing_edit_id",thingId);
			$("#edit_thing_title_input").val(thingTitle);
			$("#edit_thing_text_input").val(thingText);
			$("#edit_thing_timeType_input"+timeType).prop("checked","true");
			$("#edit_thing_time_input").val(time);
			$("input[name='edit_circulate_radio'][value="+circulate+"]").attr("checked",true); 
			$('#editThing').modal({
				backdrop : 'static'
			});

		});

		//事件修改功能
		$("#edit_thing_btn").click( function(){
			var edit_thing_title_value = $("#edit_thing_title_input").val();
			var edit_thing_text_value = $("#edit_thing_text_input").val();
			var thingId = $(this).attr("thing_edit_id");
			var circulate = $(':radio[name = "edit_circulate_radio"]:checked').val()
			$.ajax({
				url:"${APP_PATH }/thingUpdate",
				type:"POST",
				data:{
					thingId : thingId,
					thingTitle : edit_thing_title_value,
					thingText : edit_thing_text_value,
					thingTime : $("#edit_thing_time_input").val(),
					timeType : $('input[name="editTimeType"]:checked').val(),
					circulate : circulate,
					userId : user_array[0]
				},
				success:function(result){
					alert(result.msg);
					to_page(thing_query_url,thing_query_data,"thing");
					$("#addThing").modal("hide");
					$("#editThing").modal('hide');
				}
			})
		});
	
		//事件效果置换
		$(document).on("click",".thing_change_btn",function(){
			var thingId =  $(this).attr("thing_change_id");
			var ability =  $(this).attr("thing_change_ability");
			var circulate = $(this).parents("tr").find("td:eq(0)").text() == '是'?1:0;
			ability == 0 ? ability = 1 : ability = 0;
			$.ajax({
				url:"${APP_PATH}/thingUpdate",
				type:"POST",
				data:{thingId : thingId, ability : ability,circulate:circulate},
					success:function(result){
						to_page(thing_query_url,thing_query_data,"thing");
				}
			})
		});

		//构建查询后事件的表格的数据栏
		function build_thing_table_body(result){
			$("#thing_table tbody").empty();
			var things = result.extend.page.list;
			$.each(things, function(index, item) {
			  //var thingIdTd = $("<td></td>").append(item.thingId).addClass("hide");
				var thingTitleTd = $("<td></td>").append(item.thingTitle);console.log(item.ability);
				var thingTextTd = $("<td></td>").append(item.thingText);
				var timeTypeTd = $("<td></td>").append(
						item.timeType == '2' ? '农历' : '阳历');
				var thingTimeTd = $("<td></td>").append(item.thingTime);
				var circulateTd = $("<td></td>")
						.append(item.circulate == '1' ? '是':'否');
				var changeBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm thing_change_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append(item.ability == 1?"置为失效":"置为有效");
				//为编辑按钮添加一个自定义的属性,来表示当前事件id
				changeBtn.attr("thing_change_id",item.thingId);
				changeBtn.attr("thing_change_ability",item.ability);
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm thing_edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性,来表示当前事件id
				editBtn.attr("thing_edit_id",item.thingId);
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm thing_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的事件id
				delBtn.attr("thing_del_id",item.thingId);
				var btnTd = $("<td></td>").append(changeBtn).append(" ").append(editBtn).append(" ").append(
						delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(thingTitleTd).append(thingTextTd).append(thingTimeTd).append(
					timeTypeTd).append(circulateTd).append(btnTd).appendTo("#thing_table tbody");
			});
		}
	</script>

	<!--修改密码配置-->
	<script>
		$("#edit_password_btn").click(function(){
			var old_password = $("#old_password").val();
			var new_password = $("#new_password").val();
			var new_password_again = $("#new_password_again").val();
			var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ]");
			if(old_password != user_array[2]){
				show_validate_msg("#old_password","error","Please input right password!");
				return false;
			}else{
				show_validate_msg("#old_password","success","");
			}

			if(pattern.test(new_password)){
				show_validate_msg("#new_password","error","Please do not enter special characters!");
				return false;
			}else if(new_password != new_password_again){
				show_validate_msg("#new_password","error","Two password inconsistencies!");
				show_validate_msg("#new_password_again","error","Two password inconsistencies!");
				return false;
			}else if(old_password == new_password){
				show_validate_msg("#old_password","error","Two passwords can't be the same!");
				show_validate_msg("#new_password","error","Two passwords can't be the same!");
				return false;
			}else{
				show_validate_msg("#new_password","success","");
				show_validate_msg("#new_password_again","success","");
				show_validate_msg("#old_password","success","");
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

	<!--account配置-->
	<script>
			var account_query_url;	//account最近构建表格查询url和对应数据
			var account_query_data;

			//account表格栏构建
			function build_account_table_body(result){
			$("#account_table tbody").empty();
			var accounts = result.extend.page.list;
			$.each(accounts, function(index, item) {
				var accountNameTd = $("<td></td>").append(item.accountName);
				var accountUserTd = $("<td></td>").append(item.accountUser);
				var accountPasswordTd = $("<td></td>").append(item.accountPassword);
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm account_edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性,来表示当前事件id
				editBtn.attr("account_edit_id",item.accountId);
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm account_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的事件id
				delBtn.attr("account_del_id",item.accountId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(accountNameTd).append(accountUserTd).append(accountPasswordTd).append(btnTd).appendTo("#account_table tbody");
			});
		}

			//为页面添加按钮打开模态框
			$("#add_account_modal_btn").click(function(){
				$("#add_account_name_input").val("");
				$("#add_account_user_input").val("");
				$("#add_account_password_input").val("");
				$("#addAccount form").find("*").removeClass("has-error has-success");
				$("#addAccount form").find(".help-block").text("");
				$("#addAccount").modal({
					backdrop : 'static'
				})
			})

			//为模态框添加按钮附加ajax点击事件
			$("#add_account_btn").click(function(){
				var add_account_name_value = $("#add_account_name_input").val();
				var add_account_password_value = $("#add_account_password_input").val();
				var add_account_user_value = $("#add_account_user_input").val();
				var pattern = new RegExp("[`~!@#$^&*()=|{}''\\[\\]<>/?~！@#￥……&*（）——|{}【】‘”“'？]") ;;
				if(pattern.test(add_account_name_value)){
					show_validate_msg("#add_account_name_input","error","存在特殊字符");
					return false;
				}else{
					show_validate_msg("#add_account_name_input","success","");
				}
				if(pattern.test(add_account_password_value)){
					show_validate_msg("#add_account_password_input","error","存在特殊字符");
					return false;
				}else{
					show_validate_msg("#add_account_password_input","success","");
				}
				if(pattern.test(add_account_user_value)){
					show_validate_msg("#add_account_user_input","error","存在特殊字符");
					return false;
				}else{
					show_validate_msg("#add_account_user_input","success","");
				}

				$.ajax({
					url:"${APP_PATH }/addAccount",
					type:"POST",
					data:{
						accountName : add_account_name_value,
						accountPassword : add_account_password_value,
						accountUser : add_account_user_value,
						userId : user_array[0]
					},
					success: function(result){
						alert(result.msg);
						$("#addAccount").modal("hide");
						to_page("${APP_PATH }/queryAccountAll",{'userId':user_array[0],'pn':1},"account");
					}
				})
			})
	
			//查询所有account
			$("#query_account_all_btn").click(function(){
				to_page("${APP_PATH }/queryAccountAll",{'userId':user_array[0],'pn':1},"account");
			})

			//构建模糊厂商模糊查询
			$("#account_name_query_btn").click(function(){
				var account_name_query_value = $("#account_name_query_input").val();
				var data = {'userId':user_array[0],'accountName':account_name_query_value};
				to_page("${APP_PATH }/queryAccountLikeName",data,"account")
			})

			//编辑account模态框
			$(document).on("click",".account_edit_btn",function(){
				var accountName = $(this).parents("tr").find("td:eq(0)").text();
				var accountUser = $(this).parents("tr").find("td:eq(1)").text();
				var accountPassword = $(this).parents("tr").find("td:eq(2)").text();

				$("#edit_account_name_input").val(accountName);
				$("#edit_account_user_input").val(accountUser);
				$("#edit_account_password_input").val(accountPassword);
				$("#edit_account_modal_btn").attr("accountId",$(this).attr("account_edit_id"));
				$("#editAccount").modal({
					backdrop : 'static'
				})				
			})

			//编辑模态框上传编辑请求
			$("#edit_account_modal_btn").click(function(){
				var accountId = $("#edit_account_modal_btn").attr("accountId");
				var accountName = $("#edit_account_name_input").val();
				var accountUser =$("#edit_account_user_input").val();
				var accountPassword = $("#edit_account_password_input").val();

				$.ajax({
					url:"${APP_PATH }/updateAccount",
					type:"POST",
					data:{
						'accountId':accountId,
						'accountName':accountName,
						'accountUser':accountUser,
						'accountPassword':accountPassword,
						'userId':user_array[0]
					},
					success:function(result){
						alert(result.msg);
						$("#editAccount").modal("hide");
						to_page("${APP_PATH }/queryAccountLikeName",{'accountName':accountName,'userId':user_array[0]},"account");
					}
				})
			})

			//删除account
			
		//事件删除功能
		$(document).on("click",".account_delete_btn",function(){
			var accountName = $(this).parents("tr").find("td:eq(0)").text();
			var accountId =  $(this).attr("account_del_id");
			if(confirm("确认删除【"+accountName+"】的账户吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH }/deleteAccount",
					type:"POST",
					data:{
						'accountId' : accountId,
						'userId' : user_array[0]
						},
					success:function(result){
						alert(result.msg);
						to_page(account_query_url,account_query_data,"account");
					}
				})
			}
		});
	</script>

	<!--mind配置-->
	<script>

		var mind_query_url;	//最新通过to_page构建页面的请求路径和数据
		var mind_query_data;

		//mind表格栏构建
		function build_mind_table_body(result){
			$("#mind_table tbody").empty();
			var minds = result.extend.page.list;
			$.each(minds, function(index, item) {
				var mindTimeTd = $("<td></td>").append(item.mindTime);
				var mindTextTd = $("<td></td>").append(item.mindText);
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm mind_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的事件id
				delBtn.attr("mind_del_id",item.mindId);
				var btnTd = $("<td></td>").append(delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(mindTimeTd).append(mindTextTd).append(btnTd).appendTo("#mind_table tbody");
			});
		}

		//查询所有
		$("#query_mind_all_btn").click(function(){
			to_page("${APP_PATH }/queryMindAll",{'userId':user_array[0],'pn':1},"mind");
		})

		//为心情记录添加模态框点击事件
		$("#add_mind_modal_btn").click(function(){
			$("#add_mind_text_input").val("");
			$("#addMind").modal({
				backdrop : 'static'
			})
		})

		//为添加模态框时间配置，能实时获取时间
		$(document).ready(function() {
		function time() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		var second = date.getSeconds();
		
		var timeString = year + '-' + month + '-' + day  + ' ' + hour  + ':' + minute  + ':' + second;
		$("#add_mind_time_input").val(timeString);
	}
	time();
	setInterval(time, 1000);
});

		//添加模态框保存按钮
		$("#add_mind_btn").click(function(){
			$.ajax({
				url:"${APP_PATH }/addMind",
				type:"POST",
				data:{
					'userId': user_array[0],
					'mindTime': $("#add_mind_time_input").val(),
					'mindText':	$("#add_mind_text_input").val(),
				},
				success : function(result){
					alert(result.msg);
					$("#userMind_show").text($("#add_mind_text_input").val());
					to_page(mind_query_url,mind_query_data,"mind");
					$("#addMind").modal("hide");
				}
			})
		})

		//为删除按钮附加点击事件
		$(document).on("click",".mind_delete_btn",function(){
			var mindTime = $(this).parents("tr").find("td:eq(0)").text();
			var mindId =  $(this).attr("mind_del_id");
			if(confirm("确认删除【"+mindTime+"】的账户吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH }/deleteMind",
					type:"POST",
					data:{
						'mindId' : mindId,
						'userId' : user_array[0]
						},
					success:function(result){
						alert(result.msg);
						to_page(mind_query_url,mind_query_data,"mind");
					}
				})
			}
		});


	</script>

	<!--wish配置-->
	<script>
		var wish_query_url;
		var wish_query_data;//最新通过to_page构建页面的请求路径和数据

		//根据标题来模糊搜索
		$("#wish_title_query_btn").click(function(){
			var wish_title_query_value = $("#wish_title_query_input").val();

			to_page("${APP_PATH }/queryWishByLikeTitle",{'userId' : user_array[0],'wishTitle':wish_title_query_value},"wish");
		})

		//点击实现，修改
		$(document).on("click",".wish_edit_btn",function(){
			var wishId =  $(this).attr("wish_edit_id");
			var wishStatus = $(this).parents("tr").find("td:eq(3)").text();
			if(wishStatus != "前进中"){
				return false;
			}
			$.ajax({
				url:"${APP_PATH }/updateWish",
				type:"POST",
				data:{
					'wishId' : wishId,
					'wishStatus' : 2
				},
				success : function(result){
					if(result.code == 100)
						alert("恭喜你，完成心愿");
					to_page(wish_query_url,wish_query_data,"wish");
				}
			})
		})

		//根据wishId删除
		$(document).on("click",".wish_delete_btn",function(){
			var wishTitle = $(this).parents("tr").find("td:eq(0)").text();
			var wishId =  $(this).attr("wish_del_id");
			if(confirm("确认删除【"+wishTitle+"】的账户吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH }/deleteWish",
					type:"POST",
					data:{
						'wishId' : wishId,
						'userId' : user_array[0]
						},
					success:function(result){
						alert(result.msg);
						to_page(wish_query_url,wish_query_data,"wish");
					}
				})
			}
		});

		//wish表格的构建
		function build_wish_table_body(result){
			$("#wish_table tbody").empty();
			var wishs = result.extend.page.list;
			$.each(wishs, function(index, item) {
				var wishTitleTd = $("<td></td>").append(item.wishTitle);
				var wishTextTd = $("<td></td>").append(item.wishText);
				var wishOverTimeTd = $("<td></td>").append(item.wishOverTime);
				var wishStatusTd = $("<td></td>").append(item.wishStatus == 1 ? '前进中':(item.wishStatus == 2 ? '已达成' : '失败'));
				var editBtn = $("<button></button>").addClass(
						"btn btn-sm wish_edit_btn");
					//如果处于进行中的愿望可以点击,完成的默认，过期的过期样式
					if(item.wishStatus == 1) editBtn.addClass("btn-primary").append($("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("实现吗");
					else if(item.wishStatus == 2) editBtn.append($("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("已实现");
					else editBtn.addClass("btn-danger").append($("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("过期勒");
					//为编辑按钮添加一个自定义的属性,来表示当前事件id
					editBtn.attr("wish_edit_id",item.wishId);
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm wish_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的事件id
				delBtn.attr("wish_del_id",item.wishId);

				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(wishTitleTd).append(wishTextTd).append(wishOverTimeTd).append(wishStatusTd).append(btnTd).appendTo("#wish_table tbody");
			});
		}

		//查询对应用户全部
		$("#query_wish_all_btn").click(function(){
			to_page("${APP_PATH }/queryWishAll",{'userId':user_array[0]},"wish");
		})

		//添加模态框中按钮附加点击事件
		$("#add_wish_btn").click(function(){
			var wish_title = $("#add_wish_title_input").val();
			var wish_text = $("#add_wish_text_input").val();
			var wish_over_time = $("#add_wish_over_time_input").val();
			if(open_type != 1){
				show_validate_msg("#add_wish_over_time_input","error","请选择公历");
				return false;
			}else{
				show_validate_msg("#add_wish_over_time_input","success","");
			}

			$.ajax({
				url:"${APP_PATH }/addWish",
				type:"POST",
				data:{
					'wishTitle' : wish_title,
					'wishText' : wish_text,
					'wishOverTime' : wish_over_time,
					'userId' : user_array[0],
					'wishStatus' : '1'
				},
				success : function(result){
					alert(result.msg);
					to_page(wish_query_url,wish_query_data,"wish");
					$('#addWish').modal("hide");
				}
			})

		})

		//添加按钮附加点击事件，打开模态框
		$("#add_wish_modal_btn").click(function(){
			//重置模态框样式
			$("#add_wish_text_input").val("");
			$("#add_wish_title_input").val("");
			$("#addWish form").find("*").removeClass("has-error has-success");
			$("#addWish form").find(".help-block").text("");
			//打开添加模态框
			$("#addWish").modal({
				backdrop : 'static'
			})
		})
	</script>

	<!--journal配置-->
	<script>
		var journal_query_url;
		var journal_query_data;//最新通过to_page构建页面的请求路径和数据

		$("#add_change_thing_time_input").solarlunar();

		//阅读日记
		$(document).on("click",".journal_read_btn",function(){
			var journalTime = $(this).parents("tr").find("td:eq(0)").text();
			var journalWeek = $(this).parents("tr").find("td:eq(1)").text();
			var journalWeather = $(this).parents("tr").find("td:eq(2)").text();
			var journalText = $(this).parents("tr").find("td:eq(3)").text();
		
			$("#read_journal_time_input").text(journalTime);
			$("#read_journal_week_input").text(journalWeek);
			$("#read_journal_weather_input").text(journalWeather);
			$("#read_journal_text_input").val(journalText);

			$("#readJournal").modal({
				backdrop : 'static'
			})
		})

		//删除日记
		$(document).on("click",".journal_delete_btn",function(){
			var journalTime = $(this).parents("tr").find("td:eq(0)").text();
			var journalId =  $(this).attr("journal_del_id");
			if(confirm("确认删除【"+journalTime+"】的账户吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH }/deleteJournal",
					type:"POST",
					data:{
						'journalId' : journalId,
						'userId' : user_array[0]
						},
					success:function(result){
						alert(result.msg);
						to_page(journal_query_url,journal_query_data,"journal");
					}
				})
			}
		});


		//根据时间查询
		$("#journal_time_query_btn").click(function(){
			var journal_time = $("#journal_time_query_input").val();
			var patter = /^(\d{4})(-)(\d{2})(-)(\d{2})$/;
			
			if(!patter.test(journal_time)){
				alert("请输入 yyyy-mm-dd");
				return false;
			}

			to_page("${APP_PATH0 }/queryJournalByTime",{'userId':user_array[0],'pn':1,'journalTime':journal_time},"journal");
			
		})

		//查询所有日记
		$("#query_journal_all_btn").click(function(){
			to_page("${APP_PATH }/queryJournalAll",{'userId':user_array[0],'pn':1},"journal");
		})

		//日记转提醒事件
		$(document).on("click",".journal_change_btn",function(){
			var journalTime = $(this).parents("tr").find("td:eq(0)").text();
			var journalText = $(this).parents("tr").find("td:eq(3)").text();
			$("input[name='edit_circulate_radio'][value="+1+"]").attr("checked",true);
			$("#add_change_thing_time_input").val(journalTime);
			$("#add_change_thing_text_input").val(journalText);
			$("#add_change_thing_title_input").val("本人");
			$("input[name='add_change_thing_radio'][value='1']").prop("checked",true); 
			$("#journal_change_thing form").find("*").removeClass("has-error has-success");
			$("#journal_change_thing form").find(".help-block").text("");
			$("#journal_change_thing").modal({
				backdrop : 'static'
			});
		})

		//提醒时间模态框添加
		$("#add_change_thing_btn").click(function(){
			var thing_title = $("#add_change_thing_title_input").val();
			var thing_text = $("#add_change_thing_text_input").val();
			var pattern = new RegExp("[`~!@#$^&*()=|{}''\\[\\]<>/?~！@#￥……&*（）——|{}【】‘”“'？]") ;
			var circulate = $(':radio[name = "add_change_thing_radio"]:checked').val();
			if(pattern.test(thing_text)){
				show_validate_msg("#add_change_thing_text_input","error","存在特殊字符");
				return false;
			}else{
				show_validate_msg("#add_change_thing_text_input","success","");
			}
			if(pattern.test(thing_title)){
				show_validate_msg("#add_change_thing_title_input","error","存在特殊字符");
				return false;
			}else{
				show_validate_msg("#add_change_thing_title_input","success","");
			}
			$.ajax({
				url:"${APP_PATH }/thingAdd",
				type:"POST",
				data:{
					thingTitle : thing_title,
					thingText : thing_text,
					thingTime : $("#add_change_thing_time_input").val(),
					timeType : $('input[name="add_change_thing_radio"]:checked').val(),
					circulate: circulate,
					ability : 1,
					userId : user_array[0]
				},
				success:function(result){
					alert(result.msg);
					$("#journal_change_thing").modal("hide");
				}
			})
		})

		//journal表格体构建
		function build_journal_table_body(result){
			$("#journal_table tbody").empty();
			var journals = result.extend.page.list;
			$.each(journals, function(index, item) {
				var journalTimeTd = $("<td></td>").append(item.journalTime);
				var journalWeekTd = $("<td></td>").append(item.journalWeek);
				var journalTextTd = $("<td></td>").append(item.journalText).addClass("limitNum");
				var journalWeatherTd = $("<td></td>").append(item.journalWeather == 1 ? '晴天':(item.journalWeather == 2 ? '阴天' : "雨天"));
				var changeBtn = $("<button></button>").addClass("btn btn-sm journal_change_btn btn-primary")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("提醒");
				var readBtn = $("<button></button>").addClass("btn btn-sm journal_read_btn btn-primary")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("阅读");
					//为阅读按钮添加一个自定义的属性,来表示当前事件id
					readBtn.attr("journal_read_id",item.journalId);
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm journal_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的事件id
				delBtn.attr("journal_del_id",item.journalId);

				var btnTd = $("<td></td>").append(changeBtn).append(" ").append(readBtn).append(" ").append(delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(journalTimeTd).append(journalWeekTd).append(journalWeatherTd).append(journalTextTd).append(btnTd).appendTo("#journal_table tbody");
			});
		}

		//添加模态框保存按钮点击事件
		$("#add_journal_btn").click(function(){
			var journal_time = $("#add_journal_time_input").text();
			var journal_week = $("#add_journal_week_input").text();
			var journal_weather = $("#add_journal_weather_input").val();
			var journal_text = $("#add_journal_text_input").val();
			$.ajax({
				url:"${APP_PATH }/addJournal",
				type:"POST",
				data:{
					'userId' : user_array[0],
					'journalTime' : journal_time,
					'journalWeek' : journal_week,
					'journalWeather' : journal_weather,
					'journalText' : journal_text
				},
				success : function(result){
					alert(result.msg);
					$("#addJournal").modal("hide");
				}
			})
		})

		//添加打开模态框
		$("#add_journal_modal_btn").click(function(){
			var date = new Date();
			var week = date.getDay()==0?7:date.getDay();
			var year = date.getFullYear();
			var month = date.getMonth()+1;
			var day =  date.getDate();
			var journalTime = year+"年"+ month +"月" + day + "日";
			$("#add_journal_time_input").text(journalTime);
			$("#add_journal_week_input").text("星期"+week);
			//重置模态框样式
			$("#add_journal_text_input").val("");
			$("#addJournal form").find("*").removeClass("has-error has-success");
			$("#addJournal form").find(".help-block").text("");
			$("#addJournal").modal({
				backdrop : 'static'
			})
		})

	</script>

	<!--photo配置-->
	<script>
		var photo_query_url;
		var photo_query_data;//最新通过to_page构建页面的请求路径和数据
		var photo_type_judge = 0; //用来判断增加相片时，用户是已有的还是新增的

		//删除照片
		$(document).on("click",".photo_delete_btn",function(){
			var photoId = $(this).attr("photo_del_id");
			if(confirm("确认删除照片吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH }/deletePhoto",
					type:"POST",
					data:{
						'photoId' : photoId,
						'userId' : user_array[0]
						},
					success:function(result){
						alert(result.msg);
						to_page(photo_query_url,photo_query_data,"photo");
					}
				})
			}
		});

		//下载图片,按钮绑定勒<a></a>标签
	


		//根据相册查询相片
		$("#photo_album_btn").click(function(){
			var photoType = $("#photo_album_select").val();
			to_page("${APP_PATH}/queryPhotoByType",{'userId':user_array[0],'photoType':photoType},"photo");
		})

		//点击判断是否增加新相册
		$("#add_photo_type_checkbox").click(function(){
			photo_type_judge == 0 ? photo_type_judge = 1 : photo_type_judge = 0;
			$("#add_photo_type_select").toggle();
			$("#add_photo_type_input").toggle();
		})

		
		$("#photo_album_select").click(function(){
			select_photo_type();
		});
		$("#add_photo_type_select").click(function(){
			select_photo_type();
		});

		//查询用户相册类型函数
		function select_photo_type(){
			$.ajax({
				type:"POST",
				url:"${APP_PATH}/queryPhotoType",
				data:{
					'userId' : user_array[0]
				},
				success: function(result){
					$("#photo_album_select").empty();
					$("#add_photo_type_select").empty();
				//	alert(result.extend.types.length);
					if(result.extend.types == null || result.extend.types.length == 0){
					}
					$.each(result.extend.types,function(index,item){
						var selectOption = $("<option></option>").text(item);
						// $("#photo_album_select").append(selectOption);
						$("#photo_album_select").append('<option>' + item + '</option>');
						$("#add_photo_type_select").append(selectOption);
					})
				}
			})
		}

		//配置添加模态框
		$("#add_photo_btn").click(function(){
			select_photo_type();
			$("#add_photo_file_input").val("");
			$("#addPhoto").modal({
				backdrop : "static"
			})
		})

		//时间显示配置
		$(document).ready(function() {
		function time() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		var second = date.getSeconds();
		
		var timeString = year + '-' + month + '-' + day  + ' ' + hour  + ':' + minute  + ':' + second;
		$("#add_photo_time_input").val(timeString);
			}
			time();
			setInterval(time, 1000);
		});


		$(".add_photo_file_input").initUpload({
				uploadUrl : "${APP_PATH}/addPhoto",
				fileMaxNum:	30
      });


		/* //添加模态框点击保存事件
		$("#add_modal_photo_btn").click(function(){
			var photo_time = $("#add_photo_time_input").val();
			if(photo_type_judge == 0)
				var photo_type = $("#add_photo_type_select").val();
			else 
				var photo_type = $("#add_photo_type_input").val();
			var photoFile = $("#add_photo_file_input")[0].files[0];
			var formdata = new FormData();
			if(photoFile == null){
				alert("上传照片");
				return false;
			}
			formdata.append("photoTime",photo_time);
			formdata.append("photoType",photo_type);
			formdata.append("file",photoFile);
			formdata.append("userId",user_array[0]);
			$.ajax({
				url : "${APP_PATH }/addPhoto",
				type: "POST",
				data : formdata,
				cache: false, 
       			processData: false,
      			contentType: false,
				success : function(result){
					alert(result.msg);
					if(photo_type_judge != 0)
						select_photo_type();
				}
			})
		}) */

		//构建照片表体
		function build_photo_table_body(result){
			$("#photo_table tbody").empty();
			var photos = result.extend.page.list;
			$.each(photos, function(index, item) {
				var photoTimeTd = $("<td></td>").append(item.photoTime);
				var photoTypeTd = $("<td></td>").append(item.photoType);
				var photoFileTd = $("<td></td>").append($("<img>").attr("src","${APP_PATH}/"+item.photoUrl).addClass("tupian"));
				var downBtn = $("<a></a>").addClass("btn btn-sm photo_down_btn btn-primary")
								.append($("<span></span>").addClass("glyphicon glyphicon-download-alt")).append("下载").attr("href","${APP_PATH}/photoDownload?fileName="+item.photoUrl);
					//为阅读按钮添加一个自定义的属性,来表示当前事件id
					downBtn.attr("photo_down_id",item.photoId);
				var delBtn = $("<button></button> ").addClass(
						"btn btn-danger btn-sm photo_delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的事件id
				delBtn.attr("photo_del_id",item.photoId);

				var btnTd = $("<td></td>").append(downBtn).append(" ").append(delBtn);
				//append方法执行完成后还是返回原来的元素
				$("<tr></tr>").append(photoTimeTd).append(photoTypeTd).append(photoFileTd).append(btnTd).appendTo("#photo_table tbody");
			});
		}
		
		//查询所有照片
		$("#all_photo_btn").click(function(){
			to_page("${APP_PATH}/queryPhotoAll",{'userId':user_array[0]},"photo");
		})
	</script>

</body>

</html>