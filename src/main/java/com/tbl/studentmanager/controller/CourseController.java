package com.tbl.studentmanager.controller;

import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/list")
    public Object list() {
        return R.OK(courseService.findAll());
    }
}
