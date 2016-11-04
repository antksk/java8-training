package com.github.com.antksk.java8_training;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class _00_Default_Method_for_Interface {
  
  interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
      return Math.sqrt(a);
    }
  }
  
  @Test
  public void 인터페이스의_기본_메소드_사용법(){
    // 이름 없는 객체 생성
    Formula formula = new Formula() {
      @Override
      public double calculate(int a) {
          return sqrt(a * 100);
      }
    };
    // 객체 메소스 사용
    log.debug("{}", formula.calculate(100) );
  }
}
