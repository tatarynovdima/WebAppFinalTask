<!DOCTYPE html>
<html>
<head>
    <title>market`s</title>
</head>
<body>
<h1>market`s</h1><hr>
<h4>Authorization</h4>
<form action="/login" method="post">
    Email: <input type="email" name="username"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Login"/>
</form>
<a href="/registration">Registration</a>
</body>
</html>