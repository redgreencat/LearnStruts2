<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userAction" method="post">
    用户名：<input type="text" name="user.username">
    密码：<input type="password" name="user.password">
    生日：<input type="date" name="user.birthday">
    性别：<select name="user.sex">
        <option value="男">男</option>
        <option value="女">女</option>
    </select>
    <select name="user.hobby">
        <option>篮球</option>
        <option>足球</option>
        <option>排球</option>
    </select>
    <input type="submit" value="ok">
</form>
</body>
</html>
