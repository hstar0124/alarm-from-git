package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookUser {
    private int id;
    private String name;
    private String username;
    private String avatar_url;
    private String email;

}
