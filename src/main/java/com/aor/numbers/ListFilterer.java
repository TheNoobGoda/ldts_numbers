package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer{
    private GenereicListFilter genereicListFilter;

    public ListFilterer(GenereicListFilter genereicListFilter){
        this.genereicListFilter =genereicListFilter;
    }


    public List<Integer> filter(List<Integer> list){
        List<Integer> filtered = new ArrayList<>();
        for (int i : list){
            if (genereicListFilter.accept(i)){
                filtered.add(i);
            }
        }
        return filtered;
    }
}
