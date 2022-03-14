package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookChangesLablesObj {
    private int id;
    private String title;
    private String color;
    private int project_id;
    private String created_at;
    private String update_at;
    private boolean template;
    private String description;
    private String type;
    private int group_id;

}
