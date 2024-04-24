package com.example.TaskManager.controllers;

import com.example.TaskManager.models.Comment;
import com.example.TaskManager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/tasks/{taskId}/comments")
    public ResponseEntity<List<Comment>> commentsList(@PathVariable long taskId) {
        final List<Comment> comments = commentService.getComments(taskId);
        return comments!=null
                ? new ResponseEntity<>(comments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tasks/{taskId}/comments")
    public ResponseEntity<?> addComment(@PathVariable long taskId, @RequestBody Comment comment) {
        return commentService.addComment(taskId, comment)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/tasks/{taskId}/comments/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable long taskId, @PathVariable long commentId, @RequestBody Comment comment) {
        return commentService.updateComment(taskId, commentId, comment)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tasks/{taskId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable long taskId, @PathVariable long commentId) {
        return commentService.deleteComment(taskId, commentId)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
