package com.lx.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;

@Controller
public class indexController {

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id, @PathVariable Spring name){
       /* int i = 9/0;*/
    /*    String blog = null;
        if(blog == null){
            throw new NotFoundException("找不到路径");
        }*/
        System.out.println("---index---");
        return "index";
    }
}
