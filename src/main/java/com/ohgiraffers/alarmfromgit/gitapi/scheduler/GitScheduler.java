package com.ohgiraffers.alarmfromgit.gitapi.scheduler;

import com.ohgiraffers.alarmfromgit.common.util.FileUtil;
import com.ohgiraffers.alarmfromgit.common.util.HttpUtil;
import com.ohgiraffers.alarmfromgit.common.util.NotionUtil;
import com.ohgiraffers.alarmfromgit.common.util.TimeUtil;
import com.ohgiraffers.alarmfromgit.gitapi.dto.GitResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.gitapi.scheduler
 * @date : 2022-01-26
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-01-26           Lee Hosung           최초 생성
 */
@Slf4j
@Component
public class GitScheduler {

    @Value("${notion.url}")
    private String url;

    @Value("${notion.database_id}")
    private String databaseId;

    @Value("${notion.version}")
    private String notionVersion;

    @Value("${notion.apikey}")
    private String NotionApiKey;

    @Value("${git.mybatis}")
    private String GitMybatis;

    // 86400000 ms = 1day
    @Scheduled(fixedDelay = 86400000, initialDelay = 0)
    public void scheduleFixedRateTask() {
        boolean mybatis = alarmFromGit("mybatis", GitMybatis);
        log.info("[SCHEDULER] MYBATIS RESULT :: {}", mybatis == true ? "Notion Write Success":"Notion Write Fail");
    }

    private boolean alarmFromGit(String repoName, String repoUrl) {

        GitResponse gitResponse = new GitResponse();
        JSONObject request = new JSONObject();

        try {
            gitResponse = HttpUtil.sendGet(repoUrl);

            boolean dupCheck = FileUtil.dupCheckHash(gitResponse.getNode_id());
            boolean fileWrite = false;

            if(!dupCheck)
                fileWrite = FileUtil.writeHash(gitResponse.getNode_id());

            if(fileWrite) {
                request = NotionUtil.makeJsonObject(repoName, gitResponse, databaseId);
                HttpUtil.sendPost(notionVersion, NotionApiKey, url, request);
                return true;
            }

        } catch (Exception e) {
            log.error("[ALARM_FROM_GIT] Exception", e);
            if(e.toString().contains("Bad Request")){
                FileUtil.deleteHash(gitResponse.getNode_id());
            }
        }

        return false;
    }

}
