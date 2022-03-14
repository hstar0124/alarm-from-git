package com.ohgiraffers.alarmfromgit.gitapi.dto;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GitResponse {

    private String url;
    private String assets_url;
    private String upload_url;
    private String html_url;
    private String id;
    private GitRespAuthor author;
    private String node_id;
    private String tag_name;
    private String target_commitish;
    private String name;
    private boolean draft;
    private boolean prerelease;
    private String created_at;
    private String published_at;
    private GitRespAssets[] assets;
    private String tarball_url;
    private String zipball_url;
    private String body;
    private GitRespReactions reactions;

}
