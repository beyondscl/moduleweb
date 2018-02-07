package com.bird.control;

import com.bird.Util.FormUtil;
import com.bird.Util.IdGen;
import com.bird.Util.MySeesion;
import com.bird.Util.TimeUtil;
import com.bird.domain.Article;
import com.bird.domain.Page;
import com.bird.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/articleAction")
public class ArticleAction {
    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/test")
    public String test() {
        return "";
    }

    @RequestMapping(value = "/index")
    public String index(Article article, HttpServletRequest request) {
        article.setCurrentPage(article.getCurrentPage());
        //这是返回的数据
        request.setAttribute("data", articleService.queryByPage(article));
        //这是查询的数据，同时返回页码信息
        Page page = new Page();
        page.setRowCount(articleService.getCount(article));
        page.setCurrentPage(article.getCurrentPage());
        request.setAttribute("page", page);
        return "article/index";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(HttpServletRequest request) {
        String id = IdGen.getId();
        FormUtil.setFormrandom(id);
        request.setAttribute("id", id);
        return "article/add";
    }

    @RequestMapping(value = "/save")
    public void save(Article article, HttpServletRequest request,
                     HttpServletResponse response) {
        try {
            //虽然能屏蔽重复刷新表单保存，但是回退后在提交就不行了？
            if (!FormUtil.checkFormrandom(article.getId())) {
                request.getRequestDispatcher("/articleAction/index").forward(request, response);
                return;
            }
            article.setAuthorId(MySeesion.getUserValue(request, "id").toString());
            article.setCreateTime(TimeUtil.getDateStr());
            articleService.saveObject(article);

            article.setCurrentPage(0);
            request.setAttribute("data", articleService.queryByPage(article));
            request.getRequestDispatcher("/articleAction/index").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
