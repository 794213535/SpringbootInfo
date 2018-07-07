package com.cskaoyan.project.service.Impl;

import com.cskaoyan.project.bean.Letter;
import com.cskaoyan.project.mapper.MsgDao;
import com.cskaoyan.project.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    MsgDao msgDao;

    @Override
    public int sendmsg(Letter letter) {
        return msgDao.sendmsg(letter);
    }

    @Override
    public List<Letter> findmsgByUserid(int id) {
        return msgDao.findmsgByUserid(id);
    }
}
