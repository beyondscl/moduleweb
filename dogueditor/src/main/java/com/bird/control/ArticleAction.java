package com.bird.control;

import com.bird.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/articleAction")
public class ArticleAction {
    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/test")
    public String test() {
        return "";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd() {
        return "article/index";
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
