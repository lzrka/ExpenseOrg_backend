package com.expenseOrg.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorController implements ErrorController {


    @RequestMapping("/error")
    @ResponseBody
    String error(HttpServletRequest request) {
        return "<h1>Error occurred</h1>" + request.getAttribute("javax.servlet.error.status_code");
    }


    public String getErrorPath() {
        return "/error";
    }
}