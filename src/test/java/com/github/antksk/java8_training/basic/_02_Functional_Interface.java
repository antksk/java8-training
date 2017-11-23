package com.github.antksk.java8_training.basic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.google.common.collect.ImmutableMap;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 인터페이스에 @FunctionalInterface 를 사용하면,
 * default로 정의된 메소드를 제외하고 단일 메소드만 존재해야 함을 의미한다.
 * 이와 같이 단일 메소드에 대한 존재를 보장받게 되면 @FunctionalInterface로 정의된 
 * 인터페이스는 람다 형식으로 대체가 가능하다.
 * 
 * 즉, @FunctionalInterface 는 단일 메소드 정의만 존재 한다는 것을 보장 받는다. 
 * 
 * @author Seung Gyum Kim
 */
@Slf4j
public class _02_Functional_Interface {
  
  /**
   * 리턴타입이 R이고, 파라미터가 단일 값이 전달 되는 
   * 
   * 메소드 convert를 정의한 
   * 
   * Converter 인터페이스
   * 
   * @author Seung Gyum Kim
   *
   * @param <R> 리턴타입
   * @param <T> 파라미터(argument) 타입
   */
  @FunctionalInterface
  interface Converter<R, T>{
    R convert(T from);
  }
  
  class NameConverter implements Converter<Integer, String>{
    @Override
    public Integer convert(String from) {
      Pattern pattern = Pattern.compile("^[a-z]+_(0?[0-9]+)");
      Matcher matcher = pattern.matcher(from);
      if( matcher.matches() && 1 == matcher.groupCount() ){
        return Integer.valueOf(matcher.group(1));
      }
      return Integer.MIN_VALUE;
    }
    
    private final  Map<String, Integer> map = new ImmutableMap.Builder<String, Integer>()
      .put("show",111)
      .put("me",222)
      .put("the",333)
      .put("money",444)
    .build();

    public Integer toMappingInt(String from) {
      if( map.containsKey(from) ){
        return map.get(from);
      }
      return Integer.MIN_VALUE;
    }
  }
  
  /**
   * Functional Interface 내용에 대응
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#functional-interface
   */
  @Test
  @DisplayName("함수 인터페이스 키워드 활용한 테스트")
  public void useFunctionInterfaceTest(){
    
    displayConverterResult((s)->Integer.valueOf(s), "10", 10);
    // or 
    displayConverterResult(Integer::valueOf, "100", 100);
    
    // 인스턴스를 사용하면,
    NameConverter nameConverter = new NameConverter();
    displayConverterResult(nameConverter::convert, "abc_01", 1);
    displayConverterResult(nameConverter::convert, "abc01", Integer.MIN_VALUE);
    // 메소드 이름이 같은 경우에 호출되는 것이 아니라, 
    // 메소드 정의 형식이 같으면 호출됨
    displayConverterResult(nameConverter::toMappingInt, "the", 333);
    displayConverterResult(nameConverter::toMappingInt, "the money", Integer.MIN_VALUE);
  }
  
  void displayConverterResult(Converter<Integer, String> c, String from, int expect){
    Integer convert = c.convert(from);
    assertThat(convert, is(expect));
    log.debug("display converter result : {}", convert);
  }
  
  @Value
  class Person{
    String name;
    Integer age;
  }
  
  @FunctionalInterface
  interface PersonFactory<R extends Person> {
    R create( String name, Integer age );
  }
  
  /**
   * Method and Constructor References 내용과 대응
   * @see 
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#method-and-constructor-references
   */
  @Test
  @DisplayName("생성자를 호출하는 형태 테스트")
  public void newMethodCallTest(){
    // 불변 객체를 만들때, 생성자에 데이터를 설정하는 경우가 많은데, 
    Person p0 = new Person("test p0", 1);
    // 객체 생성에 대한 정의를 PersonFactroy에게 위읨하여 아래와 같이 정의 할수 있다.
    PersonFactory<Person> personFactory = Person::new;
    Person p1 = personFactory.create("test p1", 2);
  }
  
  /**
   * Accessing local variables, Accessing fields and static variables
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#accessing-local-variables
   */
  @Test
  @DisplayName("Lambda 변수 관리 범위 테스트")
  public void localValueReLocationTest(){
    // 지역변수 num은 stringConverter 에서 사용되기 때문에,
    // 암묵적으로 final int num = 1;이 된다. 
    // 즉, num 변수에 재할당이 불가능하다.
    int num = 1;
    // 또한, 람다식 안에서 num 객체에 대한 재할당도 금지 된다.
    Converter<Integer, String> stringConverter = (from) -> Integer.valueOf(from + num);
    stringConverter.convert("1234");
    // 하지만, field나 static 변수의 경우, 람다식에서 수정이 가능하다. 이는 익명 오브젝트의 특징과 같다.
  }
}   
