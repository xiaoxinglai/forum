package com.nchu.domain.DO;

import java.util.Map;

/**
 * Created by user12 on 2018/3/27.
 */
public class Option {
    private Map<Long,UserOption> userOptionMap;

    public Option() {
    }

    public Map<Long, UserOption> getUserOptionMap() {
        return userOptionMap;
    }

    public void setUserOptionMap(Map<Long, UserOption> userOptionMap) {
        this.userOptionMap = userOptionMap;
    }

}
