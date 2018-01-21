//package com.nchu.domain.DO;
//
///**
// * Created by user12 on 2017/12/11.
// */
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import java.util.Date;
//
//@Entity
//public class Question {
//
//    @Id
//    @GeneratedValue
//    private Long questionId;
//    private Long courseId;
//    private Long personId;
//    private String personName;
//    private Long commentId;
//    private Long techerId;
//    private String techerName;
//    private Long goodNum;
//    private Long badNum;
//    private Long visitNum;
//    private String title;
//    private String questionDesc;
//    private String content;
//    private Date time;//发布时间
//    private Long level;
//    private String levelDesc;
//    private boolean isResource;
//    private boolean isCream;
//
//    public Question() {
//    }
//
//    public Question(Long courseId, Long personId, String personName, Long commentId, Long techerId, String techerName, Long goodNum, Long badNum, Long visitNum, String title, String questionDesc, String content, Date time, Long level, String levelDesc, boolean isResource, boolean isCream) {
//        this.courseId = courseId;
//        this.personId = personId;
//        this.personName = personName;
//        this.commentId = commentId;
//        this.techerId = techerId;
//        this.techerName = techerName;
//        this.goodNum = goodNum;
//        this.badNum = badNum;
//        this.visitNum = visitNum;
//        this.title = title;
//        this.questionDesc = questionDesc;
//        this.content = content;
//        this.time = time;
//        this.level = level;
//        this.levelDesc = levelDesc;
//        this.isResource = isResource;
//        this.isCream = isCream;
//    }
//
//    @Override
//    public String toString() {
//        return "Question{" +
//                "questionId=" + questionId +
//                ", courseId=" + courseId +
//                ", personId=" + personId +
//                ", personName='" + personName + '\'' +
//                ", commentId=" + commentId +
//                ", techerId=" + techerId +
//                ", techerName='" + techerName + '\'' +
//                ", goodNum=" + goodNum +
//                ", badNum=" + badNum +
//                ", visitNum=" + visitNum +
//                ", title='" + title + '\'' +
//                ", questionDesc='" + questionDesc + '\'' +
//                ", content='" + content + '\'' +
//                ", time=" + time +
//                ", level=" + level +
//                ", levelDesc='" + levelDesc + '\'' +
//                ", isResource=" + isResource +
//                ", isCream=" + isCream +
//                '}';
//    }
//}
