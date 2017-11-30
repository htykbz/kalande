package com.business.kalande.contorller;
import com.business.kalande.entity.Users;
import com.business.kalande.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UsersService usersService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(path="/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/login");
        return mv;
    }

    @RequestMapping(value="/userLogin",method={RequestMethod.POST})
    public Map<String, Object> userLogin(Users users) throws ServletException, IOException {
        Users user = usersService.exists(users);
        Map<String, Object> json = new HashMap<String, Object>();
        if(user != null) {
            json.put("state", true);
        }else{
            json.put("state", false);
        }
        return json;
    }


}
