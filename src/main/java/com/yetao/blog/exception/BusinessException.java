package com.yetao.blog.exception;

/**
 * @author yetao
 * @date 2021/1/7 17:07
 * @description 自定义业务异常处理
 */

public class BusinessException extends RuntimeException {
    private Integer errorCode;

    private String errorMessage;

    private String exceptionMessage;

    private Exception exception;
}
