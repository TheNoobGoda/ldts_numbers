package com.aor.numbers;

public class DivisibleByFilter implements GenereicListFilter{
    Integer filter;

    public DivisibleByFilter(Integer filter){
        this.filter = filter;
    }

    public boolean accept(Integer number){
        if (number%filter == 0){
            return true;
        }else{
            return false;
        }
    }
}
