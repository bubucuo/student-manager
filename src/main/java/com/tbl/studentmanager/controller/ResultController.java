package com.tbl.studentmanager.controller;

import com.github.pagehelper.PageInfo;
import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.model.TblResult;
import com.tbl.studentmanager.service.ResultService;
import com.tbl.studentmanager.utils.SysUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/add")
    public Object add(@RequestBody TblResult result){
        return R.OK(resultService.add(result));
    }

    @PostMapping("/list")
    public Object list(@RequestBody TblResult result){
        return R.OK(resultService.list(result));
    }

    @PostMapping("/update")
    public Object update(@RequestBody TblResult result){
        SysUtils.checkAdmin();
        return R.OK(resultService.update(result));
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download(@RequestBody TblResult result){
        PageInfo<TblResult> page = resultService.list(result);
        page.getList();

        ByteArrayInputStream bis = new ByteArrayInputStream("csvContent".getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=courses.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new InputStreamResource(bis));
    }
}
