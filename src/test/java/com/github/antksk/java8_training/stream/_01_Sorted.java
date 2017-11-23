package com.github.antksk.java8_training.stream;

import java.util.List;


import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("01 stream.sorted")
public class _01_Sorted implements TestLogDisplay {
  @Test
  @DisplayName("오름차순 데이터 정렬")
  public void test(){
    List<String> dummyList = new TestData().inMemoryDataWithDummyList();
    log.debug("[정렬 전 데이터]");
    dummyList.stream().forEach(display(log));
    
    log.debug("[정렬 후 데이터](기본은 오름차순)");
    dummyList.stream()
      .sorted()
      .forEach(display(log));
    
    log.debug("[정렬 후 데이터](내림차순)");
    dummyList.stream()
      .sorted(this::desc)
      .forEach(display(log));
  }
  

  int desc( String s1, String s2 ){
    return s2.compareTo(s1);
  }
}
