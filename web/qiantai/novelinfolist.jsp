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
    <title>起点小说网</title>
    <style type="text/css">
        body{font:13px/1 'Microsoft Yahei', tahoma, arial, 'Hiragino Sans GB', \24b8b\4f53, sans-serif}

    </style>
</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>


    <!--#########################################################-->
    <form name="queryForm" action="<%=path%>/categoryQuery.action" method="post">
       <input id="cid" name="cid" type="hidden" value="${cid}"/>
        <input id="progress" name="progress" type="hidden" value="${progress}"/>
        <input id="sorts" name="sorts" type="hidden" value="${sorts}"/>
    </form>
    <style type="text/css">
        .searched_list .listsContent .list_details li .content .details>span>a {color: #A0A0A0;}
    </style>
<pg:pager url="categoryQuery.action" items="${itemSize}" maxPageItems="${pageItem}"
          maxIndexPages="${pageItem}" isOffset="${true}" export="offset,currentPageNumber=pageNumber"
          scope="request">
    <pg:param name="cid" value="${cid}"/>
        <pg:param name="progress" value="${progress}"/>
        <pg:param name="sorts" value="${sorts}"/>
    <div class="main">
        <div class="search_catalog">
            <p class="works_category" id="Class">
                <span>作品类别：</span>
                <a onclick="setCategory(0);" style="cursor: pointer;"  <c:if test="${cid==0}">class="current"</c:if>  >全部</a>
                <c:forEach items="${novelcategoryList}" var="novelcategory">
                  <a onclick="setCategory(${novelcategory.id});" style="cursor: pointer;" <c:if test="${cid==novelcategory.id}">class="current"</c:if>>${novelcategory.name}</a>
                </c:forEach>

            </p>
            <p class="writing_progress" id="Paixu">
                <span>写作进度：</span>
                <a onclick="setProgress(0);" style="cursor: pointer;"  <c:if test="${progress==0}">class="current"</c:if>>全部</a>
                <a onclick="setProgress(1);" style="cursor: pointer;"  <c:if test="${progress==1}">class="current"</c:if>>连载中</a>
                <a onclick="setProgress(2);" style="cursor: pointer;"  <c:if test="${progress==2}">class="current"</c:if>>已完结</a>

            </p>
            <p class="">
                <span>排序方式：</span>
                <a  onclick="setSorts('');" style="cursor: pointer;"  <c:if test="${empty sorts}">class="current"</c:if> >全部</a>
                <a onclick="setSorts('fav');" style="cursor: pointer;"  <c:if test="${sorts=='fav'}">class="current"</c:if>>收藏量</a>
                <a onclick="setSorts('view');" style="cursor: pointer;"  <c:if test="${sorts=='view'}">class="current"</c:if>>点击量</a>
                <a onclick="setSorts('utime');" style="cursor: pointer;"  <c:if test="${sorts=='utime'}">class="current"</c:if>>更新时间</a>

            </p>

        </div>
        <div class="searched_list">
            <div class="listsContent">
                <!--找到结果-->
                <h2 class="list_title">共找到：<strong>${itemSize}</strong>部作品</h2>
                <!--未找到结果-->
                <!--<h2 class="list_title"><strong>很抱歉，没有找到相关的书</strong></h2>-->
                <ul class="list_details clear">
                    <c:forEach items="${list}" var="novelinfo">
                    <li>
                        <a class="hover-img" href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}"><img width="102" height="137" src="<%=path%>/${novelinfo.novelcover}"></a>
                        <div class="content">
                            <h3><a href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}">${novelinfo.name}</a></h3>
                            <span class="author"><a href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}">作者：${novelinfo.author}</a></span>
                            <span class="author" style="margin-left: 20px;"><a href="javascript:;">字数：${novelinfo.wordsnum}</a></span>
                            <span class="author" style="margin-left: 20px;"><a href="javascript:;">点击：${novelinfo.viewcount}次</a></span>
                            <p class="intro" style="position: relative; line-height: 20px;max-height: 40px;overflow: hidden;text-overflow:ellipsis;">${novelinfo.noveldesc}</p>
                            <div class="details">
                                <span><a href="javascript:;">最新章节 ${novelinfo.newNovelchapter.title}</a></span>
                                <i>${novelinfo.updatetime}</i>
                                <p class="href_btn">
                                    <a href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}" style="background: #d43a1f;color: #fff;">书籍详情</a>
                                    <c:if test="${empty sessionScope.cuser}"><a href="javascript:showlogin2();">加入书架</a></c:if>
                                    <c:if test="${not empty sessionScope.cuser && novelinfo.favstatus=='N'}"><a id="${novelinfo.id}a" href="javascript:fav(${novelinfo.id});">加入书架</a>

                                        <a class="joined" id="${novelinfo.id}joined" style="display: none" href="javascript:;">已加书架</a>
                                    </c:if>


                                    <c:if test="${novelinfo.favstatus=='Y'}">

                                        <a class="joined" id="${novelinfo.id}joined"  href="javascript:;">已加书架</a>
                                    </c:if>


                                  </p>
                            </div>
                        </div>
                    </li>
                    </c:forEach>

                </ul>
                <pg:index>
                    <jsp:include page="/qiantai/common/pagination.jsp" flush="true"/>
                </pg:index>
            </div>
        </div>

        </pg:pager>
    </div>


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
