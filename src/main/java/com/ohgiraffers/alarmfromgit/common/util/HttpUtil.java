package com.ohgiraffers.alarmfromgit.common.util;

import com.ohgiraffers.alarmfromgit.gitapi.dto.GitResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.common.util
 * @date : 2022-01-21
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-01-21           Lee Hosung           최초 생성
 */
@Slf4j
public class HttpUtil {

    public static GitResponse sendGet(String url) throws Exception {
        RestTemplate template = new RestTemplate();

        GitResponse response = template.getForObject(url, GitResponse.class);

        return response;
    }

    public static JSONObject sendPost(String notionVersion, String apiKey, String url, JSONObject request) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Notion-Version", notionVersion);
        headers.add("Authorization", apiKey);

        HttpEntity<JSONObject> entity = new HttpEntity<>(request, headers);

        // send POST request
        JSONObject response = new RestTemplate().postForObject(url, entity, JSONObject.class);
        log.info("[HttpUtil] Response : {}", response);

        return response;
    }
}
