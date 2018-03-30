package com.nchu.aspect;

import com.nchu.domain.DO.Question;
import com.nchu.domain.DO.User;
import com.nchu.mapper.QuestionMapper;
import org.apache.catalina.session.StandardSession;
import org.apache.catalina.session.StandardSessionFacade;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author laixiaoxing
 * Created by user12 on 2017/12/13.
 */
@Aspect
@Component
public class HttpAspect {

    @Autowired
    private QuestionMapper questionMapper;

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.nchu.service.imp.QuestionService.selectByPrimaryKey(Long))&& args(questionId)")
    public void log(Long questionId) {

    }

    @Before("log(questionId)")
    public void doBefore(Long questionId){

        logger.info("监听到进入问题页面，问题序号为"+questionId);


    }

    @AfterReturning(returning = "question",pointcut = "log(questionId)")
    public void doAfter(Long questionId,Question question){


        logger.info("返回问题的访问人数{}，问题的序号{}",question.getVisitNum(),questionId);
        Question newQuestion=new Question();
        newQuestion.setQuestionId(questionId);
        newQuestion.setVisitNum(question.getVisitNum()+1);
        questionMapper.updateVisit(newQuestion);


    }


//
//    public Boolean valid(){
//
//    }






}
