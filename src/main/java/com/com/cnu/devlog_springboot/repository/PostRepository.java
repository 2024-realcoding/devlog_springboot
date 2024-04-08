package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    //Post save(Post post); jpa repository를 상속함으로써, 상속코드가 숨겨져있다.
    //List<Post>

}
