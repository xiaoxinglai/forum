//package com.nchu.domain.DO;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
///**
// * Created by user12 on 2017/12/11.
// */
//@Entity
//public class Course {
//
//    @Id
//    @GeneratedValue
//    private Long courseId;
//
//    private String title;
//
//    private String imgPath;
//
//    private Long questionNum;
//
//    public Course() {
//    }
//
//    public Course(Long courseId, String title, String imgPath, Long questionNum) {
//        this.courseId = courseId;
//        this.title = title;
//        this.imgPath = imgPath;
//        this.questionNum = questionNum;
//    }
//
//    public Long getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Long courseId) {
//        this.courseId = courseId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getImgPath() {
//        return imgPath;
//    }
//
//    public void setImgPath(String imgPath) {
//        this.imgPath = imgPath;
//    }
//
//    public Long getQuestionNum() {
//        return questionNum;
//    }
//
//    public void setQuestionNum(Long questionNum) {
//        this.questionNum = questionNum;
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "courseId=" + courseId +
//                ", title='" + title + '\'' +
//                ", imgPath='" + imgPath + '\'' +
//                ", questionNum=" + questionNum +
//                '}';
//    }
//}
