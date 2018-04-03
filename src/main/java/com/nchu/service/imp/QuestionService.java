package com.nchu.service.imp;

import com.nchu.domain.DO.Course;
import com.nchu.domain.DO.Question;
import com.nchu.domain.DO.User;
import com.nchu.domain.Form.QuestionForm;
import com.nchu.domain.VO.PageResult;
import com.nchu.mapper.CourseMapper;
import com.nchu.mapper.QuestionMapper;
import com.nchu.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by user12 on 2018/2/27.
 */
@Service
public class QuestionService implements IQuestionService {


    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Long questionGoodOrBad(Long questionId, Integer key,Long goodNum,Long badNum) {


        if (key==1){
            questionMapper.updateGoodOrBad(questionId,key,goodNum,badNum);
            return goodNum;
        }else
        {
            questionMapper.updateGoodOrBad(questionId,key,goodNum,badNum);
            return badNum;
        }

    }

    @Override
    public Boolean creamQuestion(Question question) {

        if (questionMapper.updateCream(question) > 0) {
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean EditQuestion(Question question) {

        if (questionMapper.updateByPrimaryKey(question) > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }


    @Override
    public Boolean deletequestion(Long questionId) {

        if (questionMapper.deleteByPrimaryKey(questionId) > 0) {

            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public PageResult<Question> questionSearcher(String key, Integer currentPage) {

        List<Question> questionList = questionMapper.questionSearcher(key, (currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer parageSize=questionMapper.selectCountQuestionForKey(key);



        return PageResult.Create(questionList, currentPage, parageSize/PageResult.pageSize+1);
    }

    /**
     * 插入问题
     *
     * @param questionForm
     * @return
     */
    @Override
    @Transactional
    public Long InsertQuestion(QuestionForm questionForm, User user) {

        Question question = new Question();
        question.setTitle(questionForm.getTitle());
        question.setContent(questionForm.getContent());
        question.setCourseId(questionForm.getCourseId());

        Course course=courseMapper.selectByPrimaryKey(questionForm.getCourseId());
        question.setCourseName(course.getTitle());
        question.setTime(new Date());

        question.setPersonName(user.getuName());
        question.setPersonId(user.getuId());


        if (questionMapper.insertSelective(question) > 0) {

            return question.getQuestionId();
        } else {
            return 0L;
        }

    }

    /**
     * 根据问题id查找问题
     *
     * @param questionId
     * @return
     */
    @Override
    public Question selectByPrimaryKey(Long questionId) {

        return questionMapper.selectByPrimaryKey(questionId);
    }

    /**
     * 根据课程id查找问题列表
     */
    @Override
    public PageResult<Question> selectQuestionByCourseIdAndLevel(Long CourseId, Long level, Integer currentPage) {
        List<Question> questionList = questionMapper.selectQuestionList(CourseId, level, (currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer totalSize=questionMapper.selectCountQuestion(CourseId, level);

        return PageResult.Create(questionList, currentPage, totalSize/PageResult.pageSize+1);

    }

    @Override
    public PageResult<Question> selectQuestionByUID(Long UID, Integer currentPage) {
        List<Question> questionList = questionMapper.selectQuestionListByUID(UID, (currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer totalSize=questionMapper.selectCountQuestionByUID(UID);

        return PageResult.Create(questionList, currentPage, totalSize/PageResult.pageSize+1);
    }

    @Override
    public PageResult<Question> isCreamQuetion(Integer currentPage) {
        List<Question> questionList = questionMapper.isCreamQuetion( (currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer totalSize=questionMapper.isCreamQuetionCount();

        return PageResult.Create(questionList, currentPage, totalSize/PageResult.pageSize+1);

    }

    @Override
    public PageResult<Question> isCreamCourseQuetion(Long courseId, Integer currentPage) {
        List<Question> questionList = questionMapper.isCreamQuetionbyCourseId( courseId,(currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer totalSize=questionMapper.isCreamQuetionCountbyCourseId(courseId);

        return PageResult.Create(questionList, currentPage, totalSize/PageResult.pageSize+1);

    }

    @Override
    public PageResult<Question> newQuetionAll(Integer currentPage) {
        List<Question> questionList = questionMapper.newQuetionAll( (currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer totalSize=questionMapper.newQuetionAllCount();

        return PageResult.Create(questionList, currentPage, totalSize/PageResult.pageSize+1);
    }


}
