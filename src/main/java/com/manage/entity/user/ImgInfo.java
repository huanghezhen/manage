package com.manage.entity.user;

import java.util.Date;

public class ImgInfo
{
	// 主键
	private Integer imgCode;
	// 所属分类
	private Integer categoryId;
	// 图片地址
	private String imgUrl;
	// 商户编码
	private String merchantCode;
	// 用户编码
	private String userCode;
	// 添加时间
	private Date createTime;


	public Integer getImgCode()
	{
		return imgCode;
	}

	public void setImgCode(Integer imgCode)
	{
		this.imgCode = imgCode;
	}


	public Integer getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(Integer categoryId)
	{
		this.categoryId = categoryId;
	}


	public String getImgUrl()
	{
		return imgUrl;
	}

	public void setImgUrl(String imgUrl)
	{
		this.imgUrl = imgUrl;
	}


	public String getMerchantCode()
	{
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode)
	{
		this.merchantCode = merchantCode;
	}


	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}


	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

}
