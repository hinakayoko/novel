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

    <title>起点小说网</title>
    <style type="text/css">
        body{font:13px/1 'Microsoft Yahei', tahoma, arial, 'Hiragino Sans GB', \24b8b\4f53, sans-serif}
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
        .book-content .share_area .share-scroll{
            padding-left: 35px;
            height: 58px;
            background: url(<%=path%>/images/notice.png) no-repeat left center;
            background-size: 18px 16px;
            overflow: hidden;
        }
        .book-content .share_area .share-scroll .aScroll ul li{
            height: 58px;
            line-height: 58px;
            color: #666666;
            margin-right: 10px;
            text-overflow:ellipsis;
            white-space:nowrap;
            overflow:hidden;
            font-size: 14px;
        }
        .book-content .share_area .share-scroll .aScroll ul li span{
            color: #D43A1F;
        }
        .bdsharebuttonbox{
            width: 50%;
            float: right;
            margin-top: 8px;
        }
        .content {
            min-height: calc(90vh - 146px);
        }
    </style>

</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>


    <div class="main content">
        <div class="bookdetails clear">
            <div class="bdetails_left fl">
                <div class="bookcover fl"><a class="hover-img" href="javascript:;"><img width="186" height="248" src="<%=path%>/${novelinfo.novelcover}"></a></div>
                <div class="bookintro">

                    <h2>${novelinfo.name}<span><a href="#">${novelinfo.author}&nbsp;</a>著</span></h2>
                    <p class="label">
                        <span>${novelinfo.novelcategoryVO.name}</span>
                        <span>${novelinfo.progressStr}</span>

                    </p>
                    <p class="statistics">
                        <span>•&nbsp;字数 ${novelinfo.wordsnum}</span>
                        <!--span>•&nbsp;读过此书 1971人</span-->
                    </p>
                    <p class="intro" style="position: relative; line-height: 20px;max-height: 40px;overflow: hidden;text-overflow:ellipsis;">${novelinfo.noveldesc}</p>
                    <div>
                        <a class="freeTrials btn" href="<%=path%>/read.action?id=${novelinfo.oneNovelchapter.id}">开始阅读</a>


                        <c:if test="${empty sessionScope.cuser}">
                            <a class="bookshelf btn" href="javascript:showlogin2();">加入书架</a>
                        </c:if>

                        <c:if test="${not empty sessionScope.cuser  && novelinfo.favstatus=='N'}">
                            <a  id="${novelinfo.id}a" href="javascript:fav(${novelinfo.id});" class="bookshelf btn" href="javascript:showlogin2();">加入书架</a>
                            <a class="bookshelf_added btn"  style="display: none" id="${novelinfo.id}joined"  href="javascript:;">已加书架</a>
                        </c:if>



                        <c:if test="${novelinfo.favstatus=='Y'}">

                            <a class="bookshelf_added btn" id="${novelinfo.id}joined"  href="javascript:;">已加书架</a>
                        </c:if>




                        <!--a class="reward btn" href="javascript:;" onclick="showlogin2()">打赏</a-->
                    </div>
                </div>
            </div>
            <div class="bdetails_right fr">
                <img class="author_touxiang" width="90" height="90" src="<%=path%>/images/userdefault.gif">
                <p class="author">${novelinfo.author}</p>
                <p class="author_intro">不是我懒得自我介绍，是我把时间都用来看书了！...</p>
            </div>
        </div>

        <div class="mulu-content clear">
            <ul class="navBiaoti clear">
                <li><a href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}">最新章节</a><i class="line"></i></li>
                <li class="current"><a href="javascript:;">目录</a><i class="line"></i></li>
            </ul>
        </ul>
        <h3 class="volume_tit">正文</h3>
        <ul class="mulu_list clear">
            <c:forEach items="${novelchapters}" var="chapter">
            <li><a href="<%=path%>/read.action?id=${chapter.id}">${chapter.title}</a>                </li>
            </c:forEach>


        </ul>
    </div>



        </div>
    </div>

<input type="hidden" id="urls" value="novelinfoChapterList.action?id=${novelinfo.id}">

    <!-- 网站底部信息 -->
    <jsp:include page="common/footer.jsp"></jsp:include>

</div>
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
