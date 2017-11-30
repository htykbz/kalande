package com.business.kalande.contorller;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.TrainVideos;
import com.business.kalande.service.TrainVideosService;
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
public class TrainVideosController {
    @Autowired
    private TrainVideosService trainVideosService;

    @RequestMapping(path="/trainVideos")
    public ModelAndView product() {
        ModelAndView mv = new ModelAndView("/trainVideos/trainVideos");
        return mv;
    }

    @RequestMapping(path="/trainVideosToAdd")
    public ModelAndView trainVideosToAdd() {
        ModelAndView mv = new ModelAndView("/trainVideos/trainVideosAdd");
        return mv;
    }

    @RequestMapping("/trainVideosList")
    public PageInfo<TrainVideos> trainVideosList(String name, PageInfo page){
        Page<TrainVideos> trainings = trainVideosService.listByPage(page);
        PageInfo<TrainVideos> pageInfo = new PageInfo<>(trainings);
        return pageInfo;
    }

    @RequestMapping(value="/trainVideosSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> trainVideosSave(TrainVideos trainVideos) throws ServletException, IOException {
        boolean success = trainVideosService.add(trainVideos);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/trainVideosEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> trainVideosEdit(TrainVideos trainVideos) throws ServletException, IOException {
        boolean success = trainVideosService.update(trainVideos);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/trainVideosDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> trainVideosDelete(Integer id) throws ServletException, IOException {
        boolean success = trainVideosService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(path="/trainVideosToEdit")
    public ModelAndView trainVideosToEdit() {
        ModelAndView mv = new ModelAndView("/trainVideos/trainVideosEdit");
        return mv;
    }

    @RequestMapping("/trainVideosDetail")
    @ResponseBody
    public TrainVideos trainingsDetail(Integer id){
        TrainVideos trainVideos = trainVideosService.findById(id);
        return trainVideos;
    }

    @RequestMapping("/getTrainVideosCateGories")
    @ResponseBody
    public void getTrainVideosCateGories(HttpServletResponse resp, @RequestParam("id") Integer id){
        try {
            List<ProductCategoriesVo> list = trainVideosService.getTrainVideoGoriesById(id);
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
