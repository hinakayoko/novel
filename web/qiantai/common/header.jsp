<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<script type="text/javascript" src="<%=path%>/qiantai/js/jquery-1.7.2.min.js"></script>
<script type='text/javascript' src='<%=path %>/js/layer/layer.js'></script>


	<div class="headerbg">
		<div class="header">
			<h1 class="fl logo"><a href="<%=path%>/index.action"><img    width="206" height="54" src="<%=path%>/qiantai/images/logo.png"></a></h1>
			<form class="fl" action="<%=path%>/categoryQuery.action" method="post">
				<div class="searchImg"><img src="<%=path%>/qiantai/images/search.png" alt="搜索"></div><input class="searchTxt" type="text" name="keyword" value="" placeholder="书名、作者名"><input class="searchBtn" type="submit" value="搜索">
			</form>
			<c:if test="${empty cuser}">
			<div class="fr loginArea" style="font:13px/1 'Microsoft Yahei', tahoma, arial, 'Hiragino Sans GB', \24b8b\4f53, sans-serif" id="top"><img class="peopleLogin"  title="潘多码小说网" width="20" height="20" src="<%=path%>/qiantai/images/peopleLogin.png"><a class="login_aBtn" href="javascript:showlogin2();" style="margin-left: 0;">登录</a>|<a class="register_aBtn" href="javascript:reg();">注册</a></div>
			</c:if>

<c:if test="${not empty cuser}">
			<div class="fr loginArea" id="top" style="font:13px/1 'Microsoft Yahei', tahoma, arial, 'Hiragino Sans GB', \24b8b\4f53, sans-serif"><img class="peopleLogin"    width="20" height="20" src="<%=path%>/qiantai/images/peopleLogin.png">
				你好，<a href="<%=path%>/toEditUserinfo.action" style="margin-right:10px;color:#d43a1f;">${sessionScope.cuser.nickname}</a><i>|</i>
				<a href="<%=path%>/userinfoLoginout.action">退出</a>
				<a class="myBshelf" href="<%=path%>/bookshelflist.action"><span class="img"></span>我的书架</a></div>
</c:if>

		</div>
	</div>
	<div class="nav">
		<div class="navLists">
			<ul class="fl nav-list">
				<li <c:if test="${empty cid}">class="current"</c:if> ><a href="<%=path%>/index.action">首页</a></li>
				<li <c:if test="${0== cid}">class="current"</c:if>><a href="<%=path%>/categoryQuery.action?cid=0">书库</a></li>
				<c:forEach items="${sessionScope.categorylist}" var="category">
				<li  <c:if test="${category.id== cid}">class="current"</c:if>><a href="<%=path%>/categoryQuery.action?cid=${category.id}">${category.name}</a></li>
				</c:forEach>


			</ul>

		</div>
	</div>
</div>

<jsp:include page="registerlogin.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/qiantai/js/login.js"></script>

