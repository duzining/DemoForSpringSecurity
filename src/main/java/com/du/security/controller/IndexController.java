package com.du.security.controller;


import com.du.security.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始页面
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){

        Map<String,Object> result = new HashMap<>();
        result.put("title","这里是首页不需要权限和登录拦截");
        return ResultUtil.resultSuccess(result);
    }
}
