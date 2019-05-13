<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;utf-8" %>
<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<meta name="viewport"--%>
          <%--content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <%--<script type="text/javascript" src="../statics/boot/js/jquery-3.3.1.min.js"></script>--%>
    <%--<title>Document</title>--%>
    <script>
        $(function () {

            $.ajax({
                url:"/log/findAll",
                type:"post",
                success:function (result) {
                    console.log(result);
                    for (var i =0;i<result.length;i++){
                        var da = result[i].createdate;
                        da = new Date(da);
                        var year = da.getFullYear()+'年';
                        var month = da.getMonth()+1+'月';
                        var date = da.getDate()+'日';
                        var hour=da.getHours();
                        var min =da.getMinutes();
                        var sec=da.getSeconds();
                        var li=$("<li/>");
                        li.text("操作："+result[i].success+"  管理员："+result[i].username+"  时间："+[year,month,date].join("-")+[hour,min,sec].join(":")+"  方法："+result[i].methodName);
                        $("#bd").append(li);

                    }



                }
           })

            })
    </script>
<%--</head>--%>
<div id="bd">

</div>
<%--</html>--%>