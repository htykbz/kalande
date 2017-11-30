package com.business.kalande.service.Impl;

import com.business.kalande.common.TreeUtil;
import com.business.kalande.entity.Menu;
import com.business.kalande.entity.TreeNode;
import com.business.kalande.mapper.MenuMapper;
import com.business.kalande.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<TreeNode> listBy() {
        List<Menu> list =  menuMapper.listBy();
        Map<String, TreeNode> nodelist = new LinkedHashMap<String, TreeNode>();
        for (Menu menu : list) {
            TreeNode node = new TreeNode();
            node.setText(menu.getTitle());
            node.setId(menu.getId());
            node.setParentId(menu.getPid());
            nodelist.put(node.getId().toString(), node);
        }
        // 构造树形结构
        return TreeUtil.getNodeList(nodelist);
    }

    @Override
    public Menu findById(Integer id) {
        return menuMapper.findById(id);
    }

    @Override
    public boolean add(Menu menu) {
        return menuMapper.add(menu);
    }

    @Override
    public boolean update(Menu menu) {
        return menuMapper.update(menu);
    }

    @Override
    public boolean delete(Integer id) {
        return menuMapper.delete(id);
    }

}
