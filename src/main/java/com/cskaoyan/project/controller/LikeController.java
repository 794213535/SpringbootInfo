package com.cskaoyan.project.controller;

import com.cskaoyan.project.bean.User;
import com.cskaoyan.project.service.NewsService;
import com.cskaoyan.project.service.RedisService;
import com.cskaoyan.project.vo.vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LikeController {
  @Autowired
    RedisService redisService;
  @Autowired
    NewsService newsService;

/*    @RequestMapping("like")
    @ResponseBody
    public String like(@RequestParam("newsId") int newid, HttpSession session ,Model model){
        //点赞like为1，点踩dislike为-1
        int like = 1;
        int dislike = -1;
        User user = (User) session.getAttribute("user");
        //更新点赞数
        long likeCount = redisService.like(user.getId(), 1, newid);

        newsService.updateLikeCount(newid,(int)likeCount);
        vo vo = new vo();
        vo.setLike((int)likeCount);
        model.addAttribute("vo",vo);

        return "home";

    }*/

}
