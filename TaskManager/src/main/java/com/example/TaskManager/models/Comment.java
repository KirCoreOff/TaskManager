package com.example.TaskManager.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private long id;
    private long taskId;
    private String author;
    private String comment;
    private String createTime;
    private String lastUpdateTime;
}
