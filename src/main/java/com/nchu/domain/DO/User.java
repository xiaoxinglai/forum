package com.nchu.domain.DO;

/**
 * Created by user12 on 2017/12/11.
 */

import java.util.Date;


//@Entity
public class User {

    //@Id
   // @GeneratedValue
    private Long uId;

   // @NotNull(message = "学号不能为空")
    private Long uNo;
    private String uName;
    private String gender;
    private Date  signDate;//注册时间
    private String college;
    private Integer tag;//0-学生  1-老师
    private Integer  permission;// 0-普通 1-管理员


    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getuNo() {
        return uNo;
    }

    public void setuNo(Long uNo) {
        this.uNo = uNo;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public User() {

    }

    public User(Long uNo, String uName, String gender, Date signDate, String college, Integer tag, Integer permission) {
        this.uNo = uNo;
        this.uName = uName;
        this.gender = gender;
        this.signDate = signDate;
        this.college = college;
        this.tag = tag;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uNo=" + uNo +
                ", uName='" + uName + '\'' +
                ", gender='" + gender + '\'' +
                ", signDate=" + signDate +
                ", college='" + college + '\'' +
                ", tag=" + tag +
                ", permission=" + permission +
                '}';
    }
}