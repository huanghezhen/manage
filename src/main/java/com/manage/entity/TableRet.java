package com.manage.entity;

import com.manage.config.Const;

/**
 * @ClassName: TableRet 表格的返回数据模型
 * @Description: TODO
 * @author: cl-Z
 * @date: 2019/5/20 0020 10:09
 * @Version: V1.0
 */
public class TableRet<T> {

    // 数据
    private T data;
    // 响应码
    private String code;
    // 消息
    private String msg;

    private Integer count;

    public static TableRet getTableRet(){
        return new TableRet(Const.SUCCEED,Const.SUCCEED_MSG);
    }
    public static TableRet getTableRet(String code,String msg,Integer count){
        return new TableRet(code,msg,count);
    }
    public static<T> TableRet<T> getTableRetT(T data,Integer count){
        return new TableRet<>(data,Const.SUCCEED,Const.SUCCEED_MSG,count);
    }

    public TableRet()
    {
    }

    public TableRet(String code)
    {
        this.code = code;
    }

    public TableRet(String code, String msg,Integer count)
    {
        this.code = code;
        this.msg = msg;
        this.count=count;
    }

    public TableRet(T data)
    {
        this.data = data;
    }

    public TableRet(T data, String code)
    {
        this.data = data;
        this.code = code;
    }

    public TableRet(T data, String code, String msg,Integer count)
    {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.count=count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
