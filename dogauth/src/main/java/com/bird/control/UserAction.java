package com.bird.control;

import com.bird.Util.MySeesion;
import com.bird.domain.User;
import com.bird.service.UserService;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.Token;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * author: 牛虻.
 * time:2017/11/11
 * email:pettygadfly@gmail.com
 * doc:
 */
@Controller
@RequestMapping("/user/*")
public class UserAction {
    private Logger logger = Logger.getLogger(UserAction.class.getName());


    @Resource
    private UserService userService;

    //可以存放在token <-> user session中，做双重判断！！减少查询中心服务器
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user,
                        HttpServletRequest request) {
        List<User> listUser = userService.findByObject(user);
        if (null == listUser || listUser.size() == 0)
            return "login";
        user = listUser.get(0);
        String token = Token.getToken(user);
        MySeesion.setUserByToken(token, new JSONObject(user));
        request.setAttribute("token", token);
        return "main";

    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "login";
    }


    /**
     * 提供外部接口直接返回数据，类似servlet write
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "apiTest")
    @ResponseBody
    public String apiTest(String name, String password) {
        return "login";
    }

    @RequestMapping("jumpToMain")
    public String jump(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session) {
        session.setAttribute("TJSESSIONID", UUID.randomUUID().hashCode());
        User iUesr = new User();
        iUesr.setId(UUID.randomUUID().toString());
        iUesr.setName("hello");
        iUesr.setAge(11);
        userService.addUser(iUesr);
        System.out.println("-------------------------");
        User result = userService.getUser(iUesr);
        User result2 = userService.getUser(iUesr);
        User result3 = userService.getUser(iUesr);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result2);
        Assert.assertNotNull(result3);
        System.out.println("-------------------------");
        Object o = userService.getAllUser();
        System.out.println("-------------------------");

        return "main";
    }

}
