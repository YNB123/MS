package com.ynb.controller;

import com.ynb.domain.User;
import com.ynb.redis.RedisService;
import com.ynb.redis.UserKey;
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
    @Autowired
    RedisService redisService;

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
    @ResponseBody
    public String getUser(Model model) {
        User user= userService.getById(1);
        model.addAttribute("name",user.getName());
        return "thymeleaf";
    }

//    @RequestMapping("/redis/get")
//    @ResponseBody
//    public Result<String> redisGet(Model model) {
//        //Long v1 =redisService.get("key1",Long.class);
//        redisService.set("123""UUU","222");
//        String v2 =redisService.get("UUU",String.class);
//        return Result.success(v2);
//    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(Model model) {
        User user = new User();
        user.setId(2);
        user.setName("李密");
        user.setSex("男");
        redisService.set(UserKey.getById,""+2,user);
        return Result.success(true);
    }


}


