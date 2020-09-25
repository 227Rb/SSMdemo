<%--
  Created by IntelliJ IDEA.
  User: Nan
  Date: 2020/9/25
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><a  href="/demo/hello/1">测试</a></h1>
    <h2 id="err"></h2>
    <button id="btn">1</button>
</body>
<script>

    $(document).on("click","#btn",function () {
        $.ajax({
            url:"demo/hello/5",
            type:'get',
            dataType:"json",
            success:function (data) {
                document.getElementById("err").innerHTML=data.msg;
            }
        });


    })


</script>

</html>
