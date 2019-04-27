package com.manage.entity.table;

import java.util.Date;

public class User
{
	// 用户编码
	private String userCode;
	// 商户编码
	private String merchantCode;
	// 用户名称
	private String userName;
	// 用户密码
	private String userPasswd;
	// 0 停用 1 启用
	private Integer state;
	// 创建时间
	private Date createTime;
	// 修改时间
	private Date updateTime;


	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}


	public String getMerchantCode()
	{
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode)
	{
		this.merchantCode = merchantCode;
	}


	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	public String getUserPasswd()
	{
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd)
	{
		this.userPasswd = userPasswd;
	}


	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
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

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"userCode\":\"")
				.append(userCode).append('\"');
		sb.append(",\"merchantCode\":\"")
				.append(merchantCode).append('\"');
		sb.append(",\"userName\":\"")
				.append(userName).append('\"');
		sb.append(",\"userPasswd\":\"")
				.append(userPasswd).append('\"');
		sb.append(",\"state\":")
				.append(state);
		sb.append(",\"createTime\":\"")
				.append(createTime).append('\"');
		sb.append(",\"updateTime\":\"")
				.append(updateTime).append('\"');
		sb.append('}');
		return sb.toString();
	}
}
