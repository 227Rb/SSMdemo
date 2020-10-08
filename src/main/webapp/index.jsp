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
    <h1>2</h1>
     <form id="data_form" >
        <p>姓名:<input type="text" name="eName" placeholder="姓名不可超过10个字符"></p>
         <p>密码:<input type="password" name="password" placeholder="密码必须为数字或字符._,/,*,-,+组成,7-20个字符"></p>
         <p>年龄:<input type="text" name="age" placeholder="密码必须为数字或字符._,/,*,-,+组成,7-20个字符"></p>
         <p>性别: 男<input type="radio" name="sex" value="0">
                   女<input type="radio" name="sex" value="1"></p>
         <p>地址:<input type="text" name="address" placeholder="地址输入不得超过50个字符"></p>
         <p>手机号:<input type="text" name="phone" placeholder="手机号+区号不得超过20个字符"></p>
            <input type="button" value="提交" id="btn2">
            <input type="reset" value="清空">
         <input type="button" value="修改" id="btn3">
         <input type="text" name="id" id="update_id">
     </form>
       <button id="btn">查询</button>
        <div id="dataForm"></div>
</body>
<script>
    function formToJson(flag){
        var data;
        var dataArray={};
        data=$("#data_form").serializeArray();
        $.each(data,function (i,item) {
                dataArray[item.name]=item.value;
                console.log(dataArray);
                if(flag){
                    dataArray.id=null;
                }
        });
        console.log(dataArray);
       return data=JSON.stringify(dataArray);
    }

    $(document).on("click","#btn2",function () {
        $.ajax({
            url:"demo/emp",
            type:'post',
            // contentType:'application/x-www-form-urlencoded',
            contentType:'application/json',
            data:formToJson(true),
            dataType:"json",
            success:function (data) {
            }
        });
    });

    $(document).on("click","#btn",function () {
        $.ajax({
            url: "demo/emp",
            type: 'get',
            dataType: "json",
            success: function (data) {
                console.log(data);
                $.each(data,function (i,item) {

                })
            }                                                                                                                                                                                                           
        });
    });

    $('#btn3').click(function () {
       $.ajax({
          url:"demo/emp",
          type:"post",
          dataType:"json",
           data:formToJson(false),
           success:function () {

           }
       });
    })

</script>

</html>
