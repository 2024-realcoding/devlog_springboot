package com.com.cnu.devlog_springboot.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    String code; // 클라이언트랑 약속한 작동
    String message;
}
