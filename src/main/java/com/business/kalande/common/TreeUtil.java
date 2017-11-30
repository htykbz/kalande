package com.business.kalande.common;


import com.business.kalande.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanx on 2017/11/25.
 * 构造treeView数据结构
 */
public class TreeUtil {

    public static List<TreeNode> getNodeList(Map<String, TreeNode> nodelist) {
        List<TreeNode> tnlist=new ArrayList<>();
        for (String id : nodelist.keySet()) {
            TreeNode node = nodelist.get(id);
            if (node.getParentId().equals(0)) {
                tnlist.add(node);
            } else {
                if (nodelist.get(node.getParentId().toString()).getNodes() == null)
                    nodelist.get(node.getParentId().toString()).setNodes(new ArrayList<TreeNode>());
                nodelist.get(node.getParentId().toString()).getNodes().add(node);
            }
        }
        return tnlist;
    }
}
