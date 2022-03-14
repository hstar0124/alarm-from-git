package com.ohgiraffers.alarmfromgit.notion.dto.webhook;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebhookObjectAttributes {
    private int id;
    private String target_branch;
    private String source_branch;
    private int source_project_id;
    private int author_id;
    private int assignee_id;
    private int state_id;
    private String title;
    private String created_at;
    private String updated_at;
    private boolean head_pipeline_id;
    private boolean milestone_id;
    private String state;
    private boolean blocking_discussions_resolved;
    private String merge_status;
    private int target_project_id;
    private String last_edited_at;
    private String last_edited_by_id;
    private int iid;
    private String description;
    private String merge_commit_sha;
    private WebhookOASource source;
    private String merge_error;
    private WebhookOATarget target;
    private WebhookOALastCommit last_commit;
    private boolean work_in_progress;
    private String url;
    private String action;
    private WebhookOAAssignee assignee;
}
