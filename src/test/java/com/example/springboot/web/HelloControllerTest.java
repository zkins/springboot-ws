package com.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Hello Controller 테스트 코드
 *
 * 1. Runwith(
 *    테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
 *    여기서는 SpringRunner라는 스프링 실행자
 *    즉, 스트링부트 테스트와 JUnit 사이의 연결자 역할을 한다
 *
 * 2. WebMvcTest
 *    여러 스트링 테스트 어노테이션중 Web(Spring MVC)에 집중할 수 있는 어노테이션
 *    선언시 @Controller, @ControllerAdvice 등 사용 가능
 *    단, @Service, @Component, @Repository 등은 사용 불가
 *    여기서는 컨트롤러만 사용하기 때문에 선언
 * 3. Autowired
 *    스프링이 관리하는 빈(Bean)을 주입 받음
 *
 * 4. MockMvc
 *    웹API 테스트 시 사용. 스프링 MVC 테스트의 시작점. 이 클래스를 통해 HTTP GET, POST API 테스트 가능
 *
 * 5. mvc.perform(get("/hello"))
 *    MockMvc를 통해 /hello 주소로 HTTP GET 요청
 *    체이닝이 지원되어 여러 검증 기능을 이어서 선언 가능
 * 6. .andExpect(stats().isOk())
 *    mvc.perform의 결과 검증. HTTP Header의 status를 검증(200, 404, 500 등..)
 *    여기선 OK 즉, 200 인지 아닌지 검증
 * 7. .andExpect(content().string(hello))
 *    mvc.perform의 결과 검증. 응답 본문 내용 검증
 *    Controller에서 "hello"을 리턴하기 때문에 이 값지 맞는지 검증
 *
 */
@RunWith(SpringRunner.class) // 1
@WebMvcTest(controllers = HelloController.class) // 2
public class HelloControllerTest {

    @Autowired // 3
    private MockMvc mvc; // 4

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // 5
                .andExpect(status().isOk())   // 6
                .andExpect(content().string(hello));    // 7
    }
}
