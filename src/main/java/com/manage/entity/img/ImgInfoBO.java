package com.manage.entity.img;

/**
 * @ClassName: ImgInfoBO
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/5/11 22:01
 */
public class ImgInfoBO
{
    private String categoryIdList;
    private Integer pageSize;
    private Integer pageNum;
    private String merchantCode;

    public String getCategoryIdList()
    {
        return categoryIdList;
    }

    public void setCategoryIdList(String categoryIdList)
    {
        this.categoryIdList = categoryIdList;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public String getMerchantCode()
    {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode)
    {
        this.merchantCode = merchantCode;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"categoryIdList\":\"")
                .append(categoryIdList).append('\"');
        sb.append(",\"pageSize\":")
                .append(pageSize);
        sb.append(",\"pageNum\":")
                .append(pageNum);
        sb.append(",\"merchantCode\":\"")
                .append(merchantCode).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
