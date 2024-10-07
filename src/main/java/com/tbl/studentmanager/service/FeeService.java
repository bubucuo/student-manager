package com.tbl.studentmanager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tbl.studentmanager.mapper.FeeMapper;
import com.tbl.studentmanager.model.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FeeService {

    @Autowired
    private FeeMapper feeMapper;

    public PageInfo<Fee> list(Fee fee) {
        Objects.requireNonNull(fee.getPage(), "page is required");
        Objects.requireNonNull(fee.getSize(), "size is required");
        PageHelper.startPage(fee.getPage(), fee.getSize());
        List<Fee> results = feeMapper.selectAllFees(fee);
        return new PageInfo<>(results);
    }

    public Object add(Fee fee) {
        feeMapper.insertFee(fee);
        return fee;
    }

    public void update(Fee fee) {
        feeMapper.updateFeeStatus(fee);
    }
}
