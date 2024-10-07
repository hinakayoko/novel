<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>


<div class="leftmenu">
	<a href="<%=path%>/toEditUserinfo.action"
			<c:if test="${leftmenu==1}">class="is-active router-link-exact-active leftmenu__link"</c:if>
	        <c:if test="${leftmenu!=1}"> class="leftmenu__link"</c:if>
	  >个人资料</a>
	<a href="<%=path%>/bookshelflist.action"
	   <c:if test="${leftmenu==2}">class="is-active router-link-exact-active leftmenu__link"</c:if>
			<c:if test="${leftmenu!=2}"> class="leftmenu__link"</c:if>
	>我的书架</a>



	<a  href="<%=path%>/commentlist.action"  <c:if test="${leftmenu==3}">class="is-active router-link-exact-active leftmenu__link"</c:if>
	<c:if test="${leftmenu!=3}">  class="leftmenu__link"</c:if>>我的评论</a>


    <div class="leftmenu__divide"></div>
    <a href="<%=path%>/userinfoLoginout.action" class="leftmenu__link"> 退出登录 </a></div>