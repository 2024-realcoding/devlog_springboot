package com.com.cnu.devlog_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 6f22a1aadcc0af1b47e35ae96b94e19cfe051f04
