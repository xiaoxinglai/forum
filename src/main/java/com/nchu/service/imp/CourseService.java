package com.nchu.service.imp;

import com.nchu.domain.DO.Course;
import com.nchu.domain.DO.Question;
import com.nchu.domain.VO.PageResult;
import com.nchu.mapper.CourseMapper;
import com.nchu.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user12 on 2018/3/19.
 */
@Service
public class CourseService implements ICourseService{

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public PageResult<Course> selectQuestionByCourseIdAndLevel(Integer currentPage) {
        List<Course> courses = courseMapper.selectQuestionList((currentPage - 1) * PageResult.pageSize, PageResult.pageSize);
        Integer totalSize=courseMapper.selectCountQuestion();

        return PageResult.Create(courses, currentPage, totalSize/PageResult.pageSize+1);

    }
}
