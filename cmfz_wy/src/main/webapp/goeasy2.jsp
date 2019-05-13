<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript" src="./statics/boot/js/jquery-3.3.1.min.js"></script>
    <script>
        var goEasy = new GoEasy({
            appkey: "BC-0648bf2139c140ec8787eef013d3285a"
        });
        $(function () {


            $("#bt").click(function () {
                var message=$("#aa").val();
                goEasy.publish({
                    channel: "my_channel",
                    message: message
                });
            })
        })


        goEasy.subscribe({
            channel: "my_channel",
            onMessage: function (message1) {
                //alert("Channel:" + message.channel + " content:" + message.content);
                var li=$("<li>");
                li.text(message1.content);
                $("#chat").append(li);
            }
        });

    </script>
    <title>Document</title>
</head>
<body>
<div id="chat">

</div>
<textarea id="aa" rows="3" cols="20">

</textarea>
<button id="bt">发送</button>

</body>
</html>