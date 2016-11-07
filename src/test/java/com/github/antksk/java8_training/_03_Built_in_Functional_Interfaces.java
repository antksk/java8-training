package com.github.antksk.java8_training;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 자주 사용되는 @FunctionalInterface 들이 미리 정의 되어 있는데,
 * 
 * 제일 많이 사용되는 @FunctionalInterface 는 다음과 같다 
 * 
 * Predicate<T>             boolean test(T t);              t값에 대한 논리 연산 결과 반환
 * Function<T, R>           R apply(T t);                   t값을 받아 R값으로 변환하여 반환
 * Supplier<T>              T get()                         T값을 생성(공급)
 * Consumer<T>              void accept(T t);               t값을 받아 실행(소비)
 * Comparator<T>            int compare(T o1, T o2);        o1, o2값을 비교하여 -1(작음), 0(같음), 1(큼) 리턴
 * @author Seung Gyum Kim
 *
 */
@Slf4j
public class _03_Built_in_Functional_Interfaces {

  /**
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#predicates
   */
  public void Predicates_테스트(){
    Predicate<String> predicate = (s) -> s.length() > 0;
    predicate.test("foo");              // true
    predicate.negate().test("foo");     // false
  }
  
  /**
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#functions
   */
  public void Functions_테스트(){
    Function<String, Integer> toInteger = Integer::valueOf;
    Function<String, String> backToString = toInteger.andThen(String::valueOf);
    backToString.apply("123");     // "123"
  }
  
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  class Person{
    String name;
    Integer age;
  }
  /**
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#suppliers
   */
  public void Suppliers_테스트(){
    Supplier<Person> personSupplier = Person::new;
    personSupplier.get();   // new Person
  }
  
  /**
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#consumers
   */
  @Test
  public void Consumers_테스트(){
    Consumer<Person> greeter = (p) -> log.debug("Hello, {}", p.name);
    greeter.accept(new Person("Luke", 15));
  }
  
  /**
   * @see
   *    https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md#comparators
   */
  @Test
  public void Comparators_테스트(){
    Comparator<Person> comparator = (p1, p2) -> p1.age.compareTo(p2.age);

    Person p1 = new Person("John", 20);
    Person p2 = new Person("Alice", 25);

    log.debug("{}",comparator.compare(p1, p2));             // p1보다 p2가 작음(-1) 
    log.debug("{}",comparator.reversed().compare(p1, p2));  // p1과 p2 결과 반전(1) 
  }
}
