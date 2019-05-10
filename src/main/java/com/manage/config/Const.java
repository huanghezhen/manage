package com.manage.config;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Const
 * @Description: 常量类
 * @author: huanghz
 * @date: 2019/4/27 0:06
 */
public class Const
{
    public static List<String> CAN_NOT_LOGIN_LIST = new LinkedList<>();
    // 成功
    public static final String SUCCEED = "0";
    public static final String SUCCEED_MSG = "成功";
    public static final String SESSION_USER = "SESSION_USER";
    public static final String SESSION_CODE = "SESSION_CODE";
    public static final Integer PRODUCT_UP_STATUS=1;
    public static final Integer PRODUCT_DOWN_STATUS=0;

    public enum failedEnum{
        SAVE_MERCHANT_FAILED("-1", "注册商户失败"),
        UPDATE_MERCHANT_FAILED("-2", "修改商户失败"),
        SESSION_CODE_FAILED("-3", "验证码错误"),
        UNUSER("-4", "用户不存在"),
        UNPASSWD("-5", "密码错误"),
        UNLOGIN("-6", "用户未登陆"),
        PRODUCT_SAVE_ERROR("-7","商品增加失败"),
        PRODUCT_NOT_EXIT("-8","商品不存在"),
        PRODUCT_CATEGORY_NOT_EXIT("-9","此商品分类不存在"),
        PRODUCT_CATEGORY_SON_NOT_EXIT("-10","此商品分类不存在"),
        SAVE_ERROR("-11","新增失败"),
        UPDATE_ERROR("-12","修改失败"),
        ADD_IMG_CATEGORY_ERROR("-13","新增分类失败"),
        ALL_CATEGORY_ERROR("-14","全部分类不能添加同级分类"),
        EDIT_IMG_CATEGORY_ERROR("-15","修改分类失败"),
        DELETE_IMG_CATEGORY_ERROR("-15","修改分类失败")
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
