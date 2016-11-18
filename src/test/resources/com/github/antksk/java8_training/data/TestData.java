package com.github.antksk.java8_training.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
/**
 * 모든 메서드들이 리턴 하는 데이터는 불편 객체 임
 * @author Seung Gyum Kim
 *
 */
public final class TestData {
  
  public List<String> inMemoryDataWithDummyNameList(){
    return Arrays.asList("peter", "anna", "mike", "xenia");
  }
  
  public List<Integer> inMemoryDataWithDummyIntegers(){
    return IntStream.rangeClosed(0, 100).boxed().collect(toList());
  }
  
  public List<String> inMemoryDataWithDummyList(){
    return Arrays.asList(
      "aaa0", "bbb0", "ccc0",
      "aaa1", "bbb1", "ccc1",
      "aaa2", "bbb2", "ccc2",
      "aaa3", "bbb3", "ccc3"
    );
  }
  
  public String inMemoryDataWithDummyStrings(){
    return "show me the money";
  }
}
