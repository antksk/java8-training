package com.github.antksk.java8_training.stream;

import java.util.List;

import org.junit.Test;

import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _01_Sorted {
  @Test
  public void 오름차순_데이터_정렬(){
    List<String> dummyList = new TestData().inMemoryDataWithDummyList();
    log.debug("[정렬 전 데이터]");
    dummyList.stream().forEach(this::display);
    
    log.debug("[정렬 후 데이터](기본은 오름차순)");
    dummyList.stream()
      .sorted()
      .forEach(this::display);
    
    log.debug("[정렬 후 데이터](내림차순)");
    dummyList.stream()
      .sorted(this::desc)
      .forEach(this::display);
  }
  
  void display(String s){
    log.debug("{}", s);
  }
  
  int desc( String s1, String s2 ){
    return s2.compareTo(s1);
  }
}
