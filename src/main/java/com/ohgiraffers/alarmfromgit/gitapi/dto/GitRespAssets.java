package com.ohgiraffers.alarmfromgit.gitapi.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GitRespAssets {
    private String url;
    private int id;
    private String node_id;
    private String name;
    private String label;
    private GitRespUploader uploader;
    private String content_type;
    private String state;
    private double size;
    private int download_count;
    private String created_at;
    private String updated_at;
    private String browser_download_url;

}
