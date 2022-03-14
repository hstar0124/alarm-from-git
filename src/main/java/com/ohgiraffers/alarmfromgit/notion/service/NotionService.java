package com.ohgiraffers.alarmfromgit.notion.service;

import com.ohgiraffers.alarmfromgit.common.util.HttpUtil;
import com.ohgiraffers.alarmfromgit.common.util.NotionUtil;
import com.ohgiraffers.alarmfromgit.notion.dto.webhook.WebhookMergeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.notion.service
 * @date : 2022-01-21
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-01-21           Lee Hosung           최초 생성
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class NotionService {

    @Value("${notion.url}")
    private String url;

    @Value("${notion.database_id}")
    private String databaseId;

    @Value("${notion.version}")
    private String notionVersion;

    @Value("${notion.apikey}")
    private String apiKey;

    /*public JSONObject notionAdd(WebhookMergeRequest webhookMergeRequest) throws Exception {

        JSONObject response = null;
        JSONObject request = NotionUtil.makeJsonObject(webhookMergeRequest, databaseId);
        try {
            response = HttpUtil.sendPost(notionVersion, apiKey, url, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }*/

}
