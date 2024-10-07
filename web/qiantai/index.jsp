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
    <title>起点小说网</title>
</head>

<body>
<div class="tiandiBody">
    <!-- 顶部菜单栏 -->
    <jsp:include page="common/header.jsp"></jsp:include>


    <!--#########################################################-->

    <!-- 轮播和公告 -->
    <div class="main">
        <div class="banner_area clear">
            <div class="banner fl">
                <div class="bannerRoll">
                    <div class="swiper-container">
                        <div class="swiper-wrapper ">
                            <c:forEach items="${swiperinfos}" var="lbinfo">
                                <div class="swiper-slide  ">
                                    <a href="<%=path%>/novelinfoDetail.action?id=${lbinfo.novelid}"
                                        ><img style="width: 100%;height: 340px;"
                                                                 src="<%=path%>/${lbinfo.pic}">
                                    </a></div>
                            </c:forEach>

                        </div>
                    </div>

                </div>
            </div>
            <script type="text/javascript" src="<%=path%>/qiantai/js/swiper/js/swiper.min.js"></script>
            <script>
                var swiper = new Swiper('.swiper-container', {
                    slidesPerView: 1,
                    spaceBetween: 0,
                    loop: true,
                    pagination: {
                        pagination: '.swiper-pagination',
                        paginationClickable: true
                    },
                    autoplay: {
                        delay: 5000,
                        disableOnInteraction: false
                    }
                });
            </script>


            <div class="notice_lists fr">
                <h3 class="biaoti">公告<i class="line"></i><a class="more"
                                                            href="<%=path%>/noticeinfolist.action">更多&gt;</a></h3>
                <ul>
                    <c:forEach items="${noticeinfos}" var="noticeinfo">
                        <li><a href="<%=path%>/noticeDetail.action?id=${noticeinfo.id}"
                               title="${noticeinfo.title}"><span>[公告]</span>${noticeinfo.title}</a></li>
                    </c:forEach>

                </ul>
            </div>
        </div>
        <!--#########################################################-->


        <!-- 热门推荐  新书榜-->
        <div class="tuijian_area1 clear">
            <div class="rmtj_lists fl">
                <h3 class="biaoti"><i class="line"></i>热门推荐</h3>
                <div class="clear">
                    <c:forEach items="${hotnovelinfos}" var="hottop" begin="0" end="0">
                        <div class="fl bigtj">
                            <a class="hover-img" href="<%=path%>/novelinfoDetail.action?id=${hottop.id}"><img
                                    src="<%=path%>/${hottop.novelcover}"></a>
                            <div class="bookdetails">
                                <h6><a href="<%=path%>/novelinfoDetail.action?id=${hottop.id}">${hottop.name}</a></h6>
                                <p class="author"><a
                                        href="<%=path%>/novelinfoDetail.action?id=${hottop.id}">作者：${hottop.author}</a>
                                </p>
                                <p class="intro"
                                   style=" position: relative; line-height: 20px;max-height: 40px;overflow: hidden;text-overflow:ellipsis;">${hottop.noveldesc}</p>
                            </div>
                            <a class="readBtn" href="<%=path%>/novelinfoDetail.action?id=${hottop.id}">开始阅读</a>
                        </div>
                    </c:forEach>
                    <div class="fl liststj">
                        <ul class="clear">
                            <c:forEach items="${hotnovelinfos}" var="hottop" begin="1">
                                <li>
                                    <a class="hover-img fl" href="<%=path%>/novelinfoDetail.action?id=${hottop.id}"><img
                                            src="<%=path%>/${hottop.novelcover}" alt="${hottop.name}"></a>
                                    <div class="bookdetails">
                                        <h6><a href="<%=path%>/novelinfoDetail.action?id=${hottop.id}">${hottop.name}</a>
                                        </h6>
                                        <p class="intro"
                                           style="position: relative; line-height: 20px;max-height: 40px;overflow: hidden;text-overflow:ellipsis;">${hottop.noveldesc}</p>
                                        <p class="author"><a
                                                href="<%=path%>/novelinfoDetail.action?id=${hottop.id}">作者：${hottop.author}</a>
                                        </p>
                                    </div>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="right_lists fr" style="height: 519px;">
                <h3 class="biaoti">新书榜<i class="line"></i><!--a class="more"
                                                             href="#">更多&gt;</a-->
                </h3>
                <ul>
                    <c:forEach items="${newnovelinfos}" var="newtop" begin="0" end="0">
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
                    <c:forEach items="${newnovelinfos}" var="newtop" begin="1" varStatus="status">
                        <li><a href="<%=path%>/novelinfoDetail.action?id=${newtop.id}"><span
                                class="num_list   <c:if test="${status.index+1<4}">colO</c:if>">${status.index+1}</span>${newtop.name}
                        </a></li>
                    </c:forEach>

                </ul>
            </div>
        </div>
        <!--#########################################################-->

        <!-- 前4个分类，每个分类显示前三部小说  订阅榜-->
        <div class="tuijian_area2 clear" style="margin-top: 15px;">
            <div class="rmtj_lists fl">
                <ul class="clear">
                    <c:forEach  var="i" begin="0" end="3">
                        <li>
                            <c:set var="catei" value="novelcategory${i}" scope="page"></c:set>
                            <c:set var="novel" value="novelinfos${i}" scope="page"></c:set>
                            <h3 class="biaoti">${requestScope[catei].name}<i class="line"></i></h3>
                            <c:forEach items="${requestScope[novel]}" var="novelinfo" begin="0" end="0">
                                <div class="clear">
                                    <a class="hover-img fl" href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}"><img
                                            src="<%=path%>/${novelinfo.novelcover}" alt="${novelinfo.name}"></a>
                                    <div class="bookdetails">
                                        <h6><a href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}">${novelinfo.name}</a>
                                        </h6>
                                        <p class="intro"
                                           style="position: relative; line-height: 20px;max-height: 40px;overflow: hidden;text-overflow:ellipsis;">${novelinfo.noveldesc}</p>
                                        <p class="author"><a
                                                href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}">作者：${novelinfo.author}</a>
                                        </p>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${requestScope[novel]}" var="novelinfo" begin="1">
                                <div class="recom_bottom">
                                    <span class="tag">${requestScope[catei].name}</span>
                                    <p class="intro"><a
                                            href="<%=path%>/novelinfoDetail.action?id=${novelinfo.id}">${novelinfo.noveldesc}</a>
                                    </p>
                                </div>
                            </c:forEach>

                        </li>
                    </c:forEach>

                </ul>
            </div>
            <div class="right_lists fr" style="height: 540px;">
                <h3 class="biaoti">订阅榜<i class="line"></i><!--a class="more"
                                                             href="#">更多&gt;</a-->
                </h3>
                <ul>
                    <c:forEach items="${favnovelinfos}" var="newtop" begin="0" end="0">
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
                    <c:forEach items="${newnovelinfos}" var="newtop" begin="1" varStatus="status">
                        <li><a href="<%=path%>/novelinfoDetail.action?id=${newtop.id}"><span
                                class="num_list   <c:if test="${status.index+1<4}">colO</c:if>">${status.index+1}</span>${newtop.name}
                        </a></li>
                    </c:forEach>

                </ul>
            </div>
        </div>


    </div>


    <!-- 网站底部信息 -->
    <jsp:include page="common/footer.jsp"></jsp:include>


</body>
</html>
<script type="text/javascript">

</script>