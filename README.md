# java8-training
Java8를 사용한지 2년이 넘어가지만 나름 정리한 내용이, 이곳 저곳에 흐터져 있어 이곳에 재 정리함

### build
* eclipse sts 기반 프로젝트로 생성

```gradle
gradle eclipse
```


### Java8로 적용 샘플 코드 목차
* basic: 
	- [Default Method for Interface][Default_Method_for_Interface]
	- [Lambda expressions][Lambda_expressions]
	- [Functional Interface][Functional_Interface]
	- [Built-in Functional Interfaces][Built_in_Functional_Interfaces]
[Default_Method_for_Interface]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/_00_Default_Method_for_Interface.java#L73
[Lambda_expressions]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/_01_Lambda_expressions.java#L44
[Functional_Interface]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/_02_Functional_Interface.java#L38
[Built_in_Functional_Interfaces]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/_03_Built_in_Functional_Interfaces.java#L20

* stream: 일종의 pipeline으로 연속적인 어떤 데이터의 흐름을 가르킴, Stream 연산 들은 중간 연산(intermediate operation) 이거나 결과 값을 리턴하는 종단 연산(terminal operation) 이다. 
	- [filter][filter](Predicate<? super T> predicate) : 지정된 predicate의해서 지정된 값과 일치(match)한 값들만 취합 
	- [sorted][sorted](Comparator<? super T> comparator): stream에 정렬에 대한 마킹만 하고 실제 정렬은, 종단 연산이 수행될때 진행됨(기본은 오름차순정렬)
	- [map][map](Function<? super T, ? extends R> mapper) : 지정된 strem의 데이터를 임의 데이터로 변경
	- __(terminal)__ forEach(Consumer<? super T> action) : (소비) 각각의 데이터를 모두 소비
	- __(terminal)__ [match][match] : any(아무거나 한개 이상 match), all(모두 match), none(한개도 match되지 않음) match가 존재 하며, 소비 함수 임 
	- __(terminal)__ [count][count] : stream에 존재하는 element 갯수 확인(소비, long 타입으로 리턴)
	- __(terminal)__ [reduce][reduce] : 결합법칙(결합하는 순서는 중요하지 않아야 함)이 적용된 결과값을 리턴
[filter]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/stream/_00_Filter.java#L47
[sorted]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/stream/_01_Sorted.java#L14
[map]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/stream/_02_Map.java#L16
[match]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/stream/_03_Match.java#L15
[count]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/stream/_04_Count.java#L18
[reduce]: https://github.com/antksk/java8-training/blob/develop/src/test/java/com/github/antksk/java8_training/stream/_05_Reduce.java#L53

### 참고 자료
* Java 8 tutorial:
	- [원작자 출처 (winterbe-Java 8 Tutorial)][Java_8_tutorial_kr] 
	- [번역자 출처][Java_8_tutorial_kr]
* LocalDate:
* Optionals:

[Java_8_tutorial_en]: https://github.com/winterbe/java8-tutorial
[Java_8_tutorial_kr]: https://github.com/yakmoz/ref/blob/master/java/java%208%20tutorial.md
# java8-training
Java8를 사용한지 2년이 넘어가지만 나름 정리한 내용이, 이곳 저곳에 흐터져 있어 이곳에 다시 정리함
