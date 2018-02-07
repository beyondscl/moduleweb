package com.bird.service;

import com.bird.dao.ArticleDirDao;
import com.bird.dao.BaseDao;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class ArticleDirServiceImpl extends BaseServiceImpl implements ArticleDirService {

    @Resource

    private ArticleDirDao articleDirDao;

    @Resource

    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(this.articleDirDao);
    }
}
 
