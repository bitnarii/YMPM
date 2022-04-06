package com.fitback.personal;

import com.fitback.personal.item.controller.ItemController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //생성일, 수정일 연동 관련 어노테이션
@SpringBootApplication
public class YmpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(YmpmApplication.class, args);
	}

}
