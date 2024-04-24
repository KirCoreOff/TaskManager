package com.example.TaskManager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {
    private long id;
    private String createTime;
    private String lastUpdateTime;
    private String title;
    private String description;
    private String status;
    private ArrayList<Comment> comments;
}
