package com.bird.control;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: 牛虻.
 * time:2018/2/1
 * email:pettygadfly@gmail.com
 * doc:
 * 博客文章模块
 */
@org.springframework.stereotype.Controller
@RequestMapping(value = "/article/*")
public class ArticleAction {

    @org.springframework.web.bind.annotation.RequestMapping(value = "toAdd")
    public String toArticle() {
        return "article/index";
    }
}
