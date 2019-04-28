package com.manage.entity.user;

import io.swagger.annotations.ApiModel;

/**
 * @ClassName: userLoginModel
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 13:41
 */

@ApiModel
public class UserLoginModel
{
    // 用户编码
    private String userCode;
    // 用户密码
    private String userPasswd;
    // 验证码
    private String code;


    public String getUserPasswd()
    {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd)
    {
        this.userPasswd = userPasswd;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUserCode()
    {
        return userCode;
    }

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userCode\":\"")
                .append(userCode).append('\"');
        sb.append(",\"userPasswd\":\"")
                .append(userPasswd).append('\"');
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
