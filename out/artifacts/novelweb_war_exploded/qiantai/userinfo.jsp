<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="<%=path%>/qiantai/js/swiper/css/swiper.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>


    <link href="<%=path%>/qiantai/css/common.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/qiantai/css/index.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/qiantai/css/button.css" rel="stylesheet" type="text/css">

    <link href="<%=path%>/qiantai/css/usercenter.css" rel="stylesheet" type="text/css">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

    <title>潘多码小说网</title>

    <style>

        .leftmenu {
            background-color: #fff;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            flex-shrink: 0;
            margin-right: 16px;
            padding: 24px 0;
            width: 206px
        }

        .leftmenu__link {
            color: rgba(0, 0, 0, .85);
            height: 60px;
            padding: 18px 0 18px 24px
        }

        .leftmenu__link.is-active {
            background: linear-gradient(90deg, #ffece8 1%, #fff);
            border-left: 3px solid #e60000;
            color: #e60000;
            padding-left: 21px
        }

        .leftmenu__link:hover {
            color: #e60000
        }

        .leftmenu__divide {
            background: #ececec;
            height: 1px;
            margin: 16px 24px
        }

        .content {
            min-height: calc(100vh - 70px);
        }
    </style>
</head>

<body>

<!-- 顶部菜单栏 -->
<jsp:include page="common/header.jsp"></jsp:include>


<div class="w-1200 mx-auto flex home-site content" style="margin-top: 20px;">
    <jsp:include page="common/leftmenu.jsp"></jsp:include>
    <div class="main">
        <div  class="setting">
            <div  class="tab">
                <a href="<%=path%>/toEditUserinfo.action"><div  class="tab-item target"><p  class="tab-label">基本信息</p>   </div></a>
                <a href="<%=path%>/qiantai/modifyHead.jsp"> <div  class="tab-item">  <p  class="tab-label">修改头像</p> </div></a>
            </div>
            <div   class="setting_content" clear-name="">
                <form  class="el-form el-form--default el-form--label-right demo-ruleForm" action="<%=path%>/updateUserinfo.action" method="post" name="userinfoForm">
                    <div  class="el-form-item is-no-asterisk asterisk-left st_ipt_txt" role="group"
                         aria-labelledby="el-id-1024-0">
                        <div id="el-id-1024-0" class="el-form-item__label" style="width: 82px;">手机号：</div>
                        <div class="el-form-item__content"><span  class="st_txt">${userinfo.tel}</span> </div>
                    </div>

                    <div  class="el-form-item is-required is-no-asterisk asterisk-left"><label
                               class="el-form-item__label"
                            style="width: 82px;">密码：</label>
                        <div class="el-form-item__content">
                            <div  class="el-input">
                                <div class="el-input__wrapper" style="width: 352px"> <input
                                        class="el-input__inner" type="password" name="epwd" id="epwd" value="${userinfo.pwd}"  style="width: 330px"
                                        placeholder="请输入您的密码"  >
                                </div> </div>
                        </div>
                    </div>


                    <div  class="el-form-item is-required is-no-asterisk asterisk-left"><label
                            id="el-id-1024-1" for="el-id-1024-10" class="el-form-item__label"
                            style="width: 82px;">用户昵称：</label>
                        <div class="el-form-item__content">
                            <div  class="el-input">
                                <div class="el-input__wrapper" style="width: 352px"> <input
                                        class="el-input__inner" type="text" name="enickname" id="enickname" value="${userinfo.nickname}"  style="width: 330px"
                                        placeholder="请输入您的昵称(3-12个字)" id="el-id-1024-10">
                                </div> </div>
                          </div>
                    </div>

                    <div  class="el-form-item is-required is-no-asterisk asterisk-left"><label
                            id="el-id-1024-3" for="el-id-1024-11" class="el-form-item__label"
                            style="width: 82px;">出生日期：</label>
                        <div class="el-form-item__content">
                            <div  class="el-col el-col-11">
                                <div aria-haspopup="dialog" aria-expanded="false"
                                     class="el-input el-input--prefix el-input--suffix el-date-editor el-date-editor--date el-tooltip__trigger el-tooltip__trigger"
                                     role="combobox" aria-controls="el-id-1024-4" style="width: 100%;"><!-- input -->
                                    <!-- prepend slot --><!--v-if-->
                                    <div class="el-input__wrapper"><!-- prefix slot --><span
                                            class="el-input__prefix"><span class="el-input__prefix-inner"><i
                                            class="el-icon el-input__icon"><svg xmlns="http://www.w3.org/2000/svg"
                                                                                viewBox="0 0 1024 1024"><path
                                            fill="currentColor"
                                            d="M128 384v512h768V192H768v32a32 32 0 1 1-64 0v-32H320v32a32 32 0 0 1-64 0v-32H128v128h768v64H128zm192-256h384V96a32 32 0 1 1 64 0v32h160a32 32 0 0 1 32 32v768a32 32 0 0 1-32 32H96a32 32 0 0 1-32-32V160a32 32 0 0 1 32-32h160V96a32 32 0 0 1 64 0v32zm-32 384h64a32 32 0 0 1 0 64h-64a32 32 0 0 1 0-64zm0 192h64a32 32 0 1 1 0 64h-64a32 32 0 1 1 0-64zm192-192h64a32 32 0 0 1 0 64h-64a32 32 0 0 1 0-64zm0 192h64a32 32 0 1 1 0 64h-64a32 32 0 1 1 0-64zm192-192h64a32 32 0 1 1 0 64h-64a32 32 0 1 1 0-64zm0 192h64a32 32 0 1 1 0 64h-64a32 32 0 1 1 0-64z"></path></svg></i>
                                        <!--v-if--></span></span><input class="el-input__inner" name="birthday"   readonly="readonly" onClick="WdatePicker()"
                                                                        aria-controls="el-id-1024-4" type="text"  value="${userinfo.birthday}"
                                                                        autocomplete="off" tabindex="0"
                                                                        placeholder="出生日期" id="el-id-1024-11">
                                        <!-- suffix slot --><span class="el-input__suffix"><span
                                                class="el-input__suffix-inner"> </span></span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  class="el-form-item is-no-asterisk asterisk-left"><label id="el-id-1024-5"
                                                                                                     for="el-id-1024-12"
                                                                                                     class="el-form-item__label"
                                                                                                     style="width: 82px;">性别：</label>
                        <div class="el-form-item__content">
                            <div  class="el-radio-group" role="radiogroup"
                                 aria-labelledby="el-id-1024-5" id="el-id-1024-12"><label 
                                                                                          class="el-radio is-checked"><span
                                    class="el-radio__input is-checked"><input class="el-radio__original"  <c:if test="${userinfo.sex=='男'}">checked</c:if>
                                                                              name="sex" type="radio"
                                                                              value="男"><span
                                    class="el-radio__inner"></span></span><span
                                    class="el-radio__label"> 男 </span></label><label 
                                                                                     class="el-radio"><span
                                    class="el-radio__input"><input class="el-radio__original" name="sex"   <c:if test="${userinfo.sex=='女'}">checked</c:if>
                                                                   type="radio" value="女"><span
                                    class="el-radio__inner"></span></span><span
                                    class="el-radio__label"> 女 </span></label></div>
                        </div>
                    </div>


                    <div  class="el-form-item is-no-asterisk asterisk-left st_submit">
                        <div class="el-form-item__content" style="margin-left: 82px;">

                            <button  class="el-button el-button--primary st_confirm"  onclick="saveUserinfo()"
                                    aria-disabled="false" type="button"> <span class=""> 保存修改 </span></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>


<!-- 网站底部信息 -->
<jsp:include page="common/footer.jsp"></jsp:include>


</body>
<script type="text/javascript">
    function saveUserinfo() {
        var pwd = $('#epwd').val();
        var nickname = $('#enickname').val();
        if(!pwd){
            layer.msg('密码不能为空');
            return;
        }
        if(!nickname){
            layer.msg('昵称不能为空');
            return;
        }
        document.forms['userinfoForm'].submit();
    }
</script>
</html>
