<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <html>
<body>
<div>
    ${user.username},${user.password},${user}
</div>
<form action="/hello" method="post">
    账号<input name="username"><br>
    密码<input name="password"><br>
    提交<input type="submit">
</form>
<form action="/hello2" method="post">
    账号<input name="username"><br>
    密码<input name="password"><br>
    提交<input type="submit">
</form>
<fieldset>
    <legend>文件上传</legend>
    <form action="/fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</fieldset>
</body>
</html>
