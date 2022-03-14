package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookOALastCommit {
    private String id;
    private String message;
    private String title;
    private String timestamp;
    private String url;
    private WebhookOALastCommitAuthor author;

}
