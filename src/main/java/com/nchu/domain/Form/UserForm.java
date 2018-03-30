package com.nchu.domain.Form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by user12 on 2018/2/11.
 */
public class UserForm {

    private Long uId;


    @NotBlank(message = "学院不能为空")
    private String college;


    private String gender;


    private Integer permission;


    private Date signDate;

    private Integer tag;

    @NotBlank(message = "姓名不能为空")
    private String uName;

    @NotNull(message = "学号不能为空")
    private Long uNo;


    private String detail;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "密码不能为空")
    private String Repassword;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Long getuNo() {
        return uNo;
    }

    public void setuNo(Long uNo) {
        this.uNo = uNo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return Repassword;
    }

    public void setRepassword(String repassword) {
        Repassword = repassword;
    }

    public UserForm() {
    }

    public UserForm(Long uId, String college, String gender, Integer permission, Date signDate, Integer tag, String uName, Long uNo, String detail, String password, String repassword) {
        this.uId = uId;
        this.college = college;
        this.gender = gender;
        this.permission = permission;
        this.signDate = signDate;
        this.tag = tag;
        this.uName = uName;
        this.uNo = uNo;
        this.detail = detail;
        this.password = password;
        Repassword = repassword;
    }
}
