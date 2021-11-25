package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    List<Integer> list =Arrays.asList(1,2,4,2);

    class TestListDeduplicator implements GenericListDeduplicator {
        public List<Integer> deduplicate (List<Integer> l){
            List<Integer> list1 = Arrays.asList(1,2,4);
            return list1;
        }
    }

    @Test
    public void sum() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void sum2() {
        List<Integer> list = Arrays.asList(-1,-4,1,2,3,4);
        GenericListDeduplicator gld = new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int sum = aggregator.sum(list);

        Assertions.assertEquals(5,sum);
    }

    @Test
    public void sum3(){
        List<Integer> list = Arrays.asList(0,3,2,0,6,-2,-10);
        GenericListDeduplicator gld = new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int sum = aggregator.sum(list);

        Assertions.assertEquals(-1, sum);
    }

    @Test
    public void max() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max1(){
        List<Integer> list = Arrays.asList(-1,-2,-4,0);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int max = aggregator.max(list);

        Assertions.assertEquals(0,max);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> list = Arrays.asList(-1,-4,-5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void min2() {
        List<Integer> list = Arrays.asList(1,2,4,2,-5,-2,5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int min = aggregator.min(list);

        Assertions.assertEquals(-5, min);
    }

    @Test
    public void min3() {
        List<Integer> list = Arrays.asList(0,-2,4,2,0,-10);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int min = aggregator.min(list);

        Assertions.assertEquals(-10, min);
    }

    @Test
    public void min4() {
        List<Integer> list = Arrays.asList(1,2,0,2,5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int min = aggregator.min(list);

        Assertions.assertEquals(0, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        GenericListDeduplicator gld =new TestListDeduplicator();
        ListAggregator aggregator = new ListAggregator(gld);
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3, distinct);
    }
}
