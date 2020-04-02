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

<div style="background: url(${pageContext.request.contextPath}/static/img/1.jpg);height: 700px;margin-top: -20px">
</div>

<div class="container">
    <ul class="nav nav-pills nav-justified" style="margin-top: -61px">
        <li role="presentation"><a href="${pageContext.request.contextPath}/main/first" class="btn btn-primary btn-lg">首页</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/static/student/allTeacher.html" class="btn btn-warning btn-lg">我要提问</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/static/teacher/allArticle.html" class="btn btn-success btn-lg">阅读文章</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/static/teacher/allInteract.html" class="btn btn-info btn-lg">查看解答</a></li>
        <li role="presentation"><a href="#" class="btn btn-danger btn-lg">个人中心</a></li>
    </ul>
</div>

<div style="margin-top: -20px;background: lightseagreen;height: 30px"></div>

<div class="container-fluid" style="background: lightseagreen">
    <div class="container">
        <div class="jumbotron">
            <h1>Welcome !</h1>
            <p class="lead" style="color: #2aabd2">欢迎使用 HPU 师生互动平台！</p>
            <hr>
            <p>在这里您可以</p>
            <div class="btn-group" role="group" aria-label="...">
                <p>
                    <a type="button" class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/static/student/allTeacher.html">发起师生互动 &raquo;</a>
                    <a type="button" class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/static/teacher/allInteract.html">查询教师解答 &raquo;</a>
                    <a type="button" class="btn btn-warning btn-lg" href="${pageContext.request.contextPath}/static/teacher/allArticle.html">阅览最新文章 &raquo;</a>
                </p>
            </div>
            <p>
            <hr>
            &copy; Design By Zeke
            </p>
        </div>
    </div>
</div>

<div class="container-fluid col-md-2">
    <div class="container-fluid">
        <h3>最新课程 <p class="text-right small" style="color: #2aabd2">蹭课指南</p></h3>
        <hr>
    </div>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th style="text-align: center;"><a href="javascript:void(0)"  style="text-decoration: none;"><font class="glyphicon glyphicon-book"></font></a></th>
            <th style="text-align: center;"><a href="javascript:void(0)"  style="text-decoration: none;"><font class="glyphicon glyphicon-home"></font></a></th>
            <th style="text-align: center;"><a href="javascript:void(0)"  style="text-decoration: none;"><font class="glyphicon glyphicon-user"></font></a></th>
            <th style="text-align: center;"><a href="javascript:void(0)"  style="text-decoration: none;"><font class="glyphicon glyphicon-time"></font></a></th>
        </tr>
        </thead>
        <tbody id="tproject">
        <c:forEach var="project" items="${requestScope.map.projects}">
        <tr>
            <th style="text-align: center;">${project.name}</th>
            <th style="text-align: center;">${project.place}</th>
            <th style="text-align: center;">${project.teacherId}</th>
            <th style="text-align: center;">${project.createDate}</th>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container-fluid col-md-5" style="background-color: snow">
    <div class="container-fluid">
        <h3>最热文章 <a class="small" href="${pageContext.request.contextPath}/static/teacher/allArticle.html" style="color: #2aabd2"><p class="text-right">查看所有</p></a></h3>
        <hr>
    </div>
    <div class="list-group">
        <c:forEach items="${requestScope.map.articles}" var="article">
        <a href="#" class="list-group-item">
            <blockquote style="margin-top: 3px">
                <p>${article.presentation}</p>
                <footer style="color:darkred">${article.title}</footer>
            </blockquote>
        </a>
        </c:forEach>
    </div>
</div>

<div class="container col-md-5" style="background-color: honeydew">
    <div class="container-fluid">
        <h3>最热解答 <a class="small" href="${pageContext.request.contextPath}/static/teacher/allInteract.html" style="color: #2aabd2"><p class="text-right">查看所有</p></a></h3>
        <hr>
    </div>
    <div class="list-group">
        <c:forEach items="${requestScope.map.messages}" var="message">
        <a href="${pageContext.request.contextPath}/message/show?id=${message.id}" class="list-group-item list-group-item-danger">${message.name}</a>
        </c:forEach>
    </div>
</div>

<div class="col-md-12" style="margin-top: 1px"></div>

<div class="container-fluid col-md-12" style="background-color: lavender">
    <h3>教师风采 <a class="small" href="#" style="color: #2aabd2"><p class="text-right">查看所有</p></a></h3>
    <hr>
    <div class="row">
        <c:forEach var="teacher" items="${requestScope.map.teachers}">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <div class="caption">
                    <div class="thumbnail">
                        <div class="caption">
                            <div class="page-header">
                                <h1>${teacher.name} <small>${teacher.college}</small></h1>
                            </div>
                            <h5 class="text-left">最新课程</h5><h5 class="text-right" style="margin-top: -25px">回答数量</h5>
                            <div class="list-group">
                                <c:forEach items="${teacher.map}" var="map">
                                <a href="#" class="list-group-item">${map.key.name}<span class="badge">${map.value}</span></a>
                                </c:forEach>
                            </div>
                            <p><a href="#" class="btn btn-primary" role="button">向他提问</a> <a href="#" class="btn btn-success" role="button">所有课程</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
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
