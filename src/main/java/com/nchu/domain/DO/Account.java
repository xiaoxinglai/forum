package com.nchu.domain.DO;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by user12 on 2018/2/10.
 */
public class Account {
    @NotNull(message = "学号不能为空")
    private Long uNo;
    @NotBlank(message = "密码不能为空")
    private String password;



    public Long getuNo() {
        return uNo;
    }

    public void setuNo(Long uNo) {
        this.uNo = uNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(Long uNo, String password) {
        this.uNo = uNo;
        this.password = password;

    }

    public Account() {
    }

}
