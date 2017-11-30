package com.business.kalande.contorller;

import com.business.kalande.entity.Products;
import com.business.kalande.entity.Users;
import com.business.kalande.service.UsersService;
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
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(path="/usersToEditPs")
    public ModelAndView newsToEdit() {
        ModelAndView mv = new ModelAndView("/users/usersEditPs");
        return mv;
    }

    @RequestMapping(value="/usersEditPs",method={RequestMethod.POST})
    public Map<String, Object> newsEdit(Users users) throws ServletException, IOException {
        boolean success = usersService.update(users);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("state", success);
        return json;
    }

    @RequestMapping("/usersDetail")
    @ResponseBody
    public Users productDetail(Integer id){
        Users users = usersService.findById(id);
        return users;
    }
}
