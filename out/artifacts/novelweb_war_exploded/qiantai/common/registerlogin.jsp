<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String path = request.getContextPath(); %>

<div class="login_register" style="display: none;">
	<h3 class="category">
		<ul class="clear">
			<li class="curren account_login"><span>账号登录</span><i class="line"></i></li>
			<li class="account_register"><span>账号注册</span><i class="line"></i></li>
		</ul>
		<img class="close" onclick="hidePopup()" src="<%=path%>/qiantai/images/guanbi.png">
	</h3>
	<!--账号登录-->
	<div class="loginArea" style="display: block;" id="loginMsg_new">
		<p class="tips"></p>
		<form action="#" method="post"   id="loginFrom">
			<p class="txt"><span class="img"><img src="<%=path%>/qiantai/images/zhanghao.png"></span><input type="text" name="tel" id="ltel" placeholder="手机号"></p>
			<p class="password"><span class="img"><img src="<%=path%>/qiantai/images/mima.png"></span><input type="password" name="pwd" id="lpwd" placeholder="密码"></p>
			<!--p class="checkbox"><span class="checked"></span><input style="display: none;" type="checkbox" id="arempass" name="rempass" value="" checked="checked"><label>自动登录</label><a class="fr" href="javascript:;" onclick="showpass();">忘记密码</a></p-->
			<p class="subBtn"><input type="button" name="loginBtn" id="loginBtn" value="登录"></p>

		</form>
	</div>
	<!--账号注册-->
	<div class="other_register registerDiv" style="display: none;">
		<p class="tips"></p>
		<form action="#" method="post" id="myform">
			<input name="a" value="doregister" type="hidden">
			<input name="url" value="" type="hidden">
			<p class="txt" id="r_username"><img src="<%=path%>/qiantai/images/zhanghao.png"><input type="text" id="tel" name="tel" placeholder="输入手机号"></p>

			<p class="password"><img src="<%=path%>/qiantai/images/mima.png"><input type="password" id="pwd" name="pwd" placeholder="输入密码"></p>
			<p class="password"><img src="<%=path%>/qiantai/images/mima.png"><input type="password" name="pwdconfirm" id="pwdconfirm" placeholder="再次输入密码"></p>
			<p class="txt" ><img src="<%=path%>/qiantai/images/zhanghao.png"><input type="text" id="nickname" name="nickname" placeholder="输入昵称"></p>
			<div class="code" style="height: 42px;">
				<p><input type="text" id="vcode" name="vcode" placeholder="输入验证码"><canvas width="104" height="104"></canvas></input></p>
				<span class="btn" id="btn" onclick="document.getElementById(&quot;code_img&quot;).src=document.getElementById(&quot;code_img&quot;).src+&quot;?&quot;+Math.random()"><img id="code_img" onclick="this.src=this.src+&quot;?&quot;+Math.random()" src="<%=path%>/vCodeServlet"   align="top" style="float:right;" alt="验证码"></span>
			</div>
			<p class="checkbox"><label>我已阅读并同意<a href="<%=path%>/qiantai/xieyi.jsp" target="_blank" id="r_xieyi">《用户服务协议》</a></label></p>
			<p class="subBtn"><input type="button"   id="registerBtn" name="registerBtn" value="立即注册"></p>
		</form>
	</div>
</div>
<div class="mask" style="display: none;"></div>