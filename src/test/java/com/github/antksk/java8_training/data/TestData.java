package com.github.antksk.java8_training.data;

import com.google.common.collect.Lists;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
/**
 * 모든 메서드들이 리턴 하는 데이터는 불편 객체 임
 * @author Seung Gyum Kim
 *
 */
public final class TestData {

  public List<String> inMemoryDataWithDummyNameList(){
    return Arrays.asList("peter", "anna", "mike", "xenia");
  }

  public List<Integer> inMemoryDataWithDummyIntegers(){
    return IntStream.rangeClosed(0, 100).boxed().collect(toList());
  }

  public List<String> inMemoryDataWithDummyList(){
    return Arrays.asList(
      "aaa0", "bbb0", "ccc0",
      "aaa1", "bbb1", "ccc1",
      "aaa2", "bbb2", "ccc2",
      "aaa3", "bbb3", "ccc3"
    );
  }

  public static enum ItemType{
    TYPE_NORMAL, TYPE_ETC;
  }
  @Value(staticConstructor = "of")
  public static class Item{
    private int id;
    private String name;
    private ItemType type;

    public static Item ofNormal(int id, String name){
      return of( id, name, ItemType.TYPE_NORMAL);
    }

    public static Item ofEtc(int id, String name){
      return of( id, name, ItemType.TYPE_ETC);
    }

  }


  public List<Item> inMemoryDataWithItemList(){
    return Arrays.asList(
            Item.ofNormal(0, "a-item-0"),
            Item.ofNormal(1, "b-item-1"),
            Item.ofNormal(2, "c-item-2"),
            Item.ofNormal(3, "a-item-3"),
            Item.ofNormal(4, "b-item-4"),
            Item.ofEtc(5, "c-item-5"),
            Item.ofEtc(6, "a-item-6"),
            Item.ofEtc(7, "b-item-7"),
            Item.ofEtc(8, "c-item-8"),
            Item.ofEtc(9, "a-item-9")
    );
  }

  public String inMemoryDataWithDummyStrings(){
    return "show me the money";
  }
}
