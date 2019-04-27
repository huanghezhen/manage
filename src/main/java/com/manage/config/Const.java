package com.manage.config;

/**
 * @ClassName: Const
 * @Description: 常量类
 * @author: huanghz
 * @date: 2019/4/27 0:06
 */
public class Const
{
    // 成功
    public static final String SUCCEED = "0";

    public enum failedEnum{
        SAVE_MERCHANT_FAILED("-1", "注册商户失败"),
        UPDATE_MERCHANT_FAILED("-2", "修改商户失败")
        ;

        // 错误码
        private String code;
        // 消息
        private String msg;

        failedEnum(String code, String msg)
        {
            this.code = code;
            this.msg = msg;
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
    }
}
