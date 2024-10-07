<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改</title>
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
        <div class="panel-heading">修改</div>
        <div class="panel-body">
            <form action="<%=path%>/userinfo_update.action" method="post" id="addForm">
                <input name="id" type="hidden" value="${userinfo.id}"/>
                <div class="container-fluid">
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>手机号码 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="tel" name="tel" size="35" class="form-control" type="text" readonly="readonly"
                                           value="${userinfo.tel}" tip="请输入手机号码"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>密码 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="pwd" name="pwd" size="35" class="form-control" type="password"
                                           value="${userinfo.pwd}" tip="请输入密码"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>昵称 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="nickname" name="nickname" size="35" class="form-control" type="text"
                                           value="${userinfo.nickname}" tip="请输入昵称"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><font color="red">*</font>出生日期 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="birthday" name="birthday" size="35" class="form-control"
                                           readonly="readonly" onClick="WdatePicker()" type="text"
                                           value="${userinfo.birthday}" tip="请输入出生日期"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别 </label>
                                <div class="col-sm-9 form-inline">
                                    <select id="sex" name="sex" class="form-control">
                                        <option
                                                <c:if test="${userinfo.sex=='男'}">selected</c:if> value="男">男
                                        </option>
                                        <option
                                                <c:if test="${userinfo.sex=='女'}">selected</c:if> value="女">女
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">  </label>
                                <div class="col-sm-9 form-inline">
                                    <img src="<%=path%>/${userinfo.headurl}" style="width: 60px;height: 60px;border-radius: 50px;" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row rowmargin">
                        <div class="col-sm-7">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">头像 </label>
                                <div class="col-sm-9 form-inline">
                                    <input id="headurl" readonly="readonly" name="headurl" value="${userinfo.headurl}"
                                           size="35" class="form-control" type="text" tip="请上传文件"/>
                                    <input type="button" value="上传" onclick="up('headurl',0)"/>
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

                pwd: {
                    required: true,
                },
                nickname: {
                    required: true,
                },
                birthday: {
                    required: true,
                },
            },
            messages: {

                pwd: {
                    required: '密码不能为空',
                },
                nickname: {
                    required: '昵称不能为空',
                },
                birthday: {
                    required: '出生日期不能为空',
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