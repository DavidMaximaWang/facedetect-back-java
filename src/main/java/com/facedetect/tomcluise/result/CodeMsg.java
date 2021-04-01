package com.facedetect.tomcluise.result;

public class CodeMsg {

    private int code;
    private String msg;


    //generic error
    public static CodeMsg SUCCESS =  new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR =  new CodeMsg(500100, "SERVER ERROR");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "ILLEGAL REQUEST");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问太频繁！");

    //login 模块
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg PASSWORD_NOT_IDENTICAL = new CodeMsg(500211, "password not equal");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    public static CodeMsg REGISTERED_ALREADY = new CodeMsg(500216, "You have registered, you can login");
    public static CodeMsg REGISTER_FAILED = new CodeMsg(500217, "Unknow error, register failed");

    //商品模块

    //订单模块
    public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "No this order");
    // miaosha modul
    public static CodeMsg MIAOSHA_OVER = new CodeMsg(500500, "flash sale is over");
    public static CodeMsg REPEAT_MIAOSHA = new CodeMsg(500501, "can not repeat buying");
    public static CodeMsg MIAOSHA_FAIL = new CodeMsg(500502, "秒杀失败");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CodeMsg fillArgs(Object...args) {
        int code = this.code;
        String message = String.format(this.msg,  args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }



}