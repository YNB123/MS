package com.ynb.controller;

import com.ynb.result.CodeMsg;
import com.ynb.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ynb
 * @create 2019-3-19 14:25
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

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


}


