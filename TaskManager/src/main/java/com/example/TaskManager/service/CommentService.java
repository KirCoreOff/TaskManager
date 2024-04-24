package com.example.TaskManager.service;

import com.example.TaskManager.models.Comment;
import com.example.TaskManager.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    TaskService taskService;
    private long ID = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM HH:mm");
    public boolean addComment(long taskId, Comment comment) {
        for (Task task : taskService.getTasks()) {
            if (task.getId() == taskId) {
                task.getComments().add(comment);
                comment.setId(++ID);
                comment.setTaskId(taskId);
                String time = LocalDateTime.now().format(formatter);
                comment.setCreateTime(time);
                comment.setLastUpdateTime(time);
                return true;
            }
        }
        return false;
    }

    public List<Comment> getComments(long taskId) {
        for (Task task : taskService.getTasks()) {
            if (task.getId() == taskId)
                return task.getComments();
        }
        return null;
    }

    public boolean updateComment(long taskId, long commentId, Comment newComment) {
        for (Task task : taskService.getTasks()) {
            if (task.getId() == taskId)
                for (Comment comment : task.getComments())
                    if (comment.getId() == commentId) {
                        comment.setComment(newComment.getComment());
                        comment.setLastUpdateTime(LocalDateTime.now().format(formatter));
                        return true;
                    }
        }
        return false;
    }

    public boolean deleteComment(long taskId, long commentId) {
        for (Task task : taskService.getTasks()) {
            if (task.getId() == taskId) {
                task.getComments().removeIf(comment -> comment.getId() == commentId);
                return true;
            }
        }
        return false;
    }
}
