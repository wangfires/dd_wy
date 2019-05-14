<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./statics/boot/css/bootstrap.min.css">
    <link rel="icon" href="./img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <link rel="stylesheet" href="./css/common.css" type="text/css">

    <link rel="stylesheet" href="./css/login.css" type="text/css">
    <script src="./statics/echarts/jquery.min.js"></script>
    <script src="./statics/echarts/echarts.js"></script>
    <script src="./statics/echarts/china.js"></script>
    <script type="text/javascript" src="./statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="./statics/boot/js/bootstrap.min.js"></script>

    <script src="./statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="./statics/jqgrid/js/trirand/jquery.jqGrid.min(1).js"></script>
    <script type="text/javascript" src="./utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="./utf8-jsp/ueditor.all.js"></script>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script>
    var des;
    $(function () {
        $("#add").click(function () {
            // $("#imghead").attr("class","hidden");
            $("#id").val("");
            $("#f").attr("class", "");
            $("#specialform")[0].reset();
        })
        $("#save").click(function () {
            var formData = new FormData($("#specialform")[0]);
            $.ajax({
                url: "/emp/edit",
                type: "post",
                data: formData,
                contentType: false,
                processData: false,
                success: function (result) {
                    console.log("刷新jqgrid");
                    $("#list").jqGrid().setGridParam({datatype:'json'}).trigger("reloadGrid");
                    $("#myModal").modal("hide");
                }
            })
        })
        $("#list").jqGrid({
            url: "/emp/findBypage",
            datatype: "json",
            styleUI: 'Bootstrap',
            colNames: ["ID", "姓名", "薪水", "生日", "性别", "操作"],
            pager: "#pager",
            autowidth: true,//自适应父容器
            rowNum: 3,
            loadonce:true,
            rownumbers: true,
            viewrecords: true,
            rowList: [3, 10, 15, 20, 100],
            colModel: [
                {name: "id", align: "center"},
                {name: "name", align: "center"},
                {name: "salary", align: "center"},
                {name: "bir", align: "center"},
                {name: "sex", align: "center"},
                {
                    name: "options", formatter: function (value, options, row) {
                        var content =
                            "<a target='_blank' class='glyphicon glyphicon-search'onclick='se(this)' data-toggle=\"modal\" data-target=\"#myModal\" title='专辑详情'></a>" +
                            "<a class='glyphicon glyphicon-pencil' style='margin-left: 20px;margin-right: 20px;' onclick='up(this)' data-toggle=\"modal\" data-target=\"#myModal\" title='修改'></a></a>" +
                            "<a class='glyphicon glyphicon-trash' onclick='de(this)' title='删除'></a> ";
                        ;
                        return content;
                    }
                }

            ]
        }).jqGrid("navGrid", "#pager", {edit: false, add: false, del: false, search: false, refresh: false});



        function edit(id) {
            //根据rowid获取当前行的方法
            $("#list").jqGrid('editGridRow', id, {
                height: 300,
                reloadAfterSubmit: true
            });
        }
        function del(id) {
            $("#list").jqGrid('delGridRow', id, {
                height: 300,
                reloadAfterSubmit: true
            });

        }
    })
    function de(obj) {
        alert();
        var id1 = $(obj).parent().prev().prev().prev().prev().prev().text();
        console.log(id1);
        $.ajax({
            url: "/emp/delete",
            type: "post",
            data: {"id": id1},
            success: function (result) {
                $("#list").jqGrid().setGridParam({datatype:'json'}).trigger("reloadGrid");
            }
        })
    }
    function se(obj) {
        var id = $(obj).parent().parent().attr("id");
        console.log($(obj).parent().prev().prev().prev().prev().text());
        var id1 = $(obj).parent().prev().prev().prev().prev().prev().text();
        var name = $(obj).parent().prev().prev().prev().prev().text();
        var salary = $(obj).parent().prev().prev().prev().text();
        var bir = $(obj).parent().prev().prev().text();
        var sex = $(obj).parent().prev().text();
        console.log(id1)
        $("#id").val(id1);
        $("#name").val(name);
        $("#salary").val(salary);
        $("#bir").val(bir);
        $("option[value=" + sex + "]").attr("selected", true);
    };
    function up(obj) {
        var id = $(obj).parent().parent().attr("id");
        console.log($(obj).parent().prev().prev().prev().prev().text());
        var id1 = $(obj).parent().prev().prev().prev().prev().prev().text();
        var name = $(obj).parent().prev().prev().prev().prev().text();
        var salary = $(obj).parent().prev().prev().prev().text();
        var bir = $(obj).parent().prev().prev().text();
        var sex = $(obj).parent().prev().text();

        $("#id").val(id1);
        $("#name").val(name);
        $("#salary").val(salary);
        $("#bir").val(bir);
        $("option[value=" + sex + "]").attr("selected", true);
        };
</script>
</head>
<body>
<div class="container-fluid">
    <div class="col-sm-10">
        <div class="page-header">
            <h3>员工管理</h3>
        </div>
        <div class="tab-pane">
            <ul class="nav nav-tabs">
                <li  role="presentation" class="active"><a href="#">员工列表</a></li>
                <li  role="presentation"><a id="add" data-toggle="modal" data-target="#myModal">员工添加</a></li>

            </ul>
        </div>

        <table id="list"></table>

        <div id="pager"></div>

    </div>
    <div class="modal fade" id="myModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <!--模态框标题-->
                <div class="modal-header">
                    <!--
                        用来关闭模态框的属性:data-dismiss="modal"
                    -->
                    <button type="button" class="close" data-dismiss="modal" ><span >&times;</span></button>
                    <h4 class="modal-title">编辑员工信息</h4>
                </div>

                <!--模态框内容体-->
                <div class="modal-body">

                    <form action="" class="form-horizontal" id="specialform" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" name="id" id="id"/>
                            <label class="col-sm-2 control-label">员工姓名</label>
                            <div class="col-sm-10">
                                <input type="text" name="name" id="name" placeholder="请输入员工姓名" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-2 control-label">薪水</label>
                            <div class="col-sm-10">
                                <input type="text" name="salary" id="salary" placeholder="请输入员工薪水" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-2 control-label">员工生日</label>
                            <div class="col-sm-10">
                                <input type="text" name="bir" id="bir" placeholder="请输入员工生日" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <select name="sex" class="form-control">
                                    <option  value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </div>




                    </form>

                </div>

                <!--模态页脚-->
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="save">保存</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>