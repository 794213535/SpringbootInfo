package com.cskaoyan.project.controller;

import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;
import com.cskaoyan.project.bean.oResult;
import com.cskaoyan.project.service.NewsService;
import com.cskaoyan.project.service.UserService;
import com.cskaoyan.project.vo.vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    NewsService newsService;


    @RequestMapping({"/","index"})
    public String home(Model model, HttpSession session,Integer pop){


        //首先判断用户是否登陆
        Object user = session.getAttribute("user");
        if(user!=null){
           //登陆以后，不再有弹窗显示
            pop=0;
            model.addAttribute("user",user);
         }else {
            pop=1;
        }
        model.addAttribute("pop",pop);
        //news 控制器


        List<vo> vos = new ArrayList<>();
        List<News> allNews = newsService.findAllNews();
        for (News News: allNews) {
            //根据news查出此消息发出的人
            User user1 =  newsService.findUserByUsernamefromNews(News.getUsername());
            System.out.println();
            vo vo = new vo();
            vo.setNews(News);
            vo.setUser(user1);
            vos.add(vo);
        }
//        Object user = session.getAttribute("user");
//        if (user!=null){
//            vo.setUser((User) user);
//        }


        model.addAttribute("user",user);

        model.addAttribute("vos",vos);
        return "home";
    }

    @RequestMapping("/reg")
    @ResponseBody
    public oResult tologin(Model model, HttpServletRequest request, User user){
        //判断用户名是否被占用
        boolean isvalidity = userService.isvalidity(user.getUsername());
        System.out.println(isvalidity);
        oResult oResult = new oResult();
        if (isvalidity){
            oResult.setMsgname("对不起，该用户名已经被人使用");
        }else {
            boolean register = userService.register(user);
            oResult.setCode(0);
        }
        model.addAttribute("oResult",oResult);
        return oResult;
    }

    @RequestMapping("/login")
    @ResponseBody
    @Transactional
    public oResult login(Model model,HttpServletRequest request,User user,HttpSession session){
        String rember = request.getParameter("rember");

        //验证是否user是否合法
        boolean login = userService.login(user);
        User newsByUsername = userService.findNewsByUsername(user.getUsername());
        oResult oResult = new oResult();
        if (login){
            oResult.setCode(0);
            session.setAttribute("user",newsByUsername);
            if(rember.equals("1")){
                session.setAttribute("user",newsByUsername);
            }
        }else {
            oResult.setMsgpwd("对不起，您输入的账号和密码不正确");
        }


        return oResult;
    }


}
