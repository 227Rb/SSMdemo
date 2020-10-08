package cn.yygcloud.ssmdemo.controller;

import cn.yygcloud.ssmdemo.services.HelloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/*
*@Author : Nan
*@Description :
*@Date : 18:00 2020/9/25
*@Param :
*@return :
*@Desc :
*/
@Controller
@RequestMapping("demo")
public class HelloConrtollet {

    @Autowired
    private HelloServices helloServices;

    @GetMapping("hello/{id}")
    public String Hello(@PathVariable("id") Integer id, Model m){
        m.addAttribute("name", helloServices.find(id));
        return "success";
    }




}
