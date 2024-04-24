<!DOCTYPE html>
<html>
<head>
    <title>Task</title>
</head>
<body>
<form action="/" method="get">
    <input type="submit" value="Return back"/>
</form>
<hr>
<H1>Task №${task.id}</H1>
<b>Title: </b>${task.title}<br>
<b>Description: </b>${task.description}<br>
<b>Created: </b>${task.dateTime}<br>
<form action="/task/change/${task.id}" method="post">
    <b>Status: </b>
    <select name="status" id="status-select" >
        <option selected value=${task.status}>${task.status}</option>
        <option value="New">New</option>
        <option value="At work">At work</option>
        <option value="Completed">Completed</option>
        <option value="Closed">Closed</option>
    </select><br>
    <input type="submit" value="Save"/>
</form>
<br>
</form>
<form action="/task/delete/${task.id}" method="post">
    <input type="submit" value="Delete task"/>
</form>
<hr>
<H3>Comments</H3>
<#if task.comments?has_content>
    <#list task.comments as comment>
        <form action="/task/${task.id}/deleteComment/${comment.id}" method="post">
            <b>${comment.author}</b> ${comment.dateTime}
            <input type="submit" value="Delete task"/><br>
            ${comment.comment}
        </form><br><br>
    </#list>
    <#else> <p>There are no comments. You can be the first!</p>
</#if>

<H3>Add new comment</h3>
<form action="/task/addComment/${id}" method="post">
    Your name: <input type="text" name="author"/><br><br>
    Your comment: <input type="text" name="comment"/><br><br>
    <input type="submit" value="Comment"/>
</form>
</body>
</html>