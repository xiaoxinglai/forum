package com.nchu.domain.DO;

/**
 * Created by user12 on 2018/3/27.
 */
public class UserOption {

    private Integer good;
    private Integer bad;

    public UserOption() {
        this.good = 0;
        this.bad = 0;
    }

    public Integer getGood() {
        return good;
    }

    public Integer getBad() {
        return bad;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }

}
