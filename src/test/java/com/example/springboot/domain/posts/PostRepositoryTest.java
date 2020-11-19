package com.example.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Spring Data JPA 테스트.
 * 별다른 설정 없이 @SpringBootTest를 사용할 경우 자동으로 H2 데이터베이스를 실행해준다
 *
 * 1. @After
 *    Junit에서 단위가 끝날 때마다 수행되는 메소드를 지정
 *    보통은 배포 전 전체 테스트 수행 시 테스트간 데이터 침범을 막기 위해 사용
 *
 * 2. postsRepository.save()
 *    테이블에 insert/update 쿼리를 실행
 *    id 값이 있다면 update, 없다면 insert 쿼리가 실행된다
 *
 * 3. postsRepository.findAll()
 *    테이블 posts에 있는 모든 데이터를 조회해오는 메소드
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 1
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // GIVEN
        String title = "테스트게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 2
                .title(title)
                .content(content)
                .author("test@gmail.com")
                .build());

        // WHEN
        List<Posts> postsList = postsRepository.findAll(); // 3

        // THEN
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
