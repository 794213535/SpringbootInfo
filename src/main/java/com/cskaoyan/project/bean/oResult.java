package com.cskaoyan.project.bean;

public class oResult {
    String msgname;
    String msgpwd;
    Integer code;
    String msg;

    @Override
    public String toString() {
        return "oResult{" +
                "msgname='" + msgname + '\'' +
                ", msgpwd='" + msgpwd + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public oResult(String msgname, String msgpwd, Integer code, String msg) {

        this.msgname = msgname;
        this.msgpwd = msgpwd;
        this.code = code;
        this.msg = msg;
    }

    public String getMsgname() {
        return msgname;
    }

    public void setMsgname(String msgname) {
        this.msgname = msgname;
    }

    public String getMsgpwd() {
        return msgpwd;
    }

    public void setMsgpwd(String msgpwd) {
        this.msgpwd = msgpwd;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public oResult() {

    }


}
