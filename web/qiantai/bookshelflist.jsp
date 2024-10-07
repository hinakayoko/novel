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


    <title>起点小说网</title>

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

<pg:pager url="bookshelflist.action" items="${itemSize}" maxPageItems="${pageItem}"
          maxIndexPages="${pageItem}" isOffset="${true}" export="offset,currentPageNumber=pageNumber"
          scope="request">
    <pg:param name="progress" value="${progress}"></pg:param>
        <div class="main"><!--[--><!--[-->
            <div class="bookshelf">
                <div--   class="el-tabs el-tabs--top">
                    <!--div class="el-tabs__header is-top">
                        <div class="el-tabs__nav-wrap is-top">
                            <div class="el-tabs__nav-scroll">
                                <div class="el-tabs__nav is-top" role="tablist" style="transform: translateX(0px);">
                                    <div class="el-tabs__active-bar is-top"
                                         style="width: 64px; transform: translateX(112px);"></div>
                                    <div class="el-tabs__item is-top" id="tab-recentlyRead"
                                         aria-controls="pane-recentlyRead" role="tab" aria-selected="false"
                                         tabindex="-1">最近阅读 </div>
                                    <div class="el-tabs__item is-top is-active" id="tab-bookshelf"
                                         aria-controls="pane-bookshelf" role="tab" aria-selected="true" tabindex="0">
                                        我的书架 </div>
                                    <div class="el-tabs__item is-top" id="tab-autoSubscribe"
                                         aria-controls="pane-autoSubscribe" role="tab" aria-selected="false"
                                         tabindex="-1">自动订阅 </div>
                                </div>
                            </div>
                        </div>
                    </div-->
                    <div class="el-tabs__content">
                        <div id="pane-recentlyRead" class="el-tab-pane" role="tabpanel" aria-hidden="true"
                             aria-labelledby="tab-recentlyRead" style="display: none;"></div>
                        <div id="pane-bookshelf" class="el-tab-pane" role="tabpanel" aria-hidden="false"
                             aria-labelledby="tab-bookshelf">
                            <div  class="bookshelf-tab">
                                <div   class="bookshelf-tab__condition">
                                    <div  class="bookshelf-tab__status">
                                        <button  class="el-button <c:if test="${progress==0}">is-active</c:if>" onclick="queryProgress(0)" aria-disabled="false"
                                                type="button"><span class="">全部</span></button>
                                    
                                        <button  class="el-button <c:if test="${progress==1}">is-active</c:if>" aria-disabled="false" onclick="queryProgress(1)"
                                                type="button"><span class="">连载中</span></button>
                                        <button  class="el-button <c:if test="${progress==2}">is-active</c:if>" aria-disabled="false" onclick="queryProgress(2)"
                                                type="button"><span class="">已完结</span></button>
                                    </div>
                                    <!--div   class="el-button-group ml-auto">
                                        <button  class="el-button" aria-disabled="false"
                                                type="button"><span class="">默认书架</span></button>
                                        <button  class="el-button" aria-disabled="false"
                                                type="button"><span class="">书架1</span></button>
                                        <button  class="el-button" aria-disabled="false"
                                                type="button"><span class="">书架2</span></button>
                                    </div-->
                                </div>
                                <div  class="bookshelf-tab__content">
                                    <div 
                                         class="el-table--fit el-table--enable-row-hover el-table--enable-row-transition el-table el-table--layout-fixed is-scrolling-none"
                                         data-prefix="el">
                                        <div class="el-table__inner-wrapper">

                                            <div class="el-table__header-wrapper">
                                                <table class="el-table__header" border="0" cellpadding="0"
                                                       cellspacing="0" style="width: 930px;">
                                                    <colgroup>

                                                        <col name="el-table_2_column_9" width="88">
                                                        <col name="el-table_2_column_10" width="180">

                                                        <col name="el-table_2_column_12" width="125">
                                                        <col name="el-table_2_column_13" width="75">

                                                        <col name="el-table_2_column_15" width="128">
                                                    </colgroup>
                                                    <thead class="">
                                                    <tr class="">

                                                        <th class="el-table_2_column_9 is-leaf el-table__cell"
                                                            colspan="1" rowspan="1">
                                                            <div class="cell">类别<!----><!----></div>
                                                        </th>
                                                        <th class="el-table_2_column_10 is-leaf el-table__cell"
                                                            colspan="1" rowspan="1">
                                                            <div class="cell">书名<!----><!----></div>
                                                        </th>

                                                        <th class="el-table_2_column_12 is-leaf el-table__cell"
                                                            colspan="1" rowspan="1">
                                                            <div class="cell">作者<!----><!----></div>
                                                        </th>
                                                        <th class="el-table_2_column_13 is-leaf el-table__cell"
                                                            colspan="1" rowspan="1">
                                                            <div class="cell">状态<!----><!----></div>
                                                        </th>

                                                        <th class="el-table_2_column_15 !pr-8 is-leaf el-table__cell"
                                                            colspan="1" rowspan="1">
                                                            <div class="cell">操作<!----><!----></div>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                            <div class="el-table__body-wrapper">
                                                <div class="el-scrollbar">
                                                    <div class="el-scrollbar__wrap el-scrollbar__wrap--hidden-default">
                                                        <div class="el-scrollbar__view"
                                                             style="display: inline-block; vertical-align: middle;">
                                                            <table class="el-table__body" cellspacing="0"
                                                                   cellpadding="0" border="0"
                                                                   style="table-layout: fixed; width: 930px;">
                                                                <colgroup>

                                                                    <col name="el-table_2_column_9" width="88">
                                                                    <col name="el-table_2_column_10" width="180">

                                                                    <col name="el-table_2_column_12" width="125">
                                                                    <col name="el-table_2_column_13" width="75">

                                                                    <col name="el-table_2_column_15" width="128">
                                                                </colgroup>
                                                                <tbody>

                                                                <c:forEach items="${list}" var="bookshelf">
                                                                <tr class="el-table__row">

                                                                    <td class="el-table_2_column_9 el-table__cell"
                                                                        rowspan="1" colspan="1">
                                                                        <div class="cell"><!----><span
                                                                                
                                                                                class="el-tag el-tag--light is-plain"><span
                                                                                class="el-tag__content">${bookshelf.novelcategoryVO.name}</span>
                                                                            </span></div>
                                                                    </td>
                                                                    <td class="el-table_2_column_10 el-table__cell"
                                                                        rowspan="1" colspan="1">
                                                                        <div class="cell el-tooltip"
                                                                             style="width: 178px;"><!----><a

                                                                                href="<%=path%>/novelinfoDetail.action?id=${bookshelf.novelid}"
                                                                                rel="noopener noreferrer"
                                                                                target="_blank"
                                                                                class="is-dark hover:!text-[#e60000]">${bookshelf.novelinfoVO.name}</a>
                                                                        </div>
                                                                    </td>

                                                                    <td class="el-table_2_column_12 el-table__cell"
                                                                        rowspan="1" colspan="1">
                                                                        <div class="cell el-tooltip"
                                                                             style="width: 123px;"><!----><a

                                                                                href="<%=path%>/novelinfoDetail.action?id=${bookshelf.novelid}"
                                                                                rel="noopener noreferrer"
                                                                                target="_blank"
                                                                                class="hover:text-[#e60000]">${bookshelf.novelinfoVO.author}</a>
                                                                        </div>
                                                                    </td>
                                                                    <td class="el-table_2_column_13 el-table__cell"
                                                                        rowspan="1" colspan="1">
                                                                        <div class="cell"> ${bookshelf.novelinfoVO.progressStr}</div>
                                                                    </td>

                                                                    <td class="el-table_2_column_15 !pr-8 el-table__cell"
                                                                        rowspan="1" colspan="1">
                                                                        <div class="cell"><!----><a 
                                                                                                    href="<%=path%>/novelinfoDetail.action?id=${bookshelf.novelid}"
                                                                                                    rel="noopener noreferrer"
                                                                                                    target="_blank">
                                                                            <button 
                                                                                    class="el-button is-plain is-round w-20 !h-[30px] !text-xs"
                                                                                    aria-disabled="false" type="button">
                                                                                <span class="">开始阅读</span>
                                                                            </button>




                                                                        </a>
                                                                            <a
                                                                                    href="<%=path%>/delBookshelf.action?id=${bookshelf.id}"
                                                                                    rel="noopener noreferrer"
                                                                                    >
                                                                                <button
                                                                                        class="el-button is-plain is-round w-20 !h-[30px] !text-xs"
                                                                                        aria-disabled="false" type="button">
                                                                                    <span class="">删除</span>
                                                                                </button>




                                                                            </a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table></div>
                                                    </div>

                                                </div>
                                            </div></div>
                                        <div class="el-table__column-resize-proxy" style="display: none;"></div>
                                    </div>


    <pg:index>
        <jsp:include page="/qiantai/common/pagination.jsp" flush="true"/>
    </pg:index>


                                </div>
                            </div>
                        </div></div>
                    </pg:pager>
                </div>     </div>     </div>
            </div></div>
    </div>


    <!-- 网站底部信息 -->
    <jsp:include page="common/footer.jsp"></jsp:include>


</body>
<script type="text/javascript">
   function queryProgress(progress){
       window.location.href = '<%=path%>/bookshelflist.action?progress=' +progress;
   }
</script>
</html>
