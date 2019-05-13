package com.springboot.sample.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.sample.entity.R;
import com.springboot.sample.exception.AuthException;

/**
 * Created by fanyuli on 2018/5/14.
 */
@ControllerAdvice
public class AuthAdvice {
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public R handleAuthException(final AuthException ex) {
        R rt = new R();
        rt.setRetCode("-1");
        rt.setRetMsg(ex.getMessage());
        return rt;
    }
}
