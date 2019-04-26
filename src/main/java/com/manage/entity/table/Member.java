package com.manage.entity.table;

import java.util.Date;

public class Member
{
	// 会员编码
	private String memberCode;
	// 商户编码
	private String merchantCode;
	// 会员名称
	private String memberName;
	// 会员密码
	private String memberPasswd;
	// 头像地址
	private String headImg;
	// 状态 0 停用 1 启用
	private Integer state;
	// 手机号
	private String phone;
	// 微信唯一标识
	private String openId;
	// 创建时间
	private Date createTime;
	// 修改时间
	private Date updateTime;


	public String getMemberCode()
	{
		return memberCode;
	}

	public void setMemberCode(String memberCode)
	{
		this.memberCode = memberCode;
	}


	public String getMerchantCode()
	{
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode)
	{
		this.merchantCode = merchantCode;
	}


	public String getMemberName()
	{
		return memberName;
	}

	public void setMemberName(String memberName)
	{
		this.memberName = memberName;
	}


	public String getMemberPasswd()
	{
		return memberPasswd;
	}

	public void setMemberPasswd(String memberPasswd)
	{
		this.memberPasswd = memberPasswd;
	}


	public String getHeadImg()
	{
		return headImg;
	}

	public void setHeadImg(String headImg)
	{
		this.headImg = headImg;
	}


	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}


	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}


	public String getOpenId()
	{
		return openId;
	}

	public void setOpenId(String openId)
	{
		this.openId = openId;
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
