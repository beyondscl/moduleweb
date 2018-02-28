package com.bird.control;

import com.bird.util.FormUtil;
import com.bird.util.IdGen;
import com.bird.util.MySeesion;
import com.bird.util.TimeUtil;
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

    /**
     * 可以接收查询参数,分页查询
     *
     * @param article
     * @param request
     * @return
     */
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
    public String save(Article article, HttpServletRequest request,
                       HttpServletResponse response) {
        String returnUrl = "article/index";

        try {
            //虽然能屏蔽重复刷新表单保存，但是回退后在提交就不行了？
            if (!FormUtil.checkFormrandom(article.getId())) {
                request.getRequestDispatcher("/articleAction/index").forward(request, response);
                return returnUrl;
            }
            article.setAuthorId(MySeesion.getUserValue(request, "id").toString());
            article.setCreateTime(TimeUtil.getDateStr());
            articleService.saveObject(article);
            //不带任何查询参数的首页
            article = new Article();
            article.setCurrentPage(0);
            request.setAttribute("data", articleService.queryByPage(article));
            Page page = new Page();
            page.setRowCount(articleService.getCount(article));
            page.setCurrentPage(article.getCurrentPage());
            request.setAttribute("page", page);
            return returnUrl;
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnUrl;
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
