package com.nchu.service;

import com.nchu.domain.DO.Comment;
import com.nchu.domain.VO.PageResult;

import java.util.List;

/**
 * Created by user12 on 2018/3/2.
 */
public interface ICommentService {


    int deleteBycommentId(Long commentId,Long uId);
    Boolean SubmitComment(Comment comment);

    List<Comment> queryCommentbyQuestionId(Long questionId);
    PageResult<Comment> selectCommentByQuestionId(Long questionId,Integer current);
    /**
     * 对评论进行点赞取消处理
     */
    Long CommentGoodOrBad(Long commentId,Integer key,Long Num);



}
