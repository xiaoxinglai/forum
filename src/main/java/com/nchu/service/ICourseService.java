package com.nchu.service;

import com.nchu.domain.DO.Course;
import com.nchu.domain.VO.PageResult;

/**
 * Created by user12 on 2018/3/19.
 */
public interface ICourseService {

    PageResult<Course> selectQuestionByCourseIdAndLevel(Integer currentPage);


}
