package com.manage.dao.merchant;

import com.manage.entity.merchant.MerchantModel;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MerchantMapper
 * @Description: 商户
 * @author: huanghz
 * @date: 2019/4/26 23:44
 */
@Component("merchantMapper")
public interface MerchantMapper
{
    int saveMerchant(MerchantModel merchant);

    int updateMerchant(MerchantModel merchant);
}
