package com.example.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Lombok 샘플
 *
 * 1. @Getter
 *    선언된 모든 필드의 get 메소드를 생성해준다
 * 2. @RequiredArgsContructor
 *    선언된 모든 final 필드가 포함된 생성자를 만들어준다
 *    final이 없는 필드는 생성자에 포함되지 않음
 *
 * 테스트코드 -> HelloResponseDtoTest
 */
@Getter // 1
@RequiredArgsConstructor // 2
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
