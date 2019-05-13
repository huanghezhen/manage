package com.manage.ctrl.merchant;

import com.manage.entity.Ret;
import com.manage.entity.merchant.MerchantModel;
import com.manage.service.iface.merchant.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    private MerchantService merchantService;

    /**
     * 注册商户
     * @param merchant
     * @return
     */
    @RequestMapping(value = "/registerMerchant",method = RequestMethod.GET)
    public Ret registerMerchant(@RequestBody MerchantModel merchant)
    {
        Ret ret = merchantService.registerMerchant(merchant);
        return ret;
    }

    @RequestMapping(value = "/updateMerchant",method = RequestMethod.GET)
    public Ret updateMerchant(@RequestBody MerchantModel merchant)
    {
        Ret ret = merchantService.updateMerchant(merchant);
        return ret;
    }
}
