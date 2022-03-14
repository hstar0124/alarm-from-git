package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookRepository {
    private String name;
    private String url;
    private String description;
    private String homepage;

}
