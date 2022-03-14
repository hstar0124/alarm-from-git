package com.ohgiraffers.alarmfromgit.notion.controller;

import com.ohgiraffers.alarmfromgit.notion.dto.webhook.WebhookMergeRequest;

import com.ohgiraffers.alarmfromgit.notion.service.NotionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.notion.controller
 * @date : 2022-01-21
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-01-21           Lee Hosung           최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class NotionController {

    private final NotionService notionService;

    /*@PostMapping(value = "/ohgiraffers/notion")
    public ResponseEntity<JSONObject> notionPatch(@RequestBody WebhookMergeRequest webhookMergeRequest, HttpServletRequest request)
            throws Exception {
        log.info("===============Notion PATCH Process Start===============");
        log.info("[Request] Request IP : {}", request.getRemoteAddr());
        log.info("[Request] Request Value : {}", webhookMergeRequest.toString());

        JSONObject jsonObject = notionService.notionAdd(webhookMergeRequest);

        log.info("===============Notion PATCH Process End===============");
        log.info("");
        log.info("");
        log.info("");
        return ResponseEntity.ok().body(jsonObject);
    }*/

}
