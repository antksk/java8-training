package com.github.antksk.java8_training;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 인터페이스에 @FunctionalInterface 를 사용하면,
 * default로 정의된 메소드를 제외하고 단일 메소드만 존재해야 함을 의미한다.
 * 이와 같이 단일 메소드에 대한 존재를 보장받게 되면 @FunctionalInterface로 정의된 
 * 인터페이스는 람다 형식으로 대체가 가능하다.
 * 
 * 즉, @FunctionalInterface 는 단일 메소드 정의만 존재 한다는 것을 보장 받는다. 
 * 
 * @author Seung Gyum Kim
 */
@Slf4j
public class _02_Functional_Interface {
  
  /**
   * 리턴타입이 R이고, 파라미터가 단일 값이 전달 되는 
   * 
   * 메소드 convert를 정의한 
   * 
   * Converter 인터페이스
   * 
   * @author Seung Gyum Kim
   *
   * @param <R> 리턴타입
   * @param <T> 파라미터(argument) 타입
   */
  @FunctionalInterface
  interface Converter<R, T>{
    R convert(T from);
  }
  
  @Test
  public void 함수_인터페이스_키워드_활용한_테스트(){
    
    displayConverterResult((s)->Integer.valueOf(s), "10");
    // or 
    displayConverterResult(Integer::valueOf, "100");
  }
  
  void displayConverterResult(Converter<Integer, String> c, String from){
    log.debug("display converter result : {}", c.convert(from));
  }
}   
