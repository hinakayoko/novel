<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>详情</title>
    <link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/jquery.validate.min.js"></script>
    <script src="<%=path%>/js/jquery.validate.extend.js"></script>
    <link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
<div class="page-content">
    <div class="panel panel-default">
        <div class="panel-heading">详情</div>
        <div class="panel-body">
            <div class="container-fluid">
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>小说名称 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="name" name="name" size="35" value="${novelinfo.name}" readonly="readonly"
                                       class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>小说分类 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="categoryid" name="categoryid" size="35"
                                       value="${novelinfo.novelcategoryVO.name}" readonly="readonly"
                                       class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>作者 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="author" name="author" size="35" value="${novelinfo.author}"
                                       readonly="readonly" class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>小说简介 </label>
                            <div class="col-sm-9 form-inline">
                                <textarea rows="5" readonly="readonly" cols="80" id="noveldesc" name="noveldesc"
                                          class="form-control" tip="请输入小说简介">${novelinfo.noveldesc}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>更新时间 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="updatetime" name="updatetime" size="35" value="${novelinfo.updatetime}"
                                       readonly="readonly" class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>字数 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="wordsnum" name="wordsnum" size="35" value="${novelinfo.wordsnum}"
                                       readonly="readonly" class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>浏览量 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="viewcount" name="viewcount" size="35" value="${novelinfo.viewcount}"
                                       readonly="readonly" class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>进度 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="progress" name="progress" size="35" value="${novelinfo.progressStr}"
                                       readonly="readonly" class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>收藏数 </label>
                            <div class="col-sm-9 form-inline">
                                <input id="favcount" name="favcount" size="35" value="${novelinfo.favcount}"
                                       readonly="readonly" class="form-control" type="text"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row rowmargin">
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><font color="red">*</font>封面 </label>
                            <div class="col-sm-9 form-inline">
                                <img src="<%=path%>/${novelinfo.novelcover}" style="width: 50px;height: 70px;" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2">
                    </div>
                    <div class="col-sm-4" style="margin-left: 20px;">
                        <button type="button" id="rebackBtn" class="btn btn-default"
                                style="margin-top: 40px;margin-left: 20px;">返回
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#rebackBtn").click(function () {
            window.history.go(-1);
        });
    });
</script>
</html>
