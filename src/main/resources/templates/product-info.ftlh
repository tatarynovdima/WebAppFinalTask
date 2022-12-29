<!DOCTYPE html>
<html>
<head>
    <title>market`s</title>
</head>
<body>
<h1>market`s</h1><hr>
<h4>Product Details</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Product Name: </b>${product.title}<br>
<b>Product description: </b>${product.description}<br>
<b>Price: </b>${product.price}<br>
<b>City: </b>${product.city}<br>
<b>Author: </b>${product.author}<br>
<b>Phone Number: </b>${product.user.phoneNumber}<br>
</body>
</html>