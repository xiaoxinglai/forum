package com.nchu.domain.DO;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.question_id
     *
     * @mbggenerated
     */
    private Long questionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.bad_num
     *
     * @mbggenerated
     */
    private Long badNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.course_id
     *
     * @mbggenerated
     */
    private Long courseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.good_num
     *
     * @mbggenerated
     */
    private Long goodNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.is_cream
     *
     * @mbggenerated
     */
    private Boolean isCream;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.is_resource
     *
     * @mbggenerated
     */
    private Boolean isResource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.level
     *
     * @mbggenerated
     */
    private Long level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.level_desc
     *
     * @mbggenerated
     */
    private String levelDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.person_id
     *
     * @mbggenerated
     */
    private Long personId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.person_name
     *
     * @mbggenerated
     */
    private String personName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.question_desc
     *
     * @mbggenerated
     */
    private String questionDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.techer_id
     *
     * @mbggenerated
     */
    private Long techerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.techer_name
     *
     * @mbggenerated
     */
    private String techerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.visit_num
     *
     * @mbggenerated
     */
    private Long visitNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.course_name
     *
     * @mbggenerated
     */
    private String courseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table question
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.question_id
     *
     * @return the value of question.question_id
     *
     * @mbggenerated
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.question_id
     *
     * @param questionId the value for question.question_id
     *
     * @mbggenerated
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.bad_num
     *
     * @return the value of question.bad_num
     *
     * @mbggenerated
     */
    public Long getBadNum() {
        return badNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.bad_num
     *
     * @param badNum the value for question.bad_num
     *
     * @mbggenerated
     */
    public void setBadNum(Long badNum) {
        this.badNum = badNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.content
     *
     * @return the value of question.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.content
     *
     * @param content the value for question.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.course_id
     *
     * @return the value of question.course_id
     *
     * @mbggenerated
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.course_id
     *
     * @param courseId the value for question.course_id
     *
     * @mbggenerated
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.good_num
     *
     * @return the value of question.good_num
     *
     * @mbggenerated
     */
    public Long getGoodNum() {
        return goodNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.good_num
     *
     * @param goodNum the value for question.good_num
     *
     * @mbggenerated
     */
    public void setGoodNum(Long goodNum) {
        this.goodNum = goodNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.is_cream
     *
     * @return the value of question.is_cream
     *
     * @mbggenerated
     */
    public Boolean getIsCream() {
        return isCream;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.is_cream
     *
     * @param isCream the value for question.is_cream
     *
     * @mbggenerated
     */
    public void setIsCream(Boolean isCream) {
        this.isCream = isCream;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.is_resource
     *
     * @return the value of question.is_resource
     *
     * @mbggenerated
     */
    public Boolean getIsResource() {
        return isResource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.is_resource
     *
     * @param isResource the value for question.is_resource
     *
     * @mbggenerated
     */
    public void setIsResource(Boolean isResource) {
        this.isResource = isResource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.level
     *
     * @return the value of question.level
     *
     * @mbggenerated
     */
    public Long getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.level
     *
     * @param level the value for question.level
     *
     * @mbggenerated
     */
    public void setLevel(Long level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.level_desc
     *
     * @return the value of question.level_desc
     *
     * @mbggenerated
     */
    public String getLevelDesc() {
        return levelDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.level_desc
     *
     * @param levelDesc the value for question.level_desc
     *
     * @mbggenerated
     */
    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc == null ? null : levelDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.person_id
     *
     * @return the value of question.person_id
     *
     * @mbggenerated
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.person_id
     *
     * @param personId the value for question.person_id
     *
     * @mbggenerated
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.person_name
     *
     * @return the value of question.person_name
     *
     * @mbggenerated
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.person_name
     *
     * @param personName the value for question.person_name
     *
     * @mbggenerated
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.question_desc
     *
     * @return the value of question.question_desc
     *
     * @mbggenerated
     */
    public String getQuestionDesc() {
        return questionDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.question_desc
     *
     * @param questionDesc the value for question.question_desc
     *
     * @mbggenerated
     */
    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc == null ? null : questionDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.techer_id
     *
     * @return the value of question.techer_id
     *
     * @mbggenerated
     */
    public Long getTecherId() {
        return techerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.techer_id
     *
     * @param techerId the value for question.techer_id
     *
     * @mbggenerated
     */
    public void setTecherId(Long techerId) {
        this.techerId = techerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.techer_name
     *
     * @return the value of question.techer_name
     *
     * @mbggenerated
     */
    public String getTecherName() {
        return techerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.techer_name
     *
     * @param techerName the value for question.techer_name
     *
     * @mbggenerated
     */
    public void setTecherName(String techerName) {
        this.techerName = techerName == null ? null : techerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.time
     *
     * @return the value of question.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.time
     *
     * @param time the value for question.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.title
     *
     * @return the value of question.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.title
     *
     * @param title the value for question.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.visit_num
     *
     * @return the value of question.visit_num
     *
     * @mbggenerated
     */
    public Long getVisitNum() {
        return visitNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.visit_num
     *
     * @param visitNum the value for question.visit_num
     *
     * @mbggenerated
     */
    public void setVisitNum(Long visitNum) {
        this.visitNum = visitNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.course_name
     *
     * @return the value of question.course_name
     *
     * @mbggenerated
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.course_name
     *
     * @param courseName the value for question.course_name
     *
     * @mbggenerated
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", badNum=").append(badNum);
        sb.append(", content=").append(content);
        sb.append(", courseId=").append(courseId);
        sb.append(", goodNum=").append(goodNum);
        sb.append(", isCream=").append(isCream);
        sb.append(", isResource=").append(isResource);
        sb.append(", level=").append(level);
        sb.append(", levelDesc=").append(levelDesc);
        sb.append(", personId=").append(personId);
        sb.append(", personName=").append(personName);
        sb.append(", questionDesc=").append(questionDesc);
        sb.append(", techerId=").append(techerId);
        sb.append(", techerName=").append(techerName);
        sb.append(", time=").append(time);
        sb.append(", title=").append(title);
        sb.append(", visitNum=").append(visitNum);
        sb.append(", courseName=").append(courseName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}