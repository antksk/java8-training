package com.github.antksk.java8_training.stream;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.github.antksk.java8_training.data.TestData;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _05_Reduce {
  
  interface OptionalDisplay{
    void display();
  }
  
  @Value
  static class OptionalString implements OptionalDisplay{
    Optional<String> value;
    @Override
    public void display() {
      value.ifPresent(o->log.debug("{}",o));
    }
  }
  
  @Value
  static class OptionalInteger implements OptionalDisplay{
    Optional<Integer> value;
    @Override
    public void display() {
      value.ifPresent(o->log.debug("{}",o));
    }
  }
  
  @Test
  public void 지정된_조건에_따라_결과_줄이기() {
    
    List<String> dummyNameList = new TestData().inMemoryDataWithDummyNameList();
    
    log.debug("dummyNameList : {}", dummyNameList);
    Optional<String> optional = dummyNameList.stream().reduce((reduceBuff,next)->{
      log.debug("s0 : {}, s1: {}", reduceBuff, next);
      return String.format("%s,%s",reduceBuff,next);
    });
    
    display( new OptionalString(optional) );
    
    
    
    List<Integer> dummyIntegers = new TestData().inMemoryDataWithDummyIntegers();
    Optional<Integer> optional2 = dummyIntegers.stream().reduce((i0,i1)->{
      if(isEven(i1)){
        log.debug("i0: {}, i1: {}", i0, i1);
        return i0 += i1;
      }
      return 0;
    });
    display( new OptionalInteger(optional2) );
  }
  
  void display(OptionalDisplay o){
    o.display();
  }
  
  boolean isEven(int i){
    return 0 == (i%2);
  }
  
}
