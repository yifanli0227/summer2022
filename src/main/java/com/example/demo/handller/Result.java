package com.example.demo.handller;

public class Result {
    //code =0 success，code =1 fail
    private int code;
    
    private int error;
    private String msg;
    private Object ajax; //ajax body

    public Object getAjax(){
        return ajax;
    }

    public void setAjax(Object ajax){
        this.ajax = ajax;
    }

    public int getCode() {
        return code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
    public int getError() {
        return error;
    }
 
    public void setError(int error) {
        this.error = error;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

