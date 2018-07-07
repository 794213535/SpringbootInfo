package com.cskaoyan.project.controller;


import com.cskaoyan.project.service.RedisUtils;
import com.cskaoyan.project.bean.Comment;
import com.cskaoyan.project.bean.News;
import com.cskaoyan.project.bean.User;
import com.cskaoyan.project.bean.oResult;
import com.cskaoyan.project.service.Impl.AliUploadService;
import com.cskaoyan.project.service.NewsService;
import com.cskaoyan.project.service.UserService;
import com.cskaoyan.project.vo.commentvo;
import com.cskaoyan.project.vo.vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    AliUploadService aliUploadService;
    @Autowired
    UserService userService;
    RedisUtils  redisUtils=new RedisUtils();

    @RequestMapping("uploadImage/")
    @ResponseBody
    public oResult uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model){
//        String contentType = file.getContentType();
//        String fileName = file.getOriginalFilename();
//        /*System.out.println("fileName-->" + fileName);
//        System.out.println("getContentType-->" + contentType);*/
//        String filePath = this.getClass().getResource("/static/images/upload/").getPath();
//        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
        String filepath = aliUploadService.upload(file);

        oResult oResult = new oResult();
        oResult.setCode(0);
        //String filepath = filePath + fileName;
        oResult.setMsg(filepath);

        return oResult;
    }

    @RequestMapping("/user/addNews/")
    @ResponseBody
    public Object upload(HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        News news = new News();
        String image = request.getParameter("image");
        String title = request.getParameter("title");
        String link = request.getParameter("link");
        news.setImage(image);
        news.setTitle(title);
        news.setLink(link);
        news.setUsername(user.getUsername());
        Date date = new Date();
        news.setCreateDate(date);

        int i = newsService.addNews(news);

        System.out.println(i+"fdsaf-=d-s=-=ds-f");

        oResult oResult = new oResult();

        return oResult;
    }

    @RequestMapping("/like")
    @ResponseBody
    public String like(HttpServletRequest request,Model model){
        vo vo = new vo();
        String newsId = request.getParameter("newsId");
        News news = newsService.findNewsById(newsId);
        redisUtils.set(newsId,String.valueOf(news.getLikeCount()));
        redisUtils.incr(newsId);
        String  likecount  = redisUtils.get(newsId);
        news.setLikeCount(Integer.parseInt(likecount));
        vo.setNews(news);
        vo.setLike(1);
        model.addAttribute("vo",vo);
        return "/home";
    }

//    @RequestMapping("/msg/list")
//    @ResponseBody
//    public Object list(HttpServletRequest request,Model model){
//
//    }


    @RequestMapping("/news/{id}")
    public String commence(@PathVariable("id") String id,Model model,HttpSession session){
        News news  = newsService.findNewsById(id);
        User user = (User) session.getAttribute("user");
        User toUser = userService.findNewsByUsername(news.getUsername());

        List<commentvo> commentvos = new ArrayList<>();
        List<Comment> comments = newsService.findCommentByUidAndToid(user.getId(),String.valueOf(toUser.getId()));
        System.out.println(comments+"fdsfdsafds");
        for (Comment comment1 : comments) {
            commentvo commentvo = new commentvo();
            commentvo.setComment(comment1);
            commentvo.setUser(userService.findNewsByUserId(comment1.getUid()));
            commentvos.add(commentvo);
        }

        System.out.println(news.getImage());
        model.addAttribute("news",news);
        model.addAttribute("like",news.getLikeCount());
        model.addAttribute("comments",commentvos);

        return "detail";
    }

    @RequestMapping("/addComment")
    public String addComment(HttpServletRequest request ,Model model,HttpSession session){
        String newsid = request.getParameter("newsId");
        String content = request.getParameter("content");
        News news = newsService.findNewsById(newsid);
        User toUser = userService.findNewsByUsername(news.getUsername());
        User user = (User) session.getAttribute("user");
        //System.out.println(user+"fdskfdskjfdsf-=-=-=");
        Date date = new Date();
        //System.out.println(request.getSession().getMaxInactiveInterval()+"--------------------------fdsjflkdsjf");
        Comment comment = new Comment();
        comment.setDatetime(date);
        comment.setToid(toUser.getId());
        comment.setUid(user.getId());
        comment.setTotype("1");
        comment.setText(content);
        List<commentvo> commentvos = new ArrayList<>();
        int i = newsService.addComment(comment);
        int j = newsService.addCommentCount(newsid);
        News news1  = newsService.findNewsById(newsid);
        List<Comment> comments = newsService.findCommentByUidAndToid(user.getId(), String.valueOf(toUser.getId()));
        for (Comment comment1 : comments) {
            commentvo commentvo = new commentvo();
            commentvo.setComment(comment1);
            commentvo.setUser(userService.findNewsByUserId(comment1.getUid()));
            commentvos.add(commentvo);
        }

        for (commentvo commentvo1 : commentvos){
            System.out.println(commentvo1+"fdsafds");
        }


        model.addAttribute("news",news1);
        model.addAttribute("like",news1.getLikeCount());
        model.addAttribute("comments",commentvos);
        return "detail";
    }

}
