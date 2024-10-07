package com.tbl.studentmanager.controller;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.pagehelper.PageInfo;
import com.tbl.studentmanager.model.Fee;
import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/fee")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping("/list")
    public Object list(@RequestBody Fee fee){
        return R.OK(feeService.list(fee));
    }

    @PostMapping("/fee/add")
    public Object addFee(@RequestBody Fee fee){
        fee.setFeesStatus(0);
        fee.setScolarshipStatus(0);
        return R.OK(feeService.add(fee));
    }

    @PostMapping("/fee/pay")
    public Object pay(@RequestBody Fee fee){
        fee.setFeesStatus(1);
        feeService.update(fee);
        return R.OK();
    }

    @PostMapping("/scolarship/add")
    public Object addScolarship(@RequestBody Fee fee){
        fee.setFeesStatus(0);
        fee.setScolarshipStatus(1);
        return R.OK(feeService.add(fee));
    }

    @GetMapping("/download")
    public void download(Fee fee, HttpServletResponse response) throws IOException {
        PageInfo<Fee> pageInfo = feeService.list(fee);
        // 创建 CsvMapper 实例
        CsvMapper mapper = new CsvMapper();

        // 创建 CsvSchema 实例，定义列的顺序和标题
        CsvSchema schema = CsvSchema.builder()
                .addColumn("userId")
                .addColumn("fee")
                .addColumn("feesStatus")
                .addColumn("scolarshipStatus")
                .build()
                .withHeader(); // 包含头部信息

        // 创建一些示例数据
        List<Map<String, Object>> data = new ArrayList<>();
        for (Fee f : pageInfo.getList()) {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", f.getUserId());
            map.put("fee", f.getFee());
            map.put("feesStatus", f.getFeesStatus());
            map.put("scolarshipStatus", f.getScolarshipStatus());
            data.add(map);
        }
        // 将对象列表转换为 CSV 格式的字符串并写入文件
        response.setContentType("text/csv;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=courses.csv");
        mapper.writer(schema).writeValue(response.getOutputStream(), data);
    }
}
