package com.github.antksk.java8_training.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@DisplayName("00 stream.filter")
public class _00_Filter implements TestLogDisplay{


  @Test
  @DisplayName("필터를 활용해 조건에 맞는 데이터만 출력 1(stream 중복 사용으로 에러 발생)")
  public void test_1(){
    assertThrows(IllegalStateException.class,()->{
      Stream<String> stream = new TestData().inMemoryDataWithDummyList().stream();
      Predicate<? super String> a = (s)->s.startsWith("a");
      Predicate<? super String> b = (s)->s.startsWith("b");
      Predicate<? super String> c = (s)->s.startsWith("c");

      filteringAndDisplayResult(a, stream);
      // IllegalStateException 예외 발생, stream 객체는
      // 종단 연산(terminal operation)를 만나게 되면,
      // 객체의 생명이 끝나기 때문에, 지속적으로 strem를 재 사용할 수 없음
      filteringAndDisplayResult(b, stream);
      filteringAndDisplayResult(c, stream);
    });
  }
  
  @Test
  @DisplayName("필터를 활용해 조건에 맞는 데이터만 출력 2")
  public void test_2(){
    List<String> dummyList = new TestData().inMemoryDataWithDummyList();
    Predicate<? super String> a = (s)->s.startsWith("a");
    Predicate<? super String> b = (s)->s.startsWith("b");
    Predicate<? super String> c = (s)->s.startsWith("c");
    
    log.debug("필터를_활용해_조건에_맞는_데이터만_출력_2:");
    // 지속적으로 신규 stream 객체를 생성해서 결과값 확인
    filteringAndDisplayResult(a, dummyList.stream());
    filteringAndDisplayResult(b, dummyList.stream());
    filteringAndDisplayResult(c, dummyList.stream());
    
  }
  
  void filteringAndDisplayResult(Predicate<? super String> predicate, Stream<String> stream){
    stream.filter(predicate)
    .forEach(display(log));
  }
  

}
