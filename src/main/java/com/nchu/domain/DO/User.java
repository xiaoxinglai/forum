package com.nchu.domain.DO;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_id
     *
     * @mbggenerated
     */
    private Long uId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.college
     *
     * @mbggenerated
     */
    @NotBlank(message = "学院不能为空")
    private String college;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.permission
     *
     * @mbggenerated
     */
    private Integer permission;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sign_date
     *
     * @mbggenerated
     */
    private Date signDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.tag
     *
     * @mbggenerated
     */
    private Integer tag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_name
     *
     * @mbggenerated
     */
    @NotBlank(message = "姓名不能为空")
    private String uName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_no
     *
     * @mbggenerated
     */
    @NotNull(message = "学号不能为空")
    private Long uNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.detail
     *
     * @mbggenerated
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_id
     *
     * @return the value of user.u_id
     *
     * @mbggenerated
     */
    public Long getuId() {
        return uId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_id
     *
     * @param uId the value for user.u_id
     *
     * @mbggenerated
     */
    public void setuId(Long uId) {
        this.uId = uId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.college
     *
     * @return the value of user.college
     *
     * @mbggenerated
     */
    public String getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.college
     *
     * @param college the value for user.college
     *
     * @mbggenerated
     */
    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.permission
     *
     * @return the value of user.permission
     *
     * @mbggenerated
     */
    public Integer getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.permission
     *
     * @param permission the value for user.permission
     *
     * @mbggenerated
     */
    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sign_date
     *
     * @return the value of user.sign_date
     *
     * @mbggenerated
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sign_date
     *
     * @param signDate the value for user.sign_date
     *
     * @mbggenerated
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.tag
     *
     * @return the value of user.tag
     *
     * @mbggenerated
     */
    public Integer getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.tag
     *
     * @param tag the value for user.tag
     *
     * @mbggenerated
     */
    public void setTag(Integer tag) {
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_name
     *
     * @return the value of user.u_name
     *
     * @mbggenerated
     */
    public String getuName() {
        return uName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_name
     *
     * @param uName the value for user.u_name
     *
     * @mbggenerated
     */
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_no
     *
     * @return the value of user.u_no
     *
     * @mbggenerated
     */
    public Long getuNo() {
        return uNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_no
     *
     * @param uNo the value for user.u_no
     *
     * @mbggenerated
     */
    public void setuNo(Long uNo) {
        this.uNo = uNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.detail
     *
     * @return the value of user.detail
     *
     * @mbggenerated
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.detail
     *
     * @param detail the value for user.detail
     *
     * @mbggenerated
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", college=").append(college);
        sb.append(", gender=").append(gender);
        sb.append(", permission=").append(permission);
        sb.append(", signDate=").append(signDate);
        sb.append(", tag=").append(tag);
        sb.append(", uName=").append(uName);
        sb.append(", uNo=").append(uNo);
        sb.append(", detail=").append(detail);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public User() {
    }

    public User(Long uId, String college, String gender, Integer permission, Date signDate, Integer tag, String uName, Long uNo, String detail, String password) {
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
    }
}