package com.bird.service;  
import com.bird.dao.BaseDao; 
import com.bird.dao.ArticleDao; 
import com.bird.service.base.BaseServiceImpl; 
import org.springframework.stereotype.Service; 
import javax.annotation.Resource; 
@Service 
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService { 
@Resource 
private ArticleDao articleDao ; 
@Resource 
public void setBaseDao(BaseDao baseDao) { 
super.setBaseDao(this.articleDao); 
} 
} 
