package com.manage.service.iface.merchant;

import com.manage.entity.Ret;
import com.manage.entity.merchant.MerchantModel;

/**
 * @ClassName: MerchantService
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/26 23:43
 */
public interface MerchantService
{
    Ret registerMerchant(MerchantModel merchant);

    Ret updateMerchant(MerchantModel merchant);
}
