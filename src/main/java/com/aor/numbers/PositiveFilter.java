package com.aor.numbers;

public class PositiveFilter implements GenereicListFilter {

    public boolean accept(Integer number){
        if (number > 0){
            return true;
        }else{
            return false;
        }
    }
}
