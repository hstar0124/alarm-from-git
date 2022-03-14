package com.ohgiraffers.alarmfromgit.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FileUtil {

    private static String filePath = "hash_log.txt";

    public static synchronized boolean dupCheckHash(String hash){

        boolean check = false;

        log.info("[FileUtil] HASHCODE DUP CHECK :: {}", hash);
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            // 동일값 존재시 true
            check = stream.anyMatch(h -> h.equals(hash));
            log.info("[FileUtil] HASHCODE DUP CHECK RESULT :: {}", check == true ? "중복 존재" : "중복 없음");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return check;
    }
    public static synchronized void deleteHash(String hash) {
        log.info("[FileUtil] HASHCODE DELETE : {}", hash);
        List<String> hashList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            hashList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(hashList.contains(hash)){
            hashList.remove(hash);
            try ( BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath))) {
                for (String str : hashList) {
                    bw.write(str + '\n');
                }
                log.info("[FileUtil] DELETE PROCESS SUCCESS");
            } catch (IOException e) {
                log.info("[FileUtil] DELETE PROCESS ERROR");
                e.printStackTrace();
            }
        }
    }

    public static synchronized boolean writeHash(String hash){
        log.info("[FileUtil] HASHCODE WRITE :: {}", hash);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
            bw.append(hash);
            bw.newLine();
            log.info("[FileUtil] Write success");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getFilePath(){
        return filePath;
    }

    public static void setFilePath(String filePath){
        FileUtil.filePath = filePath;
    }


}
