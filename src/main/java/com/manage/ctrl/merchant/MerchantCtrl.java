package com.manage.ctrl.merchant;

import com.manage.entity.Ret;
import com.manage.entity.table.Merchant;
import com.manage.service.iface.merchant.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MerchantCtrl
 * @Description: 商户
 * @author: huanghz
 * @date: 2019/4/26 23:41
 */
@RestController
@RequestMapping("/merchantCtrl")
public class MerchantCtrl
{
    private final Logger          logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private       MerchantService merchantService;

    /**
     * 注册商户
     * @param merchant
     * @return
     */
    @RequestMapping("/registerMerchant")
    public Ret registerMerchant(@RequestBody Merchant merchant)
    {
        Ret ret = merchantService.registerMerchant(merchant);
        return ret;
    }
}
