package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import lombok.Getter;
import lombok.ToString;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.notion.dto
 * @date : 2022-01-21
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-01-21           Lee Hosung           최초 생성
 */
@Getter
@ToString
public class WebhookMergeRequest {
    private String object_kind;
    private String event_name;
    private String event_type;
    private String user_username;
    private WebhookUser user;
    private WebhookProject project;
    private WebhookRepository repository;
    private WebhookObjectAttributes object_attributes;
    private WebhookLabels[] labels;
    private WebhookChanges changes;

}

