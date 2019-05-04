<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!--面包屑导航 开始-->
	<div class="crumb_warp">
		<!--<i class="fa fa-bell"></i> 欢迎使用登陆网站后台，建站的首选工具。-->
		<i class="fa fa-home"></i> <a href="#">首页</a> &raquo; <a href="#">员工管理</a>
		&raquo; 按年龄检索员工
	</div>
	<!--面包屑导航 结束-->

	<!-- 结果页快捷搜索框 开始-->
	<div class="search_wrap">
		<form action="#" method="post">
			<table class="search_tab">
				<tr>
					<th width="120">起始年龄</th>
					<td>
					<td><input type="text" name="low" placeholder="起始年龄"></td>
					</td>
					<th width="70">终止年龄</th>
					<td><input type="text" name="hight" placeholder="终止年龄"></td>
					<td><input type="submit" name="sub" value="查询"></td>
				</tr>
			</table>
		</form>
	</div>
	<!--结果页快捷搜索框 结束-->


	<form action="#" method="post">
		<div class="result_wrap">

			<div class="result_content">
				<div class="short_wrap">
					<a href="#"><i class="fa fa-plus"></i>新增文章</a> <a href="#"><i
						class="fa fa-recycle"></i>批量删除</a> <a href="#"><i
						class="fa fa-refresh"></i>更新排序</a>
				</div>
			</div>
		</div>
	</form>

	<!--搜索结果页面 列表 结束-->
</body>
</html>