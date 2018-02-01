package com.bird.service.base;

import com.bird.dao.BaseDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 */
@Service
public interface BaseService<T> {

    /**
     * 基本操作
     * @param o
     * @return
     */
    int saveObject(Object o);

    int updateObject(Object o);

    int deleteById(String id);

    int deleteObject(Object o);

    T findById(String id);

    T findByObject(Object O);

    List<T> queryByPage(Object O);

    //用户必须在其实现类中重写的接口
    void setBaseDao(BaseDao baseDao);
}
