<!DOCTYPE html>
<html>
<head>
    <title>My Task</title>
</head>
<body>
<H1>My tasks</H1>
<hr>
<table>
    <tr>
        <td>№</td>
        <td>Task</td>
        <td>Created</td>
        <td>Status</td>
    </tr>
    <#list taskList as task>
        <tr>
            <td>${task.id} &emsp;</td>
            <td><a href="/task/${task.id}">${task.title}</a> &emsp;</td>
            <td>${task.dateTime} &emsp;</td>
            <td>${task.status} &emsp;</td>
        </tr>
    </#list>
    <form action="/task/new">
        <button>Create Task</button>
    </form>
</table>
</body>
</html>