package com.github.antksk.java8_training.stream;

import java.util.List;

import org.junit.Test;

import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _03_Match {
  
  @Test
  public void 조건_매칭_여부_판단(){
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
