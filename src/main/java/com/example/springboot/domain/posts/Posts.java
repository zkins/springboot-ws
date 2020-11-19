package com.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고 한다.
 *
 * 1) @Entity
 *    테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름 매칭
 *    ex) SalesManager -> Sales_Manager table
 *
 * 2) Id
 *    해당 테이블의 PK 필드
 * 3) @GeneratedValue
 *    PK의 생성 규칙. 스프링부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야 auto increment 가 된다
 * 4) @Column
 *    테이블의 칼럼을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다
 *    사용하는 이유는 기본값외에 추가로 설정이 필요한 경우...
 *    문자열의 경우 varchar(255)가 기본값인데 사이즈를 500으로 늘리고 싶거나 타입을 Text 로 변경하고 싶거나 등의 경우 사용
 * 5) @NoArgsConstructor
 *    기본생성자, Posts() {}
 * 6) @Getter
 *    모든 필드의  Getter 메소드 자동 생성
 *
 * 7) @Builder
 *    해당 클래스의 빌더 패턴 클래스 생성
 *    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
 *
 *  **특이사항
 *  이 클래스에는 Setter 메소드가 없다.
 *  언제 어디서 값이 변경되는지 알수 없는 사태를 방지하기 위해 Entity 클래스에서는 Setter 메소드를 절대 만들지 않는다
 */
@Getter // 6
@NoArgsConstructor // 5
@Entity // 1
public class Posts {

    @Id // 2
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3
    private Long id;

    @Column(length = 500, nullable = false) // 4
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 7
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
