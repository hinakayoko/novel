<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
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
    <form action="<%=path%>/novelchapter_list.action" class="form-inline" method="post">
        <input type="hidden" name="novelid" value="${novelid}"/>
        <div class="panel panel-default">
            <div class="panel-heading">小说章节信息列表</div>
            <div class="panel-body">
                <div class="pull-left">

                    <div class="form-group qinfo">
                        <label>章节标题：</label>
                        <input name="title" value="${title}" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </div>
            </div>
            <pg:pager url="novelchapter_list.action" items="${itemSize}" maxPageItems="${pageItem}"
                      maxIndexPages="${pageItem}" isOffset="${true}" export="offset,currentPageNumber=pageNumber"
                      scope="request">
                <pg:param name="novelid" value="${novelid}"/>
                <pg:param name="title" value="${title}"/>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" style="text-align: center;">
                        <thead>
                        <tr>

                            <td>章节标题</td>

                            <td>章节字数</td>
                            <th width="12%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="info">
                            <tr>
                                <td><a style="color:#000000"
                                       href="<%=path%>/novelchapter_toView.action?id=${info.id}">${info.title}</a>
                                </td>

                                <td>${info.wordscount}</td>
                                <td>
                                    <a href="<%=path%>/novelchapter_toUpdate.action?id=${info.id}"
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
                            <button type="button" id="backBtn" class="btn btn-default">返回</button>
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
            window.location.href = '<%=path%>/novelchapter_toAdd.action?novelid=${novelid}';
        });

        $("#backBtn").click(function () {
            window.location.href = '<%=path%>/novelinfo_list.action';
        });

    });

    function delInfo(id) {
        if (confirm("是否确认删除？")) {
            window.location.href = '<%=path%>/novelchapter_delete.action?id=' + id;
        }
    }
</script>