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

    <title>潘多码小说网</title>
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
    </style>

</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>



    <div class="main">
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
        <div class="book-content clear">
            <div class="content_left fl">
                <div class="LatestChapter">
                    <ul class="navBiaoti clear">
                        <li class="current"><a href="javascript:;">最新章节</a><i class="line"></i></li>
                        <li><a href="<%=path%>/novelinfoChapterList.action?id=${novelinfo.id}">目录</a><i class="line"></i></li>
                    </ul>
                    <div class="capter_intro">
                        <p class="new_chapter">最新章节：<a href="<%=path%>/read.action?id=${novelinfo.newNovelchapter.id}">${novelinfo.newNovelchapter.title}</a><span class="fr">更新于：${novelinfo.updatetime}</span></p>
                        <p class="intro" >${novelinfo.newNovelchapter.desc}</p>
                    </div>
                </div>


                <div class="bookReview">
                    <h3 class="biaoti"><span>书评区&nbsp;&nbsp;(${commentsnum})<i class="line"></i></span></h3>
                    <div class="fabiao">
                        <a href="javascript:;" class="author-tx"><img src="<%=path%>/qiantai/images/touxiang.png" alt=""></a>
                        <div class="left">
                            <form action="<%=path%>/saveComment.action" method="post" name="pinglun" id="pingForm"  style="position: relative;">
                                <input type="hidden" id="urls" value="novelinfoDetail.action?id=${novelinfo.id}">
                                <input name="novelid" type="hidden" value="${novelinfo.id}">
                                <textarea class="textarea" id="contents" name="contents" cols="45" orows="5" placeholder="请输入您的评论" maxlength="200" onkeyup="wordNum(this);"></textarea>
                                <span class="word_Statistics"><i class="wordnum">0</i>/200</span>
                                <div class="geRen_article_tab">
                                    <p class="sbtP">
<c:if test="${empty sessionScope.cuser}">
                                        <input type="button" onclick="showlogin2();" value="提交" class="btn" id="cc">
</c:if>

                                        <c:if test="${not empty sessionScope.cuser}">
                                            <input type="button" onclick="saveComment();" value="提交" class="btn" id="cc">
                                        </c:if>

                                    </p>
                                    <ol class="clearfix">
                                        <li class="" style="border: none;"> &nbsp;</li>
                                        <div style="clear: both;"></div>
                                    </ol>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="review_area" style="margin-top: 20px;">
                        <ul>
                            <c:forEach items="${novelcomments}" var="comments">
                            <li>
                                <div class="touxiang fl">
                                    <a href="#" target="_blank" title="用户名"><img src="<%=path%>/${comments.userinfoVO.headurl}" width="60" height="60" alt="用户名"></a>
                                </div>
                                <div class="text fl">
                                    <div class="pinglun">
                                        <div class="pl_top">
                                            <a class="user_name" href="javascript:;">${comments.userinfoVO.nickname}</a>
                                        </div>
                                        <p class="comment">${comments.contents}</p>
                                        <div class="info clear">
                                            <span class="data">${comments.commenttime}</span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            </c:forEach>
                        </ul>

                        <!--p class="morePinglun"><a href="#">更多评论&gt;</a></p-->
                    </div>
                </div>
            </div>
            <div class="content_right fr">
                <div class="right_lists">
                    <h3 class="biaoti">点击榜<i class="line"></i><!--a class="more" href="#">更多&gt;</a--></h3>
                    <ul>
                        <c:forEach items="${viewNovelinfos}" var="newtop" begin="0" end="0">
                            <li style="height: auto;padding: 15px 0 9px;line-height: inherit;">
                                <div>
                                    <span class="num_list colO" style="vertical-align: top;margin-top: 24px;">1</span>
                                    <a class="hover-img" href="<%=path%>/novelinfoDetail.action?id=${newtop.id}"><img
                                            width="60" height="80" src="<%=path%>/${newtop.novelcover}"
                                            alt="${newtop.name}"></a>
                                    <span style="vertical-align: top;line-height: 25px;margin: 10px 0 0 8px;">
							<b><a href="<%=path%>/novelinfoDetail.action?id=${newtop.id}"
                                  title="${newtop.name}">${newtop.name}</a></b>
							<br>
							<a class="author"
                               href="<%=path%>/novelinfoDetail.action?id=${newtop.id}">${newtop.author}</a>
						</span>
                                </div>
                            </li>
                        </c:forEach>
                        <c:forEach items="${viewNovelinfos}" var="newtop" begin="1" varStatus="status">
                            <li><a href="<%=path%>/novelinfoDetail.action?id=${newtop.id}"><span class="num_list   <c:if test="${status.index+1<4}">colO</c:if>">${status.index+1}</span>${newtop.name}
                            </a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>



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



    function wordNum(obj) {
        var wordNum = $(obj).val().length;
        if(parseInt(wordNum)>200){
            wordNum = 200;
            var Txt = $(obj).val().substring(0,50);
            $(obj).val(Txt);
        }
        $(obj).siblings(".word_Statistics").children(".wordnum").html(wordNum);
    }
    function saveComment(){
        var contents = $('#contents').val();
        if(!contents){
            layer.msg('评论内容不能为空');
            $('#contents').focus();
            return;
        }
        document.forms['pinglun'].submit()
    }
</script>
</html>
