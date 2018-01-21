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
//public class Comment {
//
//    @Id
//    @GeneratedValue
//    private Long commentId;
//
//    private  String content;
//
//    private Long questionId;
//
//    private Long courseId;
//
//    private Long personId;
//    private String personName;
//    private Long goodNum;
//    private Long badNum;
//    private Date time;//评论时间
//
//
//    public Comment() {
//    }
//
//    public Comment(String content, Long questionId, Long courseId, Long personId, String personName, Long goodNum, Long badNum, Date time) {
//        this.content = content;
//        this.questionId = questionId;
//        this.courseId = courseId;
//        this.personId = personId;
//        this.personName = personName;
//        this.goodNum = goodNum;
//        this.badNum = badNum;
//        this.time = time;
//    }
//
//    @Override
//    public String toString() {
//        return "Comment{" +
//                "commentId=" + commentId +
//                ", content='" + content + '\'' +
//                ", questionId=" + questionId +
//                ", courseId=" + courseId +
//                ", personId=" + personId +
//                ", personName='" + personName + '\'' +
//                ", goodNum=" + goodNum +
//                ", badNum=" + badNum +
//                ", time=" + time +
//                '}';
//    }
//}
