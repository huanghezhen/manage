package com.manage.vo;

import java.util.List;

/**
 * @ClassName: TreeVO
 * @Description: layui eletree 的模型类
 * @author: cl-Z
 * @date: 2019/5/10 15:58
 * @Version: V1.0
 */
public class TreeVO {
    private Integer id;
    private String label;
    private Integer parentId;
    private boolean spread;
    private String href;
    private List<TreeVO> children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isSpread() {
        return spread;
    }


    public boolean getSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<TreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeVO> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
