package com.manage.service.impl.merchant;

import com.manage.config.Const;
import com.manage.dao.merchant.MerchantMapper;
import com.manage.entity.Ret;
import com.manage.entity.merchant.MerchantModel;
import com.manage.service.iface.merchant.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MerchantServiceImpl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/26 23:44
 */
@Service
public class MerchantServiceImpl implements MerchantService
{
    @Autowired
    private MerchantMapper merchantMapper;
    @Override
    public Ret registerMerchant(MerchantModel merchant)
    {
        int i = merchantMapper.saveMerchant(merchant);
        if (i<=0){
            return Ret.getRet(Const.failedEnum.SAVE_MERCHANT_FAILED.getCode(),Const.failedEnum.SAVE_MERCHANT_FAILED.getMsg());
        }else{
            return Ret.getRet(Const.SUCCEED);
        }
    }

    @Override
    public Ret updateMerchant(MerchantModel merchant)
    {
        int i = merchantMapper.updateMerchant(merchant);
        if (i<=0){
            return Ret.getRet(Const.failedEnum.UPDATE_MERCHANT_FAILED.getCode(),Const.failedEnum.UPDATE_MERCHANT_FAILED.getMsg());
        }else{
            return Ret.getRet(Const.SUCCEED);
        }

    }

}
