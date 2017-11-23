package com.github.antksk.java8_training.stream;

import java.util.List;
import java.util.function.Function;


import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("02 stream.map")
public class _02_Map implements TestLogDisplay {
  @Test
  @DisplayName("map를 활용하여, 새로운 객체 생성")
  public void test(){
    List<String> dummyNameList = new TestData().inMemoryDataWithDummyNameList();

    log.debug("[문자열 모두 대문자로 변환]");
     dummyNameList.stream()
       .map(String::toUpperCase)
       .forEach(display(log))
     ;
     
     log.debug("[문자열 첫 글자만 대문자로 변환]");
     dummyNameList.stream()
       .map(this::firstCharUpperCase)
       .forEach(display(log))
     ;
  }
  
  String firstCharUpperCase( String s ){
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }
  
}
