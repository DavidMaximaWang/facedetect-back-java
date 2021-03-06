package com.facedetect.tomcluise.result;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    public static <T> Result<List<T>> success(List<T> data){

//        List<T> t = new ArrayList<>();
//        t.add(data);
        return new Result<List<T>>(data);
    }

    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg cm) {
        if(cm == null) {
            return ;

        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();

    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }



}