package com.example.springmain.service;

import com.example.springmain.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommonService {

    @Value("${login.path:http://localhost:9092//springboot/login/hello/getLoginSystemMap}")
    public String LoginPath;


    public String getLoginMap() throws IOException {
        return HttpClientUtils.getInstance().postForm(LoginPath);
    }







}
