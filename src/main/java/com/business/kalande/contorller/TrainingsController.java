package com.business.kalande.contorller;

import com.business.kalande.common.PageInfo;
import com.business.kalande.entity.ProductCategoriesVo;
import com.business.kalande.entity.Trainings;
import com.business.kalande.service.TrainingsService;
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
public class TrainingsController {
    @Autowired
    private TrainingsService trainingsService;

    @RequestMapping(path="/Trainings")
    public ModelAndView product() {
        ModelAndView mv = new ModelAndView("/trainings/trainings");
        return mv;
    }

    @RequestMapping(path="/trainingsToAdd")
    public ModelAndView trainingsToAdd() {
        ModelAndView mv = new ModelAndView("/trainings/trainingsAdd");
        return mv;
    }

    @RequestMapping("/trainingsList")
    public PageInfo<Trainings> trainingsList(String name, PageInfo page){
        Page<Trainings> trainings = trainingsService.listByPage(page);
        PageInfo<Trainings> pageInfo = new PageInfo<>(trainings);
        return pageInfo;
    }

    @RequestMapping(value="/trainingsSave",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> trainingsSave(Trainings trainings) throws ServletException, IOException {
        boolean success = trainingsService.add(trainings);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/trainingsEdit",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> trainingsEdit(Trainings trainings) throws ServletException, IOException {
        boolean success = trainingsService.update(trainings);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(value="/trainingsDelete",method={RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> trainingsDelete(Integer id) throws ServletException, IOException {
        boolean success = trainingsService.delete(id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping(path="/trainingsToEdit")
    public ModelAndView trainingsToEdit() {
        ModelAndView mv = new ModelAndView("/trainings/trainingsEdit");
        return mv;
    }

    @RequestMapping("/trainingsDetail")
    @ResponseBody
    public Trainings trainingsDetail(Integer id){
        Trainings trainings = trainingsService.findById(id);
        return trainings;
    }

    @RequestMapping("/getTrainingsCateGories")
    @ResponseBody
    public void getTrainingsCateGories(HttpServletResponse resp, @RequestParam("id") Integer id){
        try {
            List<ProductCategoriesVo> list = trainingsService.getTrainGories(id);
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
