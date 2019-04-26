package com.manage.dao.merchant;

import com.manage.entity.table.Merchant;

/**
 * @ClassName: MerchantMapper
 * @Description: 商户
 * @author: huanghz
 * @date: 2019/4/26 23:44
 */
public interface MerchantMapper
{
    int saveMerchant(Merchant merchant);

    int updateMerchant(Merchant merchant);
}
