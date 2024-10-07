package com.tbl.studentmanager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tbl.studentmanager.exception.ServiceException;
import com.tbl.studentmanager.mapper.ResultMapper;
import com.tbl.studentmanager.model.TblResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ResultService {

    @Autowired
    private ResultMapper resultMapper;

    public Object add(TblResult result){
        Objects.requireNonNull(result.getMarks(), "marks is required");
        Objects.requireNonNull(result.getSubjectId(), "subjectId is required");
        Objects.requireNonNull(result.getCourseId(), "courseId is required");
        if (!StringUtils.hasLength(result.getUserId())){
            throw new ServiceException("userId is required");

        }

        result.setPostingDate(new Date());
        result.setUpdationDate(new Date());
        resultMapper.insertResult(result);
        return result;
    }

    public PageInfo<TblResult> list(TblResult result) {
        Objects.requireNonNull(result.getPage(), "page is required");
        Objects.requireNonNull(result.getSize(), "size is required");
        PageHelper.startPage(result.getPage(), result.getSize());
        List<TblResult> results = resultMapper.selectAllResults(result.getUserId());
        return new PageInfo<>(results);
    }

    public Object update(TblResult result) {
        Objects.requireNonNull(result.getId(), "id is required");
        resultMapper.updateResult(result);
        return result;
    }
}
