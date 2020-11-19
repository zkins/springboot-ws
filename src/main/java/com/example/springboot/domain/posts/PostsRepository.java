package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Posts 클래스로 database를 접근하게 해줄 JpaRepository
 * 인터페이스로 생성하며 JpaRepository<Entity 클래스, PK 타입>를 상속받으면 기본적인 CRUD 메소드가 자동으로 생성된다
 *
 * @Repository를 추가할 필요도 없다. 단 Entity 클래스와 같은 위치에 있어야함!
 *
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
