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
}
