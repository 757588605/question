<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2019/8/2
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
</head>
<body>
<form action="/con1/add4" method="post">
    <input type="hidden" value="${questions.id}" name="gid">
    <input type="hidden" value="${questions.answercount}" name="answercount">

<div  class="container table-responsive ">
    <table  class="table table-striped table-bordered table-hover table-condensed">
        <tr class="success">
            <td>问题：</td>
            <td>${questions.title}</td>
        </tr>
        <br>
        <tr>
            <td>问题描述：</td>
            <td>${questions.detaidesc}</td>
        </tr>
        <tr>
            <td>网友回答：</td>
            <td><c:forEach var="answers"   items="${answers}">
               <span><fmt:formatDate value="${answers.ansdate}" pattern="yyyy-MM-dd"/></span> <br>
               <span>${answers.anscontent}</span><br>
            </c:forEach>
            </td>
        </tr>
        <tr>
            <td>我来回答：</td>
            <td><textarea name="anscontent" id="anscontent" cols="10" rows="5"></textarea></td>
        </tr>

    </table>
</div>
</form>

<input  style="text-align: center" type="button" value="提交答案" onclick="tijiao()"> <a href="/con1/search">返回首页</a>

</body>
<script>
    function tijiao() {
        var answercount=$("#anscontent").val();
        if(answercount!=""&&answercount!=null){
            $("form").submit();
        }else {
            alert("请写内容")
        }
    }
</script>
</html>
