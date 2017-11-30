package com.business.kalande.contorller;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.Products;
import com.business.kalande.entity.SinglePages;
import com.business.kalande.service.ProductsService;
import com.business.kalande.service.SinglePagesService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
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
public class SinglePagesController {
    @Autowired
    private SinglePagesService singlePagesService;

    /**
     * 品牌历程
     * @return
     */
    @RequestMapping(path="/singlePages")
    public ModelAndView singlePages() {
        ModelAndView mv = new ModelAndView("/singlePage/singlePages");
        return mv;
    }

    /**
     * 品牌理念
     * @return
     */
    @RequestMapping(path="/singlePages0")
    public ModelAndView singlePages0() {
        ModelAndView mv = new ModelAndView("/singlePage/singlePages_0");
        return mv;
    }

    /**
     * 加盟合作列表
     * @return
     */
    @RequestMapping(path="/singlePages2")
    public ModelAndView singlePages2() {
        ModelAndView mv = new ModelAndView("/singlePage/singlePages_2");
        return mv;
    }

    @RequestMapping("/singlePageList")
    public PageInfo<SinglePages> demoPage(Integer singleType,PageInfo page){
        Page<SinglePages> singlePages = singlePagesService.listByPage(page,singleType);
        PageInfo<SinglePages> pageInfo = new PageInfo<>(singlePages);
        return pageInfo;
    }

    @RequestMapping(path="/singlePageToAdd")
    public ModelAndView singlePageToAdd() {
        ModelAndView mv = new ModelAndView("/singlePage/singlePagesAdd");
        return mv;
    }

    @RequestMapping(path="/singlePageToEdit")
    public ModelAndView singlePageToEdit() {

        ModelAndView mv = new ModelAndView("/singlePage/singlePagesEdit");
        return mv;
    }

    @RequestMapping(value="/singlePageEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> singlePageEdit(SinglePages singlePages) throws ServletException, IOException {
        boolean success = singlePagesService.update(singlePages);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping("/singlePageDetail")
    @ResponseBody
    public SinglePages productDetail(Integer id){
        SinglePages singlePages = singlePagesService.findById(id);
        return singlePages;
    }

    @RequestMapping(value="/singlePageSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> singlePageSave(SinglePages singlePages) throws ServletException, IOException {
        boolean success = singlePagesService.add(singlePages);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/singlePageDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> singlePageDelete(Integer id) throws ServletException, IOException {
        boolean success = singlePagesService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

}
