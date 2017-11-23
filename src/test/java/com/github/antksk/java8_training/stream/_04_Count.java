package com.github.antksk.java8_training.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("04 stream.count")
public class _04_Count {

  @Test
  @DisplayName("갯수 판단")
  public void  test(){
    Predicate<? super String> startCharA = t->t.startsWith("a");
    display("{}, {} ", 
        _ds(startCharA).collect(toList()), 
        _ds(startCharA).count()
    );
    
    Predicate<? super String> findAnyA = t-> -1 != t.indexOf("a");
    display("{}, {} ", 
        _ds(findAnyA).collect(toList()), 
        _ds(findAnyA).count()
    );
  }
  
  private Stream<String> _ds(Predicate<? super String> predicate){
    return new TestData().inMemoryDataWithDummyNameList().stream().filter(predicate);
  }

  private void display(String format, List<String> list, long count) {
    log.debug(format, list, count);
  }
  
}
