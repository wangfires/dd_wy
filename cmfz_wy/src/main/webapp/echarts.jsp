<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="./statics/echarts/jquery.min.js"></script>
    <script src="./statics/echarts/echarts.js"></script>
    <script src="./statics/boot/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    myChart.setOption({
        title: {
            text: '异步数据加载示例'
        },
        tooltip: {},
        legend: {
            data:['用户注册量']
        },
        xAxis: {
            data: ["1","2","3","4","5"]
        },
        yAxis: {},
        series: [{
            type: 'bar',
            data: []
        }]
    });
    // 使用刚指定的配置项和数据显示图表。
    $.ajax({
        url:"/user/find",
        datatype:"json",
        type:"get",
        success:function (data) {
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '用户注册量',
                    data: data.data
                }]
            });
        }
    })

</script>
</body>
</html>