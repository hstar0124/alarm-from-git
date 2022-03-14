package com.ohgiraffers.alarmfromgit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AlarmFromGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlarmFromGitApplication.class, args);
	}
}
