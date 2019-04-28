package com.manage.entity;

import com.manage.config.Const;

/**
 * @ClassName: Ret
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/23 15:03
 */
public class Ret<T>
{
    // 数据
    private T data;
    // 响应码
    private String code;
    // 消息
    private String msg;

    public static Ret getRet(){
        return new Ret(Const.SUCCEED,Const.SUCCEED_MSG);
    }
    public static Ret getRet(String code,String msg){
        return new Ret(code,msg);
    }
    public static<T> Ret<T> getRetT(T data){
        return new Ret<>(data,Const.SUCCEED,Const.SUCCEED_MSG);
    }

    public Ret()
    {
    }

    public Ret(String code)
    {
        this.code = code;
    }

    public Ret(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public Ret(T data)
    {
        this.data = data;
    }

    public Ret(T data, String code)
    {
        this.data = data;
        this.code = code;
    }

    public Ret(T data, String code, String msg)
    {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"")
                .append(code).append('\"');
        if (data != null){
            sb.append(",\"data\":")
                    .append(data);
        }
        if (msg != null){
            sb.append(",\"msg\":\"")
                    .append(msg).append('\"');
        }
        sb.append('}');
        return sb.toString();
    }
}
