<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<body>
<table border="1" >
    <tr align="center">
        <td>编号</td>
        <td>用户名</td>
        <td>年龄</td>
        <td>生日</td>
    </tr>
    <#list users as user>
    <tr>
        <td>${user?counter}</td>
        <td>${user.user_name!}</td>
        <td>${user.age!}</td>
        <td>${user.birthday!}</td>
    </tr>
</#list>
</table>
</body>
</html>