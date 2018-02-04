package com.bird.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 */
@Repository
public interface BaseDao<T> {

    //单表的基本操作
    //增加
    int saveObject(Object o);

    //根据ID更新
    int updateObject(Object o);

    //根据ID删除
    int deleteById(String id);

    int deleteByIds(String[] ids);

    //根据Object查询删除
    int deleteObject(Object o);

    //根据ID查询
    T findById(String id);

    List<T> findByIds(String[] ids);

    //根据Object查询
    List<T> findByObject(Object O);

    //根据Object分页查询
    List<T> findByPage(Object O);

    //查询某表的总数
    long getCount(Object o);
    //--------------------------
}
