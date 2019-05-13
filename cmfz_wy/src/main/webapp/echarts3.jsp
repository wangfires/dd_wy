<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->

    <script src="./statics/echarts/echarts.min.js"></script>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script src="./statics/echarts/china.js"></script>
    <script type="text/javascript" src="./statics/boot/js/jquery-3.3.1.min.js"></script>


</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var goEasy = new GoEasy({
        appkey: "BC-0648bf2139c140ec8787eef013d3285a"
    });
    goEasy.subscribe({
        channel: "my_channel",
        onMessage: function (message1) {
            //var obj=eval("("+message1.content+")")
          var obj=JSON.parse(message1.content);
            myChart.setOption({
                series : [
                    {
                        name: '男',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:obj.man
                    },
                    {
                        name: '女',
                        type: 'map',
                        mapType: 'china',
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:obj.women
                    }
                ]
            })
        }
    });
    // 指定图表的配置项和数据
    option = {
        title : {
            text: 'iphone销量',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['男','女','iphone5']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
    };
        myChart.setOption(option);
        $.ajax({
        url:"/user/map",
        type:"get",
        datatype:"json",
        success:function (data) {
            myChart.setOption({
                series : [
                    {
                        name: '男',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data.man
                    },
                    {
                        name: '女',
                        type: 'map',
                        mapType: 'china',

                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data.women
                    }
                ]
            })
        }
    })
</script>
</body>
</html>