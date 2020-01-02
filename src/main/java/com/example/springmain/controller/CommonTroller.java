package com.example.springmain.controller;

import com.example.springloggin.common.LoginInfoCache;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class CommonTroller {

    @Resource
    private LoginInfoCache loginInfoCache;



    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    public Map<String, String> getListData() {
        Map<String, String> subSystemMap = loginInfoCache.getSubSystemMap();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println(subSystemMap.toString());
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        return subSystemMap;
    }


    /**
     * 子系统停止时去除已注册的子系统
     */
    @RequestMapping(value = "cancelRegister", method = RequestMethod.GET)
    @ResponseBody
    public boolean cancelRegister(HttpServletRequest request) {
        String product = request.getHeader("product");
        loginInfoCache.removeSubSystemMap(product);
        return true;
    }
}
