<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<input id="input1" value=""/>
<input id="input2" value=""/>
<button onclick="test1()">登陆</button>
</body>
<script type="text/javascript" src="http://127.0.0.1:8080/js/jquery-2.1.0.js"></script>
<script>
    function test1() {
        var path = "http://127.0.0.1:8080/login";
        var userName = $('#input1').val();
        var password = $('#input2').val();
        console.log(userName);
        console.log(password);
        $.ajax({
            url: path,
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({userName: userName, password: password}),
            success: function (reg) {
                if (reg.code == 200) {
                    alert("登陆成功")
                } else {
                    alert(reg.msg)
                }
            }
        })
    }
</script>
</html>