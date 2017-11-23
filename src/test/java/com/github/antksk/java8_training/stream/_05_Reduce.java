package com.github.antksk.java8_training.stream;

import java.util.List;
import java.util.Optional;

import com.github.antksk.java8_training.data.TestData;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("05 stream.reduce")
public class _05_Reduce {

  interface OptionalDisplay {
    void display();
  }

  @Value
  @AllArgsConstructor
  static class OptionalString implements OptionalDisplay {
    Optional<String> value;

    public OptionalString(String value) {
      this(Optional.of(value));
    }

    @Override
    public void display() {
      value.ifPresent(o -> log.debug("{}", o));
    }
  }

  @Value
  @AllArgsConstructor
  static class OptionalInteger implements OptionalDisplay {
    Optional<Integer> value;

    public OptionalInteger(int value) {
      this(Optional.of(value));
    }

    @Override
    public void display() {
      value.ifPresent(o -> log.debug("{}", o));
    }
  }

  //@formatter:off;
  @Test
  @DisplayName("지정된 조건에 따라 결과 줄이기")
  public void test() {
    
    List<String> dummyNameList = new TestData().inMemoryDataWithDummyNameList();
    
    log.debug("dummyNameList : {}", dummyNameList);
    display( new OptionalString(dummyNameList
      .stream()
      .reduce((reduceBuff,next)->{
        // log.debug("s0 : {}, s1: {}", reduceBuff, next);
        return String.format("%s,%s",reduceBuff,next);
      }))
    );
    
    // 가장 긴 문자열을 찾아 출력
    display( new OptionalString(dummyNameList
      .stream()
      .reduce((s0, s1)->(s0.length()>=s1.length())? s0 : s1)) 
    );
    
    // 짝수인 숫자만 검색해서 sum한 값을 리턴
    List<Integer> dummyIntegers = new TestData().inMemoryDataWithDummyIntegers();
    log.debug("dummyIntegers : {}", dummyIntegers);
    display( new OptionalInteger(dummyIntegers
      .stream()
      .filter(this::isEven)
      .reduce(0, Integer::sum)) 
    );
  }
  //@formatter:on;
  
  void display(OptionalDisplay o){
    o.display();
  }
  
  boolean isEven(int i){
    return 0 == (i%2);
  }
  
}
