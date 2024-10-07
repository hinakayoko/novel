<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=path%>/qiantai/css/common.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/qiantai/css/index.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%=path%>/qiantai/js/swiper/css/swiper.min.css">
    <title>潘多码小说网</title>

</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>

    <style type="text/css">
        .content {
            min-height: calc(90vh - 146px);
        }
        .agreement {
            padding: 0 30px;
            margin-top: 10px;
            background: #fff;
            overflow: hidden;
        }
        .agreement .agreement_title {
            font-size: 38px;
            margin: 43px 0 45px;
            text-align: center;
            color: #333;
        }
        .agreement .agreement_neirong {
            padding: 0 0 30px;
            font-size: 15px;
            line-height: 32px;
        }
    </style>
    <!--#########################################################-->

    <div class="main content">
        <div class="noticeContent">
            <h2 class="notice_title">${noticeinfo.title}</h2>
            <div class="notice_neirong">
                <p></p>
                ${noticeinfo.tcontents}
            </div>
        </div>
    </div>


    <!-- 网站底部信息 -->
    <jsp:include page="common/footer.jsp"></jsp:include>


</body>
</html>
<script type="text/javascript">

</script>