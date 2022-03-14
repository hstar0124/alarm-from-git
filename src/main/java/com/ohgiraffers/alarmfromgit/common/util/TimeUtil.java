package com.ohgiraffers.alarmfromgit.common.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.common.util
 * @date : 2022-02-04
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-02-04           Lee Hosung           최초 생성
 */
@Slf4j
public class TimeUtil {

    private static final ZoneId SEOUL_ZONE_ID = ZoneId.of("Asia/Seoul");

    public static String convertTime(String time){
        log.info("[CONVERT TIME] before {}", time);
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(time);
        //String responseTime = zonedDateTime.withZoneSameInstant(SEOUL_ZONE_ID).toString().replace("[Asia/Seoul]","");
        String responseTime = zonedDateTime.withZoneSameInstant(SEOUL_ZONE_ID).toString();
        log.info("[CONVERT TIME] after {}", responseTime);

        return responseTime;
    }
}
