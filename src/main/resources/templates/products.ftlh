<!DOCTYPE html>
<html>
<head>
    <title>market`s</title>
</head>
<body>
<h1>market`s</h1><hr>
<#if user.email??>
    <h3>Username: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
<#else>
    <a href="/login">Login</a></h1>
</#if>
<hr>
<form action="/" method="get">
    Search by ad title: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} $. | <a href="/product/${product.id}">Details</a></p>
    </div>
<#else>
    <h3>>Product not found</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Create new product</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Title Ad: <input type="text" name="title"/><br><br>
        Ad Description: <input type="text" name="description"/><br><br>
        Price: <input type="number" name="price"/><br><br>
        City: <input type="text" name="city"/><br><br>
        First image: <input type="file" name="file1"/><br><br>
        Second image: <input type="file" name="file2"/><br><br>
        Third  image: <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить товар"/>
    </form>
</#if>
</body>
</html>