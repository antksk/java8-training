package com.github.antksk.java8_training.data;

import java.util.Arrays;
import java.util.List;

/**
 * 모든 메서드들이 리턴 하는 데이터는 불편 객체 임
 * @author Seung Gyum Kim
 *
 */
public final class TestData {
  
  public List<String> inMemoryDataWithDummyNameList(){
    return Arrays.asList("peter", "anna", "mike", "xenia");
  }
}
