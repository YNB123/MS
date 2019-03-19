package com.ynb.result;

/**
 * @Author ynb
 * @create 2019-3-19 15:29
 */
public class CodeMsg {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }
    //通用异常
    public static CodeMsg SUCCESS =new CodeMsg(0,"success");
    //服务器内部异常
    public static CodeMsg SERVER_ERROR =new CodeMsg(5000,"服务端异常");

    //5001 XXX
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }


}
