package com.example.springmain.controller;

import com.example.springloggin.common.LoginInfoCache;
import com.example.springmain.service.CommonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class CommonTroller {

    @Resource
    public CommonService commonService;


    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    public String getListData() {
        String loginMap=null;
        try {
            loginMap = commonService.getLoginMap();
        }catch (Exception e){
            e.printStackTrace();
        }
        return loginMap;
    }


    /**
     * 子系统停止时去除已注册的子系统
     */
    @RequestMapping(value = "cancelRegister", method = RequestMethod.GET)
    @ResponseBody
    public boolean cancelRegister(HttpServletRequest request) {
        String product = request.getHeader("product");
        LoginInfoCache.getLoginInfoCache().removeSubSystemMap(product);
        return true;
    }
}
