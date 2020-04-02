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
    <link href="${pageContext.request.contextPath}/static/boot/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div id="top"></div>
<hr>
<div class="container" style="width: 800px">
    <h3>互动详情</h3>
    <div class="jumbotron" style="background-color: powderblue">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="name">互动标题</label>
                <input type="text" class="form-control" id="name" name="name" value="${requestScope.message.name}" readonly>
            </div>
            <div class="form-group">
                <label for="createDate">创建时间</label>
                <input type="text" class="form-control" id="createDate" name="createDate" value="${requestScope.message.createDate}" readonly>
            </div>
            <div class="form-group">
                <label for="teacher">互动教师</label>
                <input type="text" class="form-control" id="teacher" name="teacherName" value="${requestScope.message.teacherName}" readonly>
            </div>
            <div class="form-group">
                <label for="projectName">课程名称：</label>
                <input type="text" class="form-control" id="projectName" value="${requestScope.message.projectName}" readonly>
            </div>
            <div class="form-group">
                <label for="knowledge">疑惑的知识点：</label>
                <input type="text" class="form-control" id="knowledge" name="knowledge" value="${requestScope.message.knowledge}" readonly>
            </div>
            <div class="form-group">
                <label for="stuContent">互动详情：</label>
                <textarea class="form-control" rows="10" id="stuContent" readonly>${requestScope.message.stuContent}</textarea>
            </div>
        </form>
    </div>
</div>

<div class="container" style="width: 800px">
    <h3>教师解答</h3>
    <div class="jumbotron" style="background-color: #b2dba1">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="teaContent">解答详情：</label>
                <textarea class="form-control" rows="10" id="teaContent" name="teaContent" readonly>${requestScope.message.teaContent}</textarea>
            </div>
        </form>
    </div>
</div>

<div id="foot"></div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/static/boot/js/jquery-1.11.3.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/static/boot/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#foot").load("${pageContext.request.contextPath}/static/jsp/foot.html");
    $("#top").load("${pageContext.request.contextPath}/static/jsp/top.html");
</script>
</body>
</html>