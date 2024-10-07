<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=path%>/qiantai/css/common.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/qiantai/css/index.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%=path%>/qiantai/js/swiper/css/swiper.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <title>潘多码小说网</title>
    <style type="text/css">
        body{font:13px/1 'Microsoft Yahei', tahoma, arial, 'Hiragino Sans GB', \24b8b\4f53, sans-serif}
        .content {
            min-height: calc(90vh - 146px);
        }
    </style>
</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>

    <style>
        .mailLists li p span{font-size: 15px}
    </style>

<pg:pager url="noticeinfolist.action" items="${itemSize}" maxPageItems="${pageItem}"
          maxIndexPages="${pageItem}" isOffset="${true}" export="offset,currentPageNumber=pageNumber"
          scope="request">
    <div class="main content">
        <div class="noticeLists">
            <h3 class="biaoti">公告列表</h3>
            <div class="mailContent">
                <ul class="mailLists">
                    <c:forEach items="${list}" var="noticeinfo">
                    <li>
                        <p>
                            <span class="mail_intro"><a target="_blank" href="<%=path%>/noticeDetail.action?id=${noticeinfo.id}">${noticeinfo.title} </a></span>
                            <span class="date">${noticeinfo.updatetime}</span>
                        </p>
                    </li>
                    </c:forEach>

                </ul>
            </div>
        </div>
        <div class="pageLists" style="margin: 34px 0 24px;">
    <pg:index>
        <jsp:include page="/qiantai/common/pagination.jsp" flush="true"/>
    </pg:index>
        </div>
    </div>
    </pg:pager>
    <!-- 网站底部信息 -->
    <jsp:include page="common/footer.jsp"></jsp:include>


</body>
<script type="text/javascript">
    function setCategory(cid){
       $('#cid').val(cid);
        document.forms['queryForm'].submit();
    }
    function setProgress(progress){
        $('#progress').val(progress);
        document.forms['queryForm'].submit();
    }
    function setSorts(sorts){
        $('#sorts').val(sorts);
        document.forms['queryForm'].submit();
    }
</script>
</html>
