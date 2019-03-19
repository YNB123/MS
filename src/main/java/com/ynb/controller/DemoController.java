package com.ynb.controller;

import com.ynb.domain.User;
import com.ynb.result.CodeMsg;
import com.ynb.result.Result;
import com.ynb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ynb
 * @create 2019-3-19 14:25
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return  "hello  ynb!";
    }
    //1.rest api json输出  2.页面

    @RequestMapping("/helloSuccess")
    @ResponseBody
    public Result<String> helloSuccess() {
        return Result.success("操作成功");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name","hxq");
        return "thymeleaf";
    }

    @RequestMapping("/db/get")
    public String getUser(Model model) {
        User user= userService.getById(1);
        model.addAttribute("name",user.getName());
        return "thymeleaf";
    }

}


