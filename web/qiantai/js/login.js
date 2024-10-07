$(window).ready(function(){

    $(".login_aBtn").click(function(){
        $(".mask").css("display","block");
        $(".login_register").css("display","block");
        $(".login_register .loginArea").css("display","block").siblings("div").css("display","none");
        $(".login_register .category ul li.account_login").addClass("curren").siblings("li").removeClass("curren");
    });
    $(".register_aBtn").click(function(){
        $(".mask").css("display","block");
        $(".login_register").css("display","block");
        $(".other_register").css("display","block").siblings("div").css("display","none");
        $(".login_register .category ul li.account_register").addClass("curren").siblings("li").removeClass("curren");
    });
    $(".login_register div .register").click(function(){
        $(this).parent().parent().css("display","none");
        $(this).parent().parent().siblings(".registerDiv").css("display","block");
    })
    $(".login_register .category ul li").on("click",function(){
        if($(this).hasClass("account_login")){
            $(".login_register .loginArea").css("display","block").siblings("div").css("display","none");
        }else {
            $(".other_register").css("display","block").siblings("div").css("display","none");
        }
        $(this).addClass("curren").siblings("li").removeClass("curren");
    });

    //同意复选框选中效果
    $(".login_register .checkbox span").click(function(){
        if($(this).hasClass("checked")){
            $(this).removeClass("checked").siblings("input").removeAttr("checked");
        }else{
            $(this).addClass("checked").siblings("input").attr("checked","checked");
        }
    });

    //密码框点击眼镜的图标  控制密码是否可见
    $(".login_register .password .disBtn").click(function(){
        if($(this).siblings("input").attr("type") == "password"){
            document.getElementById("password").type = "text";
            $(this).attr("src","images/openEyes.png");
        }else{
            document.getElementById("password").type = "password";
            $(this).attr("src","images/closeEyes.png");
        }
    });




});
function showlogin2() {
    $(".mask").show();
    $(".forgetArea").hide();
    $(".login_register").show();

}
function reg() {
    $(".mask").show();
    $(".forgetArea").hide();
    $(".login_register").show();
}

function hidePopup(){
    $(".mask").css("display","none");
    $(".login_register").css("display","none");
    $(".comment_popup").css("display","none");
    $(".reward_popup").css("display","none");
    $(".success_pop").css("display","none");
    $(".forgetArea").css("display","none");
    $("#loginpop").css("display","none");
};



//用户注册
$("#registerBtn").on('click',function(e){
    var tel = $('#tel').val()
    if(!tel){
       layer.msg('手机号不能为空');
        $('#tel').focus();
       return;
    }

    var regtel=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
    if(!tel.match(regtel)){
        layer.msg('请输入正确的手机号');
        return;
    }


    var pwd = $('#pwd').val()
    if(!pwd){
        layer.msg('密码不能为空');
        $('#pwd').focus();
        return;
    }
    var pwdconfirm = $('#pwdconfirm').val()
    if(!pwdconfirm){
        layer.msg('再次确认密码不能为空');
        $('#pwdconfirm').focus();
        return;
    }
    if(pwd!=pwdconfirm){
        layer.msg('两次密码输入不一致');
        $('#pwdconfirm').focus();
        return;
    }

    var nickname = $('#nickname').val()
    if(!nickname){
        layer.msg('昵称不能为空');
        $('#nickname').focus();
        return;
    }
    var vcode = $('#vcode').val()
    if(!vcode){
        layer.msg('验证码不能为空');
        $('#vcode').focus();
        return;
    }

    $.post("userinfoRegister.action", { tel:tel,pwd:pwd,nickname:nickname,vcode:vcode},
        function(data){
            var datas = data;
            datas = $.trim(datas)
            if(datas=="code_error"){
                layer.msg('验证码错误');
                $('#vcode').focus();
            }else if(datas=="tel_exists"){
                layer.msg('电话号码已存在');
                $('#tel').focus();
            }else{
                layer.msg('注册成功');
                $(".login_aBtn").trigger("click");
                $('#tel').val("");
                $('#pwd').val("");
                $('#pwdconfirm').val("");
                $('#vcode').val("");
                $('#nickname').val("");
            }

        });


});



//用户登录
$("#loginBtn").on('click',function(e){
    var tel = $('#ltel').val()
    if(!tel){
        layer.msg('手机号不能为空');
        $('#tel').focus();
        return;
    }

    var regtel=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
    if(!tel.match(regtel)){
        layer.msg('请输入正确的手机号');
        return;
    }

    var pwd = $('#lpwd').val()
    if(!pwd){
        layer.msg('密码不能为空');
        $('#pwd').focus();
        return;
    }

    var urls = $('#urls').val();

    $.post("userinfoLogin.action", { tel:tel,pwd:pwd},
        function(data){
            var datas = data;
            datas = $.trim(datas)
            if(datas=="loginerror"){
                layer.msg('用户名或密码错误');

            } else{
                if(urls!=null && urls!=''){
                    window.location.href = urls;
                }else{
                    window.location.href = 'index.action';
                }

            }

        });


});

$(".myBshelf").on("mouseenter",function(){
    $(this).addClass("myBshelfing");
}).on("mouseleave",function(){
    $(this).removeClass("myBshelfing");
})


function fav(id) {
    $.post("novelfav.action", { id:id},
        function(data){
            var datas = data;
            datas = $.trim(datas)
            if(datas=="true"){
                var t = '#' + id + 'joined';
                var m = '#' + id + 'a';
                $(m).hide();
                $(t).show();
            }
        });
}