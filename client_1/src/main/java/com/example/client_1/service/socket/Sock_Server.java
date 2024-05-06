package com.example.client_1.service.socket;

import com.example.client_1.model.User_ID;
import com.example.client_1.repository.Repo_usr_id;
import com.example.client_1.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sock_Server {


    private SimpMessagingTemplate messagingTemplate;
    private Repo_usr_id repoUsrId;
    private TaskService taskService;


    @Autowired
    public Sock_Server(TaskService taskService, Repo_usr_id repoUsrId, SimpMessagingTemplate messagingTemplate) {
        this.taskService = taskService;
        this.repoUsrId = repoUsrId;
        this.messagingTemplate = messagingTemplate;
    }


    @Scheduled(fixedDelay = 3000)
    public void time() {
        System.out.println("hello");
    }



    @Scheduled(fixedDelay = 2000)
    public void updateInfo() {
        int id = repoUsrId.findAll().stream().findFirst().orElse(new User_ID(-1)).getUsr_id();
        System.err.println("id = " + id);
        if (taskService.taskNeedToView(id)) {
            System.err.println("go = " + id);
            messagingTemplate.convertAndSend("/topic/pro_updates", "TaskNeedToView");
        }

    }
}
