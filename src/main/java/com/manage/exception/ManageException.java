package com.manage.exception;

import com.manage.config.Const;

/**
 * @ClassName: ManageException
 * @Description: 异常处理类
 * @author: cl-Z
 * @date: 2019/5/7 10:45
 * @Version: V1.0
 */
public class ManageException extends RuntimeException{
    private String code;

    public ManageException(Const.failedEnum failedEnum) {
        super(failedEnum.getMsg());
        this.code=failedEnum.getCode();
    }

    public ManageException(String code,String message) {
        super(message);
        this.code=code;
    }

}
