package com.github.antksk.java8_training;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Seung Gyum Kim
 * @see 
 *  default method interface: 
 *      https://github.com/antksk/ref/blob/master/java/java%208%20tutorial.md#default-method-for-interface
 *  섭씨 & 화씨 관련 지식: 
 *      https://ko.wikipedia.org/wiki/%EC%84%AD%EC%94%A8
 *      http://www.rapidtables.com/convert/temperature/how-fahrenheit-to-celsius.htm
 */
@Slf4j
public final class _00_Default_Method_for_Interface {

  /**
   * default가 포함된 interface
   */
  interface Formula {
    double calculate(double a);

    /**
     * - interface에 default 키워드 추가됨 - @FunctionalInterface 를 위한 대안으로 생각됨
     * 
     * abstract class와 점점 분간하기 힘들어 지고 있으나,
     * 
     * 몇몇 차이점이 존재함
     *
     * [1] interface는 다중 상속이 되지만, abstrace 클래스는 아직도 단일 상속만 지원됨
     * 
     * [2] interface의 메소드는 private을 선언 할수 없음
     * 
     */
    default int base() {
      return 32;
    }
    
    default float gap(){
      return 1.8f;
    }
  }
  
  /**
   * 화씨(F)에서 섭씨(C)로 변환 
   */
  class CelsiusFormula implements Formula{
    @Override
    public double calculate(double F) {
      return (F - base()) / gap();
    }
    
  }
  
  /**
   * 섭씨(C)에서 화씨(F)로 변환
   */
  class FahrenheitFormula implements Formula{
    @Override
    public double calculate(double C) {
      return (C * gap()) + base();
    }
  }
  

  //@formatter:off;
  @Test
  public void 인터페이스의_기본_메소드를_사용_한_테스트(){
    
    log.debug("#### CelsiusFormula : ");
    CelsiusFormula celsius = new CelsiusFormula();
    result(celsius, -459.67,  -273.15); // 예상 : -273.15 °C
    result(celsius, -50, -45.56 ); // 예상 : -45.56 °C
    result(celsius, -40, -40.00 ); // 예상 : -40.00 °C
    
    log.debug("#### FahrenheitFormula : ");
    FahrenheitFormula fahrenheit = new FahrenheitFormula();
    result(fahrenheit, -273.15, -459.67 ); // 예상 : -459.67 °F
    result(fahrenheit, -45.56, -50 ); // 예상 : -50 °F
    result(fahrenheit, -40.00, -40 ); // 예상 : -40 °F
    
    log.debug("#### transformation code : " );
    // calculate 메소드 내부에서 default 메소드인 base 호출하여 결과 계산함
    result(
      // 이름 없는 객체 생성
      new Formula() {
        @Override
        public double calculate(double a) {
            return base() + a;
        }
      }, 100, 132
    );
  }
  //@formatter:on;

  private void result(Formula formula, double value, double expect) {
    // assertThat(formula.calculate(value), is(expect));
    assertThat(formula.calculate(value), closeTo(expect, 2));
    log.debug("{} := {}", formula.calculate(value), expect);
  }
  
}
