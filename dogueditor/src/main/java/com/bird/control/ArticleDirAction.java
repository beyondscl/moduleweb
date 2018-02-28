package com.bird.control;

import com.bird.util.IdGen;
import com.bird.util.TimeUtil;
import com.bird.domain.ArticleDir;
import com.bird.service.ArticleDirService;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public String save(ArticleDir articleDir, HttpServletRequest request) {

        Assert.notNull(articleDir, "not be null");
        articleDir.setId(IdGen.getId());
        articleDir.setAuthorId("");
        articleDir.setCreateTime(TimeUtil.getDateStr());
        articleDirService.saveObject(articleDir);
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete(ArticleDir articleDir) {
        Assert.notNull(articleDir, "not be null");
        articleDir.setUpdateTime(TimeUtil.getDateStr());
        articleDir.setEffective(0);
        articleDirService.updateObject(articleDir);
        return "";
    }

    @RequestMapping(value = "/update")
    public String update(ArticleDir articleDir) {
        Assert.notNull(articleDir, "not be null");
        articleDir.setUpdateTime(TimeUtil.getDateStr());
        articleDirService.updateObject(articleDir);
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
