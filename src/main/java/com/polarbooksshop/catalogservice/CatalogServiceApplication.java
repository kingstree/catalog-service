package com.polarbooksshop.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 설정 클래스 정의, 컴포넌트 스캔 및 부트 자동 설정 실행
public class CatalogServiceApplication {

    public static void main(String[] args) { // 애플리케이션 시작 매서드 애플리케이션을 부트스트랩 단계에서 실행 하도록 함
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

}
