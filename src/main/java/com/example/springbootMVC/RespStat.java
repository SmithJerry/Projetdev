package com.example.springbootMVC;

/**
 * @author Liang
 * @date 2020/11/24 - 21:16
 */
public class RespStat {
    /**
     * 状态码
     * 用200 表示成功
     * 400/500 出错
     *
     * msg = 信息
     *
     */
    private int code;
    private String msg;
    private String data;

    public RespStat(){
        super();
    }
    public RespStat(int code, String msg, String data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RespStat build(int i) {
        return new RespStat(200, "ok", "wu");
    }

    public static RespStat build(int i, String msg) {
        return new RespStat(i, msg, "meiyou");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
