package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookChangesLables {
    private WebhookChangesLablesObj[] previous;
    private WebhookChangesLablesObj[] current;

}
