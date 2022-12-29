<!DOCTYPE html>
<html>
<head>
    <title>market`s</title>
</head>
<body>
<h1>market`s</h1><hr>
<form action="/" method="get">
    Search by ad title: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} $. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Product not found</h3>
</#list>
<hr>
<h3>Create new product</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Title Ad: <input type="text" name="title"/><br><br>
    Ad Description: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    City: <input type="text" name="city"/><br><br>
    Author: <input type="text" name="author"/><br><br>
    First image: <input type="file" name="file1"/><br><br>
    Second image: <input type="file" name="file2"/><br><br>
    Third  image: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Add product"/>
</form>
</body>
</html>