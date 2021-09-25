package com.example.springboot04webrestfulcrud.controller;

import com.example.springboot04webrestfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, String> handleException(Exception e){
        Map<String, String> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","出错啦");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
