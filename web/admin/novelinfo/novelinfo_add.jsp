<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增</title>
    <link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/jquery.validate.min.js"></script>
    <script src="<%=path%>/js/jquery.validate.extend.js"></script>
    <script src="<%=path%>/js/jquery.validate.method.js"></script>
    <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
<div class="page-content">
    <div class="panel panel-default">
        <div class="panel-heading">新增</div>
        <div class="panel-body">
            <form action="<%=path%>/novelinfo_add.action" method="post" id="addForm">
                <div class="container-fluid">
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>小说名称 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="name" name="name" size="35" class="form-control" type="text" value=""
                                           tip="请输入小说名称"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">小说分类 </label>
                                <div class="col-sm-9 form-inline">
                                    <select id="categoryid" name="categoryid" class="form-control">
                                        <c:forEach items="${novelcategoryList}" var="info">
                                            <option value="${info.id}">${info.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>作者 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="author" name="author" size="35" class="form-control" type="text" value=""
                                           tip="请输入作者"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">小说简介 </label>
                                <div class="col-sm-9 form-inline">
                                    <textarea rows="5" cols="80" id="noveldesc" name="noveldesc" class="form-control"
                                              tip="请输入小说简介"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">进度 </label>
                                <div class="col-sm-9 form-inline">
                                    <select id="progress" name="progress" class="form-control">
                                        <option value="1">连载中</option>
                                        <option value="2">已完结</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>封面 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="novelcover" readonly="readonly" name="novelcover" size="35"
                                           class="form-control" type="text" tip="请上传文件"/>
                                    <input type="button" value="上传" onclick="up('novelcover',0)"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                        </div>
                        <div class="col-sm-4" style="margin-left: 20px;">
                            <button type="submit" class="btn btn-primary" style="margin-top: 40px;">提交</button>
                            <button type="button" id="rebackBtn" class="btn btn-default"
                                    style="margin-top: 40px;margin-left: 20px;">返回
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#rebackBtn").click(function () {
            window.history.go(-1);
        });
        $("#addForm").validate({
            submitHandler: function (form) {//验证通过后的执行方法
                form.submit();
            },
            rules: {
                name: {
                    required: true,
                },
                author: {
                    required: true,
                },
                novelcover: {
                    required: true,
                },
                noveldesc: {
                    maxlength: 300,
                },

            },
            messages: {
                name: {
                    required: '小说名称不能为空',
                },
                author: {
                    required: '作者不能为空',
                },
                novelcover: {
                    required: '封面不能为空',
                },
                noveldesc: {
                    maxlength: "小说简介长度不能大于300个字符",
                },
            }
        });
    });
    var pop;

    function up(fname, type) {
        pop = new Popup({contentType: 1, isReloadOnClose: false, width: 400, height: 200});
        pop.setContent("contentUrl", "<%=path %>/upload/upload.jsp?fname=" + fname + "&pt=" + type);
        pop.setContent("title", "文件上传");
        pop.build();
        pop.show();
    }

    function popupClose() {
        pop.close();
    }
</script>
</html>