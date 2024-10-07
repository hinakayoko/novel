<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
    <title>菜单栏</title>
</head>
<body>
<div class="page-content">
    <form action="<%=path%>/novelinfo_list.action" class="form-inline" method="post">

        <div class="panel panel-default">
            <div class="panel-heading">小说信息列表</div>
            <div class="panel-body">
                <div class="pull-left">
                    <div class="form-group qinfo">
                        <label>小说名称：</label>
                        <input name="name" value="${name}" class="form-control">
                    </div>
                    <label>小说分类：</label>
                    <select id="categoryid" name="categoryid" class="form-control">
                        <option value="0">全部</option>
                        <c:forEach items="${novelcategoryList}" var="info">
                            <option
                                    <c:if test="${categoryid==info.id}">selected</c:if>
                                    value="${info.id}">${info.name}</option>
                        </c:forEach>
                    </select>
                    <div class="form-group qinfo">
                        <label>作者：</label>
                        <input name="author" value="${author}" class="form-control">
                    </div>
                    <label>进度：</label>
                    <select id="progress" name="progress" class="form-control">
                        <option value="">全部</option>
                        <option
                                <c:if test="${progress==1}">selected</c:if> value="1">连载中
                        </option>
                        <option
                                <c:if test="${progress==2}">selected</c:if> value="2">已完结
                        </option>
                    </select>
                    <button type="submit" class="btn btn-default">查询</button>
                </div>
            </div>
            <pg:pager url="novelinfo_list.action" items="${itemSize}" maxPageItems="${pageItem}"
                      maxIndexPages="${pageItem}" isOffset="${true}" export="offset,currentPageNumber=pageNumber"
                      scope="request">
                <pg:param name="name" value="${name}"/>
                <pg:param name="categoryid" value="${categoryid}"/>
                <pg:param name="author" value="${author}"/>
                <pg:param name="progress" value="${progress}"/>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" style="text-align: center;">
                        <thead>
                        <tr>
                            <td>小说名称</td>
                            <td>小说分类</td>
                            <td>作者</td>
                            <td>更新时间</td>
                            <td>字数</td>
                            <td>浏览量</td>
                            <td>进度</td>
                            <td>收藏数</td>
                            <td>封面</td>
                            <th width="18%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="info">
                            <tr>
                                <td><a style="color:#000000"
                                       href="<%=path%>/novelinfo_toView.action?id=${info.id}">${info.name}</a></td>
                                <td>${info.novelcategoryVO.name}</td>
                                <td>${info.author}</td>
                                <td>${info.updatetime}</td>
                                <td>${info.wordsnum}</td>
                                <td>${info.viewcount}</td>
                                <td>${info.progressStr}</td>
                                <td>${info.favcount}</td>
                                <td>
                                    <img src="<%=path%>/${info.novelcover}" style="width: 50px;height: 70px;" alt="">
                                </td>
                                <td>
                                    <a href="<%=path%>/novelchapter_list.action?novelid=${info.id}"
                                       class="btn btn-success btn-xs"><span class="glyphicon glyphicon-edit"></span>章节管理</a>
                                    <a href="<%=path%>/novelinfo_toUpdate.action?id=${info.id}"
                                       class="btn btn-info btn-xs"><span class="glyphicon glyphicon-edit"></span>编辑</a>
                                    <a href="javascript:void();" onclick="delInfo('${info.id}');"
                                       class="btn btn-danger btn-xs"><span
                                            class="glyphicon glyphicon-trash"></span>删除</a>
                                    <!--a href="#" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-eye-open"></span> 查看</a-->
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel-footer clearfix">
                        <div class="pull-left">
                            <button type="button" id="addBtn" class="btn btn-info">新增</button>
                        </div>
                        <nav class="pull-right">
                            <pg:index>
                                <jsp:include page="/common/pagination_tag.jsp" flush="true"/>
                            </pg:index>
                        </nav>
                    </div>
                </div>
            </pg:pager>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        $("#addBtn").click(function () {
            window.location.href = '<%=path%>/novelinfo_toAdd.action';
        });
    });

    function delInfo(id) {
        if (confirm("是否确认删除？")) {
            window.location.href = '<%=path%>/novelinfo_delete.action?id=' + id;
        }
    }
</script>