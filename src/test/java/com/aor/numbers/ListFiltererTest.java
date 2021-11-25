package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    class testListFilterer implements GenereicListFilter{
        public boolean accept(Integer number){
            return number > 0;
        }
    }

    @Test
    public void filter(){
        List<Integer> list= Arrays.asList(1,2,3,4,-1,-2);
        List<Integer> expected = Arrays.asList(1,2,3,4);
        List<Integer> list1= Arrays.asList(1,4,-1,2,0);
        List<Integer> expected1 = Arrays.asList(1,4,2);
        List<Integer> list2= Arrays.asList(1,2,3,4,-1,-2);
        List<Integer> expected2 = Arrays.asList(1,2,3,4);
        List<Integer> list3= Arrays.asList(1,2,3,4,-1,-2);
        List<Integer> expected3 = Arrays.asList(1,2,3,4);

        GenereicListFilter glf =new testListFilterer();
        ListFilterer listFilterer = new ListFilterer(glf);

        List<Integer> filter = listFilterer.filter(list);
        List<Integer> filter1 = listFilterer.filter(list1);
        List<Integer> filter2 = listFilterer.filter(list2);
        List<Integer> filter3 = listFilterer.filter(list3);

        Assertions.assertEquals(expected,filter);
        Assertions.assertEquals(expected1,filter1);
        Assertions.assertEquals(expected2,filter2);
        Assertions.assertEquals(expected3,filter3);


    }

    @Test
    public void positiveFilter(){
        PositiveFilter filter = new PositiveFilter();

        boolean test = filter.accept(5);
        boolean test1 = filter.accept(-1);
        boolean test2 = filter.accept(0);

        Assertions.assertEquals(true,test);
        Assertions.assertEquals(false,test1);
        Assertions.assertEquals(false,test2);
    }

    @Test
    public void divisibleByFilter3(){
        DivisibleByFilter filter = new DivisibleByFilter(3);

        boolean test = filter.accept(6);
        boolean test1 = filter.accept(135);
        boolean test2 = filter.accept(14);
        boolean test3 = filter.accept(0);
        boolean test4 = filter.accept(2);
        boolean test5 = filter.accept(-1);

        Assertions.assertEquals(true,test);
        Assertions.assertEquals(true,test1);
        Assertions.assertEquals(false,test2);
        Assertions.assertEquals(true,test3);
        Assertions.assertEquals(false,test4);
        Assertions.assertEquals(false,test5);
    }

    @Test
    public void divisibleByFilter5(){
        DivisibleByFilter filter = new DivisibleByFilter(5);

        boolean test = filter.accept(5);
        boolean test1 = filter.accept(134);
        boolean test2 = filter.accept(14);
        boolean test3 = filter.accept(0);
        boolean test4 = filter.accept(10);
        boolean test5 = filter.accept(121);

        Assertions.assertEquals(true,test);
        Assertions.assertEquals(false,test1);
        Assertions.assertEquals(false,test2);
        Assertions.assertEquals(true,test3);
        Assertions.assertEquals(true,test4);
        Assertions.assertEquals(false,test5);
    }
}
