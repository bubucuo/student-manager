package com.tbl.studentmanager.exception;

import com.tbl.studentmanager.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        // 返回通用异常的响应
        log.error("serviceException", e);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public Object handleException(ServiceException e) {
        // 返回通用异常的响应
        log.error("serviceException", e);
        int code = 500;
        if (e.getCode() != null){
            code = e.getCode();
        }
        return R.error(code, e.getMessage());
    }
}
