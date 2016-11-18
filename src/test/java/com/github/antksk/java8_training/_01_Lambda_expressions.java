package com.github.antksk.java8_training;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.github.antksk.java8_training.data.TestData;

import lombok.extern.slf4j.Slf4j;

/**
 * 기존 버전의 JAVA에선 익명 메소드를 사용하여 처리하던 사항을 
 * 간단하게 람다 형식으로 변경한 예저로
 * 메소드에 대한 기본 정보만 존재하면 람다형식으로 많은 축약화가 가능함
 * @author Seung Gyum Kim
 * @see
 *  
 */
@Slf4j
public class _01_Lambda_expressions {
  
  @Test
  public void 람다를_사용한_간단한_정렬_테스트(){
    TestData data = new TestData();
    // case 1
    oldStyleAction(data.inMemoryDataWithDummyNameList());
    
    newStyleAction(data.inMemoryDataWithDummyNameList());
  }

  /**
   * 기존 정렬 방식
   * @param names
   */
  private void oldStyleAction(List<String> names) {
    Collections.sort(names,new Comparator<String>(){
      @Override
      public int compare(String a, String b) {
        return b.compareTo(a);
      }
    });
    log.debug("### old style : {}", names);
  }
  
  /**
   * Java8에서는 Comparator 인터페이스가 @FunctionalInterface으로 정의되어 있기 때문에,
   * 아래와 같이 간단하게 Lambda를 사용할 수 있다.(-> 표현식은 여전히 불만임) 
   * @param names
   */
  private void newStyleAction(List<String> names) {
    Collections.sort(names, (a,b)->b.compareTo(a));
    // 혹은 메소드 메소드 이름에 좀더 의미를 줘서 더 간력 아래와 같이 간력하게 표시 
    // Collections.sort(names, DummyNamesSort::ascComparator);
    log.debug("### new style : {}", names);
  }
}
