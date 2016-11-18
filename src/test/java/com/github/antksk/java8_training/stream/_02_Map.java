package com.github.antksk.java8_training.stream;

import java.util.List;
import java.util.function.Function;

import org.junit.Test;

import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _02_Map {
  
  @Test
  public void 새로운_객체로_변경(){
    List<String> dummyNameList = new TestData().inMemoryDataWithDummyNameList();

    log.debug("[문자열 모두 대문자로 변환]");
     dummyNameList.stream()
       .map(String::toUpperCase)
       .forEach(this::display)
     ;
     
     log.debug("[문자열 첫 글자만 대문자로 변환]");
     dummyNameList.stream()
       .map(this::firstCharUpperCase)
       .forEach(this::display)
     ;
  }
  
  String firstCharUpperCase( String s ){
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }
  
  void display(String s){
    log.debug("{}", s);
  }
}
