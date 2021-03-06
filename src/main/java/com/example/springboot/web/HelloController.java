package com.example.springboot.web;

import com.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller 테스트 코드 작성
 *
 * 1. @Restcontroller
 *    Json을 반환하는 컨트롤러로 설정. 이전에는 메소드마다 ResponseBody 로 설정했던것을 한반에 해결
 * 2. @GetMaping
 *    HTTP의 Get 요청을 처리. 이전에는 @RequestMapping(method = RequestMethod.GET) 로 사용
 */
@RestController // 1
public class HelloController {

    @GetMapping("/hello") // 2
    public String hello() {
        return "hello";
    }


    /**
     * 1. @RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
     * @param name
     * @param amount
     * @return
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
