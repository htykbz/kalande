package com.business.kalande.entity;

import java.util.List;

public class TreeNode {
    private Integer id;
    private Integer parentId;
    private String text;
    private List<TreeNode> nodes;

    public TreeNode() {
    }

    public TreeNode(Integer id, Integer parentId, String text, List<TreeNode> nodes) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.nodes = nodes;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }
}
