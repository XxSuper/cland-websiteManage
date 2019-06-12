package com.maiyajf.loan.manage.loan.sys.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode implements Comparable<TreeNode> {
  private String id;
  private String text;
  private String dispOrder; // 显示顺序
  private List<TreeNode> children = new ArrayList<TreeNode>();
  private String no;

  public String getNo() {
    return this.no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  @Override
  public String toString() {
    return "";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean getLeaf() {
    return children == null || children.isEmpty();
  }

  public List<TreeNode> getChildren() {
    Collections.sort(children);
    return children;
  }

  public void setChildren(List<TreeNode> children) {
    this.children = children;
  }

  public int compareTo(TreeNode o) {
    if (o == null) return 1;

    if (this.dispOrder == null) return 0;

    return this.dispOrder.compareTo(o.dispOrder);
  }

  public String getDispOrder() {
    return dispOrder;
  }

  public void setDispOrder(String dispOrder) {
    this.dispOrder = dispOrder;
  }


}
