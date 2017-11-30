package com.business.kalande.contorller;

import com.business.kalande.entity.Menu;
import com.business.kalande.entity.Products;
import com.business.kalande.entity.TreeNode;
import com.business.kalande.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(path="/menu")
    public ModelAndView menu() {
        ModelAndView mv = new ModelAndView("/menu/menu");
        return mv;
    }

    /**
     * getTreeData 构造bootstrap-treeview格式数据
     *
     * @return
     */
    @RequestMapping(value = "/menuTreeData", method = RequestMethod.GET)
    public List<TreeNode> getTreeData() {

        return menuService.listBy();
    }

    @RequestMapping("/getMenu")
    @ResponseBody
    public Menu getMenu(Integer id){
        Menu menu = menuService.findById(id);
        return menu;
    }

    @RequestMapping(value="/menuSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> menuSave(Menu menu) throws ServletException, IOException {
        boolean success = menuService.add(menu);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/menuEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> menuEdit(Menu menu) throws ServletException, IOException {
        boolean success = menuService.update(menu);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/menuDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> menuDelete(Integer id) throws ServletException, IOException {
        boolean success = menuService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }
}
