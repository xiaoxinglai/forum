package com.nchu.service;

import com.nchu.domain.DO.Question;
import com.nchu.domain.DO.User;
import com.nchu.domain.Form.QuestionForm;
import com.nchu.domain.VO.PageResult;

/**
 * Created by user12 on 2018/2/27.
 */
public interface IQuestionService {





    /**
     * 对问题进行点赞取消处理
     */
    Long questionGoodOrBad(Long questionId,Integer key,Long goodNum,Long badNum);

    /**
     * 对问题进行加精 取消处理
     */

    Boolean creamQuestion(Question question);

    /**
     * 回复问题
     */
    Boolean  EditQuestion(Question question);


    /**
     * 删除问题
     */
    Boolean deletequestion(Long questionId);

    /**
     * 模糊查询问题
     */
    PageResult<Question>  questionSearcher(String key,Integer currentPage);

    /**
     * 插入问题
     * @param questionForm
     * @return
     */
    Long InsertQuestion(QuestionForm questionForm, User user);

    /**
     * 按问题id查找问题
     */
    Question selectByPrimaryKey(Long questionId);

    /**
     * 根据课程id查找问题列表
     */
    PageResult<Question> selectQuestionByCourseIdAndLevel(Long CourseId, Long level, Integer currentPage);

    /**
     * 根据用户id查找问题
     */

    PageResult<Question> selectQuestionByUID(Long UID, Integer currentPage);

    /**
     * 查询所有加精的问题
     */
    PageResult<Question>  isCreamQuetion(Integer currentPage);
    /**
     * 查询指定课程的加精的问题
     */
    PageResult<Question>   isCreamCourseQuetion(Long courseId,Integer currentPage);
    /**
     * 查询所有的问题按照访问量排序
     */
    PageResult<Question>  newQuetionAll(Integer currentPage);


}
