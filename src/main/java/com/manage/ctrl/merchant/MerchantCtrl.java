package com.manage.ctrl.merchant;

import com.manage.entity.Ret;
import com.manage.entity.table.Merchant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MerchantCtrl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/26 23:41
 */
@RestController
@RequestMapping("/merchantCtrl")
public class MerchantCtrl
{
    /**
     * 注册商户
     * @param merchant
     * @return
     */
    @RequestMapping("/registerMerchant")
    public Ret registerMerchant(@RequestBody Merchant merchant){
        return new Ret();
    }
}
