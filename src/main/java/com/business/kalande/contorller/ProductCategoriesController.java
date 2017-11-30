package com.business.kalande.contorller;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategories;
import com.business.kalande.service.ProductCategoriesService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductCategoriesController {
    @Autowired
    private ProductCategoriesService categoriesService;

    @RequestMapping(path="/productCategories")
    public ModelAndView productCategories() {
        ModelAndView mv = new ModelAndView("/product/productCategories");
        return mv;
    }

    @RequestMapping(path="/productCategoriesToAdd")
    public ModelAndView product() {
        ModelAndView mv = new ModelAndView("/product/productCategoriesAdd");
        return mv;
    }

    @RequestMapping("/productCategoriesList")
    public PageInfo<ProductCategories> demoPage(String name, PageInfo page){
        Page<ProductCategories> productCategories = categoriesService.listByPage(page);
        PageInfo<ProductCategories> pageInfo = new PageInfo<>(productCategories);
        return pageInfo;
    }

    @RequestMapping(value="/productCategoriesSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> productCategoriesSave(ProductCategories categories) throws ServletException, IOException {
        boolean success = categoriesService.add(categories);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/productCategoriesEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> productCategoriesEdit(ProductCategories categories) throws ServletException, IOException {
        boolean success = categoriesService.update(categories);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(path="/productCategoriesToEdit")
    public ModelAndView productCategoriesToEdit( ) {

        ModelAndView mv = new ModelAndView("/product/productCategoriesEdit");
        return mv;
    }

    @RequestMapping(value="/productCategoriesDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> productCategoriesDelete(Integer id) throws ServletException, IOException {
        boolean success = categoriesService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping("/categoriesDetail")
    @ResponseBody
    public ProductCategories categoriesDetail(Integer id){
        ProductCategories categories = categoriesService.findById(id);
        return categories;
    }



}
