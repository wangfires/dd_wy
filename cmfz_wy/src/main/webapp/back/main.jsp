<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../statics/boot/css/bootstrap.min.css">
    <link rel="icon" href="../img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <link rel="stylesheet" href="../css/common.css" type="text/css">

    <link rel="stylesheet" href="../css/login.css" type="text/css">
    <script src="../statics/echarts/jquery.min.js"></script>
    <script src="../statics/echarts/echarts.js"></script>
    <script src="../statics/echarts/china.js"></script>
    <script type="text/javascript" src="../statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="../statics/boot/js/bootstrap.min.js"></script>

    <script src="../statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="../statics/jqgrid/js/trirand/jquery.jqGrid.min(1).js"></script>
    <script type="text/javascript" src="../utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="../utf8-jsp/ueditor.all.js"></script>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>




    <script>
        $(function () {
            $("#collapseOne").click(function () {
                $("#main").load("./slideshow.html");
            })
            $("#sp").click(function () {
                $("#main").load("./special.html");
            })
            $("#chapter").click(function () {
                $("#main").load("./chapter.html");
            })
            $("#regist").click(function () {
                $("#main").load("../echarts.html");
            })
            $("#addr").click(function () {
                $("#main").load("../echarts3.html");
            })
            $("#log").click(function () {
                $("#main").load("./log.jsp");
            })
            $("#user").click(function () {
                $("#main").load("./user.html")
            })
            
        })
    </script>
    <style>

    </style>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-default ">
        <div class="container-fluid">
            <!--导航条标题-->
            <div class="navbar-header">
                <a href="" class="navbar-brand">后台管理系统</a>
            </div>

            <ul class="nav navbar-nav pull-right">
                <li class=""><a>欢迎:${login.username}</a></li>
                <li class=""><a> <span  class="glyphicon glyphicon-pencil"></span>修改密码 </a></li>
                <li class=""><a> <span  class="glyphicon glyphicon-off"></span>退出 </a></li>
            </ul>
        </div>
    </nav>
    <div class="col-sm-2">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" >
                            轮播图模块
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                      轮播图信息
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"  >
                           专辑模块
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body" id="sp">
                        专辑信息
                       </div>
                    <div class="panel-body" id="chapter">
                        章节信息
                    </div>
                </div>
            </div>
            <%--<div class="panel panel-default">--%>
                <%--<div class="panel-heading" role="tab" id="headingThree">--%>
                    <%--<h4 class="panel-title">--%>
                        <%--<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" >--%>
                            <%--文章模块--%>
                        <%--</a>--%>
                    <%--</h4>--%>
                <%--</div>--%>
                <%--<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">--%>
                    <%--<div class="panel-body">--%>
                        <%--文章信息--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading4">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse4" >
                           用户模块
                        </a>
                    </h4>
                </div>
                <div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
                    <div class="panel-body" id="user">
                        用户信息
                    </div>
                    <div id="regist" class="panel-body">
                        用户注册信息
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading5">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse5" >
                            日志模块
                        </a>
                    </h4>
                </div>
                <div id="collapse5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading5">
                    <div class="panel-body" id="log">
                        日志信息
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-10" id="main">
        <div class="jumbotron" style="padding:8px;margin-bottom: 10px;">
            <h4>欢迎后台管理功能</h4>
        </div>
        <div class="jumbotron" id="a">
            <div class="row">
                <div class="container-fluid">
                    <a href="#" class="thumbnail">
                        <img src="../img/3@F@AP2OAZY@3R0Q8H)_KC2.jpg">
                    </a>
                </div>

            </div>
        </div>
    </div>
<div class="container-fluid">
        <nav class="navbar navbar-default navbar-fixed-bottom container-fluid">
            <div style="text-align: center">
                <h4 style="text-align: center">@ wy@123456.com.cn</h4>
            </div>
        </nav>
</div>
</div>

</body>
</html>