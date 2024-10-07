package com.tbl.studentmanager.controller;

import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.model.Subject;
import com.tbl.studentmanager.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/list")
    public Object list() {
        return R.OK(subjectService.findAll());
    }
}
