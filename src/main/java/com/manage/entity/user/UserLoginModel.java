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
    // 用户名称
    private String userName;
    // 用户密码
    private String userPasswd;
    // 验证码
    private String code;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

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

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"userPasswd\":\"")
                .append(userPasswd).append('\"');
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
