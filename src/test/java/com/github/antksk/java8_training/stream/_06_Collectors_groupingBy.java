package com.github.antksk.java8_training.stream;

import com.github.antksk.java8_training.data.TestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
@DisplayName("06  Collectors.groupingBy(curring)")
public class _06_Collectors_groupingBy {
    @Test
    @DisplayName("단일 groupingBy 테스트")
    public void test1(){
        List<TestData.Item> items = new TestData().inMemoryDataWithItemList();
        final Map<TestData.ItemType, List<TestData.Item>> itemTypeListMap = items.stream().collect(groupingBy(TestData.Item::getType));

        itemTypeListMap.forEach((type,v)->{
            log.debug("{}", type.name() );
            v.forEach(e->{
                log.debug("\t{}",e);
            });
        });
    }

    @Test
    @DisplayName("다중 groupingBy 테스트")
    public void test2(){
        List<TestData.Item> items = new TestData().inMemoryDataWithItemList();

        // Map의 첫번째 키를 Item Type으로 지정
        Function<TestData.Item, TestData.ItemType> groupByKey_0 = TestData.Item::getType;

        // Map의 두번째 키를 Item name의 prefix로 지정
        Function<TestData.Item, String> groupByKey_1 = (e) -> e.getName().substring(0,1).toUpperCase();

        // 다중키 HashMap 생성
        final Map<TestData.ItemType, Map<String, List<TestData.Item>>> itemTypeMapAndNamePrefixMap = items.stream().collect(groupingBy(groupByKey_0, groupingBy(groupByKey_1)));


        itemTypeMapAndNamePrefixMap.forEach((type,m)->{
            log.debug("[{}]", type.name() );
            m.forEach((k,v)->{
                log.debug("\t[{}]",k);
                v.forEach((e)->{
                    log.debug("\t\t{}",e);
                });
            });
        });
    }
}

