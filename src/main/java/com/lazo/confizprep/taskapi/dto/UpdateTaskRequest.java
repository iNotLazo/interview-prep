package com.lazo.confizprep.taskapi.dto;

public record UpdateTaskRequest(
        String title,
        boolean completed
) {
}