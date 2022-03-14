package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookLabels {
    private int id;
    private String title;
    private String color;
    private int project_id;
    private String created_at;
    private String updated_at;
    private boolean template;
    private String description;
    private String type;
    private int group_id;

}
