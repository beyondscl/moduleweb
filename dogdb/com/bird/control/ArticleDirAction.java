package com.bird.control;

import com.bird.service.ArticleDirService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/articleDirAction")
public class ArticleDirAction {

    @Resource
    private ArticleDirService articleDirService;

    @RequestMapping(value = "/test")
    public String test() {
        return "";
    }

    @RequestMapping(value = "/save")
    public String save() {
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete() {
        return "";
    }

    @RequestMapping(value = "/update")
    public String update() {
        return "";
    }

    @RequestMapping(value = "/query")
    public String query() {
        return "";
    }

    @RequestMapping(value = "/pagequery")
    public String getList() {
        return "";
    }
}
 
