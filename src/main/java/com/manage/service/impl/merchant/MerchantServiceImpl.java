package com.manage.service.impl.merchant;

import com.manage.dao.merchant.MerchantMapper;
import com.manage.entity.Ret;
import com.manage.entity.table.Merchant;
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
    public Ret registerMerchant(Merchant merchant)
    {
        return null;
    }
}
