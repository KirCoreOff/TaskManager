<!DOCTYPE html>
<html>
<head>
    <title>New task</title>
</head>
<body>
<form action="/" method="get">
    <input type="submit" value="Return back"/>
</form>
<hr>
<H1>Create task</H1><hr>
<form action="/task/create" method="post">
    Title: <input type="text" name="title"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    <input type="submit" value="Create task"/>
</form>
</body>
</html>