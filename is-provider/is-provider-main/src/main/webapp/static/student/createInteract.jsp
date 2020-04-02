<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="../boot/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div id="top"></div>
<hr>

<div class="container" style="width: 800px;">
    <h2 style="margin-left: -20px">创建互动<hr></h2>
    <form class="form-horizontal" action="/message/add" method="post">
        <div class="form-group">
            <label for="teacher">互动的教师</label>
            <!--发送put请求修改数据-->
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="teacherId" value="${param.id}">
            <input type="text" class="form-control" id="teacher" name="teacherName" value="${param.name}" readonly>
        </div>
        <div class="form-group">
            <label for="name">请输入互动标题</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入互动标题">
        </div>
        <div class="form-group">
            <label for="projectName">请选择课程名称：</label>
            <select class="form-control" id="projectName">
                <option>Java</option>
                <option>PHP</option>
            </select>
        </div>
        <div class="form-group">
            <label for="knowledge">请选择疑惑的知识点：</label>
            <select class="form-control" id="knowledge">
                <option>Java动态代理</option>
                <option>SptingBoot的自动配置</option>
                <option>其他</option>
            </select>
        </div>
        <div class="form-group">
            <label for="stuContent">请填写互动详情：</label>
            <textarea class="form-control" name="stuContent" rows="10" id="stuContent"></textarea>
        </div>
        <div class="form-group">
            <div>
                <button type="submit" class="btn btn-success" style="width: 200px">提交</button>
            </div>
        </div>
    </form>
</div>

<div id="foot"></div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="../boot/js/jquery-1.11.3.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="../boot/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#foot").load("../jsp/foot.html");
    $("#top").load("../jsp/top.html");
</script>
</body>
</html>