package com.cskaoyan.project.service;

import com.cskaoyan.project.bean.Letter;

import java.util.Date;
import java.util.List;

public interface MsgService {

    int sendmsg(Letter letter);

    List<Letter> findmsgByUserid(int id);
}
