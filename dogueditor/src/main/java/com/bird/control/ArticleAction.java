package com.bird.control;

import com.bird.Util.MySeesion;
import com.bird.Util.TimeUtil;
import com.bird.domain.Article;
import com.bird.service.ArticleService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public String save(Article article, HttpServletRequest request) {
        Assert.notNull(article, "not be null");
        article.setCreateTime(TimeUtil.getDateStr());
        articleService.saveObject(article);
        String token = (String) request.getAttribute("token");
        JSONObject user = MySeesion.getUserByToken(token);
        user.get("uid");//这里应该写在配置文件中，万一以后变量呢？增加修改了呢？
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete(Article article) {
        article.setUpdateTime(TimeUtil.getDateStr());
        article.setEffective(0);
        articleService.updateObject(article);
        return "";
    }

    @RequestMapping(value = "/update")
    public String update(Article article) {
        Assert.notNull(article, "not be null");
        article.setUpdateTime(TimeUtil.getDateStr());
        articleService.updateObject(article);
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
