package com.bird.control; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import com.bird.service.ArticleService; 
@Controller 
@RequestMapping(value = "/articleAction") 
public class ArticleAction{
@Resource 
private ArticleService articleService; 
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