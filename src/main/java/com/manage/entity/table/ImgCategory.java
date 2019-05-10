package com.manage.entity.table;

import java.util.Date;

public class ImgCategory
{
	// 类别编码
	private Integer id;
	// 父类编码
	private Integer parentId;
	// 名称
	private String label;
	// 创建时间
	private Date createTime;
	// 商户编码
	private String merchantCode;

	public String getMerchantCode()
	{
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode)
	{
		this.merchantCode = merchantCode;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"id\":")
				.append(id);
		sb.append(",\"parentId\":")
				.append(parentId);
		sb.append(",\"label\":\"")
				.append(label).append('\"');
		sb.append(",\"createTime\":\"")
				.append(createTime).append('\"');
		sb.append(",\"merchantCode\":\"")
				.append(merchantCode).append('\"');
		sb.append('}');
		return sb.toString();
	}
}
