package com.manage.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: SequenceGenerator
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 11:53
 */
@Component
public class SequenceGenerator
{
    private String manage;
    private long             min;
    private long             max;
    private long             counter;
    private SimpleDateFormat format17;

    public SequenceGenerator()
    {
        manage = "1";
        min = 10000L;
        max = 99999L;
        counter = 10000L;
        format17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    }

    // 获取序列号
    public synchronized String next()
    {
        String dateStr = format17.format(new Date());
        if (counter > max)
        {
            counter = min;
        }
        return manage+dateStr + (counter++);
    }

}
