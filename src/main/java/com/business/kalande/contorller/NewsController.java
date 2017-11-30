package com.business.kalande.contorller;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.News;
import com.business.kalande.service.NewsService;
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
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(path="/news")
    public ModelAndView news() {
        ModelAndView mv = new ModelAndView("/news/news");
        return mv;
    }

    @RequestMapping(path="/newsToAdd")
    public ModelAndView productToAdd() {
        ModelAndView mv = new ModelAndView("/news/newsAdd");
        return mv;
    }

    @RequestMapping("/newsList")
    public PageInfo<News> newsList(String name, PageInfo page){
        Page<News> news = newsService.listByPage(page);
        PageInfo<News> pageInfo = new PageInfo<>(news);
        return pageInfo;
    }

    @RequestMapping(value="/newsSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> newsSave(News news) throws ServletException, IOException {
        boolean success = newsService.add(news);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/newsEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> newsEdit(News news) throws ServletException, IOException {
        boolean success = newsService.update(news);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/newsDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> newsDelete(Integer id) throws ServletException, IOException {
        boolean success = newsService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(path="/newsToEdit")
    public ModelAndView newsToEdit() {
        ModelAndView mv = new ModelAndView("/news/newsEdit");
        return mv;
    }

    @RequestMapping("/newsDetail")
    @ResponseBody
    public News newsDetail(Integer id){
        News news = newsService.findById(id);
        return news;
    }
}
