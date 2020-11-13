package com.example.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 롬복 테스트
 *
 * 1. assertThat
 *    assertj 라는 테스트 검증 라이브러리. junit의 assert가 아님
 *    메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용 가능
 *
 * 2. isEqualTo
 *    assertj의 동등 비교 메소드
 *    assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
 *
 */
public class HelloResponseDtoTest {

    @Test
    public void 로복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);  // 1, 2
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
