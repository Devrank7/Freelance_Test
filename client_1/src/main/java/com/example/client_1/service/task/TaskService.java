package com.example.client_1.service.task;

import com.example.client_1.model.TaskInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class TaskService {

    private List<TaskInfo> taskInfos =  new ArrayList<>();


    public void addTask(TaskInfo taskInfo) {
        taskInfos.add(taskInfo);
    }
    public boolean removeTaskByUser_Id(int id) {
        return taskInfos.removeIf(taskInfo -> taskInfo.getUser_id() == id);
    }
    public boolean removeTaskByDescription(String desc) {
        return taskInfos.removeIf(taskInfo -> taskInfo.getDescription().equals(desc));
    }
    public boolean isContain(TaskInfo taskInfo) {
        return taskInfos.contains(taskInfo);
    }
    public boolean taskNeedToView(int user_id) {
        for (TaskInfo taskInfo : taskInfos) {
            if (taskInfo.isActive()) {
                if (taskInfo.getUser_id() == user_id) return true;
            }
        }
        return false;
    }
    public boolean removeTaskActive(int user_id) {
        for (TaskInfo taskInfo : taskInfos) {
            if (taskInfo.getUser_id() == user_id) {
                if (taskInfo.isActive()) {
                    taskInfo.setActive(false);
                    return true;
                }
            }
        }
        return false;
    }
    public TaskInfo getTaskInfo(int user_id) {
        return taskInfos.stream().filter(taskInfo -> taskInfo.getUser_id() == user_id).findAny().orElse(null);
    }
}
