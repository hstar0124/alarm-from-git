package com.ohgiraffers.alarmfromgit.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author :  Lee Hosung
 * @packageName : com.ohgiraffers.alarmfromgit.common.dto
 * @date : 2022-01-21
 * @description :
 * ===========================================================
 * DATE                  AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022-01-21           Lee Hosung           최초 생성
 */
@Getter
public class HttpDto {
    String key;
    String data;

    public HttpDto(String key, String data){
        this.key=key;
        this.data=data;
    }
}
