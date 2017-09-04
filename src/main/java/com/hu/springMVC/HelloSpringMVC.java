package com.hu.springMVC;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class HelloSpringMVC {
    @RequestMapping("/hello")
    //传参方式:同名匹配,
    //传值方式:ModelAndView设置响应视图,传递值
    public ModelAndView handleRequest(String username, String password) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.jsp");
        mv.addObject("username", username);
        mv.addObject("password", password);
        return mv;
    }

    @RequestMapping("/hello2")
    //传参方式:模型传参
    //传值方式:ModelAndView 返回对象
    public ModelAndView handleRequest(User user) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.jsp");
//        mv.addObject("username",user.getUsername());
//        mv.addObject("password",user.getPassword());
        mv.addObject(user);
        return mv;
    }

    @RequestMapping("/delete/{id}")
    //地址栏传参
    public ModelAndView handleRequest(@PathVariable("id") Long id) throws Exception {
        System.out.println(id);
        return null;
    }

    @RequestMapping("/fileupload")
    public String upload(MultipartFile file) {
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream("c:/a.txt");
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
