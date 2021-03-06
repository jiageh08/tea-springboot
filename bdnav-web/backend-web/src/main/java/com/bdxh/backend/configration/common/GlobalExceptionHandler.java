package com.bdxh.backend.configration.common;

import com.alibaba.fastjson.JSON;
import com.bdxh.common.utils.wrapper.WrapMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @description: 全局异常处理器
 * @author: Kang
 * @create: 2019-01-10 12:16
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public void handleException(ConstraintViolationException e, HttpServletResponse response){
        String errors = e.getConstraintViolations().stream().map(u -> u.getMessage()).collect(Collectors.joining(","));
        log.error(errors);
        String jsonStr= JSON.toJSONString(WrapMapper.error(errors));
        try {
            response.getOutputStream().write(jsonStr.getBytes("utf-8"));
        }catch (Exception ex){
            e.printStackTrace();
            log.error(ex.getMessage());
        }
    }

    /**
     * 没有权限错误拦截（mlgj，MyAccessDeniedHandler捕获不到该错误，不生效不知道为毛）
     * @param e
     * @param response
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public void handleException(AccessDeniedException e, HttpServletResponse response){
        String errors = "没有相关权限";
        log.error(errors);
        String jsonStr= JSON.toJSONString(WrapMapper.error(errors));
        try {
            response.getOutputStream().write(jsonStr.getBytes("utf-8"));
        }catch (Exception ex){
            e.printStackTrace();
            log.error(ex.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public void handleException(Exception e, HttpServletResponse response){
        log.error(e.getMessage());
        String jsonStr= JSON.toJSONString(WrapMapper.error(e.getMessage()));
        try {
            response.getOutputStream().write(jsonStr.getBytes("utf-8"));
        }catch (Exception ex){
            e.printStackTrace();
            log.error(ex.getMessage());
        }
    }

}
