<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申报项目信息</title>
    <h1 style="text-align: center">我  要  提  问</h1>
        <h1 style="text-align: center"><a href="/con1/add2">返回首页</a></h1>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/jquery.form.js"></script>
</head>
<body>
<form action="/con1/add2" method="post" >
    问题：<input type="text" name="title"> <br>
    问题描述：<input type="text" name="detaidesc"> <br>
    <input type="submit" value="保存问题">
</form>

</body>

</html>
