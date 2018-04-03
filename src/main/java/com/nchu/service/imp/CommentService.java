package com.nchu.service.imp;

import com.nchu.domain.DO.Comment;
import com.nchu.domain.VO.PageResult;
import com.nchu.mapper.CommentMapper;
import com.nchu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user12 on 2018/3/2.
 */
@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int deleteBycommentId(Long commentId, Long uId) {
       Comment comment= commentMapper.selectByPrimaryKey(commentId);
       if (comment.getPersonId().equals(uId)){
           return commentMapper.deleteByPrimaryKey(commentId);
       }else {

           return -2;
       }
    }

    @Override
    public Boolean SubmitComment(Comment comment) {
        if (commentMapper.insert(comment) > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<Comment> queryCommentbyQuestionId(Long questionId) {
        return commentMapper.selectByQuestionId(questionId);
    }

    @Override
    public PageResult<Comment> selectCommentByQuestionId(Long questionId, Integer current) {

        List<Comment> comments= commentMapper.selectByQuestionIdWithCurrent(questionId,(current - 1) * PageResult.pageSize,PageResult.pageSize);
        Integer totalSize=commentMapper.selectCountComment(questionId);


        return PageResult.Create(comments, current, totalSize/PageResult.pageSize+1);


    }

    @Override
    public Long CommentGoodOrBad(Long commentId, Integer key, Long Num) {

             commentMapper.updateGoodOrBad(commentId,key,Num);
            return Num;


    }
}
