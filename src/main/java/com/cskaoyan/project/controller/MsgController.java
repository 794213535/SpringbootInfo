package com.cskaoyan.project.controller;

import com.cskaoyan.project.bean.Conversation;
import com.cskaoyan.project.bean.Letter;
import com.cskaoyan.project.bean.User;
import com.cskaoyan.project.bean.oResult;
import com.cskaoyan.project.service.MsgService;
import com.cskaoyan.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class MsgController {
    @Autowired
    MsgService msgService;
    @Autowired
    UserService userService;



    @RequestMapping("msg/list")
    public String letter(HttpSession session,Model model) throws ParseException {
        User user = (User) session.getAttribute("user");
        List<User> users = userService.findAllUser();
        List<Conversation> conversations = new ArrayList<>();
        List<Letter> letters =  msgService.findmsgByUserid(user.getId());
        Conversation conversation = new Conversation();
        Letter letternews = letters.get(0);

        for (Letter letter : letters) {
            for(User user1: users){
                if (user1.getId()==letter.getToid()||user1.getId()==letter.getFromid()){
                    if (letter.getSendTime().compareTo(letternews.getSendTime())>=0){
                        letter=letternews;
                        conversation.setUser(user);
                        conversation.setLetter(letternews);
                    }
                }
            }
            conversations.add(conversation);
        }

        model.addAttribute("conversations" ,conversations);

        return "letter";
    }

    @RequestMapping("user/tosendmsg")
    public String tosendmsg(){

        return "sendmsg";
    }

    @RequestMapping("user/msg/addMessage")
    @ResponseBody
    public Object addMessage(HttpServletRequest request, HttpSession session){
        Letter letter = new Letter();

        String toName = request.getParameter("toName");
        String content = request.getParameter("content");
        User user = (User) session.getAttribute("user");
        User touser = userService.findNewsByUsername(toName);
        Date date = new Date();
        oResult oResult = new oResult();

        if (touser!=null){
            letter.setContent(content);
            letter.setConversationId(user.getId()+"-"+touser.getId());
            letter.setSendTime(date);
            letter.setToid(touser.getId());
            letter.setFromid(user.getId());
            letter.setUnread(0);
            int i = msgService.sendmsg(letter);


        }else {
            oResult.setCode(1);
            oResult.setMsg("对不起，没有此收件人");
        }

        return oResult;
    }
}
