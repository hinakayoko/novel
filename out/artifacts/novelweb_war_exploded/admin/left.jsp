<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
<title>菜单栏</title>
</head>
<body>


	<!--main-->
	<div class="container-fluid mybody">
		<div class="main-wapper">
			<!--菜单-->
			<div id="siderbar" class="siderbar-wapper">

				<div class="panel-group menu" id="accordion" role="tablist" aria-multiselectable="true">

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									系统管理
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
								<a href="<%=path%>/tadmin_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									管理员管理
								</a>
								<a href="<%=path%>/admin/tadmin/tadmin_upwd.jsp" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									修改密码
								</a>

							</div>
						</div>
					</div>



					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne1">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne1" aria-expanded="true" aria-controls="collapseOne1">
									<span class="glyphicon glyphicon-list-alt"></span>
									小说管理
								</a>
							</h4>
						</div>
						<div id="collapseOne1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne1">
							<div class="list-group list-group-self">
								<a href="<%=path%>/novelcategory_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									小说分类管理
								</a>
								<a href="<%=path%>/novelinfo_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									小说管理
								</a>

							</div>
						</div>
					</div>


					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne4">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne4" aria-expanded="true" aria-controls="collapseOne4">
									<span class="glyphicon glyphicon-list-alt"></span>
									会员管理
								</a>
							</h4>
						</div>
						<div id="collapseOne4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne4">
							<div class="list-group list-group-self">
								<a href="<%=path%>/userinfo_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									会员管理
								</a>
							</div>
						</div>
					</div>





					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne2">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne2" aria-expanded="true" aria-controls="collapseOne2">
									<span class="glyphicon glyphicon-list-alt"></span>
									轮播图管理
								</a>
							</h4>
						</div>
						<div id="collapseOne2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne2">
							<div class="list-group list-group-self">
								<a href="<%=path%>/swiperinfo_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									轮播图管理
								</a>

							</div>
						</div>
					</div>



				<div class="panel panel-inner">
					<div class="panel-heading panel-heading-self" role="tab" id="headingOne3">
							<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne3" aria-expanded="true" aria-controls="collapseOne3">
						<span class="glyphicon glyphicon-list-alt"></span>
						公告管理
					</a>
					</h4>
				</div>
				<div id="collapseOne3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne3">
					<div class="list-group list-group-self">
						<a href="<%=path%>/noticeinfo_list.action" target="appiframe" class="list-group-item">
							<span class="glyphicon glyphicon-menu-right"></span>
							公告管理
						</a>
					</div>
				</div>
			</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne5">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne5" aria-expanded="true" aria-controls="collapseOne5">
									<span class="glyphicon glyphicon-list-alt"></span>
									评论管理
								</a>
							</h4>
						</div>
						<div id="collapseOne5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne5">
							<div class="list-group list-group-self">
								<a href="<%=path%>/novelcomment_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									评论管理
								</a>
							</div>
						</div>
					</div>



					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne6">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne6" aria-expanded="true" aria-controls="collapseOne6">
									<span class="glyphicon glyphicon-list-alt"></span>
									统计分析
								</a>
							</h4>
						</div>
						<div id="collapseOne6" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne6">
							<div class="list-group list-group-self">
								<a href="<%=path%>/viewReport.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									阅读量统计排行TOP10
								</a>

								<a href="<%=path%>/favReport.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									收藏量统计排行TOP10
								</a>

							</div>
						</div>
					</div>



					 
				 
					 





				</div>

			</div>
			<!--菜单-->
			<!--内容-->
			<div id="content" class="main-content">
				<iframe src="<%=path%>/tadmin_list.action" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
			</div>
			<!--内容-->
		</div>

	</div>

	<!--main-->

</body>
</html>