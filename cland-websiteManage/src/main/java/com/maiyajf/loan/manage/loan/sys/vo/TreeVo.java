package com.maiyajf.loan.manage.loan.sys.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeVo {
  private String id;
  private String text;
  private boolean leaf;
  private boolean expanded;

  public boolean isExpanded() {
    return this.expanded;
  }

  public void setExpanded(boolean expanded) {
    this.expanded = expanded;
  }

  private List<TreeVo> children = new ArrayList<TreeVo>();
  private String href;
  private String attributes;

  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

  public String getHref() {
    return this.href;

  }

  public void setHref(String href) {
    this.href = href;
  }

  // 是否父节点
  private int bisroot;
  // 父节点ID
  private String sparentid;
  private String iconCls;

  public String getIconCls() {
    return this.iconCls;
  }

  public void setIconCls(String iconCls) {
    this.iconCls = iconCls;
  }

  public int getBisroot() {
    return this.bisroot;
  }

  public void setBisroot(int bisroot) {
    this.bisroot = bisroot;
  }

  public String getSparentid() {
    return this.sparentid;
  }

  public void setSparentid(String sparentid) {
    this.sparentid = sparentid;
  }

  public List<TreeVo> getChildren() {
    return this.children;
  }

  public void setChildren(List<TreeVo> children) {
    this.children = children;
  }

  public String getId() {
    return this.id;
  }

  public String getText() {
    return this.text;
  }

  public boolean isLeaf() {
    return this.leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void removeNoRight() {
    int size = children.size();
    TreeVo node;
    for (int i = size - 1; i >= 0; i--) {
      node = children.get(i);
      node.removeNoRight();
      if ((!node.isLeaf()) && node.getChildren().size() == 0) {
        children.remove(i);
      }
    }
  }


}
