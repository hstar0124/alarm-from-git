package com.ohgiraffers.alarmfromgit.gitapi.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GitRespReactions {
    private String url;
    private int total_count;
    private int laugh;
    private int hooray;
    private int confused;
    private int heart;
    private int rocket;
    private int eyes;
}
