package com.yetao.blog.result;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * @Author yetao
 * @Date 2020/9/3 10:32
 * @Description 返回结果封装
 */

@Data
public class ResponseResult {

    private Integer code;
    private String msg;
    private Object data;

    private ResponseResult() {
    }

    public static ResponseResult build() {
        return new ResponseResult();
    }

    public static ResponseResult success(String msg, Object data) {
        return new ResponseResult(200, msg, data);
    }

    public static ResponseResult success(String msg) {
        return new ResponseResult(200, msg, "");
    }

    public static ResponseResult failed(String msg, Object data) {
        return new ResponseResult(500, msg, data);
    }

    public static ResponseResult failed(String msg) {
        return new ResponseResult(500, msg, "");
    }

    private ResponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult validData(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();

            Set<String> errorInfoSet = new TreeSet<>();
            for (FieldError fieldError : fieldErrorList) {
                errorInfoSet.add(fieldError.getDefaultMessage());
            }
            StringBuilder sb = new StringBuilder();
            for (String errorInfo : errorInfoSet) {
                sb.append(errorInfo);
                sb.append(",");
            }
            return ResponseResult.failed(sb.substring(0, sb.length() - 1));
        }
        return ResponseResult.success("校验成功");
    }
}
