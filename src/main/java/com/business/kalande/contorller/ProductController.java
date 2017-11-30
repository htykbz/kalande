package com.business.kalande.contorller;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Products;
import com.business.kalande.service.ProductsService;
import com.github.pagehelper.Page;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(path="/product")
    public ModelAndView product() {
        ModelAndView mv = new ModelAndView("/product/product");
        return mv;
    }

    @RequestMapping(path="/productToAdd")
    public ModelAndView productToAdd() {
        ModelAndView mv = new ModelAndView("/product/productAdd");
        return mv;
    }

    @RequestMapping("/List")
    public PageInfo<Products> demoPage(String name,PageInfo page){
        Page<Products> products = productsService.listByPage(page);
        PageInfo<Products> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @RequestMapping(value="/productSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> productSave(Products products) throws ServletException, IOException {
        boolean success = productsService.add(products);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/productEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> productEdit(Products products) throws ServletException, IOException {
        boolean success = productsService.update(products);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/productDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> productDelete(Integer id) throws ServletException, IOException {
        boolean success = productsService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(path="/productToEdit")
    public ModelAndView productToEdit() {
        ModelAndView mv = new ModelAndView("/product/productEdit");
        return mv;
    }

    @RequestMapping("/productDetail")
    @ResponseBody
    public Products productDetail(Integer id){
        Products product = productsService.findById(id);
        return product;
    }

    @RequestMapping("/getproductCateGories")
    @ResponseBody
    public void getproductCateGories(HttpServletResponse resp,@RequestParam("id") Integer id){
        try {
            List<ProductCategoriesVo> list = productsService.getProductCateGories(id);
            resp.setContentType("text/json;charset=utf-8");
           // JSONObject json = new JSONObject();
            JSONArray json = JSONArray.fromObject(list);
            PrintWriter writer = resp.getWriter();
            writer.print(json);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
