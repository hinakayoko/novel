<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<% String path = request.getContextPath();
    request.setAttribute("leftmenu",1);
%>
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
        <div class="setting">
            <div class="tab">
                <a href="<%=path%>/toEditUserinfo.action">
                    <div class="tab-item "><p class="tab-label">基本信息</p></div>
                </a>
                <a href="<%=path%>/qiantai/modifyHead.jsp">
                    <div class="tab-item target"><p class="tab-label">修改头像</p></div>
                </a>
            </div>
            <form action="<%=path %>/uploadFile.action" name="formAdd" method="post" onsubmit="return uploadFile();" enctype="multipart/form-data">
            <div  class="setting_upcon flex">
                <div  class="cut sup-left">
                    <div >
                        <div  class="sup-btgroup">
                            <div  class="self_button" >
                                     <label  class="sup-change" for="uploads"> 选择本地文件<em
                                    ></em></label><input id="uploads" name="file"   type="file" class="file" style="position: absolute; clip: rect(0px, 0px, 0px, 0px);">
                            </div>
                            <!--div  class="def_button"><label  class="sup-change">
                                选择默认头像 </label></div-->
                        </div>
                    </div>
                </div>
                <div  class="sup-line"></div>
                <div  class="sup-right">
                    <div  class="flex">
                        <div  class="sup-big-head">
                            <div   class="default-big-img"><img class="fileImg" src="<%=path%>/${sessionScope.cuser.headurl}" alt=""></div>
                            <span  class="sup-big-txt">头像</span></div>
                        <!--div  class="sup-small-head">
                            <div  class="default-small-img"><img 
                                                                                   src=""
                                                                                   alt=""></div>
                            <span  class="sup-small-txt">小头像尺寸：40*40像素</span></div-->
                    </div>
                </div>
            </div>
            <div  class="sup-tips"> 支持JPG,JPEG,PNG等格式，最大不超过3M</div>
            <button  class="sup-upload" for="uploads"> 保存头像</button>

            </form>

        </div> </div>
</div>
</div>
</div>

</div>


<!-- 网站底部信息 -->
<jsp:include page="common/footer.jsp"></jsp:include>


</body>
<script type="text/javascript">
    function uploadFile() {
        var file = $('#uploads').val();
        console.log("file=" + file);
        if (!file) {
            layer.msg('请选择头像图片');
            return false;
        }

        return  true;
    }


    $(function(){
        $(".file").change(function(){
            var fileImg = $(".fileImg");
            var explorer = navigator.userAgent;
            var imgSrc = $(this)[0].value;
            if (explorer.indexOf('MSIE') >= 0) {
                if (!/.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)) {
                    layer.msg('图片格式不正确！');
                    //imgSrc = "";
                    //fileImg.attr("src","<%=path%>/${sessionScope.cuser.headurl}");
                    return false;
                }else{
                    fileImg.attr("src",imgSrc);
                }
            }else{
                if (!/.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)) {
                    layer.msg('图片格式不正确！');

                    //imgSrc = "";
                    //fileImg.attr("src","<%=path%>/${sessionScope.cuser.headurl}");
                    return false;
                }else{
                    var file = $(this)[0].files[0];
                    var url = URL.createObjectURL(file);
                    // 验证文件大小
                    if(file.size > 1024*1024*3) {
                        // 如果文件大小超过3MB，给出提示
                        alert("请上传小于3MB的图片！");
                        return false;
                    }


                    fileImg.attr("src",url);
                }
            }
        })
    })
</script>
</html>
