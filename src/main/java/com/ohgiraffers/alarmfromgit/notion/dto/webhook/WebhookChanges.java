package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookChanges {
    private WebhookChangesUpdatedById updated_by_id;
    private WebhookChangesUpdatedAt updated_at;
    private WebhookChangesLables labels;

}
