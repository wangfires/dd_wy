<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>UEditor</title>
    <!-- 配置文件 -->
    <script type="text/javascript" src="./utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="./utf8-jsp/ueditor.all.js"></script>
</head>
<body>
<!-- 加载编辑器的容器 -->
<script id="container" name="content" type="text/plain">
        我是wy
</script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container',{
        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo', 'bold','map']
        ],
    });
</script>
</body>
</html>