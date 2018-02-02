package com.bird.service;

import com.bird.dao.ArticleDiscussDao;
import com.bird.dao.BaseDao;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleDiscussServiceImpl extends BaseServiceImpl implements ArticleDiscussService {
    @Resource
    private ArticleDiscussDao articleDiscussDao;

    @Resource
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(this.articleDiscussDao);
    }
}
