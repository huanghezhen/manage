package com.manage.entity.table;

import java.util.Date;

public class Merchant
{
	// 商户编码
	private String merchantCode;
	// 商户名称
	private String merchantName;
	// 0 停用 1 启用
	private Integer state;
	// 邮箱
	private String email;
	// 手机号
	private String phone;
	// 商户密钥
	private String secretKey;
	// 到期时间
	private Date expireTime;
	// 创建时间
	private Date createTime;
	// 修改时间
	private Date updateTime;


	public String getMerchantCode()
	{
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode)
	{
		this.merchantCode = merchantCode;
	}


	public String getMerchantName()
	{
		return merchantName;
	}

	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}


	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}


	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}


	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}


	public String getSecretKey()
	{
		return secretKey;
	}

	public void setSecretKey(String secretKey)
	{
		this.secretKey = secretKey;
	}


	public Date getExpireTime()
	{
		return expireTime;
	}

	public void setExpireTime(Date expireTime)
	{
		this.expireTime = expireTime;
	}


	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}


	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

}
