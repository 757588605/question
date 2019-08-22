
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <h1 style="text-align: center">在 线 问 答</h1>
    <title>Title</title>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
</head>
<body>

<form class="form-horizontal" role="form" action="/con1/search" id="myForm" method="post">
    <input type="hidden" name="pageNum" id="pageNum" value="1">
</form>

<h1 style="text-align: center"><a href="/con1/add1">我要提问</a></h1>


<div class="container table-responsive">
    <table  class="table table-striped table-bordered table-hover table-condensed">
        <tr class="success">
            <td>序号</td>
            <td>问题</td>
            <td>回答次数</td>
            <td>最后修改</td>
        </tr>
        <c:if test="${not empty pageInfo.list}">
            <c:forEach var="question" items="${pageInfo.list}">
                <tr class="danger">
                    <td>${question.id}</td>
                    <td><a href="/con1/add3?id=${question.id}">${question.title}</a></td>
                    <td>${question.answercount}</td>
                    <td><fmt:formatDate value="${question.lastmodified}" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>

<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${pageInfo.pageNum-1})">上一页</a></td>
        <c:forEach begin="1" var="i" end="${pageInfo.pages}"> <%--pages  count size  pageNum--%>
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${pageInfo.pageNum+1})">下一页</a></td>
        <td><a href="javascript:goPage(${pageInfo.pages})">尾页</a></td>
        <td>
            <a href="javascript:toPage()">跳转</a>到第<input type="text" id="go" value="${pageInfo.pageNum}" size="2">页
        </td>
    </tr>
</table>



</body>
<script>
    function goPage(page) {
        $("#pageNum").val(page);
        $("#myForm").submit();
    }
    function toPage() {
        var page=$("#go").val();
        goPage(page)
    }
</script>
</html>
