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
    <link rel="stylesheet" href="<%=path%>/qiantai/css/read.css">
    <link rel="stylesheet" href="<%=path%>/qiantai/js/swiper/css/swiper.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/qiantai/js/articleread.js"></script>
    <title>潘多码小说网</title>
    <style type="text/css">
        .book-content .share_area {
            background: #fff;
            padding: 0 20px;
        }

        .book-content .share_area h3 a {
            font-size: 14px;
            color: #666666;
            font-weight: normal;
            cursor: pointer;
        }

        .book-content .share_area .share-scroll {
            padding-left: 35px;
            height: 58px;
            background: url(<%=path%>/images/notice.png) no-repeat left center;
            background-size: 18px 16px;
            overflow: hidden;
        }

        .book-content .share_area .share-scroll .aScroll ul li {
            height: 58px;
            line-height: 58px;
            color: #666666;
            margin-right: 10px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
            font-size: 14px;
        }

        .book-content .share_area .share-scroll .aScroll ul li span {
            color: #D43A1F;
        }

        .bdsharebuttonbox {
            width: 50%;
            float: right;
            margin-top: 8px;
        }
    </style>


</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>

    <style type="text/css">
        body {
            color: #333;
            font-family: "微软雅黑";
            font-size: 12px;
        }

        .chover:hover {
            cursor: pointer;
        }

        .border1 {
            border: 1px solid #000;
        }

        .jqmWindow {
            display: none;
            position: fixed;
            top: 17%;
            left: 50%;
            margin-left: -300px;
            background-color: #EEE;
            color: #333;
            border: 1px solid #ccc;
            padding: 0px;
        }

        .jqmWindow {
            width: auto;
        }

        .jqmW400 {
            width: 400px;
        }

        .jqmOverlay {
            background-color: #000;
        }

        * iframe.jqm {
            position: absolute;
            top: 0;
            left: 0;
            z-index: -1;
            width: expression(this.parentNode.offsetWidth+'px');
            height: expression(this.parentNode.offsetHeight+'px');
        }

        * html .jqmWindow {
            position: absolute;
            top: expression((document.documentElement.scrollTop || document.body.scrollTop) + Math.round(17 * (document.documentElement.offsetHeight || document.body.clientHeight) / 100) + 'px');
        }

        .textinfo span {
            padding-right: 10px;
        }
    </style>
    <link rel="stylesheet" href="<%=path%>/qiantai/css/new_content.css">

    <input type="hidden" id="urls" value="bookshelflist.action">
    <div class="main">
        <div class="readDetailCon" style="padding-top: 12px;">
            <div class="centerIn" id="centerIn">
                <div class="leftNav">
                    <ul>
                        <li class="secHover"><a href="<%=path%>/novelinfoChapterList.action?id=${novelchapter.novelid}"><img
                                src="<%=path%>/qiantai/images/list.png" style="margin-top:10px"><b>目录</b></a></li>

<c:if test="${not empty sessionScope.cuser}">
                        <li><a  href="<%=path%>/bookshelflist.action"><img src="<%=path%>/qiantai/images/colect.png"><b>书架</b></a></li>
</c:if>

                        <c:if test="${empty sessionScope.cuser}">
                            <li><a onclick="showlogin2()"><img src="<%=path%>/qiantai/images/colect.png"><b>书架</b></a></li>
                        </c:if>

                        <li><a href="<%=path%>/novelinfoDetail.action?id=${novelchapter.novelid}">
                            <img src="<%=path%>/qiantai/images/info.png"><b>书页</b></a></li>
                    </ul>
                </div>
                <div class="readDetailbody" id="readDetail">
                    <div class="story_title">
                        <h1><a href="#">${novelchapter.title}</a></h1>
                        <p class="textinfo">
                            <span>书名：<a
                                    href="#">${novelchapter.novelinfoVO.name}</a></span>
                            <span>作者：<a
                                    href="#">${novelchapter.novelinfoVO.author}</a></span>
                            <span>字数：${novelchapter.wordscount}</span>

                        </p>
                    </div>
                    <div class="xsDetail article">
                        ${novelchapter.contents}

                    </div>

                    <div id="detailsubsbox">

                        <center class="nextPageBox">
<c:if test="${preid!=0}">
                            <a title="阅读上一章节" class="preva" id="prevUrl"
                               href="<%=path%>/read.action?id=${preid}">阅读上一章节</a>
</c:if>
                            <a class="dir" href="<%=path%>/novelinfoChapterList.action?id=${novelchapter.novelid}">目录</a>
<c:if test="${nextid!=0}">
                            <a class="nexta" title="阅读下一章节" id="nextUrl"
                               href="<%=path%>/read.action?id=${nextid}">阅读下一章节</a>
</c:if>
                        </center>
                    </div>
                </div>
            </div>
            <div class="side" id="scrollto">
                <ul>

                    <!--li><a href="#">
                        <div class="sidebox"><img src="<%=path%>/qiantai/images/ping.png"><b>评论</b></div>
                    </a></li-->
                    <li style="border:none;"><a href="javascript:goTop();" class="sidetop"><img
                            src="<%=path%>/qiantai/images/up.png" style="margin-top:18px"></a></li>
                </ul>
            </div>
        </div>


    </div>

    <div class="mask" style="display: none;"></div>
</body>

</html>
