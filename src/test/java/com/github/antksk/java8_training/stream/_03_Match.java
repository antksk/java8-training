package com.github.antksk.java8_training.stream;

import java.util.List;


import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

@Slf4j
@DisplayName("03 steram.xxxxMatch")
public class _03_Match {
  
  @Test
  @DisplayName("조건 매칭 여부 판단")
  public void test(){
    List<String> dummyNameList = new TestData().inMemoryDataWithDummyNameList();

    log.debug("{}", dummyNameList );
    
    display("anyMatch(t->t.startsWith(\"a\")) 한개라도 맞으면 true : {} ", dummyNameList.stream()
        .anyMatch(t->t.startsWith("a"))
    );
    
    display("allMatch(t->t.startsWith(\"a\")) 모두 맞으면 true: {} ", dummyNameList.stream()
        .allMatch(t->t.startsWith("a"))
    );
    display("noneMatch(t->t.startsWith(\"a\")) 모두 맞지 않으면 true : {} ", dummyNameList.stream()
        .noneMatch(t->t.startsWith("a"))
    );
  }

  private void display(String format, boolean match) {
    log.debug(format, match);
  }
  
}
