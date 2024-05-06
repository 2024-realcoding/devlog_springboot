package com.com.cnu.devlog_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class DevlogSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevlogSpringbootApplication.class, args);
    }

}
