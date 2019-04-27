package com.manage.ctrl;

import com.manage.entity.Ret;
import com.manage.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/getSeq")
    public Ret getSeq(){
        return Ret.getRet(sequenceGenerator.next());
    }

}
