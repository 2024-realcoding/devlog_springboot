package com.com.cnu.devlog_springboot.model;

import com.com.cnu.devlog_springboot.type.ErrorCode;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "posts")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String contents;
    @Enumerated(value = EnumType.STRING)
    ErrorCode tag;
}
