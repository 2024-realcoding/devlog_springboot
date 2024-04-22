package com.com.cnu.devlog_springboot.model;

import com.com.cnu.devlog_springboot.type.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "projects")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String summary;
    String contents;
    LocalDate startDate;
    LocalDate endDate;
    @Enumerated(value = EnumType.STRING)
    Tag tag;
}
