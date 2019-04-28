package com.manage.ctrl;

import com.manage.entity.Ret;
import com.manage.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestCtrl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 12:21
 */
@RestController
@RequestMapping("/testCtrl")
public class TestCtrl
{
    @Autowired
    private SequenceGenerator sequenceGenerator;

    @RequestMapping(value = "/getSeq",method = RequestMethod.GET)
    public Ret<String> getSeq(){
        Ret<String> ret = Ret.getRetT();
        ret.setData(sequenceGenerator.next());
        return ret;
    }

}
