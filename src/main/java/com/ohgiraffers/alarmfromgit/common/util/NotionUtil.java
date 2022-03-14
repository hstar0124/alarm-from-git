package com.ohgiraffers.alarmfromgit.common.util;

import com.ohgiraffers.alarmfromgit.gitapi.dto.GitResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Time;

@Slf4j
public class NotionUtil {

    public static JSONObject makeParent(String type, String databaseId) throws Exception{
        JSONObject parentJson = new JSONObject();
        parentJson.put("type", type);
        parentJson.put("database_id", databaseId);
        return parentJson;
    }

    public static JSONObject makeRichText(String text){
        JSONArray textBody = new JSONArray();
        JSONObject textJsonObj = new JSONObject();
        JSONObject textContent = new JSONObject();
        textContent.put("content", text);

        textJsonObj.put("type", "text");
        textJsonObj.put("text", textContent);
        textBody.add(textJsonObj);

        JSONObject richText = new JSONObject();
        richText.put("rich_text", textBody);
        return richText;
    }

    public static JSONObject makeRichTextWithUrl(String text, String url){
        JSONArray textBody = new JSONArray();
        JSONObject textJsonObj = new JSONObject();
        JSONObject textContent = new JSONObject();
        textContent.put("content", text);
        JSONObject textUrl = new JSONObject();
        textUrl.put("url", url);
        textContent.put("link", textUrl);

        textJsonObj.put("type", "text");
        textJsonObj.put("text", textContent);
        textBody.add(textJsonObj);

        JSONObject richText = new JSONObject();
        richText.put("rich_text", textBody);
        return richText;
    }

    public static JSONObject makeDate(String date){
        JSONObject dateJson = new JSONObject();
        dateJson.put("type", "date");

        JSONObject dataContent = new JSONObject();
        dataContent.put("start", date);
        dateJson.put("date",dataContent);

        return dateJson;
    }

    public static JSONObject makePropertyTitle(String text){
        JSONObject content = new JSONObject();
        content.put("content", text);

        JSONArray titleArr = new JSONArray();
        JSONObject titleContent = new JSONObject();
        titleContent.put("type", "text");
        titleContent.put("text", content);
        titleArr.add(titleContent);

        JSONObject title = new JSONObject();
        title.put("type", "title");
        title.put("title", titleArr);

        return title;
    }

    public static JSONObject makeJsonObject(String repoName, GitResponse gitResponse, String databaseId) throws Exception {
        JSONObject request = new JSONObject();

        JSONObject parent = makeParent("database_id",databaseId);
        JSONObject properties = new JSONObject();


        properties.put("RepoName", makePropertyTitle(repoName + " (" + gitResponse.getTag_name() + ")"));
        properties.put("UpdateDate", makeDate(TimeUtil.convertTime(gitResponse.getPublished_at())));
        properties.put("Comments", makeRichText(gitResponse.getBody()));
        properties.put("Url", makeRichTextWithUrl("git에서 확인하기", gitResponse.getHtml_url()));
        properties.put("Hash", makeRichText(gitResponse.getNode_id()));

        request.put("parent", parent);
        request.put("properties", properties);

        log.info("[JSONUtil] Request JSON : {}", request.toJSONString());
        return request;
    }
}
