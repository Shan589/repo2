package com.hhit.springmvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

@Component
public class HelloView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    /*
    渲染视图
    * */
    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("hello view ,time:" + new Date());
    }
}
