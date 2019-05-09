package com.manage.entity.table;

import java.util.Date;

public class ImgCategory
{
	// 类别编码
	private Integer id;
	// 父类编码
	private Integer parentId;
	// 名称
	private String name;
	// 创建时间
	private Date createTime;


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


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
