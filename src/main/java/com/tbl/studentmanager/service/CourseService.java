package com.tbl.studentmanager.service;

import com.tbl.studentmanager.mapper.CourseMapper;
import com.tbl.studentmanager.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll() {
        return courseMapper.selectAllCourses();
    }
}
