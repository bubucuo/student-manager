package com.tbl.studentmanager.service;

import com.tbl.studentmanager.mapper.SubjectMapper;
import com.tbl.studentmanager.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    public List<Subject> findAll() {
        return subjectMapper.selectAllSubjects();
    }
}
