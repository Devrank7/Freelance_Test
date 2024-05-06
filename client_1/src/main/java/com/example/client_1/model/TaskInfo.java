package com.example.client_1.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"user_id"})
public class TaskInfo {
    private int user_id;
    private String description;
    private int time;
    private boolean isActive;


}
