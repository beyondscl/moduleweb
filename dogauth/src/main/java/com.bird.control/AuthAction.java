package com.bird.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 *
 */
@Controller
public class AuthAction {

    @RequestMapping(value = "/authtest", produces = "application/json")
    @ResponseBody
    public String AuthTest() {
        return "";
    }

}
