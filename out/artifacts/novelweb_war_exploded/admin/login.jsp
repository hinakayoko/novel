<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
    <link href="<%=path%>/css/style.min.css" rel="stylesheet">
    <link href="<%=path%>/css/login.min.css" rel="stylesheet">


    <title>起点小说网</title>
</head>
<body class="signin">
<div class="signinpanel">

    <div  align="center">
        <div style="margin-bottom:50px;font-size: 30px;margin-top: -50px;">起点小说网</div>
        <div style="width:300px;" align="center">
            <form action="#" method="post" >
                <h4 class="no-margins"> </h4>

                <div id="alert-error" class="alert alert-danger" style="padding:6px; display:none;">
                    用户名或密码错误
                </div>
                <input type="text" class="form-control uname" placeholder="用户名" id="uname" name="uname"  >
                <input type="password" class="form-control pword m-b" placeholder="密码" id="upwd" id="upwd"  >





                <button class="btn btn-success btn-block" type="button" onclick="return login();" id="btnSubmit">登录</button>
            </form>
        </div>
    </div>

</div>






</body>
<script type="text/javascript">
    function login(){
        var uname = $('#uname').val();
        var upwd = $('#upwd').val();

        if(!uname){
            $('#alert-error').text("用户名不能为空");
            $('#alert-error').show();
            return false;
        }
        if(!upwd){
            $('#alert-error').text("密码不能为空");
            $('#alert-error').show();
            return false;
        }

        $.post("<%=path%>/tadmin_login.action", { uname:uname,upwd:upwd},
            function(data){
                var datas = eval(data);
                datas = $.trim(datas)
                if(datas=="false"){
                    $('#alert-error').text("用户名密码错误");
                    $('#alert-error').show();
                    return false;
                }else{
                    window.location.href = '<%=path%>/admin/index.jsp';
                }

            });

    }

</script>
</html>
